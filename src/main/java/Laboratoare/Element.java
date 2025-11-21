package Laboratoare;

public interface Element {
	void print();
	void add(Element e);
	void remove(Element e);
	Element get(int i);
	Element clone();
}
