import javax.swing.*;
import java.awt.Graphics;

public class Main extends JPanel {
    @Override
    public void paint(Graphics pen) {
        drawHLine(100, 600, 100, pen);
        drawVLine(100, 300, 100, pen);
        drawDiagonalLine(100, 600, 300, 100, pen);
    }

    public void drawHLine(int x1, int x2, int y, Graphics pen) {
        if (x1 > x2) {
            int temp = x1;
            x1 = x2;
            x2 = temp;
        }

        for (int x = x1; x < x2; x++)
            drawPoint(x, y, pen);
    }

    public void drawVLine(int x, int y1, int y2, Graphics pen) {
        if (y1 > y2) {
            int temp = y1;
            y1 = y2;
            y2 = temp;
        }

        for (int y = y1; y < y2; y++)
            drawPoint(x, y, pen);
    }

    public void drawDiagonalLine(int x1, int x2, int y1, int y2, Graphics pen) {

    }

    public void drawPoint(int x, int y, Graphics pen) {
        pen.drawLine(x, y, x, y);
    }

    public static void main(String[] args) {
        JFrame window = new JFrame("Graphics drawing");
        Main panel = new Main();

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(800, 600);
        window.add(panel);
        window.setVisible(true);
    }

}