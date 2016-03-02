package com.codeclan.sandy;

import java.util.ArrayList;
import org.apache.commons.lang3.ArrayUtils;

public class Player {
	String name;	
	int currentScore;
	ArrayList<Integer> scores;
	
	public Player(String name, int startScore)
	{
		this.name = name;
		this.currentScore = startScore;
		this.scores = new ArrayList<Integer>();
	}
	
	public void throwDarts(Throw t)
	{
		/*if (t.isValid() && !isBust(t)) {
			this.currentScore -= t.score;
			this.scores.add(this.currentScore);
		}*/
		if (isBust(t))
		{
			t.score = 0;  // you score hee-haw if you're bust!
		}
		if (t.isValid()) {
		  this.currentScore -= t.score;
		  this.scores.add(this.currentScore);
	    }
	}
	
	public boolean isBust(Throw t)
	{
		if ((t.score > this.currentScore) || ((this.currentScore - t.score) == 1)) {
			System.out.println("BUST!!");
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
