#include <iostream>
#include <fstream>
#include <cctype>
#include <sstream>
#include <iomanip>
#include <string>
#include <chrono>
#include "Hash.h"
using namespace std;
using namespace chrono;
struct Stats{
	int pacotesDistintos;
	int pacotesTotal;
	streampos tamanhoOriginal;
	streampos tamanhoFinal;
	long long tempoHash;
	long long tempoHuffman;
	long long tempoCompressao;
	long long tempoDescompressao;
};

int calculaTamanho(Stats& status){
	ifstream arquivo("sensor.log", ios::binary | ios::ate);
	int tam = 1;
	if (arquivo.is_open()) {
    	streampos tamanhobytes = arquivo.tellg();
    	status.tamanhoOriginal = tamanhobytes;
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
		/*cout << pacote << " ";*/
		if(pacote != "?"){
			for(int i = 0; pacote[i] != '\0'; i+=2){
				string hexaStr = "";
				
				hexaStr += pacote[i];
				hexaStr += pacote[i+1];	
				unsigned char hexa = stoul(hexaStr, nullptr, 16); /*Transforma em hexadecimal e salva em binário*/
				arquivoSaida << hexa;
				for(int i = 7; i >=0; i--){
					int bit = (hexa >> i) & 1;
	    			/*cout << bit;*/
				}		
				/*cout << " ";*/
			}
			unsigned char bprefix = stoul(prefix, nullptr, 2); /*transforma em binário*/
			/*cout << " - " << prefix << " - ";*/
			arquivoSaida << bprefix;
		    for(int i = 7; i >=0; i--){
				int bit = (bprefix >> i) & 1;
        		/*cout << bit;*/
			}
			/*cout << endl;*/
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

void comprimir(Item root, Stats& status){
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
			/*cout << prefixo << endl;*/
			soma += prefixo.length();
			if(soma >= 8){
				int falta = prefixo.length();
				soma = soma-8;
				falta -= soma;
				binario <<= falta;
				unsigned char b = stoul(prefixo, nullptr, 2);
				binario |= (b >> soma);
				arquivoSaida << binario;
				/*cout << "b ";
				for(int i = 7; i>=0; i--){
					cout << ((binario >> i)&1);
				}*/
				binario = 0;
				/*cout << endl;*/
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
			/*cout << "b ";
			for(int i = 7; i>=0; i--){
				cout << ((binario >> i)&1);
			}*/
		}
		
        arquivoEntrada.close();
        arquivoSaida.close();
	}
}

void compressaoMain(Stats& status){
	time_point<steady_clock> inicioHash = steady_clock::now();
    Hash* hash = new Hash(calculaTamanho(status));
    preencheHash(hash);
	status.pacotesDistintos = hash->getQuant();
	MinHeap* heap = hash->toHeap();
	
	time_point<steady_clock> fimHash = steady_clock::now();
	
	milliseconds tempoHash= duration_cast<milliseconds>(fimHash - inicioHash);
	status.tempoHash = tempoHash.count();
	
	time_point<steady_clock> inicioHuff = steady_clock::now();
	Item root = heap->toHuff();
	time_point<steady_clock> fimHuff = steady_clock::now();
	
	milliseconds tempoHuffman = duration_cast<milliseconds>(fimHuff - inicioHuff);
	status.tempoHuffman = tempoHuffman.count();
	status.pacotesTotal = root.getFreq();
	/*buscaBFS(&root);*/
	
	/*cout << endl;*/
	time_point<steady_clock> inicioCompressao  = steady_clock::now();
	ofstream arquivoSaida("sensor.tbl", ios::binary | ios::out);
	if(arquivoSaida){
		criarTabela(arquivoSaida, &root, "1");
		arquivoSaida.close();
	}
	comprimir(root, status);
	time_point<steady_clock> fimCompressao = steady_clock::now();
	
	milliseconds tempoCompressao = duration_cast<milliseconds>(fimCompressao - inicioCompressao);
	status.tempoCompressao = tempoCompressao.count();
	ifstream arquivo("sensor.hzp", ios::binary | ios::ate);
	if (arquivo.is_open()) {
    	streampos tamanhobytes = arquivo.tellg();
    	status.tamanhoFinal = tamanhobytes;
        arquivo.close();
    }
}

string buscarNaTabela(string atual){
	/*cout << atual << endl;*/
	string resultado = "Abobora";
	ifstream arquivoTabela("sensor.tbl", ios::binary | ios::in);
	if(arquivoTabela){
		char a[5];
		while(arquivoTabela.get(a,5) && resultado == "Abobora"){
			unsigned char b = arquivoTabela.get();
			string comparar = "";
			int g = 0;
			for(int i = 7; i >=0; i--){
				if(i<=g){
					/*cout << g << endl;*/
					comparar += ((b>>i)&1) + '0';
				}else if(((b>>i)&1) == 1){
					g = i;
				} 
			}
			if(comparar == atual){
				/*cout << atual << endl;*/
				resultado = "";
				for(int i = 0; i < 4; i++){
					resultado += a[i];
				}
			}
		}
		arquivoTabela.close();
	}
	return resultado;
}
string byteParaHex(unsigned char byte){
	stringstream stream;
	stream << std::hex << std::setw(2) << std::setfill('0') << (int)byte;
	string hexa = stream.str();
	for(int i = 0; i < hexa.length(); i++){
		hexa[i] = std::toupper(static_cast<unsigned char>(hexa[i]));
	}
	return hexa;
}

void descompressaoMain(){
	/*cout << endl << endl;*/
	ifstream arquivoEntrada("sensor.hzp", ios::binary | ios::in);
	
	if(arquivoEntrada) {
		ofstream arquivoSaida("sensor.log");
		char inicio[5];
		arquivoEntrada.get(inicio, 5);
		string titulo = inicio;
		if(titulo == "HZIP" && arquivoSaida){
			arquivoEntrada.get(inicio,5);
			unsigned int quantidade;
			for(int i = 0; i < 4; i++){
				quantidade = inicio[i];
			}
			char byteAtual[2];
			int contador = 0;
			string atual = "";
			while(contador < quantidade){
				arquivoEntrada.get(byteAtual,2);
				string resultado = "Abobora";
				for(int i = 7; i >=0 && contador < quantidade; i--){
					atual += ((byteAtual[0]>>i)&1) + '0';
					
					resultado = buscarNaTabela(atual);	
					
					if(resultado != "Abobora"){
						/*cout << resultado << endl;*/
						string linha = "";
						for(int i = 0; i < 4; i++){
							unsigned char byte = resultado[i];
							linha += byteParaHex(byte);
							/*cout << byteParaHex(byte);*/
							
						}
						arquivoSaida << linha;
						/*cout << endl;
						for(int i = 0; i < 4; i++){
							for(int j = 7; j>=0; j--){
									cout << ((resultado[i] >> j) &1);
								}
							cout << " ";
						}*/
						/*cout << endl;*/
						resultado = "Abobora";
						atual = "";
						contador++;
						if(contador < quantidade){
							arquivoSaida << endl;
						}
					}
				}
				
			}
			arquivoSaida.close();
		}
		arquivoEntrada.close();
	}
}

int main(int argc, char* argv[]){
	Stats status;
	string a = "";
	if(argc > 1){
		a = argv[1];
	}
	if(a == "c"){
		
		compressaoMain(status);
		ofstream arquivoStats("stats.txt");
		if(arquivoStats){
			arquivoStats << "Pacotes distintos: " << status.pacotesDistintos << endl;
			arquivoStats << "Total de pacotes: " << status.pacotesTotal << endl;
			arquivoStats << "Tamanho Original (bytes): " << status.tamanhoOriginal << endl;
			arquivoStats << "Tamanho Compactado (bytes): " << status.tamanhoFinal << endl;
			arquivoStats << "Razao de compressao (%): " << 100 - ((100*status.tamanhoFinal)/status.tamanhoOriginal) << endl;
			arquivoStats << "Tempo hash e heap (ms): " << status.tempoHash << endl;
			arquivoStats << "Tempo Huffman (ms): " << status.tempoHuffman << endl;
			arquivoStats << "Tempo Compressao (ms): " << status.tempoCompressao << endl;
			arquivoStats.close();
		}
	}else if (a == "d") {
		time_point<steady_clock> inicio = steady_clock::now();
		descompressaoMain();
		time_point<steady_clock> fim = steady_clock::now();
		
		milliseconds tempoDescompressao = duration_cast<milliseconds>(fim - inicio);
		status.tempoDescompressao = tempoDescompressao.count();
		
		ofstream arquivoStats("stats.txt", ios::app);
		if(arquivoStats){
			arquivoStats << "Tempo Descompressao (ms): " << status.tempoDescompressao << endl;
			arquivoStats.close();	
		}
	}else{
		cout << "Informe um parametro valido!" << endl;
	}
	return 0;
}