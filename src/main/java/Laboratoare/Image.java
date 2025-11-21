package Laboratoare;

public class Image implements Element {
    private String url;
    private ImageContent content;

    public Image(String url) {
        this.url = url;
        this.content = new ImageContent(url);
    }

    public ImageContent content() {
        return content;
    }

    @Override
    public void print() {
        System.out.println("Image with name: " + content.getName());
    }

    @Override
    public void add(Element e) {}
    
    @Override
    public void remove(Element e) {}
    
    @Override
    public Element get(int index) { return null; }
    
    @Override
    public Image clone() {
        return new Image(this.url);
    }

}
