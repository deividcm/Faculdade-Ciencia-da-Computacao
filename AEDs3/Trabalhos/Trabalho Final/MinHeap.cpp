#include "MinHeap.h"
#include <iostream>
using namespace std;

MinHeap::MinHeap(int tam){
	this->tam = tam;
	this->fila = new Item[tam];
	this->quant = 0;
}

void MinHeap::insert(Item* item){
	this->fila[quant] = *item;
	this->quant++;
	this->heapifyUp(this->quant-1);
	
	for(int i = 0; i < quant; i++){
		cout << i << " - " << this->fila[i].getPacote() << " - " << this->fila[i].getFreq() << endl;
	}
	cout << endl;
}
Item MinHeap::extractMin(){
	Item menorItem = this->fila[0];
	this->fila[0] = this->fila[this->quant-1];
	this->quant--;
	
	if(this->quant > 0){
		this->heapifyDown(0);
	}
	return menorItem;
}

int MinHeap::left(int i){
	return (2*i)+1;
}
int MinHeap::right(int i){
	return (2*i)+2;
}
int MinHeap::parent(int i){
	return (i-1)/2;
}
void MinHeap::heapifyUp(int i){
	while(i > 0 && this->fila[this->parent(i)].getFreq() > this->fila[i].getFreq()){
		swap(this->fila[i], this->fila[this->parent(i)]);
		i = this->parent(i);
	}
}
void MinHeap::heapifyDown(int i){
	int menor = i;
    int l = left(i);
    int r = right(i);
    
    if (l <= this->quant && this->fila[l].getFreq() < this->fila[menor].getFreq()) {
		menor = l;
    }
    if (r <= this->quant && this->fila[r].getFreq() < this->fila[menor].getFreq()) {
    	menor = r;
    }
    
    if (menor != i) {
    	swap(this->fila[i], this->fila[menor]);
        heapifyDown(menor);
    }
}
Item MinHeap::toHuff(){
	while(this->quant > 1){
		
		Item esq = this->extractMin();
		Item dir = this->extractMin();
		
		
		Item* pai = new Item(esq.getFreq() + dir.getFreq());
		pai->setEsq(new Item(esq));
		pai->setDir(new Item(dir));
		
		this->insert(pai);
	}
	
	
	return this->extractMin();
}


