#ifndef MINHEAP_H
#define MINHEAP_H
#include "Item.h"

class MinHeap{
	private:
		Item* fila;
		int tam;
		int quant;
		
		int left(int i);
		int right(int i);
		int parent(int i);
		void heapifyUp(int i);
		void heapifyDown(int i);
	public:
		MinHeap(int tam);
		void insert(Item* item);
		Item extractMin();
		Item toHuff();
};


#endif