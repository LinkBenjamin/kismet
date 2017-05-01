package com.benlink.kismet.model.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;

public class GUIDieWindow extends JFrame {

    private static final long serialVersionUID = 1L;

    public GUIDieWindow() {
        this.setSize(800,400);
        this.setTitle("Roll Dice GUI");
        Container contentPane = this.getContentPane();
        
        contentPane.setBackground(Color.GRAY);
        contentPane.setLayout(new FlowLayout());
        contentPane.add(new GUIDiePanel());
    }
}
