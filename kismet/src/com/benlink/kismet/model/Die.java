package com.benlink.kismet.model;

public class Die {
    public final static int DEFAULT_SIDES = 6;
    
    private int numberOfSides;
    private int currentValue;
    
    public Die(){
        this(DEFAULT_SIDES);
    }
    
    public Die(int sides){
        setNumberOfSides(sides);
        roll();
    }

    public int getNumberOfSides() {
        return numberOfSides;
    }

    private void setNumberOfSides(int numberOfSides) {
        this.numberOfSides = numberOfSides;
    }

    public int getCurrentValue() {
        return currentValue;
    }

    private void setCurrentValue(int currentValue) {
        this.currentValue = currentValue;
    }
    
    public int roll(){
        setCurrentValue((int) (Math.random() * numberOfSides) + 1);
        return getCurrentValue();
    }
     
}
