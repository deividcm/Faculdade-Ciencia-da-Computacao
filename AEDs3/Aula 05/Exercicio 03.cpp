#include <iostream>
using namespace std;

void swap(int*pos1,int*pos2){
	int aux = *pos1;
	*pos1 = *pos2;
	*pos2 = aux;
}

void imprimeVet(int vet[], int tam){
	for(int i = 0; i < tam-1; i++){
		cout << vet[i] << ", ";
	}
	cout << vet[tam-1] << endl;
}

int partition(int vet[], int pivo, int inicio, int final){
	
	int primeiroMaior = inicio;
	int igual;
	int aux;
	for(int i = inicio; i < final; i++){
		if(vet[i] < pivo) {
			swap(&vet[i], &vet[primeiroMaior]);
			
			primeiroMaior++;	
		}

		else if (vet[i] == pivo){
			igual = i;
		}
	}
	swap(&vet[igual], &vet[primeiroMaior]);
	
	return primeiroMaior;
}

void quickSort(int porcas[], int parafusos[], int inicio, int final){
	int p1;
	int p2;
	if(final > inicio){
		p1 = partition(porcas,parafusos[final],inicio,final);
		p2 = partition(parafusos, porcas[p1], inicio, final);
		quickSort(porcas,parafusos,inicio,p1-1);
		quickSort(porcas,parafusos,p1+1,final);
	}
}


int main(){
	int porcas[] = {6,3,4,2,8,1,5,7,9};
	int parafusos[]={7,3,2,9,1,6,4,5,8};
	int tam = 9;
	
	quickSort(porcas,parafusos,0, tam-1);
	
	imprimeVet(porcas,tam);
	imprimeVet(parafusos,tam);
}

