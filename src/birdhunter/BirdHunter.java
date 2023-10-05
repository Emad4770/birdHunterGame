/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package birdhunter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JApplet;

/**
 *
 * @author Emad47
 */
public class BirdHunter extends JApplet implements KeyListener{
    
    
    ScreenManager sm;
    Gun gun;
    BirdGenerator bg;
    Score sc;
    Background bc;
    long start ;
    long dif ;
    long lastshoot;
    boolean pressed = false;
    boolean lpress, rpress, spress;
    
    
 public void init(){
     
     setSize(1600,900);
     
     sm = new ScreenManager(this);
     
     bc = new Background(0, 0, getWidth(), getHeight(),Color.GREEN, sm);
     sm.addSO(bc);
     
     sc = new Score(getWidth()-4*25,getHeight()-40,40*4,40,Color.green);
     sm.addSO(sc);
                                                                                                    
     gun = new Gun((getWidth()-35)/2, getHeight()-60, 35, 60, Color.red, 30, sm);
     sm.addSO(gun);
     
     
     lastshoot =(int)System.currentTimeMillis();
     
     bg = new BirdGenerator(sm);
     
     
     this.addKeyListener(this);
     setFocusable(true);
     requestFocus();
     
 
 }
 
 
 
 public void start(){
     
     sm.start();
     bg.start();
     
 }
 public void stop(){
     
     bg.stopGenerate();
     sm.stopManager();
   
 }
 
 
 
 public void paint(Graphics g){
     sm.draw(g);
     
 }
 
 
 
 

    @Override
    public void keyTyped(KeyEvent e) {
        
        if(lpress == true && pressed == true){
           
            dif = 30 ;
          
            long now = (int)System.currentTimeMillis();
            
            if (now - lastshoot > 700){
                  
            gun.fire();
             lastshoot = now;
             
            }
         gun.left();
        }
        
        
        else if(rpress == true && pressed == true){
            
            dif = 30 ;
          
            long now = (int)System.currentTimeMillis();
            
            if (now - lastshoot > 700){
                  
            gun.fire();
             lastshoot = now;
             
            }
         gun.right();
            
            
            
        }
     }

    @Override
    public void keyPressed(KeyEvent e) {
        
        switch(e.getKeyCode()){
            
            case KeyEvent.VK_LEFT:
            {
                gun.left();
                lpress = true;
            }
                break;
                
                
            case KeyEvent.VK_RIGHT:{
                
                gun.right();
                rpress = true;
            }
                break;
                
            case KeyEvent.VK_SPACE :
                
                if(pressed == false)
                 start = (int)System.currentTimeMillis();
                pressed =true;
                
          
        
        }
     }
    
    

    @Override
    public void keyReleased(KeyEvent e) {
        
     
    
        switch(e.getKeyCode()){
            
            case KeyEvent.VK_LEFT:
                lpress = false;
                break;
                
            case KeyEvent.VK_RIGHT:
                rpress = false;
                break;
                
            case KeyEvent.VK_SPACE :
                
            {
            
            dif = (int)System.currentTimeMillis() - start ;
          
            long now = (int)System.currentTimeMillis();
            
            if (now - lastshoot > 500){
                  
             gun.fire();
            
             lastshoot = now; }
            
            pressed = false;
            
        }
            break;
            
        }
             
        
        }
    
    
    
    
    
    
    
    
    
    
    
    
 
}
