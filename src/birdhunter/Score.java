/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package birdhunter;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
/**
 *
 * @author Emad47
 */
public class Score extends ScreenObject{
    
    private int sc=0;
    
 public Score(int x, int y, int w, int h,Color cl){
     super(x,y,w,h,cl);
 }

 
 public void incScore(int d){
     sc += d;
 }
 
 public void decScore(int d){
     
     sc -= d;
     
 }
 
 
    @Override
    public void draw(Graphics g) {
        g.setColor(cl);
        g.setFont(new Font("Arial",Font.BOLD,h));
        g.drawString(sc+"", x, y+h/2);
     }
    
}
