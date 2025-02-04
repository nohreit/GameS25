import javax.swing.*;
import java.awt.*;

public class Main extends JPanel {
    Rect r1 = new Rect(200, 100, 200, 100);
    Rect r2 = new Rect(350, 100, 300, 200);
    PointXY p1 = new PointXY(150, 150);

    @Override
    public void paint(Graphics pen) {

        pen.drawString(r1.contains(p1) ? "The point is inside" : "The point is outside", 100, 400);

        pen.drawString(r1.overlaps(r2) ? "They overlap" : "They don't overlap", 100, 450);

        pen.setColor(Color.CYAN);
        r1.draw(pen);

        pen.setColor(Color.GREEN);
        r2.draw(pen);

        pen.setColor(Color.RED);
        p1.draw(pen);
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

    public void drawRect(int x, int y, int w, int h, Graphics pen) {
        drawHLine(x, x + w, y, pen);
        drawHLine(x, x + w, y + h, pen);
        drawVLine(x, y, y + h, pen);
        drawVLine(x + w, y, y + h, pen);
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