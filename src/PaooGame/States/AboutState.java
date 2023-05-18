package PaooGame.States;

import PaooGame.GameWindow.GameWindow;
import PaooGame.RefLinks;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/*! \class public class AboutState extends State
    \brief Implementeaza notiunea de credentiale (about)
 */
public class AboutState extends State
{
    private Color backColor;
    private BufferedImage background;
//    private String[] options;
//    public int selectedItem;

//    private JTextArea textArea;
//    private JScrollPane scrollPane;

    /*! \fn public AboutState(RefLinks refLink)
        \brief Constructorul de initializare al clasei.

        \param refLink O referinta catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.
     */
    public AboutState(RefLinks refLink)
    {
            ///Apel al constructorului clasei de baza.
        super(refLink);
        backColor= Color.white;

    }
    /*! \fn public void Update()
        \brief Actualizeaza starea curenta a meniu about.
     */

    @Override
    public void Update()
    {
        if(refLink.GetKeyManagerState().m)
        {
            State.SetState(new MenuState(refLink));
        }

        if(refLink.GetKeyManagerState().p)
        {
            State.SetState(new PlayState(refLink));
        }
    }

    /*! \fn public void Draw(Graphics g)
        \brief Deseneaza (randeaza) pe ecran starea curenta a meniu about.

        \param g Contextul grafic in care trebuie sa deseneze starea jocului pe ecran.
     */
    @Override
    public void Draw(Graphics g)
    {
        g.setColor(backColor);
        g.fillRect(0,0,960,680);
       // scrollPane.paintComponents(g);

        try
        {
            background = ImageIO.read(new File("src/res/textures/paper-with-sidebar-plain.png"));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

        g.drawImage(background,0,0,960,680,null);

        g.setColor(Color.black);
        Font font = new Font("Calibri", Font.PLAIN, 30);
        g.setFont(font);
        String text = "Game Title: Robots' intergalactic adventure";
        g.drawString(text, 250, 190);
        String text2 = "Version: 1.0.0";
        g.drawString(text2, 150, 220);
        String text3 = "Developer: Manea Paula";
        g.drawString(text3, 250, 260);
        String text4 = "Release date: 22.05.2023";
        g.drawString(text4, 250, 290);

        Font font2 = new Font("Calibri", Font.BOLD, 30);
        g.setFont(font2);
        g.setColor(Color.red);
        String text5 = "Press P to PLAY the game";
        g.drawString(text5, 250, 480);
        String text6= "Press M to go to the MAIN MENU";
        g.drawString(text6,250,520);
    }
}
