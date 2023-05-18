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
  //  public static BufferedImage grass;
 //   public static BufferedImage mountain;
    //public static BufferedImage ErikaIdle,ErikaUp1,ErikaUp2,ErikaDown1,ErikaDown2,ErikaLeft1,ErikaLeft2,ErikaRight1,ErikaRight2,ErikaAttack1,ErikaAttack2;
    //   public static BufferedImage soil;
    //  public static BufferedImage grass;
    //   public static BufferedImage mountain;
//    public static BufferedImage wall, grass,tree;
//    public static BufferedImage sand,coconut,dune;
//    public static BufferedImage diamond,gem,purpleSoil;
//   // public static BufferedImage water;
// //   public static BufferedImage flower;
//    public static BufferedImage battery;
//    public static BufferedImage chest,button,fireball,blade,light;
//    public static BufferedImage portal;
    public static BufferedImage      wall, grass, tree,
            sand,coconut, dune,
            purpleSoil, gem, diamond,
            chest1,chest2,chest3,
            portal1,portal2,
            battery1, battery2, battery3,
            buttonActRosu1,buttonActRosu2 ,buttonActRosu3, buttonNactRosu1, buttonNactRosu2, buttonNactRosu3,
            buttonActAlb1,buttonActAlb2 ,buttonActAlb3, buttonNactAlb1, buttonNactAlb2, buttonNactAlb3,
            light1, light2,light3,
            fireRight1,fireRight2,fireRight3,
            fireDown2;

    /*! \fn public static void Init()
        \brief Functia initializaza referintele catre elementele grafice utilizate.

        Aceasta functie poate fi rescrisa astfel incat elementele grafice incarcate/utilizate
        sa fie parametrizate. Din acest motiv referintele nu sunt finale.
     */
    public static void Init()  {
            /// Se creaza temporar un obiect SpriteSheet initializat prin intermediul clasei ImageLoader
        SpriteSheet sheet = new SpriteSheet(ImageLoader.LoadImage("src/res/textures/SpritesheetFinal.png"));
        SpriteSheet sheetPlayer1= new SpriteSheet(ImageLoader.LoadImage("src/res/textures/player.png"));
        SpriteSheet sheetPlayer2= new SpriteSheet(ImageLoader.LoadImage("src/res/textures/player2.png"));
        SpriteSheet itemN1= new SpriteSheet(ImageLoader.LoadImage("src/res/textures/itemiN1.png"));
        SpriteSheet itemN2= new SpriteSheet(ImageLoader.LoadImage("src/res/textures/itemiN2.png"));
        SpriteSheet itemN3= new SpriteSheet(ImageLoader.LoadImage("src/res/textures/itemiN3.png"));
        //    SpriteSheet en= new SpriteSheet(ImageLoader.LoadImage("/textures/enemy.png"));

        /// Se obtin subimaginile corespunzatoare elementelor necesare.
        wall=sheet.crop(0,0);
        grass=sheet.crop(1,0);
        tree=sheet.crop(2,0);
        sand=sheet.crop(0,1);
        coconut=sheet.crop(1,1);
        dune=sheet.crop(2,1);
        purpleSoil=sheet.crop(0,2);
        diamond=sheet.crop(1,2);
        gem=sheet.crop(2,2);

        chest1=itemN1.crop(0,0);
        battery1=itemN1.crop(1,0);
        fireRight1=itemN1.crop(0,1);
        light1=itemN1.crop(0,2);
        buttonActRosu1=itemN1.crop(3,2);
        buttonNactRosu1=itemN1.crop(2,2);
        buttonActAlb1=itemN1.crop(1,3);
        buttonNactAlb1=itemN1.crop(0,3);
        portal1=itemN1.crop(2,3);

        chest2=itemN2.crop(0,0);
        battery2=itemN2.crop(1,0);
        fireRight2=itemN2.crop(0,1);
        light2=itemN2.crop(0,2);
        buttonActRosu2=itemN2.crop(2,2);
        buttonNactRosu2=itemN2.crop(3,2);
        buttonActAlb2=itemN2.crop(1,3);
        buttonNactAlb2=itemN2.crop(0,3);
        portal2=itemN2.crop(2,3);
        fireDown2=itemN2.crop(2,1);

        chest3=itemN3.crop(0,0);
        battery3=itemN3.crop(1,0);
        fireRight3=itemN3.crop(0,1);
        light3=itemN3.crop(0,2);
        buttonActRosu3=itemN3.crop(3,2);
        buttonNactRosu3=itemN3.crop(2,2);
        buttonActAlb3=itemN3.crop(1,3);
        buttonNactAlb3=itemN3.crop(0,3);

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

    }
}
