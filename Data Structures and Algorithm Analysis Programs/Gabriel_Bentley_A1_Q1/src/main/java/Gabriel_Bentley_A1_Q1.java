// Assignment 1 question 1 for CS 2336 involves outputting the american flag
// through the use of loops

import java.util.*;

public class Gabriel_Bentley_A1_Q1 {
    
    // function for printing out the stars for the flag, alternating each row
    public static void printStars(int row){
        
        for(int i = 0; i < 6; i++)
        {
            if(row %2 == 1) // stars for odd numbered rows
            {
                System.out.print("*");
                System.out.print(" ");
            }
            else // stars for even numbered rows
            {
                if(i < 5)
                {
                    System.out.print(" ");
                    System.out.print("*");
                }
                else // acount for the extra space in even numbered rows
                {
                    System.out.print("  ");
                }
            }
        }
    }
    
    // function for printing out the strips of the flag, printing out fewer = on
    // the rows that have stars. printStrips returns the row number for the flag
    public static int printStrips(int row)
    {
        if(row < 10) // 34 = length for the first 10 rows of the flag
        {
            for(int i = 0; i < 34; i++) // prints out the strip
            {
                System.out.print("=");
            }
        }
        else // 46 = length for the final rows of the flag
        {
            for(int i = 0; i < 46; i++)
            {
                System.out.print("=");
            }
        }
        
        System.out.println(); // signals end of the row
        
        row++; // incrament the row count 
        
        return row; // return the row count
    }
    
    public static void main(String[] args)
    {
        int row = 1;
        
        for(int i = 0; i < 14; i++) // loop for number of rows 
        {
            if(row < 10)
            {
                printStars(row); // call the printStars method for the first 9 rows
            }
            
            row = printStrips(row); // call the printStrips method and updates row count
        }
        
    }
}
