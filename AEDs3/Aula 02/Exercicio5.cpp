#include <iostream>
using namespace std;


void preencherVet(int * vet, int tam){
	for(int i = 0; i < tam; i++){
		cout << "Informe o elemento da posicao " << i << ": ";
		cin >> vet[i]; 
	}
}

// O(n²)
int encontraElementoMajoritario(int * vet, int tam){
	
	for (int i = 0; i < (tam/2 + 1); i++){
		int cont = 0;
		for(int j = 0; j < tam; j++){
			if (vet[i] == vet[j]){
				cont++;
			}
		}
		if (cont >= tam/2){
			return vet[i];
		}
	}
	
	cout << "Nao existe um elemento majoritario" << endl;
	
	return -1;
}


int main(){
	int tam;
	int *vet;
	
	cout << "Informe o tamanho do vetor: ";
	cin >> tam;
	vet = new int[tam];
	
	preencherVet(vet,tam);
	
	int eMajoritario = encontraElementoMajoritario(vet, tam);
	
	cout << "Elemento majoritario: " << eMajoritario << endl;
	
	return 0;
}