#ifndef NODO_H
#define NODO_H
#include <string>
#include "Item.h"
using namespace std;
class Nodo{
	private:
		Nodo* prox;
		Item* item;
		string prefixo;
	public:
		Nodo();
	    Nodo(string& pacote);
	    Nodo(Item* item, string& prefixo);
	    void addFreq();
	    int getFreq() const;
	    void setProx(Nodo* prox);
	    Nodo* getProx() const;
	    void setItem(Item* item);
	    Item* getItem() const;
	    void setPrefixo(string prefixo);
	    string getPrefixo() const;
};

#endif