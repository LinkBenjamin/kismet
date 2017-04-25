package com.benlink.kismet.model.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GUIDiePanel extends JPanel implements ActionListener {

    private static final long serialVersionUID = 1L;

    private GUIDie die1;
    private GUIDie die2;
//    private GUIDie die3;
//    private GUIDie die4;
//    private GUIDie die5;
    
    private JButton rollButton;
    
    public GUIDiePanel() {
        die1 = new GUIDie();
        die2 = new GUIDie();
//        die3 = new GUIDie();
//        die4 = new GUIDie();
//        die5 = new GUIDie();
        rollButton = new JButton("Roll");
        rollButton.addActionListener(this);
        
        this.setBackground(Color.BLUE);
        this.setLayout(new BorderLayout());
        this.add(die1, BorderLayout.WEST);
        this.add(die2, BorderLayout.EAST);
//        this.add(die3, BorderLayout.WEST);
//        this.add(die4, BorderLayout.WEST);
//        this.add(die5, BorderLayout.WEST);
        
        this.add(rollButton, BorderLayout.SOUTH);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        die1.roll();
        die1.paintComponent(getGraphics());
        die2.roll();
        die2.paintComponent(getGraphics());
//        die3.roll();
//        die4.roll();
//        die5.roll();
    }
}
