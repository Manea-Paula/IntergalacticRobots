package PaooGame.Items;

import PaooGame.RefLinks;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Obstacol extends Character {
    private static float DEFAULT_SPEED=1.2f;
    protected float speed;
    // specificam coordonatele de start si de final ale zonei pe care se va misca obstacolul
    private float startY;
    private float endY;
    private BufferedImage image ;

    public Obstacol(RefLinks refLink, float x, float y, int width, int height, float startY, float endY) {
        super(refLink, x, y, width, height);
        speed= DEFAULT_SPEED;
        this.startY = startY;
        this.endY = endY;
        try{
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/textures/blade.png")));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

        bounds.x=(int)x;
        bounds.y=(int)y;
        bounds.width=width;
        bounds.height=height;

        life=10;
    }

    @Override
    public void Update() {
        // actualizam pozitia pe axa Y a obstacolului in functie de viteza setata
        y += speed;
        // daca obstacolul a ajuns la coordonata de final, il resetam la pozitia de start
        if (y > endY) {
            y = startY;
        }
        // actualizam dreptunghiul de coliziune
        bounds.y = (int)y;


    }

    @Override
    public void Draw(Graphics g) {
        // desenam obstacolul
//        g.setColor(Color.BLACK);
//        g.fillRect((int)x, (int)y, width, height);
       g.drawImage(image,(int)x,(int)y,width,height,null);
//       g.drawRect((int)x,(int)y,width,height);
    }

    public Rectangle getBounds()
    {
        return new Rectangle((int)x,(int)y,width,height);
    }
}
