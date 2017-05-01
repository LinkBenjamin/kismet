package com.benlink.kismet.model;

import java.awt.Color;

import com.benlink.kismet.exceptions.ImpossibleDieValueException;

public class KismetDie extends Die {
    public static final int SIDES = 6;
    private Color color;
    
    public KismetDie(){
        super(SIDES);
        try {
            setColor(identifyColor(getCurrentValue()));
        } catch (ImpossibleDieValueException e) {
            e.printStackTrace();
        }
    }

    public Color getColor() {
        return color;
    }

    private void setColor(Color color) {
        this.color = color;
    }
    
    private Color identifyColor(int value) throws ImpossibleDieValueException {
        Color returnValue = Color.WHITE;
        
        switch(value){
            case 1:
            case 6:
                returnValue = Color.BLACK;
                break;
            case 2:
            case 5:
                returnValue = Color.RED;
                break;
            case 3:
            case 4:
                returnValue = Color.GREEN;
                break;
            default:
                throw new ImpossibleDieValueException("Dunno how you managed to roll " + value + " on a d6.");
        }
        return returnValue;
    }
    
    @Override
    public int roll() {
    	int newValue = super.roll();
    	
    	try {
            setColor(identifyColor(getCurrentValue()));
        } catch (ImpossibleDieValueException e) {
            e.printStackTrace();
        }
    	
    	return newValue;
    }
    
}
