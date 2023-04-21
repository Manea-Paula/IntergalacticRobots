package PaooGame.Graphics;

import java.awt.image.BufferedImage;

/*! \class public class Assets
    \brief Clasa incarca fiecare element grafic necesar jocului.

    Game assets include tot ce este folosit intr-un joc: imagini, sunete, harti etc.
 */
public class Assets
{
        /// Referinte catre elementele grafice (dale) utilizate in joc.

    public static BufferedImage KevinIdle;
    public static BufferedImage KevinUp1,KevinUp2, KevinUp3,KevinUp4,KevinUp5,KevinUp6,KevinUp7;
    public static BufferedImage KevinDown1,KevinDown2,KevinDown3,KevinDown4,KevinDown5,KevinDown6, KevinDown7;
    public static BufferedImage KevinLeft1,KevinLeft2,KevinLeft3,KevinLeft4,KevinLeft5,KevinLeft6,KevinLeft7;
    public static BufferedImage KevinRight1,KevinRight2,KevinRight3,KevinRight4,KevinRight5,KevinRight6,KevinRight7;

    public static BufferedImage KevinAttack1,KevinAttack2,KevinAttack3,KevinAttack4,KevinAttack5,KevinAttack6,KevinAttack7;

    public static BufferedImage ErikaIdle;
    public static BufferedImage ErikaUp1,ErikaUp2, ErikaUp3,ErikaUp4,ErikaUp5,ErikaUp6,ErikaUp7;
    public static BufferedImage ErikaDown1,ErikaDown2,ErikaDown3,ErikaDown4,ErikaDown5,ErikaDown6, ErikaDown7;
    public static BufferedImage ErikaLeft1,ErikaLeft2,ErikaLeft3,ErikaLeft4,ErikaLeft5,ErikaLeft6,ErikaLeft7;
    public static BufferedImage ErikaRight1,ErikaRight2,ErikaRight3,ErikaRight4,ErikaRight5,ErikaRight6,ErikaRight7;

    public static BufferedImage ErikaAttack1,ErikaAttack2,ErikaAttack3,ErikaAttack4,ErikaAttack5,ErikaAttack6,ErikaAttack7;
    //public static BufferedImage ErikaIdle,ErikaUp1,ErikaUp2,ErikaDown1,ErikaDown2,ErikaLeft1,ErikaLeft2,ErikaRight1,ErikaRight2,ErikaAttack1,ErikaAttack2;
    //   public static BufferedImage soil;
    public static BufferedImage grass;
 //   public static BufferedImage mountain;
    public static BufferedImage wall;
    public static BufferedImage sand;
    public static BufferedImage water;
    public static BufferedImage flower;
    public static BufferedImage battery;
    public static BufferedImage chest;
    public static BufferedImage portal;
    public static BufferedImage enemy;
    public static BufferedImage blade;


//    public static BufferedImage townGrass;
//    public static BufferedImage townGrassDestroyed;
//    public static BufferedImage townSoil;
//    public static BufferedImage rockUp;
//    public static BufferedImage rockDown;
//    public static BufferedImage rockLeft;
//    public static BufferedImage rockRight;
 //   public static BufferedImage tree;

    /*! \fn public static void Init()
        \brief Functia initializaza referintele catre elementele grafice utilizate.

        Aceasta functie poate fi rescrisa astfel incat elementele grafice incarcate/utilizate
        sa fie parametrizate. Din acest motiv referintele nu sunt finale.
     */
    public static void Init()
    {
            /// Se creaza temporar un obiect SpriteSheet initializat prin intermediul clasei ImageLoader
        SpriteSheet sheet = new SpriteSheet(ImageLoader.LoadImage("/textures/SpriteSheet.png"));
        SpriteSheet sheetPlayer1= new SpriteSheet(ImageLoader.LoadImage("/textures/player.png"));
        SpriteSheet sheetPlayer2= new SpriteSheet(ImageLoader.LoadImage("/textures/player2.png"));
        SpriteSheet sheetItems= new SpriteSheet(ImageLoader.LoadImage("/textures/ITEMS.png"));
    //    SpriteSheet en= new SpriteSheet(ImageLoader.LoadImage("/textures/enemy.png"));

            /// Se obtin subimaginile corespunzatoare elementelor necesare.
          wall=sheet.crop(0,0);
          sand = sheet.crop(1, 0);
          water = sheet.crop(2, 0);
          grass = sheet.crop(3, 0);
          flower = sheet.crop(4, 0);
//        mountain = sheet.crop(3, 0);
//        townGrass = sheet.crop(0, 1);
//        townGrassDestroyed = sheet.crop(1, 1);
//        townSoil = sheet.crop(2, 1);
//        tree = sheet.crop(3, 1);

//        player1Idle_1=sheetPlayer1.crop(0,0);
//        player1Idle_2=sheetPlayer1.crop(0,3);
//        player1Idle_3=sheetPlayer1.crop(0,7);
//        player1Right_1 = sheetPlayer1.crop(1, 0);
//        player1Right_2 = sheetPlayer1.crop(1, 3);
//        player1Right_3 = sheetPlayer1.crop(1, 7);
//        player1Left_1 = sheetPlayer1.crop(2, 0);
//        player1Left_2 = sheetPlayer1.crop(2, 3);
//        player1Left_3 = sheetPlayer1.crop(2, 7);
//        player1Up_1 =sheetPlayer1.crop(3,0);
//        player1Up_2 =sheetPlayer1.crop(3,3);
//        player1Up_3 =sheetPlayer1.crop(3,7);
//        player1Down_1=sheetPlayer1.crop(4,0);
//        player1Down_2=sheetPlayer1.crop(4,3);
//        player1Down_3=sheetPlayer1.crop(4,7);

//        player1Idle=sheetPlayer1.crop(1,0);
//        player1Right = sheetPlayer1.crop(1, 0);
//        player1Left = sheetPlayer1.crop(2, 0);
//        player1Up =sheetPlayer1.crop(3,0);
//        player1Down=sheetPlayer1.crop(4,0);
//
//        player2Idle=sheetPlayer2.crop(0,0);
//        player2Right = sheetPlayer2.crop(1, 0);
//        player2Left = sheetPlayer2.crop(2, 0);
//        player2Up =sheetPlayer2.crop(3,0);
//        player2Down=sheetPlayer2.crop(4,0);

        KevinIdle=sheetPlayer1.crop(0,0);

        KevinLeft1=sheetPlayer1.crop(0,2);
        KevinLeft2=sheetPlayer1.crop(1,2);
        KevinLeft3=sheetPlayer1.crop(2,2);
        KevinLeft4=sheetPlayer1.crop(3,2);
        KevinLeft5=sheetPlayer1.crop(4,2);
        KevinLeft6=sheetPlayer1.crop(5,2);
     //   KevinLeft7=sheetPlayer1.crop(6,1);


        KevinRight1=sheetPlayer1.crop(0,1);
        KevinRight2=sheetPlayer1.crop(1,1);
        KevinRight3=sheetPlayer1.crop(2,1);
        KevinRight4=sheetPlayer1.crop(3,1);
        KevinRight5=sheetPlayer1.crop(4,1);
        KevinRight6=sheetPlayer1.crop(5,1);
   //     KevinRight7=sheetPlayer1.crop(6,2);

        KevinUp1=sheetPlayer1.crop(0,3);
        KevinUp2=sheetPlayer1.crop(1,3);
        KevinUp3=sheetPlayer1.crop(2,3);
        KevinUp4=sheetPlayer1.crop(3,3);
        KevinUp5=sheetPlayer1.crop(4,3);
        KevinUp6=sheetPlayer1.crop(5,3);
 //       KevinUp7=sheetPlayer1.crop(6,3);

        KevinDown1=sheetPlayer1.crop(0,4);
        KevinDown2=sheetPlayer1.crop(1,4);
        KevinDown3=sheetPlayer1.crop(2,4);
        KevinDown4=sheetPlayer1.crop(3,4);
        KevinDown5=sheetPlayer1.crop(4,4);
        KevinDown6=sheetPlayer1.crop(5,4);
    //    KevinDown7=sheetPlayer1.crop(6,4);


        KevinAttack1=sheetPlayer1.crop(0,5);
        KevinAttack2=sheetPlayer1.crop(1,5);
        KevinAttack3=sheetPlayer1.crop(2,5);
        KevinAttack4=sheetPlayer1.crop(3,5);
        KevinAttack5=sheetPlayer1.crop(4,5);
        KevinAttack6=sheetPlayer1.crop(5,5);
   //     KevinAttack7=sheetPlayer1.crop(6,5);


        ErikaIdle=sheetPlayer2.crop(1,0);

        ErikaUp1=sheetPlayer2.crop(0,3);
        ErikaUp2=sheetPlayer2.crop(1,3);
        ErikaUp3=sheetPlayer2.crop(2,3);
        ErikaUp4=sheetPlayer2.crop(3,3);
        ErikaUp5=sheetPlayer2.crop(4,3);
        ErikaUp6=sheetPlayer2.crop(5,3);
  //      ErikaUp7=sheetPlayer2.crop(6,3);

        ErikaDown1=sheetPlayer2.crop(0,4);
        ErikaDown2=sheetPlayer2.crop(1,4);
        ErikaDown3=sheetPlayer2.crop(2,4);
        ErikaDown4=sheetPlayer2.crop(3,4);
        ErikaDown5=sheetPlayer2.crop(4,4);
        ErikaDown6=sheetPlayer2.crop(5,4);
 //       ErikaDown7=sheetPlayer2.crop(6,4);

        ErikaLeft1=sheetPlayer2.crop(0,2);
        ErikaLeft2=sheetPlayer2.crop(1,2);
        ErikaLeft3=sheetPlayer2.crop(2,2);
        ErikaLeft4=sheetPlayer2.crop(3,2);
        ErikaLeft5=sheetPlayer2.crop(4,2);
        ErikaLeft6=sheetPlayer2.crop(5,2);
 //       ErikaLeft7=sheetPlayer2.crop(6,1);

        ErikaRight1=sheetPlayer2.crop(0,1);
        ErikaRight2=sheetPlayer2.crop(1,1);
        ErikaRight3=sheetPlayer2.crop(2,1);
        ErikaRight4=sheetPlayer2.crop(3,1);
        ErikaRight5=sheetPlayer2.crop(4,1);
        ErikaRight6=sheetPlayer2.crop(5,1);
 //       ErikaRight7=sheetPlayer2.crop(6,2);

        ErikaAttack1=sheetPlayer2.crop(0,5);
        ErikaAttack2=sheetPlayer2.crop(1,5);
        ErikaAttack3=sheetPlayer2.crop(2,5);
        ErikaAttack4=sheetPlayer2.crop(3,5);
        ErikaAttack5=sheetPlayer2.crop(4,5);
        ErikaAttack6=sheetPlayer2.crop(5,5);
  //      ErikaAttack7=sheetPlayer2.crop(6,5);

        chest=sheetItems.crop(0,0);
        battery=sheetItems.crop(1,0);
        portal=sheetItems.crop(2,0);
     //   blade=sheetItems.crop(2,0);



//        rockUp = sheet.crop(2, 2);
//        rockDown = sheet.crop(3, 2);
//        rockLeft = sheet.crop(0, 3);
//        rockRight = sheet.crop(1, 3);
    }
}
