package com.codeclan.sandy;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ThrowTest {

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
    public void testThrowNegativeValusIsNotValid()
    {
    	Throw t = new Throw(-10);
    	assertFalse(t.isValid());
    }
}
