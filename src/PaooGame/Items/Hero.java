package PaooGame.Items;

import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;

import java.awt.*;
import java.awt.image.BufferedImage;

/*! \class public class Hero extends Character
    \brief Implementeaza notiunea de erou/player (caracterul controlat de jucator).

    Elementele suplimentare pe care le aduce fata de clasa de baza sunt:
        imaginea (acest atribut poate fi ridicat si in clasa de baza)
        deplasarea
        atacul (nu este implementat momentan)
        dreptunghiul de coliziune

        adunatul de obiecte
 */
public class Hero extends Character
{
    private BufferedImage image;    /*!< Referinta catre imaginea curenta a eroului.*/

    private BufferedImage[] upFrames;    // Array of images for character motion
    private BufferedImage[] downFrames;
    private BufferedImage[] leftFrames;
    private BufferedImage[] rightFrames;
    private BufferedImage[] attackFrames;
    private int currentFrame; // Current animation frame
    private int animationSpeed; // Speed of animation
    private boolean canMove = true; //  pt coliziune
    private boolean foundBattery = true; // pt baterii
    private boolean foundChest=true; //pt chei
    private boolean mapanoua=true;
    Hero hero2;


//    private int cameraX=DEFAULT_CREATURE_WIDTH;
//    private int cameraY=DEFAULT_CREATURE_HEIGHT;


    /*! \fn public Hero(RefLinks refLink, float x, float y)
            \brief Constructorul de initializare al clasei Hero.

            \param refLink Referinta catre obiectul shortcut (obiect ce retine o serie de referinte din program).
            \param x Pozitia initiala pe axa X a eroului.
            \param y Pozitia initiala pe axa Y a eroului.
         */
    public Hero(RefLinks refLink, float x, float y)
    {
            ///Apel al constructorului clasei de baza
        super(refLink, x,y, Character.DEFAULT_CREATURE_WIDTH, Character.DEFAULT_CREATURE_HEIGHT);
            ///Seteaza imaginea de start a eroului
        image = Assets.KevinIdle;
            ///Stabilieste pozitia relativa si dimensiunea dreptunghiului de coliziune, starea implicita(normala)
        normalBounds.x = 16;
        normalBounds.y = 16;
        normalBounds.width = 16;
        normalBounds.height = 32;


        // Load images for character motion
        upFrames = new BufferedImage[] { Assets.KevinUp1, Assets.KevinUp2,Assets.KevinUp3,Assets.KevinUp4,Assets.KevinUp5,Assets.KevinUp6};
        downFrames = new BufferedImage[] { Assets.KevinDown1, Assets.KevinDown2,Assets.KevinDown3,Assets.KevinDown4,Assets.KevinDown5,Assets.KevinDown6};
        leftFrames = new BufferedImage[] { Assets.KevinLeft1, Assets.KevinLeft2, Assets.KevinLeft3,Assets.KevinLeft4,Assets.KevinLeft5,Assets.KevinLeft6};
        rightFrames = new BufferedImage[] { Assets.KevinRight1, Assets.KevinRight2 ,Assets.KevinRight3,Assets.KevinRight4,Assets.KevinRight5,Assets.KevinRight6};
        attackFrames= new BufferedImage[] {Assets.KevinAttack2,Assets.KevinAttack3,Assets.KevinAttack4,Assets.KevinAttack5,Assets.KevinAttack6};


        currentFrame = 0;
        animationSpeed = 14;

  //      this.obstacol=new Obstacol(refLink,150,150,48,48,80,600);
            ///Stabilieste pozitia relativa si dimensiunea dreptunghiului de coliziune, starea de atac
//        attackBounds.x = 10;
//        attackBounds.y = 10;
//        attackBounds.width = 38;
//        attackBounds.height = 38;
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
//        float newX=x+speed;
//        float newY=y+speed; //->pt functia de isCollision
//
//        if(map.checkMapCollision(bounds))
//        {
//            System.out.println(" CEVA ");
//            xMove=0;
//            yMove=0;
//        }

//        if(!map.isCollision((int) newX, (int) newY))
//        {
//            x=newX;
//            y=newY;
//        }
//        else
//        {
//            Move();
//        }

            ///Actualizeaza imaginea
        if (refLink.GetKeyManager().up == true) {
            currentFrame++;
            if (currentFrame >= upFrames.length * animationSpeed) {
                currentFrame = 0;
            }
            image = upFrames[currentFrame / animationSpeed];
        } else if (refLink.GetKeyManager().down == true) {
            currentFrame++;
            if (currentFrame >= downFrames.length * animationSpeed) {
                currentFrame = 0;
            }
            image = downFrames[currentFrame / animationSpeed];
        } else if (refLink.GetKeyManager().left == true) {
            currentFrame++;
            if (currentFrame >= leftFrames.length * animationSpeed) {
                currentFrame = 0;
            }
            image = leftFrames[currentFrame / animationSpeed];
        } else if (refLink.GetKeyManager().right == true) {
            currentFrame++;
            if (currentFrame >= rightFrames.length * animationSpeed) {
                currentFrame = 0;
            }
            image = rightFrames[currentFrame / animationSpeed];
        } else if(refLink.GetKeyManager().c ==true)
        {
            currentFrame++;
            if (currentFrame >= rightFrames.length * animationSpeed) {
                currentFrame = 0;
            }
            image = attackFrames[currentFrame / animationSpeed];


          //  String soundUrl= this.getClass().getResource("/res/textures/AngryRobotBird.wav").getPath();
            // SoundManager.playSound("/home/paula/Documents/PaooGameEtapa2/res/textures/Angry Robot Bird.wav");
            //SoundManager.playSound(soundUrl);
        }
        else
        {
            // If no direction is pressed, show idle image
            image = Assets.KevinIdle;
        }

      //  System.out.println(x+" "+y);
       // cameraX=x-400;
//        if(refLink.GetKeyManager().c==true)
//        {
//            System.out.println("ceva "+x+" "+y);
//            PlayState.map.GetBattery((int)x,(int)y);
//        }


    }

    /*! \fn private void GetInput()
        \brief Verifica daca a fost apasata o tasta din cele stabilite pentru controlul eroului.
     */
    public void GetInput()
    {
        xMove = 0;
        yMove = 0;


        if(refLink.GetKeyManager().up)
        {

            // Apel functie checkCollisionWithObstacles pentru directia in care merge eroul
            canMove = refLink.GetMap().checkCollisionWithObstacles(x, y + yMove, DEFAULT_CREATURE_WIDTH);
            foundBattery=refLink.GetMap().checkCollisionWithBattery(x,y+yMove,DEFAULT_CREATURE_WIDTH);
            foundChest=refLink.GetMap().checkCollisionWithChest(x,y+yMove,DEFAULT_CREATURE_WIDTH);
            mapanoua=refLink.GetMap().loadothermap(x,y+yMove,DEFAULT_CREATURE_WIDTH);

            System.out.println("up "+canMove);
            System.out.println(x+" "+(y+yMove));
            System.out.println();
//
            if(canMove==false) //nu e coliziune
            {
                yMove = -speed;
            }
           else
            {
                yMove=40;
                SetX(x);
            }

           if(foundBattery)
           {
               System.out.println("merge bine");
               speed+=0.2f;
           }

           if(foundChest)
           {
               System.out.println("gasit cufar");
           }

           if(mapanoua)
           {
               System.out.println("MAPA NOUA");
           }

        }
        else if(refLink.GetKeyManager().down)
        {

            // Apel functie checkCollisionWithObstacles pentru directia in care merge eroul
            canMove = refLink.GetMap().checkCollisionWithObstacles(x, y + yMove, DEFAULT_CREATURE_WIDTH);
            foundBattery=refLink.GetMap().checkCollisionWithBattery(x,y+yMove,DEFAULT_CREATURE_WIDTH);
//            System.out.println("down "+canMove);
//            System.out.println(x+" "+(y+yMove));
//            System.out.println();

            if(canMove==false) //nu e coliziune
            {
                yMove = speed;
            }
            else
            {
                yMove=-40;
                SetX(x);
            }

            if(foundBattery)
            {
                System.out.println("merge bine");
                speed+=0.2f;
            }

            if(foundChest)
            {
                System.out.println("gasit cufar");
                keys++;
            }
        }
        else if(refLink.GetKeyManager().left)
        {

            // Apel functie checkCollisionWithObstacles pentru directia in care merge eroul
            canMove = refLink.GetMap().checkCollisionWithObstacles(x + xMove, y, DEFAULT_CREATURE_WIDTH);
            foundBattery=refLink.GetMap().checkCollisionWithBattery(x+xMove,y,DEFAULT_CREATURE_WIDTH);
            System.out.println("left"+canMove);
            System.out.println((x+xMove)+" "+y);
            System.out.println();

            if(canMove==false) //nu e coliziune
            {
                xMove = -speed;
            }
            else
            {
                xMove=40;
                SetY(y);
            }
           // xMove=-speed;

            if(foundBattery)
            {
                System.out.println("merge bine");
                speed+=0.2f;
            }

            if(foundChest)
            {
                System.out.println("gasit cufar");
                keys++;
            }

        }
        else if(refLink.GetKeyManager().right)
        {

            // Apel functie checkCollisionWithObstacles pentru directia in care merge eroul
            canMove = refLink.GetMap().checkCollisionWithObstacles(x + xMove, y, DEFAULT_CREATURE_WIDTH);
            foundBattery=refLink.GetMap().checkCollisionWithBattery(x+xMove,y,DEFAULT_CREATURE_WIDTH);
            foundChest=refLink.GetMap().checkCollisionWithBattery(x+xMove,y,DEFAULT_CREATURE_WIDTH);
            System.out.println("right"+canMove);
            System.out.println((x+xMove)+" "+y);
            System.out.println();

            if(canMove==false) //nu e coliziune
            {
                xMove = speed;
            }
            else
            {
                xMove=-40;
                SetY(y);
            }

            if(foundBattery)
            {
                System.out.println("merge bine");
                speed+=0.1f;
            }

            if(foundChest)
            {
                System.out.println("gasit cufar");
                keys++;
            }
        }
        else if(refLink.GetKeyManager().c)
        {
            Rectangle rchero2= getBounds();
            if(getBounds().intersects(hero2.getBounds()))
            {
                System.out.println("ATAC");
                hero2.life-=10;
            }
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
  //  @Override
//    public void Draw(Graphics g)
//    {
//        g.drawImage(image, (int)(x-cameraX), (int)(y-cameraY), width, height, null);
//
//            ///doar pentru debug daca se doreste vizualizarea dreptunghiului de coliziune altfel se vor comenta urmatoarele doua linii
//        //g.setColor(Color.blue);
//        //g.fillRect((int)(x + bounds.x), (int)(y + bounds.y), bounds.width, bounds.height);
//    }

    @Override
    public void Draw(Graphics g)
    {

        g.drawImage(image, (int)x, (int)y, width, height, null);

        ///doar pentru debug daca se doreste vizualizarea dreptunghiului de coliziune altfel se vor comenta urmatoarele doua linii
//        g.setColor(Color.blue);
//        g.fillRect((int)(x + bounds.x), (int)(y + bounds.y), bounds.width, bounds.height);
    }

    public Rectangle getBounds()
    {
        return new Rectangle((int)x,(int)y,width,height);
    }

//    public void intersectareSpike()
//    {
//        Rectangle rp=getBounds();
//        if(rp.intersects(obstacol.getBounds()))
//        {
//            System.out.println("intra in fct");
//            life=life-5;
//        }
//
//        if(life<0)
//        {
//            System.out.println("Personaj mort");
//        }

   //  }





    //de cautat poza originala cu tot cu heal, vad cum utilizez aia

}
