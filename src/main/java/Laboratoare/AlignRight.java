package Laboratoare;

public class AlignRight implements AlignStrategy {
    @Override
    public void render(Paragraph p, Object context) {
        System.out.println("Align Right: " + p.getText());
    }
}
