package com.benlink.kismet.exceptions;

public class TypeAlreadyPlayedException extends Exception {

	/**
	 * Exceptions gonna except.
	 */
	private static final long serialVersionUID = 1L;
	
    /**
     * @param newMessage Custom Message
     */
    public TypeAlreadyPlayedException(String newMessage){
        super(newMessage);
    }
    
    /**
     * Default message.
     */
    public TypeAlreadyPlayedException(){
        this("You've already played this spot on your scorecard.");
    }

}
