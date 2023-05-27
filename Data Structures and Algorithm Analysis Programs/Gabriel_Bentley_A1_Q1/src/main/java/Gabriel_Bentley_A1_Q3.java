// The program for assignment 1 question 3 involves requesting a number n from the
// user and then outputing n + nn + nnn + nnnn = total to the consoul. note this 
// only works with single digit numbers entered

import java.util.*;

public class Gabriel_Bentley_A1_Q3 {
    
    public static void main(String[] args){
        
        System.out.println("Input number"); // request user input for number n
        
        Scanner input = new Scanner(System.in); 
        
        int num1 = input.nextInt(); // read in number n from consoul
                
        // calculate the values of all numbers to be added and their total
        int num2 = num1 * 10 + num1;
        int num3 = num2 * 10 + num1;
        int num4 = num3 * 10 + num1;
        int total = num1 + num2 + num3+ num4;
        
        // output the results of the calculations to the consoul
        System.out.println(num1 + " + " + num2 + " + " + num3 + " + " 
                            + num4 + " = " + total);
    }
    
}
