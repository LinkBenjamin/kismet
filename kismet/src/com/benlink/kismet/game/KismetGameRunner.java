package com.benlink.kismet.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.benlink.kismet.enums.ScoreType;
import com.benlink.kismet.exceptions.TypeAlreadyPlayedException;
import com.benlink.kismet.model.KismetDie;
import com.benlink.kismet.model.KismetScoreSheet;

/**
 * @author Ben
 * 
 * This is how you play the game.
 *
 */
public class KismetGameRunner {
	private int turnNumber;
	private boolean gameOver;
	
	private KismetScoreSheet scoreSheet;
	
	/**
	 * Default Constructor sets the game up.
	 */
	public KismetGameRunner(){
		setGameOver(false);
		
		setTurnNumber(1);
		
		scoreSheet = new KismetScoreSheet();
	}
	
	/**
	 * @return score sheet
	 */
	public KismetScoreSheet getScoreSheet() {
		return scoreSheet;
	}

	/**
	 * @param over whether the game is over.
	 */
	private void setGameOver(boolean over){
		gameOver = over;
	}
	
	/**
	 * Well, it should be obvious what that does.
	 */
	private void incrementTurnNumber(){
		setTurnNumber(getTurnNumber() + 1);
	}
	
	/**
	 * @param turn what turn it is
	 */
	private void setTurnNumber(int turn){
		turnNumber = turn;
	}
	
	/**
	 * @return well?  Is it?
	 */
	public boolean isGameOver(){
		return gameOver;
	}
	
	/**
	 * @return the turn number
	 */
	public int getTurnNumber(){
		return turnNumber;
	}
	
	/**
	 * @param die1 the first die
	 * @param die2 the second die
	 * @param die3 the third die
	 * @param die4 the fourth die
	 * @param die5 the fifth die
	 * @param scoreType how you intend for it to be scored
	 * @throws TypeAlreadyPlayedException If you've already played in that space.
	 */
	public void score(KismetDie die1, KismetDie die2, KismetDie die3, KismetDie die4, KismetDie die5, ScoreType scoreType) throws TypeAlreadyPlayedException{
		
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
			if(evalStraight(die1, die2, die3, die4, die5))
				scoreValue = 30;			
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
		
		System.out.println("KismetGameRunner 144: " + scoreType + " " + scoreValue);
		scoreSheet.score(scoreType, scoreValue);
			
		if (getTurnNumber() >= 15){
			setGameOver(true);
		}
		
		incrementTurnNumber();		
	}

	/**
	 * @param die1
	 * @param die2
	 * @param die3
	 * @param die4
	 * @param die5
	 * @return is it a straight?
	 */
	private boolean evalStraight(KismetDie die1, KismetDie die2, KismetDie die3, KismetDie die4, KismetDie die5) {
		List<KismetDie> dice = new ArrayList<KismetDie>();
		dice.add(die1);
		dice.add(die2);
		dice.add(die3);
		dice.add(die4);
		dice.add(die5);
		
		Collections.sort(dice);
		
		boolean isStraight = true;
		KismetDie previous = null;
		for(KismetDie current: dice){
			if(previous != null){
				if(current.getCurrentValue() != previous.getCurrentValue() + 1){
					isStraight = false;
					break;
				}
			}
		}
		
		return isStraight;
	}

	/**
	 * @param die1
	 * @param die2
	 * @param die3
	 * @param die4
	 * @param die5
	 * @return the most of-a-kind in the current roll
	 */
	private int ofAKind(KismetDie die1, KismetDie die2, KismetDie die3, KismetDie die4, KismetDie die5) {
		List<KismetDie> dice = new ArrayList<KismetDie>();
		dice.add(die1);
		dice.add(die2);
		dice.add(die3);
		dice.add(die4);
		dice.add(die5);
		
		Collections.sort(dice);
		
		int largestOfAKind = 0;
		int ofAKind = 0;
		int value = 0;
		
		for(KismetDie d: dice){
			if(value == 0){
				ofAKind = 1;
				value = d.getCurrentValue();
			} else {
				if(d.getCurrentValue() == value){
					ofAKind++;
				} else {
					if(ofAKind > largestOfAKind){
						largestOfAKind = ofAKind;
					}
					ofAKind = 1;
					value = d.getCurrentValue();
				}
			}
		}
		
		if(ofAKind > largestOfAKind){
			largestOfAKind = ofAKind;
		}
		
		return largestOfAKind;
	}

	/**
	 * @param die1
	 * @param die2
	 * @param die3
	 * @param die4
	 * @param die5
	 * @return whatever happened to predictability?
	 */
	private boolean hasFullHouse(KismetDie die1, KismetDie die2, KismetDie die3, KismetDie die4, KismetDie die5) {
		if(ofAKind(die1, die2, die3, die4, die5) == 3 &&
	       countPairs(die1, die2, die3, die4, die5) > 1){
			return true;
		}
		
		return false;
	}

	/**
	 * @param die1
	 * @param die2
	 * @param die3
	 * @param die4
	 * @param die5
	 * @return how many pairs do you have?
	 */
	private int countPairs(KismetDie die1, KismetDie die2, KismetDie die3, KismetDie die4, KismetDie die5) {
		List<Integer> histogram = new ArrayList<Integer>();
		
		histogram.add(countDiceWithValue(die1, die2, die3, die4, die5, 1));
		histogram.add(countDiceWithValue(die1, die2, die3, die4, die5, 2));
		histogram.add(countDiceWithValue(die1, die2, die3, die4, die5, 3));
		histogram.add(countDiceWithValue(die1, die2, die3, die4, die5, 4));
		histogram.add(countDiceWithValue(die1, die2, die3, die4, die5, 5));
		histogram.add(countDiceWithValue(die1, die2, die3, die4, die5, 6));

		int returnValue = 0;
		
		for(int x: histogram){
		    returnValue += (x / 2);
		}
		
		System.out.println("countPairs = " + returnValue);
		
		return returnValue;
	}

	/**
	 * @param die1
	 * @param die2
	 * @param die3
	 * @param die4
	 * @param die5
	 * @return how many different colors?
	 */
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

	/**
	 * @param die1
	 * @param die2
	 * @param die3
	 * @param die4
	 * @param die5
	 * @param magicNumber the number you're looking for
	 * @return how many dice have that number?
	 */
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
