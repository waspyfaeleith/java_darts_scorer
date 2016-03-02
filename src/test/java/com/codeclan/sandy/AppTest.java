package com.codeclan.sandy;

import org.junit.Test;
import static org.junit.Assert.*;


public class AppTest {

	@Test
	public void testGame()
	{
       Game g = new Game();
			
	   assertEquals(501, g.startScore);
	}
	
	@Test
	public void testGamePlayersSet()
	{
		Game g = new Game();
		Player p1 = new Player("Fred", g.startScore);
		Player p2 = new Player("Barney", g.startScore);
		g.player1 = p1;
		g.player2 = p1;
		
		assertEquals(501, g.startScore);
		assertEquals(g.startScore, p1.currentScore);
		assertEquals(g.startScore, p2.currentScore);
	}
	
	@Test
    public void testPlayerSet() {
    	Player p = new Player("Fred", 501);
    	assertEquals("Fred", p.name);
    	assertEquals(501, p.currentScore);
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
		//p.currentScore = 40;
		assertTrue(p.isBust(t));
	}
    
	@Test
	public void testPlayerThrowsBustScoreLeavesOne() {
		Player p = new Player("Fred", 100);
		Throw t = new Throw(99);
		//p.currentScore = 100;
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
		//p.currentScore = 100;
		Throw t = new Throw(45);
		assertFalse(p.isWinningScore(t));
	}
	
	
	@Test
	public void testPlayerThrowsBustScoreDoesNotChange() {
		Player p = new Player("Fred", 40);
		Throw t = new Throw(65);
		//p.currentScore = 40;
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
		//p.currentScore = 158;
		assertTrue(p.isOnAFinish());
    }
    
    @Test
    public void test138IsAFinish()
    {
    	Player p = new Player("Fred", 138);
		//p.currentScore = 138;
		assertTrue(p.isOnAFinish());
    }
    
    @Test
    public void test159IsNotAFinish()
    {
    	Player p = new Player("Fred", 159);
		//p.currentScore = 159;
		assertFalse(p.isOnAFinish());
    }
    
    @Test
    public void test162IsNotAFinish()
    {
    	Player p = new Player("Fred", 162);
		//p.currentScore = 162;
		assertFalse(p.isOnAFinish());
    }
    
}