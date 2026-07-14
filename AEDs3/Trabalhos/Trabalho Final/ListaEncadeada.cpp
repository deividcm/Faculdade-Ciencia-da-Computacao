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
bool ListaEncadeada::isEmpty() const{
	return this->head == nullptr;
}
		
int ListaEncadeada::getQuant() const{
	return this->quant;
}
Nodo* ListaEncadeada::getHead() const{
	return this->head;
}