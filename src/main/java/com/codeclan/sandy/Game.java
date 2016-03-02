package com.codeclan.sandy;

import java.util.Scanner;

public class Game {
	Player player1;
	Player player2;
	Player thrower;
	Player winner;
	int startScore;
	private Scanner in;
	String input;
	
	public Game() {
    	this.startScore = 501;
    	in = new Scanner(System.in);
    }
	
    public Game(Player player1, Player player2) {
    	this.startScore = 501;
        this.player1 = player1;
    	this.player2 = player2;
    	this.thrower = player1;
    	this.winner = null;
    }
    
    
    private void changeThrower()
    {
    	if (this.thrower == this.player1) {
    		this.thrower = this.player2;
    	} else {
    		this.thrower = this.player1;
    	}
    }
    
    private void getPlayerScore()
    {
    	if (thrower.isOnAFinish())
    	{
    		System.out.println(this.thrower.name + ", you require " + this.thrower.currentScore);
    	}
    	System.out.println("\n\nEnter " + this.thrower.name + "'s score: ");
        input = in.nextLine();
        Throw t = new Throw(Integer.parseInt(input));
        
        while (!t.isValid()) {
        	System.out.println("Invalid Score - enter " + this.thrower.name + "'s score: ");
        	input = in.nextLine();
        	t.score = Integer.parseInt(input);   	
        }
        
        this.thrower.throwDarts(t);
        if (this.thrower.currentScore == 0)
        	this.winner = this.thrower;
        this.printScoreboard();
        this.changeThrower();
    }
    
    private void start()
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
    
    private void printScoreboard()
    {
    	this.clearScreen();
        System.out.println("\n\t\t" + this.startScore);
        System.out.println("\n\t" + this.player1.name+ "\t  | \t" + this.player2.name);
        System.out.println("----------------------------------");
        int i;
        for (i = 0; i < player2.scores.size(); i++)
        {
        	System.out.println("\t" + (this.player1.scores.size() >= i ? this.player1.scores.get(i) : "  " ) + "\t| \t" + (this.player2.scores.size() >= i ? this.player2.scores.get(i) : " '"));
        }
        if (thrower == player1 && player1.scores.size() > i && player1.scores.size() > 0) {
          System.out.println("\t" + this.player1.scores.get(i) + "\t| \t");	
        }
    }
    
    public void play()
    {
    	this.start();
    	this.printScoreboard();
    	
    	do {
    		this.getPlayerScore();
    		//this.printScoreboard();
    	} while (this.winner == null);
    	
    	System.out.println("Game shot, and the leg, to " + this.winner.name);
    }
}
