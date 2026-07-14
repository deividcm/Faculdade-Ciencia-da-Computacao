#ifndef LISTAENCADEADA_H
#define LISTAENCADEADA_H

#include <string>
#include "Nodo.h"
using namespace std;
class ListaEncadeada{
	private:
		int quant;
		Nodo *head;
		Nodo *ultimo;
	public:
		ListaEncadeada();
		
		int insert(string pacote); 
		void insert(Item* item, string prefixo); 
		Nodo* pop();
		bool isEmpty() const;
		
		int getQuant() const;
		Nodo * getHead() const;
};

#endif