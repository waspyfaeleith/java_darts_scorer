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
    
    /*private void getPlayerScore()
    {
    	if (thrower.isOnAFinish())
    	{
    		System.out.println("\n\n" + this.thrower.name + ", you require " + this.thrower.currentScore);
    	}
    	System.out.println("\n\nEnter " + this.thrower.name + "'s score: ");
        input = in.nextLine();
        Throw t = new Throw(Integer.parseInt(input));
        
        while (!t.isValid()) {
        	System.out.println("\nInvalid Score - enter " + this.thrower.name + "'s score: ");
        	input = in.nextLine();
        	t.score = Integer.parseInt(input);   	
        }
        
        this.thrower.throwDarts(t);
        if (this.thrower.currentScore == 0)
        	this.winner = this.thrower;
        this.printScoreboard();
        this.changeThrower();
    }*/
    
    /*private void start()
    {	
    	System.out.println("Enter player 1 name: ");
        input = in.nextLine();
        player1 = new Player(input, this.startScore);
        System.out.println("Enter player 2 name: ");
        input = in.nextLine();
        player2 = new Player(input, this.startScore);
        this.thrower = player1;
    }
    
    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    
    private int scoreBoardLength()
    {
    	if (player1.scores.size() > player2.scores.size())
    	{
          return player1.scores.size();
    	} else {
    	  return player2.scores.size();
    	}
    }*/
    
    /*private void printScoreboard()
    {
    	this.clearScreen();
        System.out.println("\n\t\t" + this.startScore);
        System.out.println("\n\t" + this.player1.name+ "\t | \t" + this.player2.name);
        System.out.println("----------------------------------");
        
        for (int i = 0; i < this.scoreBoardLength(); i++)
        {
          System.out.println("\t" + (this.player1.scores.size() > i ? this.player1.scores.get(i) : " " ) + "\t | \t" + (this.player2.scores.size() > i ? this.player2.scores.get(i) : " "));
        }
    }*/
    
    /*public void play()
    {
    	this.start();
    	this.printScoreboard();
    	
    	do {
    		this.getPlayerScore();
    		//this.printScoreboard();
    	} while (this.winner == null);
    	
    	System.out.println("\nGame shot, and the leg, to " + this.winner.name);
    }*/
}
