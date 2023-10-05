/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package birdhunter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

/**
 *
 * @author Emad47
 */
public class Background extends ScreenObject{

    Image m3;
    ScreenManager sm;
    
    public Background(int x, int y, int w, int h, Color cl, ScreenManager sm) {
        super(x, y, w, h, cl);
        this.sm= sm;
        m3 =  sm.parent.getImage(sm.parent.getCodeBase(),"bc.jpg");
    }

    @Override
    public void draw(Graphics g) {
        
        g.drawImage(m3, x, y, w, h, sm.parent);
    }
    
}
