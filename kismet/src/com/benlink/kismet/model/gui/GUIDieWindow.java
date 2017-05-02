package com.benlink.kismet.model.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;

import com.benlink.kismet.game.KismetGameRunner;

public class GUIDieWindow extends JFrame {

    private static final long serialVersionUID = 1L;

    public GUIDieWindow() {
    	KismetGameRunner game = new KismetGameRunner();
    	
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000,800);
        this.setTitle("Roll Dice GUI");
        Container contentPane = this.getContentPane();
        
        contentPane.setBackground(Color.GRAY);
        contentPane.setLayout(new FlowLayout());
        contentPane.add(new GUIDiePanel(game));
    }
}
