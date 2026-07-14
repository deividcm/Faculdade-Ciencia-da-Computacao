#ifndef HASH_H
#define HASH_H
#include "ListaEncadeada.h"
#include "MinHeap.h"

class Hash{
	private:
		ListaEncadeada * tabela;
		int tam;
		int quant;
		unsigned int funcaoHash(string pacote);
	public:
		Hash(int tam);
		void insert(string pacote);
		MinHeap* toHeap();
};



#endif