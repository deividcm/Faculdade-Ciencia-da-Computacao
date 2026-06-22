#include <stdio.h>
#include <iostream>
#include <stdlib.h>
#include <string.h>
#include <fstream>
#include <iomanip> 

using namespace std;


#define TAMANHO_TABELA  65536 // 2^16
typedef struct Node {
	char ip[16];
	int frequencia;
	int size;
	struct Node* proximo;
} Node;

Node* tabela[TAMANHO_TABELA];
//Coloquei como variavel global so para focar nas outras partes;
int total = 0;
int total_unico = 0;

unsigned int funcao_hash(char* ip) {
	unsigned int hash = 1;
	// usa caracteres ASCII do IP
	for (int i = 8; ip[i] != '\0'; i++) {
		hash += ip[i];
		hash *= ip[i];
	}
	//cout << hash << endl;
	int a = 2654435769;
    int l = 16;
    uint32_t mult = (unsigned int) hash * a;
	return (mult >> (32-l));
	/*return hash % TAMANHO_TABELA;*/
}
void inserir(char* ip) {
	unsigned int indice = funcao_hash(ip);
	Node* atual = tabela[indice];
	total++;
	while (atual != NULL) {
		if (strcmp(atual->ip, ip) == 0) {
			atual->frequencia++;
			return;
		}
		atual = atual->proximo;
	}
	
	// aloca memória para novo nó
	Node* novo = (Node*)malloc(sizeof(Node));
	if (novo == NULL) {
		printf("Erro: Falha na alocação de memória.\n");
		exit(1);
	}
	// dados do novo nó
	strcpy(novo->ip, ip);
	novo->frequencia = 1;
	
	novo->size = 1; 
	novo->proximo = tabela[indice];
	if(tabela[indice] != nullptr){
		novo->size += tabela[indice]->size;
	}
	// tabela tem novo nó como referência
	tabela[indice] = novo;
	
	total_unico++;
}

int main(){
	string nomeArquivo = "dados_ips.txt";
	ifstream arquivo;
	arquivo.open(nomeArquivo.c_str());
	string ip;
	while(getline(arquivo, ip)){
		char * ip_char = new char[16];
		ip_char = (char *)ip.c_str();
		inserir(ip_char);
		//cout << ip_char << endl;
	}
	arquivo.close();
	
	int maior = 0;
	int soma_vazio = 0;
	for(int i = 0; i < TAMANHO_TABELA; i++){
		Node* no = tabela[i];
		if(no != nullptr){
			if(no->size > maior){
				maior = no->size;
			}
		}
		else{
			soma_vazio++;
		}
		
	}
	float fator = total_unico/TAMANHO_TABELA;
	cout << "Total de IPs: " << total << endl;
	cout << "Total de IPs Unicos: " << total_unico << endl;
	cout << "Fator de carga: " << setprecision(2) << (float)total_unico/ (float)TAMANHO_TABELA << endl;
	cout << "Tamanho da maior lista: " << maior << endl;
	cout << "Posicoes vazias: " << soma_vazio << " de " << TAMANHO_TABELA << endl;
	return 0;
}



