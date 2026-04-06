#include <iostream>
using namespace std;

void insertionSortDuplo(int vetor[], int n){
	int j = 0;
	int k = 0;
	for(int i = 0; i < n-1; i+=2){
		if(vetor[i] <= vetor[i+1]){
			j = i;
			k = i+1;
		}else{
			j = i+1;
			k = i+1;
		}
		while((j>0) && (vetor[j] <= vetor[j-1])){
			int aux = vetor[j];
			vetor[j] = vetor[j-1];
			vetor[j-1] = aux;
			j -= 1;
			
			if(vetor[k] <= vetor[k-1]){
				aux = vetor[k];
				vetor[k] = vetor[k-1];
				vetor[k-1] = aux;
				k -= 1;
			}
		}
		/*
		while((k>0) && (vetor[k] <= vetor[k-1])){
			int aux = vetor[k];
			vetor[k] = vetor[k-1];
			vetor[k-1] = aux;
			
			k -= 1;
		}*/
	}
	
	if(n%2 == 1){
		j = n-1;
		while((j>0) && (vetor[j] < vetor[j-1])){
			int aux = vetor[j];
			vetor[j] = vetor[j-1];
			vetor[j-1] = aux;
			
			j -= 1;
		}
	}
	
}

void imprimeVet(int vet[], int n){
	for(int i = 0; i < n-1; i++){
		cout << vet[i] << ", ";
	}
	cout << vet[n-1] << endl;
}

void insertion_sort(int s[], int n){
    int i = 0, j = 0;
    for (i=1; i<n; i++) {
        j=i;
        while ((j>0) && (s[j] < s[j-1])) {
        	int aux = s[j];
        	s[j] = s[j-1];
        	s[j-1] = aux;
            
            j = j-1;
        }
    }
}


int main(){
	int vetor[] = {7, 8, 5, 1, 4, 2, 3};
	
	insertionSortDuplo(vetor,7);
	
	imprimeVet(vetor, 7);
	
}