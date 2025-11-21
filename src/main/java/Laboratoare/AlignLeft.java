package Laboratoare;

public class AlignLeft implements AlignStrategy {
    @Override
    public void render(Paragraph p, Object context) {
        System.out.println("Align Left: " + p.getText());
    }
}
