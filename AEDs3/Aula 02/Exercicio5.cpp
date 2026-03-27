#include <iostream>
using namespace std;


void preencherVet(int * vet, int tam){
	for(int i = 0; i < tam; i++){
		cout << "Informe o elemento da posicao " << i << ": ";
		cin >> vet[i]; 
	}
}

// O(n²) feito sozinho
int encontraElementoMajoritarioN2(int * vet, int tam){
	
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
//O(n) dado pelo professor
int encontraElementoMajoritarioN(int * vet, int tam){
	int candidato = 0;
	int cont = 0;
	
	for(int i = 0; i < tam; i++){
		if(cont == 0){
			candidato = vet[i];
		}
		
		if(candidato == vet[i]){
			cont++;
		}
		else{
			cont--;
		}
	}
	
	
	return candidato;
}

int main(){
	int tam;
	int *vet;
	
	cout << "Informe o tamanho do vetor: ";
	cin >> tam;
	vet = new int[tam];
	
	preencherVet(vet,tam);
	
	int eMajoritario = encontraElementoMajoritarioN(vet,tam);
	
	cout << "Elemento majoritario: " << eMajoritario << endl;
	
	return 0;
}