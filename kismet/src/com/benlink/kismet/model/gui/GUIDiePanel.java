package com.benlink.kismet.model.gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUIDiePanel extends JPanel implements ActionListener {

    private static final long serialVersionUID = 1L;

    private GUIDie die1;
    private GUIDie die2;
    private GUIDie die3;
    private GUIDie die4;
    private GUIDie die5;
    
    private JButton rollButton;
    
    private JCheckBox hold1;
    private JCheckBox hold2;
    private JCheckBox hold3;
    private JCheckBox hold4;
    private JCheckBox hold5;
    
    public GUIDiePanel() {
        die1 = new GUIDie();
        die2 = new GUIDie();
        die3 = new GUIDie();
        die4 = new GUIDie();
        die5 = new GUIDie();
        
        hold1 = new JCheckBox("Hold");
        hold2 = new JCheckBox("Hold");
        hold3 = new JCheckBox("Hold");
        hold4 = new JCheckBox("Hold");
        hold5 = new JCheckBox("Hold");
        
        rollButton = new JButton("Roll");
        rollButton.addActionListener(this);
        
        this.setBackground(Color.GRAY);
        this.setLayout(new GridLayout(0,5));
        this.add(die1);
        this.add(die2);
        this.add(die3);
        this.add(die4);
        this.add(die5);
        
        this.add(hold1);
        this.add(hold2);
        this.add(hold3);
        this.add(hold4);
        this.add(hold5);
        
        this.add(new JLabel(""));
        this.add(new JLabel(""));
        
        this.add(rollButton);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(!hold1.isSelected()){
	    	die1.roll();
	        die1.paintComponent(die1.getGraphics());
        }
        
        if(!hold2.isSelected()){
	        die2.roll();
	        die2.paintComponent(die2.getGraphics());
        }
        
        if(!hold3.isSelected()){
	        die3.roll();
	        die3.paintComponent(die3.getGraphics());
        }
        
        if(!hold4.isSelected()){
	        die4.roll();
	        die4.paintComponent(die4.getGraphics());
        }
        
        if(!hold5.isSelected()){
	        die5.roll();
	        die5.paintComponent(die5.getGraphics());
        }
    }
}
