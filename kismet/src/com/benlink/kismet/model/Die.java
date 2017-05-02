package com.benlink.kismet.model;

/**
 * @author Ben
 *
 * I hate naming this class Die because it feels like a command.
 *
 */
public class Die {
    public final static int DEFAULT_SIDES = 6;
    
    private int numberOfSides;
    private int currentValue;
    
    /**
     * constructors gonna construct
     */
    public Die(){
        this(DEFAULT_SIDES);
    }
    
    /**
     * @param sides how many sides does it need to have?
     */
    public Die(int sides){
        setNumberOfSides(sides);
        roll();
    }

    /**
     * @return the number of sides
     */
    public int getNumberOfSides() {
        return numberOfSides;
    }

    /**
     * @param numberOfSides the number of sides
     */
    private void setNumberOfSides(int numberOfSides) {
        this.numberOfSides = numberOfSides;
    }

    /**
     * @return the current value
     */
    public int getCurrentValue() {
        return currentValue;
    }

    /**
     * @param currentValue the current value
     */
    private void setCurrentValue(int currentValue) {
        this.currentValue = currentValue;
    }
    
    /**
     * They see me rollin', they hatin'
     * 
     * @return the new value
     */
    public int roll(){
        setCurrentValue((int) (Math.random() * numberOfSides) + 1);
        return getCurrentValue();
    }
     
}
