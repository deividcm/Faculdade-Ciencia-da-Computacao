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
void treePrint(ofstream &arquivoSaida, Item* item, string prefix){
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
		}else{
			/*cout << item->getFreq() << endl;*/
		}
		string lprefix = prefix;
		lprefix += "0";
		treePrint(arquivoSaida, item->getEsq(), lprefix);
    	string rprefix = prefix;
		rprefix += "1";
		treePrint(arquivoSaida, item->getDir(), rprefix);
	}
}
void preOrder(Item *root) 
{ 
    if(root != NULL) { 
    	cout << root->getPacote() << " " << root->getFreq() << endl;
    	preOrder(root->getEsq());
    	preOrder(root->getDir());
    } 
} 

void teste(){
	
    Hash* hash = new Hash(calculaTamanho());
    
    preencheHash(hash);
	
	MinHeap* heap = hash->toHeap();

	
	Item root = heap->toHuff();
	preOrder(&root);
	
	cout << endl;
	ofstream arquivoSaida("sensor.tbl", ios::binary | ios::out);
	if(arquivoSaida){
		treePrint(arquivoSaida, &root, "");
		arquivoSaida.close();
	}
	/*ifstream arquivoEntrada("sensor.tbl", ios::binary | ios::in);
	if(arquivoEntrada){
		char byte;
		while(arquivoEntrada.get(byte)){
			for (int i = 7; i >= 0; --i) {
            	// Desloca os bits e isola o bit atual com mascaramento bitwise (& 1)
            	std::cout << ((byte >> i) & 1);
        	}
       		cout << " ";
		}
		
        arquivoEntrada.close();
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