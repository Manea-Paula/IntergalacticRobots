package PaooGame.States;

import PaooGame.Items.*;
import PaooGame.Maps.Camera;
import PaooGame.Maps.Map;
import PaooGame.RefLinks;

import java.awt.*;

/*! \class public class PlayState extends State
    \brief Implementeaza/controleaza jocul.
 */
public class PlayState extends State
{
    private Hero hero;  /*!< Referinta catre obiectul animat erou (controlat de utilizator).*/
    private Hero2 hero2;
    private static Map map;    /*!< Referinta catre harta curenta.*/
    private Camera camera;
   // private Camera2 cam;


    /*! \fn public PlayState(RefLinks refLink)
        \brief Constructorul de initializare al clasei

        \param refLink O referinta catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.
     */
    public PlayState(RefLinks refLink)
    {
            ///Apel al constructorului clasei de baza
        super(refLink);
            ///Construieste harta jocului
        map = new Map(refLink);
            ///Referinta catre harta construita este setata si in obiectul shortcut pentru a fi accesibila si in alte clase ale programului.
        refLink.SetMap(map);

            ///Construieste eroul + camera
        camera=new Camera(0,0);
        hero = new Hero(refLink,200, 500);
        hero2= new Hero2(refLink,120,350);

        //chest= new Chest(refLink,415,265,50,50);
      //  camera=new Camera(0,0,960,680,hero,hero2);

      // camera2=new CameraHero2(100,100);


    }

    /*! \fn public void Update()
        \brief Actualizeaza starea curenta a jocului.
     */
    @Override
    public void Update()
    {

        map.Update();
        hero.Update();

        hero2.Update();
        //obstacol.Update();

        //hero.intersectareSpike();
      //  chest.Update();
    //    camera.update();
        //obstacolManager.updateObstacles();
     //   camera2.centerOnEntity(hero2);
        camera.centerOnEntity(hero);
       // obstacol.Update();

    }

    /*! \fn public void Draw(Graphics g)
        \brief Deseneaza (randeaza) pe ecran starea curenta a jocului.

        \param g Contextul grafic in care trebuie sa deseneze starea jocului pe ecran.
     */
    @Override
    public void Draw(Graphics g)
    {
        map.Draw(g);
       // g.translate((int) -camera.getxOffset(), (int) -camera.getyOffset());
        hero.Draw(g);
        //obstacolManager.drawObstacles(g);
        hero2.Draw(g);
        //chest.Draw(g);
       // obstacol.Draw(g);
   //     camera.draw(g);
      //  g.translate((int) camera.getxOffset(), (int) camera.getyOffset());

        HandleInput();

    }

    public void HandleInput()
    {
        if(refLink.GetKeyManagerState().escape)
        {
            //refLink.GetGame().SetState(new MenuState(refLink));
            State.SetState(new MenuState(refLink));
        }
    }
}
