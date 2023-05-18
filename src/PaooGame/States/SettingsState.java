package PaooGame.States;

import PaooGame.RefLinks;

import java.awt.*;
import java.sql.*;

/*! \class public class SettingsState extends State
    \brief Implementeaza notiunea de settings pentru joc.

    Aici setarile vor trebui salvate/incarcate intr-un/dintr-un fisier/baza de date sqlite.
 */
public class SettingsState extends State
{
    private Color color;

    Connection c= null;
    Statement stmt= null;
    /*! \fn public SettingsState(RefLinks refLink)
        \brief Constructorul de initializare al clasei.

        \param refLink O referinta catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.
     */
    public SettingsState(RefLinks refLink)
    {
            ///Apel al construcotrului clasei de baza.
        super(refLink);

        color=Color.black;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:src/res/bazaSettings.db");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM setari;" );
            while ( rs.next() ) {
                String name = rs.getString("Personaj1");
                String name2= rs.getString("Personaj2");
                int night = rs.getInt("NightMode");
            //    int difficulty= rs.getInt("DifficultyLevel");

                System.out.println("nume pers 1: "+name+" \n nume pers 2"+name2+"\n mod joc: "+night);
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e )
        {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }

        System.out.println("Opened database successfully");
    }


    /*! \fn public void Update()
        \brief Actualizeaza starea setarilor.
     */
    @Override
    public void Update()
    {

    }

    /*! \fn public void Draw(Graphics g)
        \brief Deseneaza (randeaza) pe ecran setarile.

        \param g Contextul grafic in care trebuie sa deseneze starea setarilor pe ecran.
     */
    @Override
    public void Draw(Graphics g)
    {
        g.setColor(color);

        if(refLink.GetKeyManagerState().escape)
        {
            State.SetState(new MenuState(refLink));
        }

    }
}
