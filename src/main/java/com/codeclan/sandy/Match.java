package com.codeclan.sandy;

import java.util.ArrayList;

public class Match {
	int sets;
	int legsPerSet;
	int startScore;
	ArrayList<Player> players;
	Player setThrower;
	Player legThrower;
	Game game;
	Viewer viewer;
	
	public Match(String player1Name, String player2Name, int sets, int legsPerSet, int startScore) {
		Player player1 = new Player(player1Name, startScore);
		Player player2 = new Player(player2Name, startScore);
		this.sets = sets;
		this.legsPerSet = legsPerSet;
		this.startScore = startScore;
		this.players = new ArrayList<Player>();
		this.players.add(player1);
		this.players.add(player2);
		
		this.game = new Game(startScore, players, sets, legsPerSet);
		
		this.setThrower = player1;
		this.legThrower = player1;
		
		this.viewer = new Viewer();
	}
	
	public int setsNeededToWinMatch() {
		return (this.sets / 2) + 1; 
	}
	
	public int legsNeededToWinSet() {
		return (this.legsPerSet / 2) + 1;
	}
	
	public boolean setWon() {
		if ((game.player1.legsWon == legsNeededToWinSet()) ||
				(game.player2.legsWon == legsNeededToWinSet())) {
			game.winner().setsWon++;
			return true;
		}	
		return false;
	}
	
	public boolean matchWon() {
		return ((game.player1.setsWon == setsNeededToWinMatch()) ||
				(game.player2.setsWon == setsNeededToWinMatch()));
	}
	
	private void newSet() {
		game.player1.legsWon = 0;
		game.player2.legsWon = 0;
		newGame();
		game.thrower = switchThrower(setThrower);
		this.setThrower = game.thrower;	
	}
	
	private void newGame() {
		game.player1.resetScores(this.startScore);
		game.player2.resetScores(this.startScore);
		game = new Game(startScore, players,sets, legsPerSet);
	}
	
	public void newLeg() {
		this.newGame();
		game.thrower = switchThrower(legThrower);
		legThrower = game.thrower;
	}
	
	private void legWon() {
		game.winner().legsWon++;
		if (setWon()) {
			if (matchWon()) {
				displayWinner("match");
				return;
			} else {
				displayWinner("set");
				newSet();
			}
		} else {
			displayWinner("leg");
			newLeg();
		}
	}
	
	private void turn(Player player) {
		
		this.viewer.playerOnAFinish(player);
		

		int playerThrowScore = viewer.getScore(player);
		Throw playerThrow = new Throw(playerThrowScore);
		
		this.viewer.playerIsBust(player, playerThrow);
		
		player.throwDarts(playerThrow);		
	}
  
   	public void play() {
   		viewer.printScoreboard(game);
    	while (matchWon() == false) {
    		playLeg();
    		legWon();
    		viewer.printScoreboard(game);
    	}
    }
	
	private void playLeg() {
		while (!game.gameWon()) {
			this.turn(game.thrower);
			viewer.printScoreboard(game);
			this.game.changeThrower();
		}
	}
	
	private Player switchThrower(Player thrower) {
		if (thrower == game.player1) {
			thrower = game.player2;	
		} else {
			thrower = game.player1;
		}
		return thrower;
	}
	
	private void displayWinner(String gameWon) {
		String name = game.winner().name;
		viewer.printWinner(name, gameWon);		
	}	
}
