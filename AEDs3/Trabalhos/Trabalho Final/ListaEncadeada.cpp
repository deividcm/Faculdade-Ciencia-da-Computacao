#include "ListaEncadeada.h"
#include <iostream>
using namespace std;

ListaEncadeada::ListaEncadeada(){
	this->head = nullptr;
	this->quant = 0;
}

int ListaEncadeada::insert(string pacote){
	int a = 0;
	if(this->isEmpty()){
		this->head = new Nodo(pacote);
		a=1;
	}else{
		Nodo* atual = this->head;
		bool flag = true;
		while(flag){
			if(atual->getItem()->getPacote() == pacote){
				atual->addFreq();
				/*cout << "f"<< atual->getFreq() << endl;*/
				flag = false;
			}else{
				flag = atual->getProx() != nullptr;
				if(flag){
					atual = atual->getProx();
				}
				else{
					atual->setProx(new Nodo(pacote));
					a = 1;
				}
			}
		}
	}
	return a;
}
void ListaEncadeada::insert(Item* item, string prefixo){
	Nodo* novo = new Nodo(item, prefixo);
	if(this->isEmpty()){
		this->head = novo;
		this->ultimo = novo;
	}else{
		this->ultimo->setProx(novo);
		this->ultimo = novo;
	}
}
Nodo* ListaEncadeada::pop(){
	Nodo* retorno = nullptr;
	if(this->head!= nullptr){
		retorno = this->head;
		this->head = retorno->getProx();
	}
	return retorno;
}
bool ListaEncadeada::isEmpty() const{
	return this->head == nullptr;
}
		
int ListaEncadeada::getQuant() const{
	return this->quant;
}
Nodo* ListaEncadeada::getHead() const{
	return this->head;
}