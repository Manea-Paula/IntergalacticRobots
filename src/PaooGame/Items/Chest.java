package PaooGame.Items;

import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;

import java.awt.*;
import java.awt.image.BufferedImage;

enum Key {
    found(1),
    notFound(0);

    private final int info;

    Key(int info) {
        this.info = info;
    }

    public int getInfo() {
        return info;
    }
}
public class Chest extends Item {
  //  private static float DEFAULT_SPEED=1.2f;
    protected float speed;
    // specificam coordonatele de start si de final ale zonei pe care se va misca obstacolul

    private BufferedImage image ;
    Hero hero;
    Hero2 hero2;


    public Chest(RefLinks refLink, float x, float y, int width, int height) {
        super(refLink, x, y, width, height);

        image = Assets.chest;

        bounds.x=(int)x;
        bounds.y=(int)y;
        bounds.width=width;
        bounds.height=height;

    }

    @Override
    public void Update() {

        // actualizam dreptunghiul de coliziune
        bounds.y = (int)y;

        // verificam daca player-ul intersecteaza obiectul

            // facem un switch case pentru cazul in care cheia a fost gasita sau nu
            switch (Key.found) {
                case found:
                    System.out.println("You found the key with info: " + Key.found.getInfo());

                    break;
                case notFound:
                    System.out.println("No key found with info: " + Key.notFound.getInfo());
                  //  hero.score=0;
                    break;
            }




    }

    @Override
    public void Draw(Graphics g) {
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
