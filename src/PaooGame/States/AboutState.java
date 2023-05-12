package PaooGame.States;

import PaooGame.GameWindow.GameWindow;
import PaooGame.RefLinks;

import java.awt.*;
import java.awt.image.BufferStrategy;

/*! \class public class AboutState extends State
    \brief Implementeaza notiunea de credentiale (about)
 */
public class AboutState extends State
{
    private GameWindow wnd;
    private BufferStrategy bs;

    /*! \fn public AboutState(RefLinks refLink)
        \brief Constructorul de initializare al clasei.

        \param refLink O referinta catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.
     */
    public AboutState(RefLinks refLink)
    {
            ///Apel al constructorului clasei de baza.
        super(refLink);
       // wnd= new GameWindow("About",960,680);
     //   wnd.BuildGameWindow();
    }
    /*! \fn public void Update()
        \brief Actualizeaza starea curenta a meniu about.
     */
    @Override
    public void Update()
    {
      //  System.out.println();

    }

    /*! \fn public void Draw(Graphics g)
        \brief Deseneaza (randeaza) pe ecran starea curenta a meniu about.

        \param g Contextul grafic in care trebuie sa deseneze starea jocului pe ecran.
     */
    @Override
    public void Draw(Graphics g)
    {
//        g.drawRect(12,12,100,13);
//        g.setColor(Color.BLACK);

        bs= wnd.GetCanvas().getBufferStrategy();
        if(bs == null)
        {
            /// Se executa doar la primul apel al metodei Draw()
            try
            {
                /// Se construieste tripul buffer
                wnd.GetCanvas().createBufferStrategy(3);
                return;
            }
            catch (Exception e)
            {
                /// Afisez informatii despre problema aparuta pentru depanare.
                e.printStackTrace();
            }
        }

        g = bs.getDrawGraphics();
        Font fnt1 = new Font("arial",Font.BOLD,30);
        g.setFont(fnt1);
        g.setColor(Color.black);
        g.drawString("proba 1 2",200,30);

        /// Se sterge ce era
        g.clearRect(0, 0, wnd.GetWndWidth(), wnd.GetWndHeight());

        bs.show();
        g.dispose();


    }
}
