package PaooGame.States;

import PaooGame.GameWindow.GameWindow;
import PaooGame.RefLinks;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

/*! \class public class AboutState extends State
    \brief Implementeaza notiunea de credentiale (about)
 */
public class AboutState extends State
{
    private Color backColor;
    private JTextArea textArea;
    private JScrollPane scrollPane;

    /*! \fn public AboutState(RefLinks refLink)
        \brief Constructorul de initializare al clasei.

        \param refLink O referinta catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.
     */
    public AboutState(RefLinks refLink)
    {
            ///Apel al constructorului clasei de baza.
        super(refLink);
        backColor= Color.gray;
        textArea=new JTextArea();
        textArea.setEditable(false); // Set to true if you want the text to be editable
        textArea.setLineWrap(true); // Enable line wrapping
        textArea.setWrapStyleWord(true); // Wrap lines at word boundaries
        scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(0, 0, 960, 680); // Set the size of the scroll pane
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); // Always show the vertical scrollbar

    }
    /*! \fn public void Update()
        \brief Actualizeaza starea curenta a meniu about.
     */
    @Override
    public void Update()
    {
        textArea.setText("by moving doors.");
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
        scrollPane.paintComponents(g);

    }
}
