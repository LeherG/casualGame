import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Game implements KeyListener, Runnable {
    private Character player;
    private String bgLocation = "bg.png";
    private File bg;
    private BufferedImage backg;

    private boolean pause = false;
    private boolean end = false;

    public Game(String charChoice) {
        try {
            bg = new File(bgLocation);
        } catch (Exception f) {
            System.out.println("Couldn't open bg file");
        }

        try {
            backg = ImageIO.read(bg);
        } catch (IOException e) {
            System.out.println("Couldn't load background");
        }


        setBackground(Color.black);

        new Thread(this).start();
        
        setVisible(true);

        player = new Character(charChoice, 20, 20, 20, 20, 3);
    }

    public void update(Graphics window) {
        paint(window);
    }

    public void paint(Graphics window) {
        if (end) return;
        
        Graphics2D twoDGraph = (Graphics2D) window;

        if (backg != null) {
            twoDGraph.drawImage(backg, 0, 0, this);
        }
    }

    public void run() {
        try {
            while (true) {
                Thread.currentThread().sleep(5);
            }
        } catch (Exception e) {
        }
    }
}
