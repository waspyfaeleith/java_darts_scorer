package com.codeclan.sandy;

import java.util.Scanner;

public class Viewer {
	private Scanner in;
	String input;
	
	public Viewer() {
		in = new Scanner(System.in);
	}
	
	public int getScore(Player player) {
		System.out.println("\n\nEnter " + player.name + "'s score: ");
        input = in.nextLine();
        int score = Integer.parseInt(input);
        return score;
	}
	
	public int getScoreAfterInvalidInput(Player player) {
		System.out.println("\n\nInvalid input - enter " + player.name + "'s score: ");
        input = in.nextLine();
        int score = Integer.parseInt(input);
        return score;
	}
	
	public int getStartScore() {
		System.out.println("\n\nEnter start score: ");
        input = in.nextLine();
        int startScore = Integer.parseInt(input);
        return startScore;
	}
	
	public String getPlayerName(int number) {
		System.out.println("\n\nEnter player " + number + "'s name: ");
        input = in.nextLine();
        return input;
	}
	
	public int bestOf(String setsOrLegs)
	{
		int bestOf = 0;
		while ((bestOf %2) == 0) {
			System.out.println("\n\nHow many " + setsOrLegs + " ?(must be an odd number): ");
        	input = in.nextLine();
        	bestOf = Integer.parseInt(input);
		}
        return bestOf;
	}
	
	private int scoreBoardLength(Game game)
    {
    	if (game.player1.scores.size() > game.player2.scores.size())
    	{
          return game.player1.scores.size();
    	} else {
    	  return game.player2.scores.size();
    	}
    }
	
	private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
	
	public void printScoreboard(Game game)
    {
    	this.clearScreen(); 
        System.out.println("\n\t\t" + game.player1.setsWon + "  Sets  " + game.player2.setsWon);
        System.out.println("\n\t\t" + game.player1.legsWon + "  Legs  " + game.player2.legsWon);
        System.out.println("\n\t\t" + game.startScore);
        System.out.println("\n\t" + game.player1.name + "\t | \t" + game.player2.name);
        System.out.println("----------------------------------");
        
        for (int i = 0; i < this.scoreBoardLength(game); i++)
        {
          System.out.println("\t" + (game.player1.scores.size() > i ? game.player1.scores.get(i) : " " ) + "\t | \t" + (game.player2.scores.size() > i ? game.player2.scores.get(i) : " "));
        }
    }
	
	public void playerOnAFinish(Player player) {
		if (player.isOnAFinish()) {
    		System.out.println("\n\n" + player.name + ", you require " + player.currentScore);
    	}
	}
	
	public void playerIsBust(Player player, Throw playerThrow) {
		if (player.isBust(playerThrow)) {
			System.out.println("BUST!!");
		}
	}
	
	public void printWinner(String name, String gameType) {
		System.out.println("\n\n" + "Game shot, and the " + gameType + ", to " + name);
	}
}
