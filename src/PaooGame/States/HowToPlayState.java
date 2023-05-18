package PaooGame.States;

import PaooGame.RefLinks;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/*! \class public class AboutState extends State
    \brief Implementeaza notiunea de reguli de joc
 */
public class HowToPlayState extends State
{
    private Color backColor;
    private BufferedImage img1;
//    private String[] options;
//    private int selectedItem;
    public HowToPlayState(RefLinks refLink)
    {
        super(refLink);
        backColor=Color.white;
    //    options= new String[]{"<-Back", "Play->"};
    //    selectedItem=0;
    }

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

    @Override
    public void Draw(Graphics g)
    {
        g.setColor(backColor);
                try
        {
            img1 = ImageIO.read(new File("src/res/textures/instr.png"));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

        g.drawImage(img1,0,0,960,680,null);

        Font font = new Font("Calibri",Font.BOLD,30);
        g.setFont(font);

        g.setColor(Color.red);
        String text5 = "Press P to PLAY the game";
        g.drawString(text5, 250, 540);
        String text6= "Press M to go to the MAIN MENU";
        g.drawString(text6,250,580);

    }

}
