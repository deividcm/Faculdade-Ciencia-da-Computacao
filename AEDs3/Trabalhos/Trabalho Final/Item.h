#ifndef ITEM_H
#define ITEM_H
#include<string>
using namespace std;
class Item{
	private:
		string pacote;
		int freq;
		Item* esq;
		Item* dir;
	public:
		Item();
		Item(int freq);
		Item(string pacote);
		Item(const Item& outro);
		void setPacote(string pacote);
	    string getPacote() const;
	    void addFreq();
	    int getFreq() const;
	    void setEsq(Item* esq);
	    Item* getEsq() const;
	    void setDir(Item* dir);
	    Item* getDir() const;
};

#endif