package Laboratoare;
public class Paragraph implements Element {
    private String text;
    private AlignStrategy textAlignment;

    public Paragraph() {}
    public Paragraph(String text) {
        this.text = text;
    }

    public void setAlignStrategy(AlignStrategy a) {
        this.textAlignment = a;
    }

    @Override
    public void print() {
        if (textAlignment != null) {
            textAlignment.render(this, null);
        } else {
            System.out.println("Paragraph: " + text);
        }
    }

    @Override
    public void add(Element e) {}
    
    @Override
    public void remove(Element e) {}
    
    @Override
    public Element get(int index) { return null; }
    
    @Override
    public Paragraph clone() {
        return new Paragraph(this.text);
    }

    public String getText() {
        return text;
    }
}
