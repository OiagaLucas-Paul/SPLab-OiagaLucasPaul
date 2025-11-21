package Laboratoare;

public class Author {
	String name;
	String surname;
	Author(){}
	Author(String name, String surname){
		this.name=name;
		this.surname=surname;
	}
	public void print() {
		System.out.println("Author name: " + name + "\n Author surname: " + surname);
	}
}
