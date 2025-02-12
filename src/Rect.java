import java.awt.Graphics;

public class Rect {
    int x, y;

    int w, h;

    int old_x, old_y;

    public Rect(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;

        this.w = w;
        this.h = h;
    }

    public void chase(Rect r){

    }

    public boolean comesFromBellow() {
        return y > old_y;
    }

    public boolean comesFromAbove() {
        return y < old_y;
    }

    public boolean comesFromLeft() {
        return x > old_x;
    }

    public boolean comesFromRight() {
        return x < old_x;
    }

    // pushBy() is the reaction of the calling object due to the action of the moveBy() of the same calling object.
    public void pushBy(int dx, int dy) {
        x += dx;
        y += dy;
    }

    public boolean contains(PointXY p) {
        return (x <= p.x) && (x + w >= p.x) && (y <= p.y) && (y + h >= p.y);
    }

    public void moveBy(int dx, int dy) {
        // need to remember the last position of the object before update.
        old_x = x;
        old_y = y;

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
