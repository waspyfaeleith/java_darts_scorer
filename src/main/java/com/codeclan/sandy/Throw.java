package com.codeclan.sandy;

import org.apache.commons.lang3.ArrayUtils;

public class Throw {
	int score;
	boolean isValid;
	 
	public Throw(int score)
	{
		this.score = score;
	}
		
	boolean isValid()
	{
		int[] validHighScores = { 180, 177, 174, 171, 170, 168, 167, 165, 164 };
		
		if ( ArrayUtils.contains( validHighScores, this.score ) || (this.score >= 0 && this.score < 163)) {
		    return true;
		} else {
			return false;
		}
	}
}
