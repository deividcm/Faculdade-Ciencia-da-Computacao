#include "Item.h"
using namespace std;

Item::Item(){
	this->freq = 0;
	this->pacote = "";
	this->dir = nullptr;
	this->esq = nullptr;
}
Item::Item(string pacote){
	this->freq = 1;
	this->pacote = pacote;
	this->dir = nullptr;
	this->esq = nullptr;
}
Item::Item(int freq){
	this->freq = freq;
	this->pacote = "?";
	this->dir = nullptr;
	this->esq = nullptr;
}
Item::Item(const Item& outro){
	this->freq = outro.getFreq();
	this->pacote = outro.getPacote();
	this->dir = outro.getDir();
	this->esq = outro.getEsq();
}

void Item::addFreq(){
	this->freq++;
}
int Item::getFreq() const{
	return this->freq;
}

void Item::setPacote(string pacote){
	this->pacote = pacote;
}
string Item::getPacote() const{
	return this->pacote;
}

void Item::setEsq(Item* esq){
	this->esq = esq;
}
Item* Item::getEsq() const{
	return this->esq;
}

void Item::setDir(Item* dir){
	this->dir = dir;
}
Item* Item::getDir() const{
	return this->dir;
}