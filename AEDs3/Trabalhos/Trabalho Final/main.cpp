#include <iostream>
#include <fstream>
#include <string>
#include "Hash.h"
using namespace std;

int calculaTamanho(){
	ifstream arquivo("sensor.log", ios::binary | ios::ate);
	int tam = 1;
	if (arquivo.is_open()) {
    	streampos tamanhobytes = arquivo.tellg();
    	tam = (int) tamanhobytes/8;
        arquivo.close();
    }
	return tam;
}
void preencheHash(Hash* hash){
	ifstream arquivoEntrada("sensor.log");
	string linha;
    if(arquivoEntrada.is_open()){
    	while (getline(arquivoEntrada, linha)) {
            hash->insert(linha);
        }
        arquivoEntrada.close();
	}
}

void imprimeLinha(ofstream &arquivoSaida, Item* item, string prefix){
	if(item != nullptr){
		string pacote = item->getPacote();
		if(pacote != "?"){
			for(int i = 0; pacote[i] != '\0'; i+=2){
				string hexaStr = "";
				
				hexaStr += pacote[i];
				hexaStr += pacote[i+1];	
				unsigned char hexa = stoul(hexaStr, nullptr, 16); /*Transforma em hexadecimal e salva em binário*/
				arquivoSaida << hexa;
				/*for(int i = 7; i >=0; i--){
					int bit = (hexa >> i) & 1;
	    			cout << bit;
				}		
				cout << " ";*/
			}
			unsigned char bprefix = stoul(prefix, nullptr, 2); /*transforma em binário*/
			/*cout << " - " << prefix << " - ";*/
			arquivoSaida << bprefix;
			/*for(int i = 7; i >=0; i--){
				int bit = (bprefix >> i) & 1;
        		cout << bit;
			}
			cout << endl;*/
		}
	}
}

void criarTabela(ofstream &arquivoSaida, Item* item, string prefixo){
	ListaEncadeada* fila = new ListaEncadeada();
	Nodo* atual = new Nodo(item, prefixo);
    while(atual != nullptr){
    	if(atual->getItem()->getPacote() != "?"){
    		imprimeLinha(arquivoSaida, atual->getItem(), atual->getPrefixo());
		}else{
			fila->insert(atual->getItem()->getDir(), atual->getPrefixo()+"1");
			fila->insert(atual->getItem()->getEsq(), atual->getPrefixo()+"0");
		}
		atual = fila->pop();
	}
	
	/*if(item != nullptr){
		string pacote = item->getPacote();
		if(pacote != "?"){
			for(int i = 0; pacote[i] != '\0'; i+=2){
				string hexaStr = "";
				
				hexaStr += pacote[i];
				hexaStr += pacote[i+1];	
				
				unsigned char hexa = stoul(hexaStr, nullptr, 16); /*Transforma em hexadecimal e salva em binário
				arquivoSaida << hexa;
				for(int i = 7; i >=0; i--){
					int bit = (hexa >> i) & 1;
	    			cout << bit;
				}		
				cout << " ";
			}
			unsigned char bprefix = stoul(prefix, nullptr, 2); /*transforma em binário
			cout << " - " << prefix << " - ";
			arquivoSaida << bprefix;
			for(int i = 7; i >=0; i--){
				int bit = (bprefix >> i) & 1;
        		cout << bit;
			}
			cout << endl;
		}else{
			/*cout << item->getFreq() << endl;
		}
		string lprefix = prefix;
		lprefix += "0";
		treePrint(arquivoSaida, item->getEsq(), lprefix);
    	string rprefix = prefix;
		rprefix += "1";
		treePrint(arquivoSaida, item->getDir(), rprefix);
	}*/

}
string buscaBFS(Item *root, string pacote){ 
	ListaEncadeada* fila = new ListaEncadeada();
	string prefixo = "";
	Nodo* atual = new Nodo(root, prefixo);
    while(atual != nullptr){
		if(atual->getItem()->getPacote() == "?"){
			fila->insert(atual->getItem()->getDir(), atual->getPrefixo()+"1");
			fila->insert(atual->getItem()->getEsq(), atual->getPrefixo()+"0");
		}else if(atual->getItem()->getPacote() == pacote){
			return atual->getPrefixo();
		}
    	
		atual = fila->pop();
	}
	return "";
} 

void comprimir(Item root){
	ifstream arquivoEntrada("sensor.log");
	ofstream arquivoSaida("sensor.hzp", ios::binary | ios::out);
	if(arquivoEntrada && arquivoSaida){
		arquivoSaida << "HZIP";
		unsigned int numPacotes = root.getFreq();
		unsigned char a =0;
		int soma = 0;
		for (int i =31; i>=0; i--){
			soma++;
			a <<=1;
			a |= ((numPacotes >>i)&1);
			
			if(soma == 8){
				arquivoSaida << a;
				a = 0;
				soma = 0;
			}
		}
		/*arquivoSaida << numPacotes;*/
		string linha;
		soma =0;
		unsigned char binario;
		while(getline(arquivoEntrada, linha)){
			string prefixo = buscaBFS(&root, linha);
			cout << prefixo << endl;
			soma += prefixo.length();
			if(soma >= 8){
				int falta = prefixo.length();
				soma = soma-8;
				falta-= soma;
				unsigned char b = stoul(prefixo, nullptr, 2);
				binario <<= falta;
				binario |= (b >> soma);
				arquivoSaida << binario;
				cout << "b ";
				for(int i = 7; i>=0; i--){
					cout << ((binario >> i)&1);
				}
				cout << endl;
				binario |= (b << 8-soma);
				binario >>= 8-soma;
			}else{
				binario <<= prefixo.length();
				binario |= stoul(prefixo, nullptr, 2);
			}
		}
		if (soma > 0){
			binario <<= 8-soma;
			arquivoSaida << binario;
			cout << "b ";
			for(int i = 7; i>=0; i--){
				cout << ((binario >> i)&1);
			}
		}
		
        arquivoEntrada.close();
        arquivoSaida.close();
	}
}

void compressaoMain(){
    Hash* hash = new Hash(calculaTamanho());
    
    preencheHash(hash);
	
	MinHeap* heap = hash->toHeap();

	
	Item root = heap->toHuff();
	/*buscaBFS(&root);*/
	
	cout << endl;
	
	ofstream arquivoSaida("sensor.tbl", ios::binary | ios::out);
	if(arquivoSaida){
		criarTabela(arquivoSaida, &root, "");
		arquivoSaida.close();
	}
	comprimir(root);
	
}

string buscarNaTabela(unsigned char atual){
	string resultado = "";
	ifstream arquivoTabela("sensor.tbl", ios::binary | ios::in);
	if(arquivoTabela){
		char a[5];
		while(arquivoTabela.get(a,5) && resultado == ""){
			unsigned char b = arquivoTabela.get();
			if(b == atual){
				resultado = a;
				resultado += " G ";
			}
		}
		arquivoTabela.close();
	}
	return resultado;
}

void descompressaoMain(){
	ifstream arquivoEntrada("sensor.hzp", ios::binary | ios::in);
	if(arquivoEntrada){
		char inicio[5];
		arquivoEntrada.get(inicio, 5);
		string b = inicio;
		if(b == "HZIP"){
			arquivoEntrada.get(inicio,5);
			unsigned int quantidade;
			for(int i = 0; i < 4; i++){
				quantidade = inicio[i];
			}
			char a[2];
			unsigned char c = 0;
			int contador = 0;
			while(arquivoEntrada.get(a,2) ){
				string resultado = "";
				int cont = 0;
				for(int i = 7; i >=0 && contador < 12; i--){
					c <<=1;
					c |= ((a[0]>>i)&1);
					cont++;
					if(cont>=2){
						for(int j = 7; j >=0; j--){
							cout << ((c>>j)& 1);
						}
						cout << endl;
						resultado = buscarNaTabela(c);	
					}
					
					if(resultado != ""){
						cout << resultado << endl;
						resultado = "";
						c=0;
						contador++;
						cont = 0;
					}
				}
				
			}
			
		}
		arquivoEntrada.close();
	}
}

int main(int argc, char* argv[]){	
	string a = "";
	if(argc > 1){
		a = argv[1];
	}
	if(a == "c"){
		compressaoMain();
	}else if (a == "d") {
		cout << "Parametro d" << endl;
	}else{
		cout << "Informe um parametro valido!" << endl;
		descompressaoMain();
	}
	
	return 0;
}