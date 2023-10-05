/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package birdhunter;

import com.sun.webkit.ContextMenu;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Emad47
 */

public class ScreenManager extends Thread{
    
    ArrayList<ScreenObject> ol;
    BirdHunter parent;
    boolean isRunning = true;
    AudioClip s1, s2;
    
    public ScreenManager(BirdHunter parent) {
        
        this.parent = parent;
        ol = new ArrayList<>();
        
    }
    
    
    
    public void addSO(ScreenObject so){
        ol.add(so);
    }
    public void removeSO(ScreenObject so){
        ol.remove(so);
    }
    
    
    
    
    
    
    private void checkConflict() {

        s1 = parent.getAudioClip(parent.getCodeBase(), "bs.wav");
        s2 = parent.getAudioClip(parent.getCodeBase(), "bos.wav");
        
        ArrayList<Bird> brl= new ArrayList<Bird>();
        ArrayList<Bullet> bll= new ArrayList<Bullet>();
        ArrayList<Bomb> bol= new ArrayList<Bomb>();
        ArrayList<Gun> gnl= new ArrayList<Gun>();
        
        Score score = null;
        
        for (int i = 0; i < ol.size(); i++) {
            
            ScreenObject so = ol.get(i);

            if(so instanceof Bird) brl.add((Bird)so);
            if(so instanceof Bullet) bll.add((Bullet)so);
            if(so instanceof Bomb) bol.add((Bomb)so);
            if(so instanceof Gun) gnl.add((Gun)so);
            if(so instanceof Score) score = (Score)so;
           
        }

          for (int i = 0; i < bol.size(); i++) {
            
            for (int j = 0; j < gnl.size(); j++) {
                
                Bomb bm=bol.get(i);
                Gun gn = gnl.get(j);
               
                if (bm.x <= gn.x + gn.w && bm.x >= gn.x
                        && bm.y <= gn.y + gn.h && bm.y >= parent.gun.y) {
                    
                    removeSO(bm);
                    s2.play();
                    score.decScore(50);
                    
                }
                
            }
        }
        
          for (int i = 0; i < bol.size(); i++) {
            
            for (int j = 0; j < bll.size(); j++) {
                
                Bomb bm=bol.get(i);
                Bullet bl = bll.get(j);
               
                
                int bx = bl.x + bl.w / 2;
                int by = bl.y;

                 int bmx = bm.x + bm.w / 2;
                int bmy = bm.y + bm.h;
                
                if (bx <= bm.x + bm.w && bx >= bm.x && by <= bm.y + bm.h && by >= bm.y) {
                    
                    removeSO(bm);
                    removeSO(bl);
                    
                }
                 
            }
        }
        
        for (int i = 0; i < brl.size(); i++) {
            
            for (int j = 0; j < bll.size(); j++) {
                
                Bird br=brl.get(i);
                Bullet bl = bll.get(j);
               
                
                int bx = bl.x + bl.w / 2;
                int by = bl.y;

                if (bx <= br.x + br.w && bx >= br.x && by <= br.y + br.h && by >= br.y) {
                    
                    removeSO(br);
                    removeSO(bl);
                    s1.play();
                    score.incScore(150 - br.w + br.dx);

                }
                
            }
        }
        
    }
    
    
    
    
    
    
    public void draw(Graphics g){
        
        Image offImg;
        Graphics offG;
        
        offImg = parent.createImage(parent.getWidth(),parent.getHeight());
        offG = offImg.getGraphics();
        
        offG.setColor(Color.white);
        offG.fillRect(0, 0,parent.getWidth(), parent.getHeight());
        for (int i = 0; i <ol.size(); i++) {
             ol.get(i).draw(offG);
        }
        g.drawImage(offImg, 0, 0, parent);
        
        
    }
    
    
    
    
    
    
    
    
    public void run(){
    
      while(isRunning){
          
          checkConflict();
          parent.repaint();
          
          try {
              sleep(20);   
          }
          catch (InterruptedException ex) {
              Logger.getLogger(ScreenManager.class.getName()).log(Level.SEVERE, null, ex);
          }
          
          
          
      }
    }
    
    
    
    public void stopManager(){
      isRunning = false;   
    }
    
    
    
}
