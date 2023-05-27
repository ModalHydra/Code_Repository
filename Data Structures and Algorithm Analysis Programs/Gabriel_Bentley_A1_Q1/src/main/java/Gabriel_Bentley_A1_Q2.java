// assignment 1 question 2 for CS 2336 involves requesting a number n from the
// user and then outputting the number on n rows repeating the number of times
// n is outputted on a row equal to the row number.
// Ex: input number: 4
// 4
// 44
// 444
// 4444

import java.util.*;

public class Gabriel_Bentley_A1_Q2 {
    
    public static void main(String[] args)
    {
        System.out.println("Please enter a Number"); // request number n from user
        
        Scanner input = new Scanner(System.in);
        
        int num = input.nextInt(); // read in the number entered from the consoul
        
        System.out.println(); // output a newline for formatting
        
        for(int i = 0; i < num; i++) // the loop for number of rows
        {
            for(int k = 0; k <= i; k++) // loop for number of outputs per row
            {
                System.out.print(num);
            }
            
            System.out.println(); // start a new row
        }
    }
    
}
