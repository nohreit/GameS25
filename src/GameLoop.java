import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameLoop extends JPanel implements KeyListener {

    Rect r1;
    Rect r2;
    int ax = 6;
    int ay = 6;

    boolean UP_pressed = false;
    boolean DN_pressed = false;
    boolean LT_pressed = false;
    boolean RT_pressed = false;

    // GameLoop
    public GameLoop() {
        // Create objects
        r1 = new Rect(200, 100, 20, 20);
        r1.spx = 6;
        r1.spy = 6;
        r2 = new Rect(250, 100, 50, 50);
        r2.spx = 2;
        r2.spy = 2;

        // Set up game loop
        Timer timer = new Timer(16, e -> gameUpdate());
        timer.start();

        // Set up listeners
        setFocusable(true);
        requestFocusInWindow();
        addKeyListener(this);

    }

    public void gameLogic() {
        if (UP_pressed) r1.moveBy(0, -ay);
        if (DN_pressed) r1.moveBy(0, ay);
        if (LT_pressed) r1.moveBy(-ax, 0);
        if (RT_pressed) r1.moveBy(ax, 0);

//        r2.chase(r1);
        r2.evade(r1);

        if (r1.overlaps(r2)) {
//            if (r1.comesFromBellow()) r1.pushBy(0, -ay);
//            if (r1.comesFromAbove()) r1.pushBy(0, ay);
//            if (r1.comesFromLeft()) r1.pushBy(-ax, 0);
//            if (r1.comesFromRight()) r1.pushBy(ax, 0);
//            int x = r2.x, y = r2.y, h = r2.h, w = r2.w;
//            pen.fillRect(r2.x, r2.y, r2.w, r2.h);

            // This will move the red square off the screen on contact with the blue square
            r2.x = -r2.w;
            r2.y = -r2.h;

            // This will prevent the red square to keep moving.
            r2.spx = 0;
            r2.spy = 0;
        }
    }

    public void drawGameGraphics(Graphics pen) {
        pen.setColor(Color.BLUE);
        r1.draw(pen);

        pen.setColor(Color.RED);
        r2.draw(pen);

        if (r2.x < 0 && r2.y < 0) {
            pen.drawString("You won!!!!", 500, 200);
        }
    }

    // GameUpdate
    public void gameUpdate() {
        // Game update logic here
        gameLogic();
        repaint(); // Refresh the screen (Ask OS to update the screen)
    }

    @Override
    public void paint(Graphics pen) {
        super.paint(pen);
        // Draw game graphics here
        drawGameGraphics(pen);
    }

    public static void main(String[] args) {
        JFrame window = new JFrame("Graphics drawing");
        GameLoop game = new GameLoop();

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(1080, 720);
        window.add(game);
        window.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) UP_pressed = true;
        if (e.getKeyCode() == KeyEvent.VK_DOWN) DN_pressed = true;
        if (e.getKeyCode() == KeyEvent.VK_LEFT) LT_pressed = true;
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) RT_pressed = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) UP_pressed = false;
        if (e.getKeyCode() == KeyEvent.VK_DOWN) DN_pressed = false;
        if (e.getKeyCode() == KeyEvent.VK_LEFT) LT_pressed = false;
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) RT_pressed = false;
    }
}