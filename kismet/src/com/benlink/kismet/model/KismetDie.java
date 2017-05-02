package com.benlink.kismet.model;

import java.awt.Color;

import com.benlink.kismet.exceptions.ImpossibleDieValueException;

/**
 * @author Ben
 * 
 * These are special dice because they're colored.
 *
 */
public class KismetDie extends Die implements Comparable<KismetDie> {
    public static final int SIDES = 6;
    private Color color;
    
    /**
     * constructors gonna construct.
     */
    public KismetDie(){
        super(SIDES);
        try {
            setColor(identifyColor(getCurrentValue()));
        } catch (ImpossibleDieValueException e) {
            e.printStackTrace();
        }
    }

    /**
     * @return the color
     */
    public Color getColor() {
        return color;
    }

    /**
     * @param color the color
     */
    private void setColor(Color color) {
        this.color = color;
    }
    
    /**
     * @param value if the die shows this value, what color should it be?
     * @return this color!
     * @throws ImpossibleDieValueException if you roll a 7 on a d6, you should get a prize.
     */
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
    
    /* (non-Javadoc)
     * @see com.benlink.kismet.model.Die#roll()
     * 
     * rolling a KismetDie requires us to set the color, too
     * 
     */
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

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 * 
	 * Implementing Comparable-KismetDie
	 */
	@Override
	public int compareTo(KismetDie o) {
		final int BEFORE = -1;
	    final int EQUAL = 0;
	    final int AFTER = 1;
	    
	    if(this == o) return EQUAL;
	    
	    if(this.getCurrentValue() < o.getCurrentValue()) return BEFORE;
	    if(this.getCurrentValue() > o.getCurrentValue()) return AFTER;
	    
	    return EQUAL;
	}
    
}
