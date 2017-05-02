package com.benlink.kismet.model.gui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.benlink.kismet.enums.ScoreType;
import com.benlink.kismet.exceptions.TypeAlreadyPlayedException;
import com.benlink.kismet.game.KismetGameRunner;
import com.benlink.kismet.model.KismetScoreSheet;

/**
 * @author ben
 *
 * The panel of dice and their entourage
 *
 */
public class GUIDiePanel extends JPanel implements ActionListener {

    private static final long serialVersionUID = 1L;
    
    private JLabel rollNum;
    private JLabel scoreCardOutput;

    private GUIDie die1;
    private GUIDie die2;
    private GUIDie die3;
    private GUIDie die4;
    private GUIDie die5;
    
    private JButton rollButton;
    private JComboBox<ScoreType> moveSelect;
    private JButton scoreButton;
    
    private JCheckBox hold1;
    private JCheckBox hold2;
    private JCheckBox hold3;
    private JCheckBox hold4;
    private JCheckBox hold5;
    
    private int rollNumber;
    private KismetGameRunner game;
    
    /**
     * @param myGame
     * 
     * Pass in the game object.  Build a panel to play it in.
     */
    public GUIDiePanel(KismetGameRunner myGame) {
    	game = myGame;        
        rollNumber = 1;
    	
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
        
        moveSelect = new JComboBox<ScoreType>(ScoreType.values());
        
        scoreButton = new JButton("Score");
        scoreButton.addActionListener(this);
        
        rollNum = new JLabel("Roll " + rollNumber);
        scoreCardOutput = new JLabel("Scorecard");
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 5;
        
        this.setBackground(Color.GRAY);
        this.setLayout(new GridBagLayout());
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(die1, gbc);
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;
        gbc.gridx = 1;
        gbc.gridy = 0;
        this.add(die2, gbc);
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;
        gbc.gridx = 2;
        gbc.gridy = 0;
        this.add(die3, gbc);
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;
        gbc.gridx = 3;
        gbc.gridy = 0;
        this.add(die4, gbc);
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;
        gbc.gridx = 4;
        gbc.gridy = 0;
        this.add(die5, gbc);
        
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        this.add(hold1, gbc);
      
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;
        gbc.gridx = 1;
        gbc.gridy = 1;
        this.add(hold2, gbc);
 
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;
        gbc.gridx = 2;
        gbc.gridy = 1;
        this.add(hold3, gbc);
   
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;
        gbc.gridx = 3;
        gbc.gridy = 1;
        this.add(hold4, gbc);
    
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;
        gbc.gridx = 4;
        gbc.gridy = 1;
        this.add(hold5, gbc);
     
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;
        gbc.gridx = 1;
        gbc.gridy = 2;
        this.add(rollNum, gbc);
      
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;
        gbc.gridx = 2;
        gbc.gridy = 2;
        this.add(rollButton, gbc);
     
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;
        gbc.gridx = 3;
        gbc.gridy = 2;
        this.add(moveSelect, gbc);
     
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;
        gbc.gridx = 4;
        gbc.gridy = 2;
        this.add(scoreButton, gbc);
                
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 5;
        gbc.gridx = 0;
        gbc.gridy = 3;
        this.add(scoreCardOutput, gbc);
        

        
    }

    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     * 
     * When stuff happens...
     */
    @Override
    public void actionPerformed(ActionEvent e) {
    	if(e.getSource() == rollButton){
    		if(rollNumber < 3){
    	    	
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
    	        
    	        rollNumber++;
    	        rollNum.setText("Roll " + rollNumber);
    	    }
    		
    	} else if(e.getSource() == scoreButton) {
    		
    		try {
    			
				game.score(die1.getDie(), die2.getDie(), die3.getDie(), die4.getDie(), die5.getDie(), ScoreType.valueOf(moveSelect.getSelectedItem().toString()));
				rollNumber = 0;
				
				hold1.setSelected(false);
				hold2.setSelected(false);
				hold3.setSelected(false);
				hold4.setSelected(false);
				hold5.setSelected(false);
				
				scoreCardOutput.setText(getScoreCardOutputString(game.getScoreSheet()));
				
			} catch (TypeAlreadyPlayedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    	}
    	
    }

	/**
	 * @param scoreSheet
	 * @return the score sheet.  HTML tags make it display nicely in a JLabel.
	 */
	private String getScoreCardOutputString(KismetScoreSheet scoreSheet) {
		String returnValue = "<html>(1s = " + scoreSheet.getAces() + ") <br/>";
		returnValue += "(2s = " + scoreSheet.getDeuces() + ") <br/>";
		returnValue += "(3s = " + scoreSheet.getTreys() + ") <br/>";
		returnValue += "(4s = " + scoreSheet.getFours() + ") <br/>";
		returnValue += "(5s = " + scoreSheet.getFives() + ") <br/>";
		returnValue += "(6s = " + scoreSheet.getSixes() + ") <br/><br/>";
		
		returnValue += "(Bonus = " + scoreSheet.getBonus() + ") <br/><br/>";
		
		returnValue += "(2pair = " + scoreSheet.getTwoPair() + ") <br/>";
		returnValue += "(3/Kind = " + scoreSheet.getThreeOfAKind() + ") <br/>";
		returnValue += "(Straight = " + scoreSheet.getStraight() + ") <br/>";
		returnValue += "(Flush = " + scoreSheet.getFlush() + ") <br/>";
		returnValue += "(FullHouse = " + scoreSheet.getFullHouse() + ") <br/>";
		returnValue += "(FullHouseSameColor = " + scoreSheet.getFullHouseSameColor() + ") <br/>";
		returnValue += "(4/Kind = " + scoreSheet.getFourOfAKind() + ") <br/>";
		returnValue += "(Yarborough = " + scoreSheet.getYarborough() + ") <br/>";
		returnValue += "(Kismet = " + scoreSheet.getKismet() + ") <br/><br/>";
		
		returnValue += "(Total = " + scoreSheet.calculateScore() + ")</html>";
		
		return returnValue;
	}
}
