package PaooGame.Tiles;

import java.awt.*;
import java.awt.image.BufferedImage;

/*! \class public class Tile
    \brief Retine toate dalele intr-un vector si ofera posibilitatea regasirii dupa un id.
 */

public class Tile
{
    private static final int NO_TILES   = 40;
    public static Tile[] tiles          = new Tile[NO_TILES];       /*!< Vector de referinte de tipuri de dale.*/

        /// De remarcat ca urmatoarele dale sunt statice si publice. Acest lucru imi permite sa le am incarcate
        /// o singura data in memorie
//    public static Tile grassTile        = new GrassTile(0);     /*!< Dala de tip iarba*/
//    public static Tile mountainTile     = new MountainTile(1);  /*!< Dala de tip munte/piatra*/
//    public static Tile waterTile        = new WaterTile(2);     /*!< Dala de tip apa*/
//    public static Tile treeTile         = new TreeTile(3);      /*!< Dala de tip copac*/
//    public static Tile soilTile         = new SoilTile(4);      /*!< Dala de tip sol/pamant*/

    public static Tile sandTile= new SandTile(0);
    public static Tile wallTile= new WallTile(1);
    public static Tile duneTile= new DuneTile(2);
    public static Tile coconutTile= new CoconutTile(3);
    public static Tile light1TIle= new Light1(4);
    public static Tile chest1Tile= new ChestLevel1Tile(5);
    public static Tile battery1Tile= new Battery1Tile(6);
    public static Tile portal1Tile= new PortalLevel1Tile(7);
    public static Tile activA1Tile= new ButtonActivAlb1Tile(8);
    public static Tile neactivA1Tile= new ButtonNeactivAlb1Tile(9);

    public static Tile grassTile = new GrassTile(10);
    public static Tile treeTrunkTile= new TreeTrunkTile(11);
    public static Tile battery2Tile= new Battery2Tile(12);
    public static Tile chest2Tile= new ChestLevel2Tile(13);
    public static Tile light2Tile= new Light2(14);
    public static Tile  fireDown2Tile= new FireDown2Tile(15);
    public static Tile fireRight2Tile= new FireRight2Tile(16);
    public static Tile activA2Tile= new ButtonActivAlb2Tile(17);
    public static Tile neactivA2Tile= new ButtonNeactivAlb2Tile(18);
    public static Tile activR2Tile= new ButtonActivRosu2Tile(19);
    public static Tile neactivR2Tile= new ButtonNeactivRosu2Tile(20);
    public static Tile portal2Tile= new PortalLevel2Tile(30);
    public static Tile purpleSoilTile = new PurpleSoilTile(21);
    public static Tile gemTile= new GemTile(22);
    public static Tile diamondTile= new DiamondTile(23);
    public static Tile light3Tile= new Light3(24);
    public static Tile fireRight3Tile= new FireRight3Tile(25);
    public static Tile activA3Tile= new ButtonActivAlb3Tile(26);
    public static Tile neactivA3Tile= new ButtonNeactivAlb3Tile(27);
    public static Tile activR3Tile= new ButtonActivRosu3Tile(28);
    public static Tile neactivR3Tile= new ButtonNeactivRosu3Tile(29);
    public static Tile chest3Tile= new ChestLevel3Tile(31);
    public static Tile battery3Tile= new Battery3Tile(32);
    public static Tile fireRight2= new FireRight2Tile(33);


    public static final int TILE_WIDTH  = 32;                       /*!< Latimea unei dale.*/
    public static final int TILE_HEIGHT = 32;                       /*!< Inaltimea unei dale.*/

    protected BufferedImage img;                                    /*!< Imaginea aferenta tipului de dala.*/
    protected final int id;                                         /*!< Id-ul unic aferent tipului de dala.*/

    /*! \fn public Tile(BufferedImage texture, int id)
        \brief Constructorul aferent clasei.

        \param image Imaginea corespunzatoare dalei.
        \param id Id-ul dalei.
     */
    public Tile(BufferedImage image, int idd)
    {
        img = image;
        id = idd;

        tiles[id] = this;
    }

    /*! \fn public void Update()
        \brief Actualizeaza proprietatile dalei.
     */
    public void Update()
    {

    }

    /*! \fn public void Draw(Graphics g, int x, int y)
        \brief Deseneaza in fereastra dala.

        \param g Contextul grafic in care sa se realizeze desenarea
        \param x Coordonata x in cadrul ferestrei unde sa fie desenata dala
        \param y Coordonata y in cadrul ferestrei unde sa fie desenata dala
     */
    public void Draw(Graphics g, int x, int y)
    {
            /// Desenare dala
        g.drawImage(img, x, y, TILE_WIDTH, TILE_HEIGHT, null);
    }

    /*! \fn public boolean IsSolid()
        \brief Returneaza proprietatea de dala solida (supusa coliziunilor) sau nu.
     */
    public boolean IsSolid()
    {
        return false;
    }

    /*! \fn public int GetId()
        \brief Returneaza id-ul dalei.
     */
    public int GetId()
    {
        return id;
    }
}
