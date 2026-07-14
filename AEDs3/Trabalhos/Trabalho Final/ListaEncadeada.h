#ifndef LISTAENCADEADA_H
#define LISTAENCADEADA_H

#include <string>
#include "Nodo.h"
using namespace std;
class ListaEncadeada{
	private:
		int quant;
		Nodo *head;
	public:
		ListaEncadeada();
		
		int insert(string item); 
		bool isEmpty() const;
		
		int getQuant() const;
		Nodo * getHead() const;
};

#endif