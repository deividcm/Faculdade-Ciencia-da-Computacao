#include "Nodo.h"
using namespace std;

Nodo::Nodo(){
	this->prox = nullptr;
	this->item = nullptr;
}
Nodo::Nodo(string& pacote){
	this->prox = nullptr;
	this->item = new Item(pacote);
}

void Nodo::addFreq(){
	this->item->addFreq();
}
int Nodo::getFreq() const{
	return this->item->getFreq();
}

void Nodo::setItem(Item* item){
	this->item = item;
}
Item* Nodo::getItem() const{
	return this->item;
}

void Nodo::setProx(Nodo* prox){
	this->prox = prox;
}
Nodo* Nodo::getProx() const{
	return this->prox;
}