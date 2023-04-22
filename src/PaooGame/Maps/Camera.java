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

//        if(heroX<0)
//        {
//            heroX=0;
//        }
//
//        if(heroY<0)
//        {
//            heroY=0;
//        }

//        if(heroX>935)
//        {
//            heroX=935;
//        }
//
//        if(heroY>660)
//        {
//            heroY=660;
//        }


//            // Verifică dacă coordonata X a eroului se află în marginea stângă a camerei
//            if (heroX <= cameraX + width / 2) {
//                cameraX = Math.max(heroX - width / 2, 0);
//
//            }
//            // Verifică dacă coordonata X a eroului se află în marginea dreaptă a camerei
//            else if (heroX >= cameraX + width / 2) {
//                cameraX = Math.min(heroX - width / 2,  width-pastCameraX);
//            }
//
//            // Verifică dacă coordonata Y a eroului se află în marginea de sus a camerei
//            if (heroY <= cameraY + height / 2) {
//                cameraY = Math.max(heroY - height / 2, 0);
//            }
//            // Verifică dacă coordonata Y a eroului se află în marginea de jos a camerei
//            else if (heroY >= cameraY + height / 2) {
//                cameraY = Math.min(heroY - height / 2,  height-pastCameraY);
//            }
//
//            // Actualizează poziția eroului pe ecran
//            h.SetX(heroX - cameraX);
//            h.SetY(heroY - cameraY);



//        if(h.GetX() > (float) width /2){
//            cameraX = (int) (h.GetX()) - width/2;
//            h.SetX(width/2 + cameraX);
//        }
////        else {
////            cameraX = 0;
////        }
//
//        if(h.GetY() > (float) height/2){
//            cameraY = (int) (h.GetY()) - height/2;
//            h.SetY(height/2 + cameraY);
//        }
//        else {
//            cameraY = 0;
//        }

//        System.out.println(h.GetX() + " - > " + h.GetY());
//        System.out.println(cameraX + " - > " + cameraY);
//        System.out.println();
//        System.out.println();
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