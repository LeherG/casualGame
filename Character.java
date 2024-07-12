import java.io.File;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.util.List;

public class Character extends MovingThing {
    private Image image;
    private int ySpeed;
    private int y;

    public Character(String o, int x, int y, int w, int h, int s) {
        super(x,y,w,h);
        ySpeed = s;
        this.y = y;

        try {
            URL url = getClass().getResource(o+".png");
        }
        catch(Exception e) {
            //empty
        }
    }

    public void jump() {
        ySpeed = -20;
    }

    public void update() {
        y += ySpeed;
        ySpeed += 2;
        if (y > 500 - getHeight()) { // Adjust 500 based on the ground level
            y = 500 - getHeight();
            ySpeed = 0; // Character is on the ground, so reset the vertical speed
        }
    }

    public int getSpeed() {
        return ySpeed;
    }

    public void setSpeed(int s) {
        ySpeed = s;
    }

    public void move(String direction){ }

    public void draw(Graphics window) {
        window.drawImage(image, getX(), getY(), getWidth(), getHeight(), null);
    }
}
