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
    	tam = (int) tamanhobytes/4;
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
				for(int i = 7; i >=0; i--){
					int bit = (hexa >> i) & 1;
	    			cout << bit;
				}		
				cout << " ";
			}
			unsigned char bprefix = stoul(prefix, nullptr, 2); /*transforma em binário*/
			cout << " - " << prefix << " - ";
			arquivoSaida << bprefix;
			for(int i = 7; i >=0; i--){
				int bit = (bprefix >> i) & 1;
        		cout << bit;
			}
			cout << endl;
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
void buscaBFS(Item *root){ 
	ListaEncadeada* fila = new ListaEncadeada();
	string prefixo = "";
	Nodo* atual = new Nodo(root, prefixo);
    while(atual != nullptr){
    	
    	cout << atual->getItem()->getPacote() << " - " << atual->getFreq() << " - " << atual->getPrefixo() << endl;
		if(atual->getItem()->getPacote() == "?"){
			fila->insert(atual->getItem()->getDir(), atual->getPrefixo()+"1");
			fila->insert(atual->getItem()->getEsq(), atual->getPrefixo()+"0");
		}
    	
		atual = fila->pop();
	}
} 

void teste(){
	
    Hash* hash = new Hash(calculaTamanho());
    
    preencheHash(hash);
	
	MinHeap* heap = hash->toHeap();

	
	Item root = heap->toHuff();
	buscaBFS(&root);
	
	cout << endl;
	
	ofstream arquivoSaida("sensor.tbl", ios::binary | ios::out);
	if(arquivoSaida){
		criarTabela(arquivoSaida, &root, "");
		arquivoSaida.close();
	}
	/*
	ifstream arquivoEntrada2("sensor.log");
	if(arquivoEntrada2){
		string linha2;
		while(getline(arquivoEntrada2, linha2)){
			unsigned int primeiro = stoul(linha2, nullptr, 16);
			unsigned int segundo = 0;
			ifstream arquivoEntrada("sensor.tbl", ios::binary | ios::in);
			if(arquivoEntrada){
				char linha[5];
				while(arquivoEntrada.get(linha, 5)){
					for (int i = 0; i < 4; i++) {
						for(int j = 0; j>= 7; j++){
							// Desloca os bits e isola o bit atual com mascaramento bitwise (& 1)
		            		segundo |= ((linha[i] >> j) & 1);
						}
		        	}
		        	if(primeiro == segundo){
		        		char byte;
			        	if(arquivoEntrada.get(byte)){
			        		for (int i = 7; i >= 0; --i) {
			            		// Desloca os bits e isola o bit atual com mascaramento bitwise (& 1)
			            		std::cout << ((byte >> i) & 1);
			        		}
						}
			       		cout << endl;
					}
		        	
				}
		    	arquivoEntrada.close();
		    }
		}
        arquivoEntrada2.close();
	}*/
}

int main(int argc, char* argv[]){	
	string a = "";
	if(argc > 1){
		a = argv[1];
	}
	if(a == "c"){
		cout << "Parametro c" << endl;
	}else if (a == "d") {
		cout << "Parametro d" << endl;
	}else{
		cout << "Informe um parametro valido!" << endl;
	}
	
	teste();
	
	return 0;
}