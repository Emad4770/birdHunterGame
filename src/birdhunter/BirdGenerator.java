/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package birdhunter;

import java.awt.Color;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Emad47
 */
public class BirdGenerator extends Thread{
    
    
    ScreenManager sm;
    private boolean isRunning = true;

    public BirdGenerator(ScreenManager sm) {
        this.sm = sm;
    }
    
    
    public void stopGenerate(){
        isRunning = false;
    }
    
    
    public Bird randomBird(){
        
        int w = 40+(int)(75*Math.random());
        int h = 40+(int)(75*Math.random());
        int y = 10+(int)(400*Math.random());
        int x = -w;
        int dx = 5+(int)(45*Math.random());
        Color c = Color.BLACK;
        
       int type = 1 + (int) (4 * Math.random());
      
        return new Bird(x, y, w, h, c, dx, sm, type);
        
    }
    public void run(){
        
        while(isRunning){
            
            Bird b = randomBird();
            sm.addSO(b);
            Thread t = new Thread(b);
            t.start();
            try {
                sleep(500+(int)(1500*Math.random()));
            } catch (InterruptedException ex) {
                Logger.getLogger(BirdGenerator.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
}
