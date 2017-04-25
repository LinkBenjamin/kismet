package com.benlink.kismet.exceptions;

/**
 * @author Ben
 * 
 * Exceptions gonna Except
 *
 */
public class ImpossibleDieValueException extends Exception {

    /**
     *  'Cause I have to have one.
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * @param newMessage Custom Message
     */
    public ImpossibleDieValueException(String newMessage){
        super(newMessage);
    }
    
    /**
     * Default message.
     */
    public ImpossibleDieValueException(){
        this("You can't have that value on a die of this type.");
    }
}
