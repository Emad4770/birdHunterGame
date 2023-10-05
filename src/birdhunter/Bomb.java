/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package birdhunter;

import java.awt.Color;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Emad47
 */
public class Bomb extends ScreenObject implements Runnable {

    int dy;
    ScreenManager sm;
    
    public Bomb(int x, int y, int w, int h, Color cl, int dy, ScreenManager sm) {
        super(x, y, w, h, cl);
        this.dy = dy;
        this.sm = sm;
    }

    @Override
    public void draw(Graphics g) {
       g.setColor(cl);
        g.fillOval(x, y, w, h);
    }

    @Override
    public void run() {
        
        while(y+h<sm.parent.getHeight()){
           y+=dy;
            try {
                Thread.currentThread().sleep(20);
            } catch (InterruptedException ex) {
                Logger.getLogger(Bullet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                   sm.removeSO(this);

     }
    }
    

