package com.gabriel;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void correctMathSolution1()
    {
        MathMan gabriel = new MathMan(120, "Gabriel");
        MathExpression easy = new MathExpression("2 + 2.5");
        MathExpression medium = new MathExpression("5 * 5 + 16 - 41");
        MathExpression hard = new MathExpression("34 * 60.6 + 883 / 5 + 92 * 2");
        
        assertEquals(4.5,gabriel.solveExpression(easy),0);
        assertEquals(0,gabriel.solveExpression(medium),0);
        assertEquals(2421.0,gabriel.solveExpression(hard),0);
    }

    @Test 
    public void checkExpressionValidity(){
        MathExpression test = new MathExpression("5 + 5");

        assertTrue(test.validExpression());
        assertFalse(test.validExpression("+ 5 + 5"));
        assertFalse(test.validExpression("5 + 5 = 10"));
        assertFalse(test.validExpression("5 + 5."));
        assertFalse(test.validExpression("5 + .5"));
        assertFalse(test.validExpression("5 + + 5"));
    }

    @Test
    public void correctDifficulty(){
        MathExpression easy = new MathExpression("2 + 2.5");
        MathExpression medium = new MathExpression("5 * 5 + 16 - 41");
        MathExpression hard = new MathExpression("34 * 60.6 + 883 / 5 + 92 * 2");

        assertEquals(20, easy.getDifficulty());
        assertEquals(50, medium.getDifficulty());
        assertEquals(105, hard.getDifficulty());
    }

    @Test
    public void smartEnough(){
        MathMan gabriel = new MathMan(120, "Gabriel");
        MathExpression problem = new MathExpression("34 * 60.6 + 883 / 5 + 92 * 2");
        assertTrue( gabriel.canSolve(problem) );
        problem.setExpression("5 * 5 + 16 - 41");
        assertTrue(gabriel.canSolve(problem));
        gabriel.setIntelligence(20);
        problem.setExpression("2 + 2.5");
        assertTrue(gabriel.canSolve(problem));
    }
    
    @Test
    public void notSmartEnough()
    {
        MathMan gabriel = new MathMan(0, "Gabriel");
        MathExpression problem = new MathExpression("34 * 60.6 + 883 / 5 + 92 * 2");
        assertFalse( gabriel.canSolve(problem) );
        problem.setExpression("5 * 5 + 16 - 41");
        assertFalse(gabriel.canSolve(problem));
        gabriel.setIntelligence(19);
        problem.setExpression("2 + 2.5");
        assertFalse(gabriel.canSolve(problem));
    }
}
