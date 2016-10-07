package com.codeclan.sandy;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PlayerTest {
	
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
		assertEquals(40,p.currentScore);
	}
  
    @Test
    public void test164IsAFinish()
    {
    	Player p = new Player("Fred", 164);
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
