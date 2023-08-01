package com.gabriel;

/**
 * The Math Problem project will involve two classes MathMan which is a object that will have
 * an intelligence value given to them and will attemt to solve the math question, and MathExpression
 * which is an object that will hold a given math expression and returns it's difficulty 
 * if the MathMan object has an intelligence greater than or equal to the given difficulty then it will 
 * sovle the expression and print out the answer if they don't have the intelligence then they will print
 * out a random number. If a person fails to solve a problem their intelligence increases by 2 if they solve
 * the problem their intelligence increases by 1.
 * 
 * An Expressions difficulty is directly proportional to the amount of operators in it and how big the numbers
 * in it are. every + or - in the expression adds 5 to the difficulty, every * adds 10 to the difficulty, and 
 * every / adds 15 to the difficulty. the amount of difficulty a number adds is equal to 5 * the number of
 * digits in the number.
 * 
 * There are sure to be better ways to calculate difficulty of a math problem but this is the formula
 * for this challenge.
 * 
 * There will be no expressions with negative numbers and no paretheses either
 * 
 * There will be
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}
