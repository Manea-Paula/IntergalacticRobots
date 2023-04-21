package PaooGame.Input;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class KeyState implements KeyListener {

    private boolean[] keys; /*!< Vector de flaguri pentru toate tastele. Tastele vor fi regasite dupa cod [0 - 255]*/
    public boolean enter;
    public boolean up;
    public boolean down;  /*!< Flag pentru tasta "dreapta" apasata.*/
    public boolean escape;

    /*! \fn public KeyManager()
        \brief Constructorul clasei.
     */
    public KeyState()
    {
        ///Constructie vector de flaguri aferente tastelor.
        keys = new boolean[256];
    }


    public void Update()
    {
        enter=keys[KeyEvent.VK_ENTER];
        up=keys[KeyEvent.VK_UP];
        down=keys[KeyEvent.VK_DOWN];
        escape=keys[KeyEvent.VK_ESCAPE];
    }

    /*! \fn public void keyPressed(KeyEvent e)
        \brief Functie ce va fi apelata atunci cand un un eveniment de tasta apasata este generat.

         \param e obiectul eveniment de tastatura.
     */
    @Override
    public void keyPressed(KeyEvent e)
    {
        ///se retine in vectorul de flaguri ca o tasta a fost apasata.
        keys[e.getKeyCode()] = true;
    }

    /*! \fn public void keyReleased(KeyEvent e)
        \brief Functie ce va fi apelata atunci cand un un eveniment de tasta eliberata este generat.

         \param e obiectul eveniment de tastatura.
     */
    @Override
    public void keyReleased(KeyEvent e)
    {
        ///se retine in vectorul de flaguri ca o tasta a fost eliberata.
        keys[e.getKeyCode()] = false;
    }

    /*! \fn public void keyTyped(KeyEvent e)
        \brief Functie ce va fi apelata atunci cand o tasta a fost apasata si eliberata.
        Momentan aceasta functie nu este utila in program.
     */
    @Override
    public void keyTyped(KeyEvent e)
    {

    }
}
