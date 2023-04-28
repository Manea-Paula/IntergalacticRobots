package PaooGame.Maps;

import PaooGame.Items.Hero;

import java.awt.*;

public class Camera {
    public static int cameraX;
    public static int cameraY;

    public static int pastCameraX = 400;
    public static int pastCameraY = 400;
    public static int width=960;
    public static int height=680;
 //   public static  float scaleFactor=0.9f;

    public Camera(int cameraX, int cameraY) {
        this.cameraX=cameraX;
        this.cameraY=cameraY;
    }

    public void centerOnEntity(Hero h) {

        if(cameraX<0)
        {
            cameraX=0;
        }

        if(cameraY<0)
        {
            cameraY=0;
        }


        int heroX = (int) h.GetX();
        int heroY = (int) h.GetY();

        if(heroX > (float) width - 100){
            cameraX = (int) (h.GetX()) - (width - 100);
        }
        if(heroY > (float) height - 100){
            cameraY = (int) (h.GetY()) - (height - 100);
        }


    }

    public void Draw(Graphics g)
    {
/*        g.setColor(new Color(0,0,0,0));
        g.drawRect(cameraX,cameraY,width,height);*/
    }

    public static int getX() {
        return cameraX;
    }

    public void setX(int cameraX) {
        this.cameraX = cameraX;
    }

    public static int getPastX() {
        return pastCameraX;
    }

    public static int getPastY() {
        return pastCameraY;
    }


    public static int getY() {
        return cameraY;
    }

    public void setY(int cameraY) {
        this.cameraY = cameraY;
    }

}