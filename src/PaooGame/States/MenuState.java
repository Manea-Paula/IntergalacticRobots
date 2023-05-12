package PaooGame.States;

import PaooGame.Game;
import PaooGame.RefLinks;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;

/*! \class public class MenuState extends State
    \brief Implementeaza notiunea de menu pentru joc.
 */
public class MenuState extends State
{
    /*! \fn public MenuState(RefLinks refLink)
        \brief Constructorul de initializare al clasei.

        \param refLink O referinta catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.
     */
    private BufferedImage background;
    private String[] options;
    public int selectedItem;
//    private RefLinks refLinks;
//    public Rectangle playButton;
//    public Rectangle settingsButton;
//    public Rectangle aboutButton;
//    public Rectangle exitButton;

    public MenuState(RefLinks refLink)
    {
            ///Apel al constructorului clasei de baza.
        super(refLink);
        options = new String[]{"Play", "Settings","About", "Exit"};
//
//        playButton = new Rectangle(400, 250,150,50);
//        settingsButton = new Rectangle(400, 350,150,50);
//        aboutButton = new Rectangle(400, 450,150,50);
//        exitButton = new Rectangle(400,550,150,50);

        ///Seteaza elementul selectat la prima optiune.
        selectedItem = 0;
        System.out.println("selectedItem"+selectedItem);

    }
    /*! \fn public void Update()
        \brief Actualizeaza starea curenta a meniului.
     */
    @Override
    public void Update()
    {
       HandleInput();

    }

    /*! \fn public void Draw(Graphics g)
        \brief Deseneaza (randeaza) pe ecran starea curenta a meniului.

        \param g Contextul grafic in care trebuie sa deseneze starea jocului pe ecran.
     */
    @Override
    public void Draw(Graphics g)
    {
        try{
            background = ImageIO.read(new File("src/res/textures/bkg.png"));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

        g.drawImage(background,0,0,960,680,null);

        Graphics2D g2d= (Graphics2D)g;
     //   g.drawRect(200,200,960,680);
        ///Seteaza fontul si culoarea de afisare.
        Font font = new Font("Arial", Font.BOLD, 48);
        g.setFont(font);
        g.setColor(Color.CYAN);
        g.drawString("Robots' intergalactic adventure",140,100);

        ///Deseneaza optiunile meniului.
        for(int i = 0; i < options.length; i++) {
            ///Daca optiunea curenta este selectata, se afiseaza cu o culoare diferita.
            if(i == selectedItem) {
                g.setColor(Color.black);
            }
            else {
                g.setColor(Color.orange);
            }
            g.drawString(options[i], 480 - g.getFontMetrics().stringWidth(options[i]) / 2, 250 + i * 100);
        }
//        Font fnt1 = new Font("arial",Font.BOLD,30);
//        g.setFont(fnt1);
//        g.setColor(Color.red);
//        g.drawString("Play", playButton.x+39, playButton.y+33);
//        g2d.draw(playButton);
//        g.setColor(Color.orange);
//        g.drawString("Settings", settingsButton.x+19, settingsButton.y+33);
//        g2d.draw(settingsButton);
//        g.setColor(Color.blue);
//        g.drawString("About", aboutButton.x+29, aboutButton.y+33);
//        g2d.draw(aboutButton);
    }

//    //ma mut mai sus in meniu cu o pozitie
    private void MoveUp() {
        System.out.println("move up");

        selectedItem--;System.out.println(selectedItem);
        if(selectedItem < 0) {
            selectedItem = options.length - 1;
        }
    }

    //ma mut mai jos in meniu cu o pozitie

    private void MoveDown() {
        System.out.println("move down");
        selectedItem++;
        System.out.println(selectedItem);
        if(selectedItem >= options.length) {
            selectedItem = 0;
        }
    }

    //handle user input (e.g., move up or down in the menu)
    public void HandleInput()
    {
        if(refLink.GetKeyManagerState().up)
        {
            MoveUp();
        }
        if(refLink.GetKeyManagerState().down)
        {
            MoveDown();
        }
        if(refLink.GetKeyManagerState().enter)
        {
            System.out.println("enter");
            //execute the selected menu option
            switch(selectedItem)
            {
                case 0: //start game
                    //change the game state to the play state
                    State.SetState(new PlayState(refLink));

                    break;
                case 1: //settings
                    //change the game state to the settings state
                    State.SetState(new SettingsState(refLink));
                    break;
                case 2: //about
                    State.SetState(new AboutState(refLink));
                    break;
                case 3:
                    //exit the game
                    System.exit(0);
                    refLink.GetGame().StopGame();
                    break;
            }
        }
//
//        if(refLink.GetKeyManagerState().escape)
//        {
//            refLink.GetGame().SetState(new MenuState(refLink));
//        }

    }

}
