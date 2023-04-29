package PaooGame.Items;

import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class ObstacolBlade extends Character {
    private static float DEFAULT_SPEED=1.2f;
    protected float speed;
    // specificam coordonatele de start si de final ale zonei pe care se va misca obstacolul
    private float startY;
    private float endY;
    private BufferedImage image ;
    private float rotationAngle = 0.0f;
    private static final float ROTATION_SPEED = 2.0f; // Viteza de rotație în grade pe cadru


    public ObstacolBlade(RefLinks refLink, float x, float y, int width, int height, float startY, float endY) {
        super(refLink, x, y, width, height);
        speed= DEFAULT_SPEED;
        this.startY = startY;
        this.endY = endY;

        image= Assets.blade;

        bounds.x=(int)x;
        bounds.y=(int)y;
        bounds.width=width;
        bounds.height=height;

      //  life=10;
    }

    @Override
    public void Update() {
        // actualizam unghiul de rotație
        rotationAngle += ROTATION_SPEED;
        if (rotationAngle >= 360.0f) {
            rotationAngle -= 360.0f;
        }

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
   //    g.drawImage(image,(int)x,(int)y,width,height,null);
//       g.drawRect((int)x,(int)y,width,height);

        Graphics2D g2d = (Graphics2D) g.create();
        AffineTransform oldTransform = g2d.getTransform();
        g2d.rotate(Math.toRadians(rotationAngle), x + width / 2, y + height / 2);
        g2d.drawImage(image, (int) x, (int) y, width, height, null);
        g2d.setTransform(oldTransform);
        g2d.dispose();
    }

    public Rectangle getBounds()
    {
        return new Rectangle((int)x,(int)y,width,height);
    }
}
