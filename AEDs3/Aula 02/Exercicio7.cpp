#include <iostream>
using namespace std;

void preencherVet(int * vet, int tam){
	for(int i = 0; i < tam; i++){
		cout << "Informe o elemento da posicao " << i << ": ";
		cin >> vet[i]; 
	}
}

int achaDiferente(int *vet, int tam){
	int inicio = vet[0];
	int contador = 0;
	for(int i = 1; i < tam; i++){
		if(inicio == vet[i]){
			contador++;
		}
		else if(contador > 0 or inicio == vet[i+1]){
			return i;
		}	
		else{
			return 0;
		}
		
	}
	return -1;
	
}

int main(){
	int tam;
	int *vet;
	
	cout << "Informe o tamanho do vetor: ";
	cin >> tam;
	vet = new int[tam];
	
	preencherVet(vet,tam);
	
	
	cout << "Posicao diferente: " << achaDiferente(vet,tam) << endl;
	return 0;
}
