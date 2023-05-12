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
        backColor= Color.gray;

//        textArea=new JTextArea();
//        textArea.setEditable(false); // Set to true if you want the text to be editable
//        textArea.setLineWrap(true); // Enable line wrapping
//        textArea.setWrapStyleWord(true); // Wrap lines at word boundaries
//        scrollPane = new JScrollPane(textArea);
//        scrollPane.setBounds(0, 0, 960, 680); // Set the size of the scroll pane
//        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); // Always show the vertical scrollbar
//        options = new String[]{"<-Back", "Play->"};
//        selectedItem=0;
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
//        g.setColor(backColor);
//        g.fillRect(0,0,960,680);
       // scrollPane.paintComponents(g);

        try
        {
            background = ImageIO.read(new File("src/res/textures/about.png"));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

        g.drawImage(background,0,0,960,680,null);

        g.setColor(Color.white);
        Font font = new Font("Arial", Font.PLAIN, 30);
        g.setFont(font);
        String text = "Game Title: Robots' intergalactic adventure";
        g.drawString(text, 150, 190);
        String text2 = "Version: 1.0.0";
        g.drawString(text2, 150, 220);
        String text3 = "Developer: Manea Paula";
        g.drawString(text3, 150, 250);
        String text4 = "Release date: 22.05.2023";
        g.drawString(text4, 150, 280);

        g.setColor(Color.orange);
        String text5 = "Press P to PLAY the game";
        g.drawString(text5, 150, 480);
        String text6= "Press M to go to the MAIN MENU";
        g.drawString(text6,150,520);
    }
}
