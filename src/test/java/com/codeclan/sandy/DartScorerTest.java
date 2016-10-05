package com.codeclan.sandy;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;


public class DartScorerTest {

	Game game;
	
	@Before
	public void initialize() {
		int startScore = 501;
		int sets = 3;
		int legsPerSet = 5;
		Player p1 = new Player("Fred", startScore);
		Player p2 = new Player("Barney", startScore);
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(p1);
		players.add(p2);

		game = new Game(startScore, players, sets, legsPerSet);
	}
	
	@Test
	public void testGame()
	{
	   assertEquals(501, game.startScore);
	}
	
	@Test
	public void testGamePlayersSet()
	{
		
		
		assertEquals(501, game.startScore);
		assertEquals(game.startScore, game.player1.currentScore);
		assertEquals(game.startScore, game.player2.currentScore);
	}
	
	@Test
    public void testPlayerSet() {
    	Player p = new Player("Fred", 501);
    	assertEquals("Fred", p.name);
    	assertEquals(501, p.currentScore);
    }
	
	@Test
    public void testPlayerSetLegsScoreIsZero() {
    	Player p = new Player("Fred", 501);
    	assertEquals("Fred", p.name);
    	assertEquals(0, p.legsWon);
    }
	
	@Test
    public void testPlayerSetSetsScoreIsZero() {
    	Player p = new Player("Fred", 501);
    	assertEquals("Fred", p.name);
    	assertEquals(0, p.setsWon);
    }
	
	@Test
	public void testPlayerThrowGetsNewCurrentScore() {
		Player p = new Player("Fred", 140);
		//p.currentScore = 140;
		Throw t = new Throw(100);
		p.throwDarts(t);
		assertEquals(40, p.currentScore);
	}
	
	@Test
	public void testPlayerThrowsBustScoreGreaterThanCurrentScore() {
		Player p = new Player("Fred", 40);
		Throw t = new Throw(41);
		assertTrue(p.isBust(t));
	}
    
	@Test
	public void testPlayerThrowsBustScoreLeavesOne() {
		Player p = new Player("Fred", 100);
		Throw t = new Throw(99);
		assertTrue(p.isBust(t));
	}
	
	
	@Test
	public void testPlayerThrowsWinningScore() {
		Player p = new Player("Phil", 100);
		p.currentScore = 100;
		Throw t = new Throw(100);
		assertTrue(p.isWinningScore(t));
		assertEquals(0,p.currentScore);
	}
	
	@Test
	public void testPlayerDoesNotThrowWinningScore() {
		Player p = new Player("Phil", 100);
		Throw t = new Throw(45);
		assertFalse(p.isWinningScore(t));
	}
	
	
	@Test
	public void testPlayerThrowsBustScoreDoesNotChange() {
		Player p = new Player("Fred", 40);
		Throw t = new Throw(65);
		p.throwDarts(t);
		//assertTrue(p.isBust(t));
		assertEquals(40,p.currentScore);
	}
	
    @Test
    public void testScore() {
    	Throw t = new Throw(180);
    	assertEquals(180,t.score);
    }
    
    @Test
    public void testThrow181IsNotScore()
    {
    	Throw t = new Throw(181);
    	assertFalse(t.isValid());
    }
    
    @Test
    public void testThrow163IsNotValidScore()
    {
    	Throw t = new Throw(163);
    	assertFalse(t.isValid());
    }
    
    @Test
    public void testThrow164IsValidScore()
    {
    	Throw t = new Throw(164);
    	assertTrue(t.isValid());
    }
    
    @Test
    public void testThrow100IsValid()
    {
    	Throw t = new Throw(100);
    	assertTrue(t.isValid());
    }
    
    @Test
    public void testThrowZeroIsValid()
    {
    	Throw t = new Throw(0);
    	assertTrue(t.isValid());
    }
    
    @Test
    public void test164IsAFinish()
    {
    	Player p = new Player("Fred", 164);
		//p.currentScore = 164;
		assertTrue(p.isOnAFinish());
    }
    
    @Test
    public void test158IsAFinish()
    {
    	Player p = new Player("Fred", 158);
		assertTrue(p.isOnAFinish());
    }
    
    @Test
    public void test138IsAFinish()
    {
    	Player p = new Player("Fred", 138);
		assertTrue(p.isOnAFinish());
    }
    
    @Test
    public void test159IsNotAFinish()
    {
    	Player p = new Player("Fred", 159);
		assertFalse(p.isOnAFinish());
    }
    
    @Test
    public void test162IsNotAFinish()
    {
    	Player p = new Player("Fred", 162);
		assertFalse(p.isOnAFinish());
    }
    
}