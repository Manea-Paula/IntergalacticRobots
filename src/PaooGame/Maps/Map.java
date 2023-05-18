package PaooGame.Maps;

import PaooGame.Items.*;
import PaooGame.RefLinks;
import PaooGame.Tiles.Tile;

import java.awt.*;
import java.io.*;

import java.util.Random;
import java.util.Scanner;

/*! \class public class Map
    \brief Implementeaza notiunea de harta a jocului.
 */
public class Map {
    private Key key;
    public boolean hasChest=false;
    public boolean hasBattery=false;;

    public static Graphics g;
    private RefLinks refLink;   /*!< O referinte catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.*/
    public static int width = 50;          /*!< Latimea hartii in numar de dale.*/
    public static int height = 31;         /*!< Inaltimea hartii in numar de dale.*/
    private int[][] tiles;     /*!< Referinta catre o matrice cu codurile dalelor ce vor construi harta.*/
    private int ID;
  //  private LevelObserver levelObserver;
    private ObstacolBlade obstacol,obstacol2;
    ObstacolManager obstacolManager = ObstacolManager.getInstance();

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
        ID=1;
    }

    /*! \fn public  void Update()
        \brief Actualizarea hartii in functie de evenimente (un copac a fost taiat)
     */
    public void Update()
    {
        obstacolManager.updateObstacles();

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
                tile.Draw(g,x* Tile.TILE_HEIGHT - Camera.getX(),y*Tile.TILE_HEIGHT- Camera.getY());
            }

        //Se parcurge matricea de dale (codurile aferente) si se deseneaza harta respectiva
//       for (int y = 0; y < refLink.GetGame().GetHeight() / Tile.TILE_HEIGHT; y++)
//       {
//            for (int x = 0; x < refLink.GetGame().GetWidth() / Tile.TILE_WIDTH; x++)
//            {
//                GetTile(x, y).Draw(g, (int) x * Tile.TILE_HEIGHT, (int) y * Tile.TILE_WIDTH);
//            }
//        }

        obstacolManager.drawObstacles(g);
    }


    /*! \fn public Tile GetTile(int x, int y)
        \brief Intoarce o referinta catre dala aferenta codului din matrice de dale.

        In situatia in care dala nu este gasita datorita unei erori ce tine de cod dala, coordonate gresite etc se
        intoarce o dala predefinita (ex. grassTile, mountainTile)
     */
    public Tile GetTile(int x, int y) {
        if (x < 0 || y < 0 || x >= width || y >= height)
        {
            return Tile.grassTile;
        }
        Tile t = Tile.tiles[tiles[y][x]];
        if (t == null)
        {
            return Tile.wallTile;
        }
        return t;
    }


    /*! \fn private void LoadWorld()
        \brief Functie de incarcare a hartii jocului.
        Aici se poate genera sau incarca din fisier harta
     */
    public void LoadWorld(int id)
    {
        //atentie latimea si inaltimea trebuiesc corelate cu dimensiunile ferestrei sau
        //se poate implementa notiunea de camera/cadru de vizualizare al hartii
        ///Se stabileste latimea hartii in numar de dale.

        switch (id)
        {
            case 1:
                try
                {
                    Scanner sc = new Scanner(new File("src/res/maps/mapLevel1.txt"));
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
                    for (int y = 0; y < height; y++)
                    {
                        for (int x = 0; x < width; x++)
                        {
                            tiles[x][y] = Level1(y, x);
                        }
                    }

                }
                break;

            case 2:
                try
                {
                    Scanner sc = new Scanner(new File("src/res/maps/mapLevel2.txt"));
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
            case 3:
                try
                {
                    Scanner sc = new Scanner(new File("src/res/maps/mapLevel3.txt"));
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

                    obstacol=new ObstacolBlade(refLink,900,150,48,48,70,520);
                    obstacol2=new ObstacolBlade(refLink,600,150,48,48,40,530);

                    obstacolManager.addObstacle(obstacol);
                    obstacolManager.addObstacle(obstacol2);

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
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        };
        return map[x][y];
    }

    public static int getWidth(){return width;}
    public static int getHeight(){return height;}

    public boolean loadothermap(float x, float y, int playerSize)
    {
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

        for (int row = topTile; row <= bottomTile; row++)
        {
            for (int col = leftTile; col <= rightTile; col++)
            {
                if (tiles[row][col] == 7 && ID==1 )
                {
                    LoadWorld(2);
                    System.out.println("aici e problema");
                    ID=2;
                    return true;
                }
                else
                    if(tiles[row][col]==30 && ID==2)
                    {
                        LoadWorld(3);
                        ID=3;
                        return true;
                    }
            }
        }

        return false;

    }
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
                if (tiles[row][col] == 1 || tiles[row][col]==4 || tiles[row][col]==14  || tiles[row][col]==15  || tiles[row][col]==16  || tiles[row][col]==24  || tiles[row][col]==25)
                {
                    return true; // a avut loc o coliziune
                }
            }
        }

        return false; // nu a avut loc nicio coliziune

    }

    public boolean checkCollisionWithChest(Rectangle bounds)
    {
//        int leftTile = (int) (x - playerSize / 2) / Tile.TILE_HEIGHT;
//        int rightTile = (int) (x + playerSize / 2) / Tile.TILE_HEIGHT;
//        int topTile = (int) (y - playerSize / 2) / Tile.TILE_WIDTH;
//        int bottomTile = (int) (y + playerSize / 2) / Tile.TILE_WIDTH;

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


        for (int i = 0; i < height; i++)
        {
            for (int j = 0; j < width; j++)
            {
                if (tiles[i][j] == 5 || tiles[i][j]==13 || tiles[i][j]==31)
                {
                    Rectangle obstacleBounds = new Rectangle(j * Tile.TILE_WIDTH, i * Tile.TILE_HEIGHT, Tile.TILE_WIDTH, Tile.TILE_HEIGHT);
                    if(obstacleBounds.intersects(bounds))
                    {
                        switch (key)
                        {
                            case found:
                                //InfoBox.ShowInfo("Cheie gasita!","Chei");
                                // g.drawString("Cheie gasita",50,50);
                                hasChest=true;
                                if(ID==1)
                                    tiles[i][j]=0;
                                else if(ID==2)
                                        tiles[i][j]=10;
                                    else if(ID==3)
                                            tiles[i][j]=21;
                                break;
                            case notFound:
                                System.out.println("No key found with info: " + PaooGame.Items.Key.notFound.getInfo());
                                //  hero.score=0;
                                hasChest=false;
                                if(ID==1)
                                    tiles[i][j]=0;
                                else if(ID==2)
                                    tiles[i][j]=10;
                                else if(ID==3)
                                    tiles[i][j]=21;                                                     ;
                                break;
                        }
                        return true;
                    }

                }
            }
        }

        return false;
    }

    public boolean collisionBattery(Rectangle bounds) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (tiles[i][j] == 6 || tiles[i][j]==12 || tiles[i][j]==32)
                {
                    Rectangle obstacleBounds = new Rectangle(j * Tile.TILE_WIDTH, i * Tile.TILE_HEIGHT, Tile.TILE_WIDTH, Tile.TILE_HEIGHT);
                    if (obstacleBounds.intersects(bounds))
                    {
                        if(ID==1)
                            tiles[i][j]=0;
                        else if(ID==2)
                            tiles[i][j]=10;
                        else if(ID==3)
                            tiles[i][j]=21;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    //obiecte nivel 1

    public void checkCollisionWithButtonAlb1(Rectangle bounds)
    {
        for(int i=0; i< height; i++)
        {
            for(int j=0;j<width;j++)
            {
                if(tiles[i][j]==9)
                {
                    Rectangle obstacleBounds= new Rectangle(j * Tile.TILE_WIDTH, i * Tile.TILE_HEIGHT, Tile.TILE_WIDTH, Tile.TILE_HEIGHT);
                    if(obstacleBounds.intersects(bounds))
                    {
                        tiles[i][j]=8;
                        deactivateButtonAndLight1(i,j);

                    }

                }
            }
        }

    }

    public void deactivateButtonAndLight1(int i, int j) {
        if (tiles[i][j] == 8)
        {
            // Dezactivare light
            for (int x = 0; x < height; x++)
            {
                for (int y = 0; y < width; y++)
                {
                    if (tiles[x][y] == 4)
                    {
                        tiles[x][y] = 0;
                    }
                }
            }
        }
    }

    //obiecte nivel 2
    public void checkCollisionWithButtonAlb2(Rectangle bounds)
    {
        for(int i=0; i< height; i++)
        {
            for(int j=0;j<width;j++)
            {
                if(tiles[i][j]==18)
                {
                    Rectangle obstacleBounds= new Rectangle(j * Tile.TILE_WIDTH, i * Tile.TILE_HEIGHT, Tile.TILE_WIDTH, Tile.TILE_HEIGHT);
                    if(obstacleBounds.intersects(bounds))
                    {
                        tiles[i][j]=17;
                        deactivateButtonAndLight2(i,j);

                    }

                }
            }
        }

    }

    public void deactivateButtonAndLight2(int i, int j) {
        if (tiles[i][j] == 17)
        {
            // Dezactivare light
            for (int x = 0; x < height; x++)
            {
                for (int y = 0; y < width; y++)
                {
                    if (tiles[x][y] == 14)
                    {
                        tiles[x][y] = 10;
                    }
                }
            }
        }
    }

    public void checkCollisionWithButtonRosu2(Rectangle bounds)
    {
        for(int i=0; i< height; i++)
        {
            for(int j=0;j<width;j++)
            {
                if(tiles[i][j]==20)
                {
                    Rectangle obstacleBounds= new Rectangle(j * Tile.TILE_WIDTH, i * Tile.TILE_HEIGHT, Tile.TILE_WIDTH, Tile.TILE_HEIGHT);
                    if(obstacleBounds.intersects(bounds))
                    {
                        tiles[i][j]=19;
                        deactivateButtonAndFire2(i,j);

                    }

                }
            }
        }

    }

    public void deactivateButtonAndFire2(int i, int j) {
        if (tiles[i][j] == 19)
        {
            // Dezactivare light
            for (int x = 0; x < height; x++)
            {
                for (int y = 0; y < width; y++)
                {
                    if (tiles[x][y] == 15)
                    {
                        tiles[x][y] = 10;
                    }
                }
            }
        }
    }

    //obiecte nivel 3
    public void checkCollisionWithButtonRosu3(Rectangle bounds)
    {
        for(int i=0; i< height; i++)
        {
            for(int j=0;j<width;j++)
            {
                if(tiles[i][j]==29)
                {
                    Rectangle obstacleBounds= new Rectangle(j * Tile.TILE_WIDTH, i * Tile.TILE_HEIGHT, Tile.TILE_WIDTH, Tile.TILE_HEIGHT);
                    if(obstacleBounds.intersects(bounds))
                    {
                        tiles[i][j]=28;
                        deactivateButtonAndFire3(i,j);

                    }

                }
            }
        }

    }

    public void deactivateButtonAndFire3(int i, int j) {
        if (tiles[i][j] == 28)
        {
            // Dezactivare light
            for (int x = 0; x < height; x++)
            {
                for (int y = 0; y < width; y++)
                {
                    if (tiles[x][y] == 25)
                    {
                        tiles[x][y] = 21;
                    }
                }
            }
        }
    }

    public void checkCollisionWithButtonAlb3(Rectangle bounds)
    {
        for(int i=0; i< height; i++)
        {
            for(int j=0;j<width;j++)
            {
                if(tiles[i][j]==27)
                {
                    Rectangle obstacleBounds= new Rectangle(j * Tile.TILE_WIDTH, i * Tile.TILE_HEIGHT, Tile.TILE_WIDTH, Tile.TILE_HEIGHT);
                    if(obstacleBounds.intersects(bounds))
                    {
                        tiles[i][j]=26;
                        deactivateButtonAndLight3(i,j);

                    }

                }
            }
        }

    }

    public void deactivateButtonAndLight3(int i, int j) {
        if (tiles[i][j] == 26)
        {
            // Dezactivare light
            for (int x = 0; x < height; x++)
            {
                for (int y = 0; y < width; y++)
                {
                    if (tiles[x][y] == 24)
                    {
                        tiles[x][y] = 21;
                    }
                }
            }
        }
    }



}


