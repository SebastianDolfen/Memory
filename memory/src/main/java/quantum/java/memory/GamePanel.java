package quantum.java.memory;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import java.awt.event.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable, KeyListener {
    private static final long serialVersionUID = 1L;

    public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    private Thread thread;
    private boolean isRunning = false;

    private int FPS = 60;
    private long targetTime = 1000 / FPS;

    private GameStateManager gsm = new GameStateManager();

    public GamePanel() {
        setPreferredSize(screenSize);
        addKeyListener(this);
        setFocusable(true);
        start();
    }
    
    private void start() {
        isRunning = true;
        thread = new Thread(this);
        thread.start();
    }

    public void run() {
        long start, elapsed, wait;

        while(isRunning) {
            start = System.nanoTime();

            tick();
            repaint();

            elapsed = System.nanoTime() - start;
            wait = targetTime - elapsed / 1000000;

            if (wait <= 0) {
                wait = 5;
            }

            try {
                Thread.sleep(wait);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void tick() {
        gsm.tick();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.clearRect(0, 0, screenSize.width, screenSize.height);

        gsm.draw(g);
    }

    public void keyPressed(KeyEvent e) {
        gsm.keyPressed(e.getKeyCode());
    }

    public void keyReleased(KeyEvent e) {
        gsm.keyReleased(e.getKeyCode());
    }

    public void keyTyped(KeyEvent e) {
        
    }
}