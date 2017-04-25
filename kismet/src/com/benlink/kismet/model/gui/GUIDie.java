package com.benlink.kismet.model.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JComponent;

import com.benlink.kismet.model.KismetDie;

public class GUIDie extends JComponent {

    private static final long serialVersionUID = 1L;

    private KismetDie die;
    private static final int PIP_DIAMETER = 18;
    
    public GUIDie() {
        this.setPreferredSize(new Dimension(120, 120));
        this.setDie(new KismetDie());
    }

    public KismetDie getDie() {
        return die;
    }

    private void setDie(KismetDie singleDie) {
        this.die = singleDie;
    }
    
    public int roll(){
        return this.die.roll();
    }
    
    public void paintComponent(Graphics g) {
        int w = this.getWidth();
        int h = this.getHeight();
        
        g.setColor(Color.WHITE);
        g.fillRoundRect(0,0,w,h,50,50);
        
        g.setColor(this.die.getColor());
        g.drawRoundRect(0,0,w-1,h-1,50,50);
        
        switch(this.die.getCurrentValue()) {
            case 1:
                this.drawPip(g, w/2, h/2);
                break;
            case 3:
                this.drawPip(g, w/2, h/2);
            case 2:
                this.drawPip(g, w/4,  h/4);
                this.drawPip(g, 3*w/4,  3*h/4);
                break;
            case 5:
                this.drawPip(g, w/2, h/2);
            case 4:
                this.drawPip(g, w/4, h/4);
                this.drawPip(g, 3*w/4, 3*h/4);
                this.drawPip(g, 3*w/4, h/4);
                this.drawPip(g, w/4, 3*h/4);
                break;
            case 6:
                this.drawPip(g, w/4, h/4);
                this.drawPip(g, 3*w/4, 3*h/4);
                this.drawPip(g, 3*w/4, h/4);
                this.drawPip(g, w/4, 3*h/4);
                this.drawPip(g, 3*w/4, h/2);
                this.drawPip(g, w/4, 3*h/2);
                break;                
        }
    }
    
    private void drawPip(Graphics g, int x, int y){
        g.fillOval(x - PIP_DIAMETER, y - PIP_DIAMETER, PIP_DIAMETER, PIP_DIAMETER);
    }
}
