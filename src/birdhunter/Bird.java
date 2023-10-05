/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package birdhunter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Emad47
 */
public class Bird extends ScreenObject implements Runnable{
    
    Image m,m1,m2,m3,m4;
    int dx, type;
    BirdHunter parent;
    
    
 ScreenManager sm;
 
    public Bird(int x, int y, int w, int h,Color cl,int dx, ScreenManager sm, int type){
     super(x,y,w,h,cl);
     this.dx = dx;
     this.sm =sm;
     this.type = type;
     
     
    m  = sm.parent.getImage(sm.parent.getCodeBase(), "bird.png");
    m1 = sm.parent.getImage(sm.parent.getCodeBase(), "cloud.png");
    m2 = sm.parent.getImage(sm.parent.getCodeBase(), "bird2.png");
    m3 = sm.parent.getImage(sm.parent.getCodeBase(), "bird3.png");
    m4 = sm.parent.getImage(sm.parent.getCodeBase(), "bird4.png");

 }
    
    @Override
    public void draw(Graphics g) {
        
        if(type == 1){
            
        g.drawImage(m2, x, y,w,h, sm.parent);
        g.drawImage(m1,0, 0, sm.parent.getWidth(), sm.parent.getHeight(),sm.parent);
        
        }
        
        else if (type == 2){
           
        g.drawImage(m1,0, 0, sm.parent.getWidth(), sm.parent.getHeight(),sm.parent);
         g.drawImage(m, x, y,w,h, sm.parent);
        
        }
        
        else if(type == 3){
            
        g.drawImage(m3, x, y,w,h, sm.parent);
        g.drawImage(m1,0, 0, sm.parent.getWidth(), sm.parent.getHeight(),sm.parent);
            
        }
        
        else if(type == 4){
            
            g.drawImage(m4, x, y,w,h, sm.parent);
            
        g.drawImage(m1,0, 0, sm.parent.getWidth(), sm.parent.getHeight(),sm.parent);
        if(x%45 == 0 )
        fireb();
        }
        
        }
        
       
    
    
    public void fireb(){
         
         Bomb b = new Bomb(x+(w-5)/2, y+20, 20, 20, Color.black, 5, sm);
         sm.addSO(b);
         Thread t = new Thread(b);
         t.start();
         
     }
    
    
    
    @Override
    public void run() {
        
        
        
        while(x<sm.parent.getWidth()){
           x+=dx;
           
            try {
                Thread.currentThread().sleep(20);
            } 
            
            
            catch (InterruptedException ex) {
                Logger.getLogger(Bird.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
                   sm.removeSO(this);

     }
    
}
