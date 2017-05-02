package com.benlink.kismet.model;

import com.benlink.kismet.enums.ScoreType;
import com.benlink.kismet.exceptions.TypeAlreadyPlayedException;

/**
 * @author Ben
 * 
 * Your score sheet.
 *
 */
public class KismetScoreSheet {
	private int aces;
	private int deuces;
	private int treys;
	private int fours;
	private int fives;
	private int sixes;
	private int twoPair;
	private int threeOfAKind;
	private int straight;
	private int flush;
	private int fullHouse;
	private int fullHouseSameColor;
	private int fourOfAKind;
	private int yarborough;
	private int kismet;
	
	private int bonus;
	
	/**
	 * Constructors gonna construct
	 */
	public KismetScoreSheet(){
		aces = deuces = treys = 
		fours = fives = sixes = 
		twoPair = threeOfAKind = straight =
		flush = fullHouse = fullHouseSameColor = 
		fourOfAKind = yarborough = kismet = -1;
	}

	/**
	 * @return aces
	 */
	public int getAces() {
		if(aces < 0) return 0;
		
		return aces;
	}

	/**
	 * @return deuces
	 */
	public int getDeuces() {
		if(deuces < 0) return 0;
		
		return deuces;
	}

	/**
	 * @return treys
	 */
	public int getTreys() {
		if(treys < 0) return 0;
		
		return treys;
	}

	/**
	 * @return fours
	 */
	public int getFours() {
		if(fours < 0) return 0;
		
		return fours;
	}

	/**
	 * @return fives
	 */
	public int getFives() {
		if(fives < 0) return 0;
		
		return fives;
	}

	/**
	 * @return sixes
	 */
	public int getSixes() {
		if(sixes < 0) return 0;
		
		return sixes;
	}

	/**
	 * @return twoPair
	 */
	public int getTwoPair() {
		if(twoPair < 0) return 0;
		
		return twoPair;
	}

	/**
	 * @return 3oaK
	 */
	public int getThreeOfAKind() {
		if(threeOfAKind < 0) return 0;
		
		return threeOfAKind;
	}

	/**
	 * @return straight
	 */
	public int getStraight() {
		if(straight < 0) return 0;
		
		return straight;
	}

	/**
	 * @return flush
	 */
	public int getFlush() {
		if(flush < 0) return 0;
		
		return flush;
	}

	/**
	 * @return fullhouse
	 */
	public int getFullHouse() {
		if(fullHouse < 0) return 0;
		
		return fullHouse;
	}

	/**
	 * @return fhsc
	 */
	public int getFullHouseSameColor() {
		if(fullHouseSameColor < 0) return 0;
		
		return fullHouseSameColor;
	}

	/**
	 * @return 4oaK
	 */
	public int getFourOfAKind() {
		if(fourOfAKind < 0) return 0;
		
		return fourOfAKind;
	}

	/**
	 * @return yarborough
	 */
	public int getYarborough() {
		if(yarborough < 0) return 0;
		
		return yarborough;
	}

	/**
	 * @return kismet
	 */
	public int getKismet() {
		if(kismet < 0) return 0;
		
		return kismet;
	}

	/**
	 * @return the bonus
	 */
	public int getBonus() {
		return bonus;
	}

	/**
	 * @param aces
	 */
	private void setAces(int aces) {
		this.aces = aces;
	}

	/**
	 * @param deuces
	 */
	private void setDeuces(int deuces) {
		this.deuces = deuces;
	}

	/**
	 * @param treys
	 */
	private void setTreys(int treys) {
		this.treys = treys;
	}

	/**
	 * @param fours
	 */
	private void setFours(int fours) {
		this.fours = fours;
	}

	/**
	 * @param fives
	 */
	private void setFives(int fives) {
		this.fives = fives;
	}

	/**
	 * @param sixes
	 */
	private void setSixes(int sixes) {
		this.sixes = sixes;
	}

	/**
	 * @param twoPair
	 */
	private void setTwoPair(int twoPair) {
		this.twoPair = twoPair;
	}

	/**
	 * @param threeOfAKind
	 */
	private void setThreeOfAKind(int threeOfAKind) {
		this.threeOfAKind = threeOfAKind;
	}

	/**
	 * @param straight
	 */
	private void setStraight(int straight) {
		System.out.println(straight);
		this.straight = straight;
	}

	/**
	 * @param flush
	 */
	private void setFlush(int flush) {
		this.flush = flush;
	}

	/**
	 * @param fullHouse
	 */
	private void setFullHouse(int fullHouse) {
		this.fullHouse = fullHouse;
	}

	/**
	 * @param fullHouseSameColor
	 */
	private void setFullHouseSameColor(int fullHouseSameColor) {
		this.fullHouseSameColor = fullHouseSameColor;
	}

	/**
	 * @param fourOfAKind
	 */
	private void setFourOfAKind(int fourOfAKind) {
		this.fourOfAKind = fourOfAKind;
	}

	/**
	 * @param yarborough
	 */
	private void setYarborough(int yarborough) {
		this.yarborough = yarborough;
	}

	/**
	 * @param kismet
	 */
	private void setKismet(int kismet) {
		this.kismet = kismet;
	}

	/**
	 * @param bonus
	 */
	private void setBonus(int bonus) {
		this.bonus = bonus;
	}
	
	/**
	 * @return the total score
	 */
	public int calculateScore(){
		int firstSection = getAces() + 
						   getDeuces() + 
						   getTreys() + 
						   getFours() + 
						   getFives() + 
						   getSixes();
		
		int secondSection = getTwoPair() + 
							getThreeOfAKind() + 
							getStraight() + 
							getFlush() +
							getFullHouse() +
							getFullHouseSameColor() +
							getFourOfAKind() +
							getYarborough() +
							getKismet();
		
		if(firstSection > 77){
			setBonus(75);
		} else if (firstSection > 70) {
			setBonus(55);
		} else if (firstSection > 62) {
			setBonus(35);
		} else {
			setBonus(0);
		}
		
		return firstSection + getBonus() + secondSection;
	}
	
	/**
	 * @param type What kind of score.
	 * @param value The value.
	 * @throws TypeAlreadyPlayedException if you've already played this one.
	 */
	public void score(ScoreType type, int value) throws TypeAlreadyPlayedException{
		switch(type){
		case ACES:
			if(aces < 0){
				setAces(value);
			} else {
				throw new TypeAlreadyPlayedException("You've already played aces");
			}
				
			break;
		case DEUCES:
			if(deuces < 0){
				setDeuces(value);
			} else {
				throw new TypeAlreadyPlayedException("You've already played deuces");
			}
			
			break;
		case FIVES:
			if(fives < 0){
				setFives(value);
			} else {
				throw new TypeAlreadyPlayedException("You've already played fives");
			}
			break;
		case FLUSH:
			if(flush < 0){
			setFlush(value);
		} else {
			throw new TypeAlreadyPlayedException("You've already played flush");
		}
			break;
		case FOUROFAKIND:
			if(fourOfAKind < 0){
				setFourOfAKind(value);
			} else {
				throw new TypeAlreadyPlayedException("You've already played 4 of a kind");
			}
			break;
		case FOURS:
			if(fours < 0){
				setFours(value);
			} else {
				throw new TypeAlreadyPlayedException("You've already played fours");
			}
			break;
		case FULLHOUSE:
			if(fullHouse < 0){
				setFullHouse(value);
			} else {
				throw new TypeAlreadyPlayedException("You've already played fullhouse");
			}
			break;
		case FULLHOUSESAMECOLOR:
			if(fullHouseSameColor < 0){
				setFullHouseSameColor(value);
			} else {
				throw new TypeAlreadyPlayedException("You've already played fullhouse-same color");
			}
			break;
		case KISMET:
			if(kismet < 0){
				setKismet(value);
			} else {
				throw new TypeAlreadyPlayedException("You've already played kismet");
			}
			break;
		case SIXES:
			if(sixes < 0){
				setSixes(value);
			} else {
				throw new TypeAlreadyPlayedException("You've already played sixes");
			}
			break;
		case STRAIGHT:
			if(straight < 0){
				setStraight(value);
			} else {
				throw new TypeAlreadyPlayedException("You've already played a straight");
			}
			break;
		case THREEOFAKIND:
			if(threeOfAKind < 0){
				setThreeOfAKind(value);
			} else {
				throw new TypeAlreadyPlayedException("You've already played 3 of a kind");
			}
			break;
		case TREYS:
			if(treys < 0){
				setTreys(value);
			} else {
				throw new TypeAlreadyPlayedException("You've already played treys");
			}
			break;
		case TWOPAIR:
			if(twoPair < 0){
				setTwoPair(value);
			} else {
				throw new TypeAlreadyPlayedException("You've already played two pair");
			}
			break;
		case YARBOROUGH:
			if(yarborough < 0){
				setYarborough(value);
			} else {
				throw new TypeAlreadyPlayedException("You've already played yarborough");
			}
			break;
		default:
			throw new TypeAlreadyPlayedException("You picked an invalid type... somehow.  Way to go, genius.");
		}
	}
	
}
