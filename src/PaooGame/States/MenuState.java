package PaooGame.States;

import PaooGame.RefLinks;

import java.awt.*;
import java.awt.image.BufferedImage;

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
    private int selectedItem;
    private RefLinks refLinks;

    public MenuState(RefLinks refLink)
    {
            ///Apel al constructorului clasei de baza.
        super(refLink);
        options = new String[]{"Start Game", "Settings", "Exit"};

        ///Seteaza elementul selectat la prima optiune.
        selectedItem = 0;

//        try{
//            background = ImageIO.read(getClass().getResourceAsStream("/textures/bkg.png"));
//        }
//        catch(IOException e)
//        {
//            e.printStackTrace();
//        }
    }
    /*! \fn public void Update()
        \brief Actualizeaza starea curenta a meniului.
     */
    @Override
    public void Update()
    {
        if(refLinks.GetKeyManagerState().up)
        {
            MoveUp();
        }
        if(refLinks.GetKeyManagerState().down)
        {
            MoveDown();
        }
        if(refLinks.GetKeyManagerState().enter)
        {
            //execute the selected menu option
            switch(selectedItem)
            {
                case 0: //start game
                    //change the game state to the play state
                    refLinks.GetGame().SetState(new PlayState(refLinks));
                    break;
                case 1: //settings
                    //change the game state to the settings state
                    refLinks.GetGame().SetState(new SettingsState(refLinks));
                    break;
                case 2: //exit
                    //exit the game
                    System.exit(0);
                    break;
            }
        }

        if(refLinks.GetKeyManagerState().escape)
        {
            refLinks.GetGame().SetState(new SettingsState(refLinks));
        }


    }

    /*! \fn public void Draw(Graphics g)
        \brief Deseneaza (randeaza) pe ecran starea curenta a meniului.

        \param g Contextul grafic in care trebuie sa deseneze starea jocului pe ecran.
     */
    @Override
    public void Draw(Graphics g)
    {
        g.drawRect(200,200,200,500);
        ///Seteaza fontul si culoarea de afisare.
        Font font = new Font("Arial", Font.BOLD, 48);
        g.setFont(font);
        g.setColor(Color.white);

        ///Deseneaza optiunile meniului.
        for(int i = 0; i < options.length; i++) {
            ///Daca optiunea curenta este selectata, se afiseaza cu o culoare diferita.
            if(i == selectedItem) {
                g.setColor(Color.green);
            }
            else {
                g.setColor(Color.white);
            }
            g.drawString(options[i], refLinks.GetWidth() / 2 - g.getFontMetrics().stringWidth(options[i]) / 2, 250 + i * 100);
        }

    }

    //ma mut mai sus in meniu cu o pozitie
    private void MoveUp() {
        selectedItem--;
        if(selectedItem < 0) {
            selectedItem = options.length - 1;
        }
    }

    //ma mut mai jos in meniu cu o pozitie

    private void MoveDown() {
        selectedItem++;
        if(selectedItem >= options.length) {
            selectedItem = 0;
        }
    }

    //handle user input (e.g., move up or down in the menu)
    public void HandleInput()
    {

    }


}
