#include "Nodo.h"
using namespace std;

Nodo::Nodo(){
	this->prox = nullptr;
	this->item = nullptr;
	this->prefixo = "";
}
Nodo::Nodo(string& pacote){
	this->prox = nullptr;
	this->item = new Item(pacote);
	this->prefixo = "";
}
Nodo::Nodo(Item* item, string& prefixo){
	this->prox = nullptr;
	this->item = item;
	this->prefixo = prefixo;
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

void Nodo::setPrefixo(string prefixo){
	this->prefixo = prefixo;
}
string Nodo::getPrefixo() const{
	return this->prefixo;
}