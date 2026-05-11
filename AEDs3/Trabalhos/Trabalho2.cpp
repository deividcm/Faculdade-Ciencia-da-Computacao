#include <iostream>
#include <iomanip> 
using namespace std;

double funcao(double x){
  return ((x*x*x) - x - 2);
}

double encontraRaiz(double menor, double maior){
  if(menor > maior){
    return -999;
  }
  
  double meio = (menor+maior)/2;
  
  if(funcao(meio) <= 0.00001 && funcao(meio) >= -0.00001){
    return meio;
  }
  
  else if(funcao(meio)*funcao(menor) < 0){
    return encontraRaiz(menor, meio);
  }
  
  else{
    return encontraRaiz(meio, maior);
  }
}

int main(){
  
  double raiz = encontraRaiz(0, 2);
  cout << setprecision(5) << raiz << endl;
  return 0;
}
