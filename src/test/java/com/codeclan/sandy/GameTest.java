package com.codeclan.sandy;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

public class GameTest {
	Game game;
	Player player1;
	Player player2;
	
	@Before
	public void initialize() {
		player1 = new Player("Jack", 501);
		player2 = new Player("Victor", 501);
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(player1);
		players.add(player2);
		
		game = new Game(501, players, 3, 5);
	}
	
	@Test
	public void test_game_start_score_is_set() {
		assertEquals(501, game.startScore);
	}
	
	@Test
	public void test_game_thrower_player_1() {
		assertEquals(player1, game.thrower);
	}
	
	@Test
	public void test_switch_thrower_to_player2() {
		game.changeThrower();
		assertEquals(player2, game.thrower);
	}
	
	@Test
	public void test_game_won_is_false() {
		assertEquals(false, game.gameWon());
	}
	
	@Test
	public void test_game_won_is_true() {
		game.player1.currentScore = 0;
		assertEquals(true, game.gameWon());
	}	
}
