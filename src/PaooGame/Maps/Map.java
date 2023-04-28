package PaooGame.Maps;

import PaooGame.InfoBox;
import PaooGame.Items.Battery;
import PaooGame.Items.Character;
import PaooGame.Items.Hero;
import PaooGame.Items.Key;
import PaooGame.RefLinks;
import PaooGame.Tiles.Tile;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


/*! \class public class Map
    \brief Implementeaza notiunea de harta a jocului.
 */
public class Map {
    private Key key;
    private Battery battery;
    public boolean hasCol=false;
    public boolean hasBattery=false;
    public static int score;
    public static float speed=1.9f;
    public int bladePozX,bladePozY;

    public static Graphics g;
    private RefLinks refLink;   /*!< O referinte catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.*/
    public static int width = 50;          /*!< Latimea hartii in numar de dale.*/
    public static int height = 31;         /*!< Inaltimea hartii in numar de dale.*/
    private int[][] tiles;     /*!< Referinta catre o matrice cu codurile dalelor ce vor construi harta.*/

    /*! \fn public Map(RefLinks refLink)
        \brief Constructorul de initializare al clasei.

        \param refLink O referinte catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.
     */
    public Map(RefLinks refLink)
    {
        /// Retine referinta "shortcut".
        this.refLink = refLink;

        ///incarca harta de start. Functia poate primi ca argument id-ul hartii ce poate fi incarcat.
        LoadWorld(1);
    }

    /*! \fn public  void Update()
        \brief Actualizarea hartii in functie de evenimente (un copac a fost taiat)
     */
    public void Update()
    {

    }

    /*! \fn public void Draw(Graphics g)
        \brief Functia de desenare a hartii.

        \param g Contextl grafi in care se realizeaza desenarea.
     */
    public void Draw(Graphics g)
    {

        for(int y=0;y<height;y++)
            for(int x=0;x<width;x++)
            {

                Tile tile= GetTile(x,y);
                tile.Draw(g,x* Tile.TILE_HEIGHT - Camera.getX(),y*Tile.TILE_HEIGHT- Camera.getY()); //si aici tb intrebat
            }

        Font fnt0 = new Font("Monospaced", Font.BOLD,18);
        g.setFont(fnt0);
        g.setColor(Color.black);
        BufferedImage img= null;

        try {
            img = ImageIO.read(new File("src/res/textures/rsz_secret_key.png"));
            g.drawImage(img,800,10,null);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if(hasCol)
        {
            System.out.println(hasCol);
           // Character.score++;
            //g.drawString("Key Players "+(Character.score+1),810,19);

            //Character.score+=1;
            InfoBox.ShowInfo("You have found one more key!","KeyPlayers");

         //   g.drawString("Speed"+(Hero2.speed),10,19);
        }

        if(hasBattery)
        {
            System.out.println("hasBattery"+hasBattery);
            g.drawString("Life "+(Hero.life),10,19);

        }


        //Se parcurge matricea de dale (codurile aferente) si se deseneaza harta respectiva
//       for (int y = 0; y < refLink.GetGame().GetHeight() / Tile.TILE_HEIGHT; y++)
//       {
//            for (int x = 0; x < refLink.GetGame().GetWidth() / Tile.TILE_WIDTH; x++)
//            {
//                GetTile(x, y).Draw(g, (int) x * Tile.TILE_HEIGHT, (int) y * Tile.TILE_WIDTH);
//            }
//        }


    }



    /*! \fn public Tile GetTile(int x, int y)
        \brief Intoarce o referinta catre dala aferenta codului din matrice de dale.

        In situatia in care dala nu este gasita datorita unei erori ce tine de cod dala, coordonate gresite etc se
        intoarce o dala predefinita (ex. grassTile, mountainTile)
     */
    public Tile GetTile(int x, int y) {
        if (x < 0 || y < 0 || x >= width || y >= height) {
            return Tile.grassTile;
        }
        Tile t = Tile.tiles[tiles[y][x]];
        if (t == null) {
            return Tile.flowerTile;
        }
        return t;
    }

    /*! \fn private void LoadWorld()
        \brief Functie de incarcare a hartii jocului.
        Aici se poate genera sau incarca din fisier harta
     */
    private void LoadWorld(int id)
    {
        //atentie latimea si inaltimea trebuiesc corelate cu dimensiunile ferestrei sau
        //se poate implementa notiunea de camera/cadru de vizualizare al hartii
        ///Se stabileste latimea hartii in numar de dale.

        switch (id)
        {
            case 1:
                try
                {
                    Scanner sc = new Scanner(new File("src/res/maps/harta.txt"));
                    int rows = 31;
                    int columns = 50;
                    int [][] harta = new int[rows][columns];
                    while(sc.hasNextLine()) {
                        for (int i=0; i<harta.length; i++) {
                            String[] line = sc.nextLine().trim().split(" ");
                            for (int j=0; j<line.length; j++) {
                                harta[i][j] = Integer.parseInt(line[j]);
                            }
                        }
                    }
                    tiles = harta;
//            System.out.println(Arrays.deepToString(harta));

                }
                catch(Exception e)
                {
                    e.printStackTrace();
                    // daca incarc prost harta din fisier, fct o restaurez pe harta statica
                    width = 50;
                    height = 31;
                    tiles = new int[width][height];
                    for (int y = 0; y < height; y++) {
                        for (int x = 0; x < width; x++) {
                            tiles[x][y] = Level1(y, x);
                        }
                    }

                }
                break;

            case 2:
                try
                {
                    Scanner sc = new Scanner(new File("src/res/maps/hartaNivel2.txt"));
                    int rows = 31;
                    int columns = 50;
                    int [][] harta = new int[rows][columns];
                    while(sc.hasNextLine()) {
                        for (int i=0; i<harta.length; i++) {
                            String[] line = sc.nextLine().trim().split(" ");
                            for (int j=0; j<line.length; j++) {
                                harta[i][j] = Integer.parseInt(line[j]);
                            }
                        }
                    }
                    tiles = harta;
//                  System.out.println(Arrays.deepToString(harta));

                }
                catch(Exception e)
                {
                    e.printStackTrace();
                    // daca incarc prost harta din fisier, fct o restaurez pe harta statica
                    width = 50;
                    height = 31;
                    tiles = new int[width][height];
                    for (int y = 0; y < height; y++) {
                        for (int x = 0; x < width; x++) {
                            tiles[x][y] = Level2(y, x);
                        }
                    }

                }
                break;

        }

    }


    /*! \fn private int MiddleEastMap(int x ,int y)
        \brief O harta incarcata static.

        \param x linia pe care se afla codul dalei de interes.
        \param y coloana pe care se afla codul dalei de interes.
     */
    private int Level1(int x, int y) {
        ///Definire statica a matricei de coduri de dale.
        final int map[][] = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 5, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 0, 0, 0, 0, 6, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};


        return map[x][y];

    }

    private int Level2(int x,int y)
    {
        final int map[][]={
                {0,0,0,0},
                {0,0,0,0}
        };
        return map[x][y];
    }

    public int getWidth(){return width;}
    public  int getHeight(){return height;}


    public boolean checkCollisionWithObstacles(float x, float y, int playerSize) {
        int leftTile = (int) (x - playerSize / 2) / Tile.TILE_HEIGHT;
        int rightTile = (int) (x + playerSize / 2) / Tile.TILE_HEIGHT;
        int topTile = (int) (y - playerSize / 2) / Tile.TILE_WIDTH;
        int bottomTile = (int) (y + playerSize / 2) / Tile.TILE_WIDTH;
        System.out.println(leftTile+" "+rightTile+" "+topTile+" "+bottomTile);
        System.out.println();

//
//        if(leftTile < 0) return true;
//        if(rightTile > 49) return true;
//        if(topTile < 0) return true;
//        if(bottomTile > 30) return true;

        // Verificăm dacă există vreo cifră 1 în zona de coliziune
        for (int row = topTile; row <= bottomTile; row++)
        {
            for (int col = leftTile; col <= rightTile; col++)
            {
                if (tiles[row][col] == 1) {
                    return true; // a avut loc o coliziune
                }
            }
        }

        return false; // nu a avut loc nicio coliziune

    }

    public boolean checkCollisionWithChest(float x,float y,int playerSize)
    {
        int leftTile = (int) (x - playerSize / 2) / Tile.TILE_HEIGHT;
        int rightTile = (int) (x + playerSize / 2) / Tile.TILE_HEIGHT;
        int topTile = (int) (y - playerSize / 2) / Tile.TILE_WIDTH;
        int bottomTile = (int) (y + playerSize / 2) / Tile.TILE_WIDTH;

        Random random = new Random();
        int randomNumber = random.nextInt(2);
        if (randomNumber == 0)
        {
            key = Key.notFound;
        }
        else
        {
            key = Key.found;
        }


        for (int row = topTile; row < bottomTile; row++)
        {
            for (int col = leftTile; col < rightTile; col++)
            {
                if (tiles[row][col] == 5)
                {

//                        int ceva= Key.found.getInfo();
//                        int ceva2= Key.notFound.getInfo();
//                        System.out.println(ceva+" "+ceva2);

                        switch (key)
                        {
                            case found:
                                System.out.println("intra in fct");
                                hasCol=true;
                                break;
                            case notFound:
                                System.out.println("No key found with info: " + PaooGame.Items.Key.notFound.getInfo());
                                //  hero.score=0;
                                hasCol=false;
                                break;
                        }
                    return true;

                }
            }
        }

        return false;
    }

    public boolean checkCollisionWithBattery(float x, float y, int playerSize) {

        Random random = new Random();
        int randomNumber = random.nextInt(2);
        if (randomNumber == 0)
        {
            battery = Battery.good;
        }
        else
        {
            battery=battery.bad;
        }
       // System.out.println("baterii");
        int leftTile = (int) (x - playerSize / 2) / Tile.TILE_HEIGHT;
        int rightTile = (int) (x + playerSize / 2) / Tile.TILE_HEIGHT;
        int topTile = (int) (y - playerSize / 2) / Tile.TILE_WIDTH;
        int bottomTile = (int) (y + playerSize / 2) / Tile.TILE_WIDTH;

        for (int row = topTile; row < bottomTile; row++)
        {
            for (int col = leftTile; col < rightTile; col++)
            {
                if(tiles[row][col]==6)
                {

                    switch(battery)
                    {
                        case good:
                            System.out.println("baterie +");
                            hasBattery=true;
                            break;
                        case bad:
                            System.out.println("baterie -");
                            hasBattery=false;
                            break;

                    }
                    System.out.println("speed increased");
                    //Hero hero;
                    //Hero.speed+=2.5f;
                   // Hero.life+=10;
                    //hasBattery=true;
                    return true;
                }


//                if(tiles[row][col]==7)
//                {
//                 //   speed-=0.5f;
//                    Hero.life-=10;
//                    hasBattery=true;
//                    return  true;
//                }

            }
        }

        return false;
    }


}