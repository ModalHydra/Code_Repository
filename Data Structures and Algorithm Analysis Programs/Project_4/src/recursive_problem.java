//File Name: recursive_problem.java
//File Author: Gabriel Bentley
//Date: October 13th, 2020
//Editor: Eclipse IDE
/*Program Purpose: The purpose of the recursive_problem Program is to 
 * have recursive boolean method called solvable that can, determine
 * if an array of positive integers with a zero at the end is able to 
 * be solved by moving from a starting position to the end of the array
 * only by moving spaces equal to the elements value  
 */

import java.util.*;



public class recursive_problem {

	/* Solvable method takes in the starting position in the array, and
	 * an integer array which the method recursively finds if it is
	 * solvable 
	 */
	
	static boolean solvable (int start, int [] squares)
	{
		// variables for the method
		int right = -1;
		int left = -1;
	 	int value = squares[start];
		int rightStart = start + value;
		int leftStart = start - value;
		boolean moveRight = true;
		boolean moveLeft = true;
		boolean solve = true;
		

		// determine if moving right goes outside array bounds
		if(rightStart > squares.length-1)
		{
			moveRight = false;
		}
		else // if moving right is within bounds find right value
		{
			right = squares[rightStart];
		}

		// determine if moving left goes outside array bounds
		if(leftStart < 0)
		{
			moveLeft = false;
		}
		else// if moving left is within bounds find left value
		{
			left = squares [leftStart];
		}
		
		// determine if moving right leads to a previously visited space 
		if(left == -1) {
			moveLeft = false;
		}
		//determine if moving left leads to a previously visited space
		if(right == -1) {
			moveRight = false;
		}
		
		// base case for if the array is solvable
		if(value == 0)
		{
			return true;
		}
		// if able to move right call the solvable function with rightStart
		if(moveRight)
		{
			// make the space marked as visited
			squares[start] = -1;
			
			// recursive call
			solve = solvable(rightStart, squares);
			
			//unmark the space returning it to is original value
			squares[start] = value;
			return solve;
		}
		// if able to move left call the solvable method with left start
		else if (moveLeft)
		{
			// make the space marked as visited
			squares[start] = -1;
			
			// recursive call
			solve = solvable(leftStart, squares);
			
			//unmark the space returning it to is original value
			squares[start] = value;
			return solve;
		}
		else // the method is unable to move right or left
		{
			return false;
		}
	}

	//calls the solvable method and contains the array to be tested
	public static void main(String[] args) {
		
		// array for solvable method
		int[] array = {3,6,4,3,0};
		
		//print out the result of if the array is solvable
		System.out.println(solvable(0, array));
		
		
		
		
		

	}

}
