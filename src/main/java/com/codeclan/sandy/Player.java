package com.codeclan.sandy;

import java.util.ArrayList;
import org.apache.commons.lang3.ArrayUtils;

public class Player {
	String name;	
	int currentScore;
	int legsWon;
	int setsWon;
	ArrayList<Integer> scores;
	
	public Player(String name, int startScore)
	{
		this.name = name;
		this.legsWon = 0;
		this.setsWon = 0;
		this.resetScores(startScore);
	}
	
	public void resetScores(int startScore)
	{ 
		this.currentScore = startScore;
		this.scores = new ArrayList<Integer>();
	}
	
	public void throwDarts(Throw t)
	{
		if (t.isValid() && !isBust(t)) {
			this.currentScore -= t.score;
			this.scores.add(this.currentScore);
		}
	}
	
	public boolean isBust(Throw t)
	{
		if ((t.score > this.currentScore) || ((this.currentScore - t.score) == 1)) {
			return true;
		}
		return false;
	}
	
	public boolean isOnAFinish()
	{
		int[] highFinishes  = { 170, 167, 164, 161, 160 };
		
		if ( ArrayUtils.contains( highFinishes, this.currentScore ) || (this.currentScore < 159)) {
		    return true;
		} else {
			return false;
		}
	}
	
	public boolean isWinningScore(Throw t) {
		if (t.score == this.currentScore) {
	     currentScore = 0;
		 return true;
	    }
		return false;
	}

}
