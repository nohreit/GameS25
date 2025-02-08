import javax.swing.*;
import java.awt.*;

public class GameLoop extends JPanel {

    Rect r1 = new Rect(200, 100, 200, 100);
    Rect r2 = new Rect(450, 100, 300, 200);

    // GameLoop
    public GameLoop () {
        Timer timer = new Timer(16, e -> gameUpdate());
        timer.start();
    }

    // GameUpdate
    public void gameUpdate() {
        // Game update logic here
        r1.moveBy(2, 1);
        r2.moveBy(1, -1);


        repaint(); // Refresh the screen
    }

    @Override
    public void paint(Graphics pen) {
        super.paint(pen);
        // Draw game graphics here
        pen.drawString(r1.overlaps(r2) ? "The rectangles overlap" : "The rectangles don't overlap", 100, 450);

        pen.setColor(Color.CYAN);
        r1.draw(pen);

        pen.setColor(Color.GREEN);
        r2.draw(pen);
    }

    public static void main(String[] args) {
        JFrame window = new JFrame("Graphics drawing");
        GameLoop game = new GameLoop();

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(1080, 720);
        window.add(game);
        window.setVisible(true);
    }

}