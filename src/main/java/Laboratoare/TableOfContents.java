package Laboratoare;

public class TableOfContents implements Element {
    @Override
    public void print() {
        System.out.println("Table of contents...");
    }

    @Override
    public void add(Element e) {}
    
    @Override
    public void remove(Element e) {}
    
    @Override
    public Element get(int index) { return null; }
    
    @Override
    public TableOfContents clone() {
        return new TableOfContents();
    }
}
