package com.codeclan.sandy;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

public class MatchTest {
	
	Match match;
	
	@Before
	public void initialize() {
		
		match = new Match("Tam", "Winston", 7, 5, 301);
	}
	
	@Test
	public void test_sets_needed_to_win() {
		assertEquals(4, match.setsNeededToWinMatch());
	}
	
	@Test
	public void test_legs_needed_to_win_set() {
		assertEquals(3, match.legsNeededToWinSet());
	}

	@Test
	public void test_set_won() {
		match.game.player1.legsWon = 3;
		match.game.player2.setsWon = 0;
		match.game.player2.currentScore = 0;
		
		assertEquals(true, match.setWon());
	}
}
