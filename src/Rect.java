import java.awt.Graphics;

public class Rect {
    int x;
    int y;

    int w;
    int h;

    public Rect(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;

        this.w = w;
        this.h = h;
    }

    public boolean contains(PointXY p) {
        return (x <= p.x) && (x + w >= p.x) && (y <= p.y) && (y + h >= p.y);
    }

    public void moveBy(int dx, int dy) {
        x += dx;
        y += dy;
    }

    public boolean overlaps(Rect r) {
        return (x <= r.x + r.w) &&
                (x + w >= r.x) &&
                (y <= r.y + r.h) &&
                (y + h >= r.y);
    }

    public void draw(Graphics pen) {
        pen.drawRect(x, y, w, h);
    }
}
