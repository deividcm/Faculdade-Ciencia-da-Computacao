#include "Hash.h"
#include "Nodo.h"
#include "MinHeap.h"
#include <iostream>
using namespace std;


Hash::Hash(int tam){
	this->tam = tam;
	this->tabela = new ListaEncadeada[tam];
	this->quant =0;
}
unsigned int Hash::funcaoHash(string item){
	unsigned int a = 1;
	for(int i = 0; item[i] != '\0'; i++){
		a += item[i] * i;
		a *= item[i] + i;
	}
	return a % this->tam;
}


void Hash::insert(string item){
	unsigned int posicao = this->funcaoHash(item);
	/*cout << posicao << endl;*/
	this->quant += this->tabela[posicao].insert(item);
}

MinHeap* Hash::toHeap(){
	MinHeap* heap = new MinHeap(this->quant+2);
	for(int i = 0; i < tam; i++){
		if(!tabela[i].isEmpty()){
			Nodo* atual = tabela[i].getHead();
			while(atual != nullptr){
				Item* item = atual->getItem();
				heap->insert(item);
				atual = atual->getProx();
			}
		}
	}
	return heap;
}

int Hash::getQuant() const{
	return this->quant;
}