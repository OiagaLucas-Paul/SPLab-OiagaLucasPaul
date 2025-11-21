package Laboratoare;

import java.util.ArrayList;
import java.util.List;

public class Section implements Element {
    private String title;
    private List<Element> elements = new ArrayList<>();

    public Section() {}
    public Section(String title) {
        this.title = title;
    }

    @Override
    public void print() {
        System.out.println("Section: " + title);
        for (Element e : elements) {
            e.print();
        }
    }

    @Override
    public void add(Element e) {
        elements.add(e);
    }

    @Override
    public void remove(Element e) {
        elements.remove(e);
    }

    @Override
    public Element get(int index) {
        return elements.get(index);
    }
    
    @Override
    public Section clone() {
        Section copy = new Section(this.title);
        for (Element e : this.elements) {
            try {
                copy.add(e.clone());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return copy;
    }

}
