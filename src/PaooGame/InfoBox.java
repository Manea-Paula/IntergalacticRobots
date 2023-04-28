package PaooGame;

import javax.swing.JOptionPane;

public class InfoBox {
    public static void ShowInfo(String message, String title)
    {
        JOptionPane.showMessageDialog(null,message,"InfoBox: " + title, JOptionPane.INFORMATION_MESSAGE);
    }
}
