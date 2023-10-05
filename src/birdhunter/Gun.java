/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package birdhunter;

import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
/**
 *
 * @author Emad47
 */

public class Gun extends ScreenObject{
    
    Image m;
    private int dx;
    private ScreenManager sm;
    AudioClip a;
    
     public Gun(int x, int y, int w, int h,Color cl, int dx, ScreenManager sm){
         
     super(x,y,w,h,cl);
     this.dx = dx;
     this.sm= sm;
     m = sm.parent.getImage(sm.parent.getCodeBase(), "gun.png");
     a = sm.parent.getAudioClip(sm.parent.getCodeBase(), "gs.wav");
     
     
 }
     public void fire(){
         
         Bullet b = new Bullet(x+(w-5)/2, y+10, 7, 13, Color.black, 20+ (int)sm.parent.dif/5, sm);
         sm.addSO(b);
         Thread t = new Thread(b);
         t.start();
         a.play();
         
     }
     
     
     
     public void right(){
       if(x+dx+w<sm.parent.getWidth()) x+=dx;   
     }
     
     public void left(){
       if(x-dx>=0) x-=dx;   
     }
     
     
    @Override
    public void draw(Graphics g) {
      
       g.drawImage(m, x, y, w, h, sm.parent);
    }
}
