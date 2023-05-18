package PaooGame.Items;

import PaooGame.Graphics.Assets;
import PaooGame.InfoBox;
import PaooGame.RefLinks;
import PaooGame.Sound.SoundManager;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/*! \class public class Hero extends Character
    \brief Implementeaza notiunea de erou/player (caracterul controlat de jucator).

    Elementele suplimentare pe care le aduce fata de clasa de baza sunt:
        imaginea (acest atribut poate fi ridicat si in clasa de baza)
        deplasarea
        atacul (nu este implementat momentan)
        dreptunghiul de coliziune

        adunatul de obiecte
 */
public class Hero2 extends Character
{
    private BufferedImage image;    /*!< Referinta catre imaginea curenta a eroului.*/
    private BufferedImage[] upFrames;    // Array of images for character motion
    private BufferedImage[] downFrames;
    private BufferedImage[] leftFrames;
    private BufferedImage[] rightFrames;
    private BufferedImage[] attackFrames;
    private int currentFrame; // Current animation frame
    private int animationSpeed; // Speed of animation
    private boolean canMove=true;
    private boolean foundBattery= true;
    private boolean foundChest=true;
    private boolean mapanoua=true;

    /*! \fn public Hero(RefLinks refLink, float x, float y)
        \brief Constructorul de initializare al clasei Hero.

        \param refLink Referinta catre obiectul shortcut (obiect ce retine o serie de referinte din program).
        \param x Pozitia initiala pe axa X a eroului.
        \param y Pozitia initiala pe axa Y a eroului.
     */
    public Hero2(RefLinks refLink, float x, float y)
    {
        ///Apel al constructorului clasei de baza
        super(refLink, x,y, Character.DEFAULT_CREATURE_WIDTH, Character.DEFAULT_CREATURE_HEIGHT);
        ///Seteaza imaginea de start a eroului
        image = Assets.ErikaIdle;
        ///Stabilieste pozitia relativa si dimensiunea dreptunghiului de coliziune, starea implicita(normala)
        normalBounds.x = 16;
        normalBounds.y = 16;
        normalBounds.width = 16;
        normalBounds.height = 32;

        ///Stabilieste pozitia relativa si dimensiunea dreptunghiului de coliziune, starea de atac
//        attackBounds.x = 10;
//        attackBounds.y = 10;
//        attackBounds.width = 38;
//        attackBounds.height = 38;

        // Load images for character motion
        upFrames = new BufferedImage[] { Assets.ErikaUp1, Assets.ErikaUp2,Assets.ErikaUp3,Assets.ErikaUp4,Assets.ErikaUp5,Assets.ErikaUp6};
        downFrames = new BufferedImage[] { Assets.ErikaDown1, Assets.ErikaDown2,Assets.ErikaDown3,Assets.ErikaDown4,Assets.ErikaDown5,Assets.ErikaDown6};
        leftFrames = new BufferedImage[] { Assets.ErikaLeft1, Assets.ErikaLeft2, Assets.ErikaLeft3,Assets.ErikaLeft4,Assets.ErikaLeft5,Assets.ErikaLeft6};
        rightFrames = new BufferedImage[] { Assets.ErikaRight1, Assets.ErikaRight2 ,Assets.ErikaRight3,Assets.ErikaRight4,Assets.ErikaRight5,Assets.ErikaRight6};
        attackFrames= new BufferedImage[] {Assets.ErikaAttack2,Assets.ErikaAttack3,Assets.ErikaAttack4,Assets.ErikaAttack5,Assets.ErikaAttack6};


        currentFrame = 0;
        animationSpeed = 14;
    }


    /*! \fn public void Update()
        \brief Actualizeaza pozitia si imaginea eroului.
     */
    @Override
    public void Update()
    {
        ///Verifica daca a fost apasata o tasta
        GetInput();
        ///Actualizeaza pozitia
        Move();
        ///Actualizeaza imaginea
        if (refLink.GetKeyManager2().up == true) {
            currentFrame++;
            if (currentFrame >= upFrames.length * animationSpeed) {
                currentFrame = 0;
            }
            image = upFrames[currentFrame / animationSpeed];
        } else if (refLink.GetKeyManager2().down == true) {
            currentFrame++;
            if (currentFrame >= downFrames.length * animationSpeed) {
                currentFrame = 0;
            }
            image = downFrames[currentFrame / animationSpeed];
        } else if (refLink.GetKeyManager2().left == true) {
            currentFrame++;
            if (currentFrame >= leftFrames.length * animationSpeed) {
                currentFrame = 0;
            }
            image = leftFrames[currentFrame / animationSpeed];
        } else if (refLink.GetKeyManager2().right == true) {
            currentFrame++;
            if (currentFrame >= rightFrames.length * animationSpeed) {
                currentFrame = 0;
            }
            image = rightFrames[currentFrame / animationSpeed];
        } else if (refLink.GetKeyManager2().p == true) {
            currentFrame++;
            if (currentFrame >= rightFrames.length * animationSpeed) {
                currentFrame = 0;
            }
            image = attackFrames[currentFrame / animationSpeed];

            //    String soundUrl= this.getClass().getResource("/res/textures/AngryRobotBird.wav").getPath();
            // SoundManager.playSound("/home/paula/Documents/PaooGameEtapa2/res/textures/Angry Robot Bird.wav");
            //  SoundManager.playSound(soundUrl);
        }

        else
        {
            // If no direction is pressed, show idle image
            image = Assets.ErikaIdle;
        }
    }

    /*! \fn private void GetInput()
        \brief Verifica daca a fost apasata o tasta din cele stabilite pentru controlul eroului.
     */
    public void GetInput()
    {
        xMove = 0;
        yMove = 0;


        if(refLink.GetKeyManager2().up)
        {

            // Apel functie checkCollisionWithObstacles pentru directia in care merge eroul
            canMove = refLink.GetMap().checkCollisionWithObstacles(x, y + yMove, DEFAULT_CREATURE_WIDTH);
            foundBattery=refLink.GetMap().collisionBattery(getBounds());
            foundChest=refLink.GetMap().checkCollisionWithChest(getBounds());
            mapanoua=refLink.GetMap().loadothermap(x,y+yMove,DEFAULT_CREATURE_WIDTH);
            refLink.GetMap().checkCollisionWithButtonAlb1(getBounds());
            refLink.GetMap().checkCollisionWithButtonAlb2(getBounds());
            refLink.GetMap().checkCollisionWithButtonRosu2(getBounds());
            refLink.GetMap().checkCollisionWithButtonRosu3(getBounds());
            refLink.GetMap().checkCollisionWithButtonAlb3(getBounds());
            System.out.println("up"+canMove);
//            System.out.println(x+""+(y+yMove);
//
            if(canMove==false) //nu e coliziune
            {
                yMove = -speed;
            }
            else
            {
                life-=10;
                yMove=40;
                SetX(x);

            }

            if(foundBattery)
            {
           //     System.out.println("merge bine 2");
                speed+=0.5f;
            }

            if(foundChest)
            {
             //   System.out.println("gasit cufar");
                keys++;
                if(keys>=2)
                {
                    System.out.println("intra pe aici");
//                    mapanoua=refLink.GetMap().loadothermap(x,y+yMove,DEFAULT_CREATURE_WIDTH);
                }
            }

        }
        else if(refLink.GetKeyManager2().down)
        {

            // Apel functie checkCollisionWithObstacles pentru directia in care merge eroul
            canMove = refLink.GetMap().checkCollisionWithObstacles(x, y + yMove, DEFAULT_CREATURE_WIDTH);
            foundBattery=refLink.GetMap().collisionBattery(getBounds());
            foundChest=refLink.GetMap().checkCollisionWithChest(getBounds());
            mapanoua=refLink.GetMap().loadothermap(x,y+yMove,DEFAULT_CREATURE_WIDTH);
            refLink.GetMap().checkCollisionWithButtonAlb1(getBounds());
            refLink.GetMap().checkCollisionWithButtonAlb2(getBounds());
            refLink.GetMap().checkCollisionWithButtonRosu2(getBounds());
            refLink.GetMap().checkCollisionWithButtonRosu3(getBounds());
            refLink.GetMap().checkCollisionWithButtonAlb3(getBounds());
            System.out.println("down"+canMove);

            if(canMove==false) //nu e coliziune
            {
                yMove = speed;
            }
            else
            {
                life-=10;
                yMove=-40;
                SetX(x);
            }

            if(foundChest)
            {
                System.out.println("gasit cufar");
                keys++;
                if(keys>=2)
                {
                    System.out.println("intra pe aici");
//                    mapanoua=refLink.GetMap().loadothermap(x,y+yMove,DEFAULT_CREATURE_WIDTH);
                }
            }

            if(foundBattery)
            {
                speed+=0.5f;
            }
        }
        else if(refLink.GetKeyManager2().left)
        {

            // Apel functie checkCollisionWithObstacles pentru directia in care merge eroul
            canMove = refLink.GetMap().checkCollisionWithObstacles(x + xMove, y, DEFAULT_CREATURE_WIDTH);
            foundBattery=refLink.GetMap().collisionBattery(getBounds());
            foundChest=refLink.GetMap().checkCollisionWithChest(getBounds());
            mapanoua=refLink.GetMap().loadothermap(x,y+yMove,DEFAULT_CREATURE_WIDTH);
            refLink.GetMap().checkCollisionWithButtonAlb1(getBounds());
            refLink.GetMap().checkCollisionWithButtonAlb2(getBounds());
            refLink.GetMap().checkCollisionWithButtonRosu2(getBounds());
            refLink.GetMap().checkCollisionWithButtonRosu3(getBounds());
            refLink.GetMap().checkCollisionWithButtonAlb3(getBounds());
            System.out.println("left"+canMove);

            if(canMove==false) //nu e coliziune
            {
                xMove = -speed;
            }
            else
            {
                life-=10;
                xMove=40;
                SetY(y);
            }

            if(foundBattery)
            {
                System.out.println("merge bine");
                speed+=0.5f;
            }

            if(foundChest)
            {
                System.out.println("gasit cufar");
                keys++;
                if(keys>=2)
                {
                    System.out.println("intra pe aici");
//                    mapanoua=refLink.GetMap().loadothermap(x,y+yMove,DEFAULT_CREATURE_WIDTH);
                }
            }

        }
        else if(refLink.GetKeyManager2().right)
        {

            // Apel functie checkCollisionWithObstacles pentru directia in care merge eroul
            canMove = refLink.GetMap().checkCollisionWithObstacles(x + xMove, y, DEFAULT_CREATURE_WIDTH);
            foundBattery=refLink.GetMap().collisionBattery(getBounds());
            foundChest=refLink.GetMap().checkCollisionWithChest(getBounds());
            mapanoua=refLink.GetMap().loadothermap(x,y+yMove,DEFAULT_CREATURE_WIDTH);
            refLink.GetMap().checkCollisionWithButtonAlb1(getBounds());
            refLink.GetMap().checkCollisionWithButtonAlb2(getBounds());
            refLink.GetMap().checkCollisionWithButtonRosu2(getBounds());
            refLink.GetMap().checkCollisionWithButtonRosu3(getBounds());
            refLink.GetMap().checkCollisionWithButtonAlb3(getBounds());
            System.out.println("right"+canMove);

            if(canMove==false) //nu e coliziune
            {
                xMove = speed;
            }
            else
            {
                life-=10;
                xMove=-40;
                SetY(y);
            }

            if(foundBattery)
            {
                System.out.println("merge bine");
                speed+=0.5f;
            }

            if(foundChest)
            {
                System.out.println("gasit cufar");
                keys++;
                if(keys>=2)
                {
                    System.out.println("intra pe aici");
                   // mapanoua=refLink.GetMap().loadothermap(x,y+yMove,DEFAULT_CREATURE_WIDTH);
                }
            }
        }
        else
            if(refLink.GetKeyManager2().p)
            {
                System.out.println("atac");
            }

        // Actualizare pozitie erou in cazul in care variabila canMove este false aka fara coliziune
        if (canMove==false)
        {
            Move();
        }


    }


    /*! \fn public void Draw(Graphics g)
        \brief Randeaza/deseneaza eroul in noua pozitie.

        \brief g Contextul grafi in care trebuie efectuata desenarea eroului.
     */
    @Override
    public void Draw(Graphics g)
    {
        g.drawImage(image, (int)x, (int)y, width, height, null);

        BufferedImage img;

//        try {
//            img = ImageIO.read(new File("src/res/textures/rsz_secret_key.png"));
//            g.drawImage(img,10,10,null);
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        if(keys!=0)
        {
            g.setColor(Color.red);
            g.drawString("Key Player 2:"+(keys),10,10);

        }

        g.drawString("Life player 2:"+(life),10,15);

        if(life==0)
        {
            InfoBox.ShowInfo("Ai murit!","Viata personaj 2");
            refLink.GetGame().StopGame();
        }

        ///doar pentru debug daca se doreste vizualizarea dreptunghiului de coliziune altfel se vor comenta urmatoarele doua linii
//        g.setColor(Color.red);
//        g.fillRect((int)(x + bounds.x), (int)(y + bounds.y), bounds.width, bounds.height);
    }

    public Rectangle getBounds()
    {
        return new Rectangle((int)x,(int)y,width,height);
    }

}
