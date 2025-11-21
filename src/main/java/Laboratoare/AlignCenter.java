package Laboratoare;

public class AlignCenter implements AlignStrategy {
    @Override
    public void render(Paragraph p, Object context) {
        System.out.println("Align Center: " + p.getText());
    }
}
