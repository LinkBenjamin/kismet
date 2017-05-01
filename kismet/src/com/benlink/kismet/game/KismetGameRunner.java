package com.benlink.kismet.game;

import com.benlink.kismet.enums.ScoreType;
import com.benlink.kismet.exceptions.TypeAlreadyPlayedException;
import com.benlink.kismet.model.KismetDie;
import com.benlink.kismet.model.KismetScoreSheet;

public class KismetGameRunner {
	private int turnNumber;
	private boolean gameOver;
	
	private KismetScoreSheet scoreSheet;
	
	public KismetGameRunner(){
		setGameOver(false);
		
		setTurnNumber(1);
		
		scoreSheet = new KismetScoreSheet();
	}
	
	private void setGameOver(boolean over){
		gameOver = over;
	}
	
	private void incrementTurnNumber(){
		setTurnNumber(getTurnNumber() + 1);
	}
	
	private void setTurnNumber(int turn){
		turnNumber = turn;
	}
	
	public boolean isGameOver(){
		return gameOver;
	}
	
	public int getTurnNumber(){
		return turnNumber;
	}
	
	public void score(KismetDie die1, KismetDie die2, KismetDie die3, KismetDie die4, KismetDie die5, ScoreType scoreType){
		
		int scoreValue = 0;
		
		switch(scoreType){
		case ACES:
			scoreValue = countDiceWithValue(die1, die2, die3, die4, die5, 1);
			break;
		case DEUCES:
			scoreValue = 2 * countDiceWithValue(die1, die2, die3, die4, die5, 2);
			break;
		case TREYS:
			scoreValue = 3 * countDiceWithValue(die1, die2, die3, die4, die5, 3);
			break;
		case FOURS:
			scoreValue = 4 * countDiceWithValue(die1, die2, die3, die4, die5, 4);
			break;
		case FIVES:
			scoreValue = 5 * countDiceWithValue(die1, die2, die3, die4, die5, 5);
			break;
		case SIXES:
			scoreValue = 6 * countDiceWithValue(die1, die2, die3, die4, die5, 6);
			break;
		case TWOPAIR:
			break;
		case THREEOFAKIND:
			if(ofAKind(die1, die2, die3, die4, die5) >= 3){
				scoreValue = die1.getCurrentValue() +
					     die2.getCurrentValue() +
					     die3.getCurrentValue() +
					     die4.getCurrentValue() +
					     die5.getCurrentValue();
			}
			break;
		case STRAIGHT:
			// TODO: Straight
			break;
		case FLUSH:
			if(countDifferentColors(die1, die2, die3, die4, die5) == 1){
				scoreValue = 35;
			}
			break;
		case FULLHOUSE:
			if(hasFullHouse(die1, die2, die3, die4, die5)){
				scoreValue = die1.getCurrentValue() +
						     die2.getCurrentValue() +
						     die3.getCurrentValue() +
						     die4.getCurrentValue() +
						     die5.getCurrentValue() +
						     15;
			}
			break;
		case FULLHOUSESAMECOLOR:
			if(hasFullHouse(die1, die2, die3, die4, die5) && 
					(countDifferentColors(die1, die2, die3, die4, die5) == 1)){
				scoreValue = die1.getCurrentValue() +
					     die2.getCurrentValue() +
					     die3.getCurrentValue() +
					     die4.getCurrentValue() +
					     die5.getCurrentValue() +
					     20;
			}
			break;
		case FOUROFAKIND:
			if(ofAKind(die1, die2, die3, die4, die5) >= 4){
				scoreValue = die1.getCurrentValue() +
					     die2.getCurrentValue() +
					     die3.getCurrentValue() +
					     die4.getCurrentValue() +
					     die5.getCurrentValue() +
					     25;
			}
			break;
		case YARBOROUGH:
			scoreValue = die1.getCurrentValue() +
		     die2.getCurrentValue() +
		     die3.getCurrentValue() +
		     die4.getCurrentValue() +
		     die5.getCurrentValue();
			
			break;
		case KISMET:
			if(ofAKind(die1, die2, die3, die4, die5) == 5){
				scoreValue = die1.getCurrentValue() +
					     die2.getCurrentValue() +
					     die3.getCurrentValue() +
					     die4.getCurrentValue() +
					     die5.getCurrentValue() +
					     50;
			}
			break;
		}
		
		try {
			scoreSheet.score(scoreType, scoreValue);
			
			if (getTurnNumber() >= 15){
				setGameOver(true);
			}
			
			incrementTurnNumber();
		} catch (TypeAlreadyPlayedException e) {
			// TODO what do when failed scoring attempt?
			e.printStackTrace();
		}
		

		
	}

	private int ofAKind(KismetDie die1, KismetDie die2, KismetDie die3, KismetDie die4, KismetDie die5) {
		int[] ofAKindArray = new int[7];
		
		ofAKindArray[die1.getCurrentValue()]++;
		ofAKindArray[die2.getCurrentValue()]++;
		ofAKindArray[die3.getCurrentValue()]++;
		ofAKindArray[die4.getCurrentValue()]++;
		ofAKindArray[die5.getCurrentValue()]++;
		
		int returnValue = 1;
		
		for(int i=1; i<=6; i++){
			if(ofAKindArray[i] > returnValue){
				returnValue = i;
			}
		}
		
		return 0;
	}

	private boolean hasFullHouse(KismetDie die1, KismetDie die2, KismetDie die3, KismetDie die4, KismetDie die5) {
		if(ofAKind(die1, die2, die3, die4, die5) == 3 &&
	       countPairs(die1, die2, die3, die4, die5) == 2){
			return true;
		}
		
		return false;
	}

	private int countPairs(KismetDie die1, KismetDie die2, KismetDie die3, KismetDie die4, KismetDie die5) {
		// TODO Count Pairs
		return 0;
	}

	private int countDifferentColors(KismetDie die1, KismetDie die2, KismetDie die3, KismetDie die4, KismetDie die5) {
		int colors = 1;
		
		if(die2.getColor() != die1.getColor()){
			colors++;			
		}
		
		if(!(die3.getColor() == die1.getColor() || 
				die2.getColor() == die3.getColor())){
			colors++;
		}
		
		if(colors == 3) {
			return colors;
		}
		
		if(!(die4.getColor() == die1.getColor() ||
				die2.getColor() == die4.getColor() ||
				die3.getColor() == die4.getColor())){
			colors++;
		}
		
		if(colors == 3) {
			return colors;
		}
		
		if(!(die5.getColor() == die1.getColor() ||
				die2.getColor() == die5.getColor() ||
				die3.getColor() == die5.getColor() ||
				die4.getColor() == die5.getColor())){
			colors++;
		}
		
		return colors;		
	}

	private int countDiceWithValue(KismetDie die1, KismetDie die2, KismetDie die3, KismetDie die4, KismetDie die5,
			int magicNumber) {
		int returnValue = 0;
		
		if(die1.getCurrentValue() == magicNumber){
			returnValue++;
		}
		if(die2.getCurrentValue() == magicNumber){
			returnValue++;
		}
		if(die3.getCurrentValue() == magicNumber){
			returnValue++;
		}
		if(die4.getCurrentValue() == magicNumber){
			returnValue++;
		}
		if(die5.getCurrentValue() == magicNumber){
			returnValue++;
		}	
		
		return returnValue;
	}
}
