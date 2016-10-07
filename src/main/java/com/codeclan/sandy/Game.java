package com.codeclan.sandy;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
	Player player1;
	Player player2;
	Player thrower;
	Player winner;
	int startScore;
	int sets;
	int legsPerSet;
	private Scanner in;
	String input;
	Viewer viewer;
	
	public Game(int startScore, ArrayList<Player> players, int sets, int legsPerSet) {
		viewer = new Viewer();
		this.startScore = startScore;
		this.sets = sets;
		this.legsPerSet = legsPerSet;
		this.player1 = players.get(0);
		this.player2 = players.get(1);
		thrower = player1;
		
    }
	
    public Game(Player player1, Player player2) {
    	this.startScore = 501;
        this.player1 = player1;
    	this.player2 = player2;
    	this.thrower = player1;
    	this.winner = null;
    }
        
    public void changeThrower()
    {
    	if (this.thrower == this.player1) {
    		this.thrower = this.player2;
    	} else {
    		this.thrower = this.player1;
    	}
    }
    
    public boolean gameWon() {
    	return ((player1.currentScore == 0) || (player2.currentScore == 0));
    }
    
    public Player winner() {
    	if (player1.currentScore == 0) {
    	      return player1;
    	} else if (player2.currentScore == 0) {
    	      return player2;
    	}
    	return null;
    }
}
