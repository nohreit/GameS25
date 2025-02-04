import java.awt.*;

public class PointXY {
    int x;
    int y;

    public PointXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics pen) {
        pen.drawLine(x, y, x, y);
    }
}
