// Assignment 1 question 4 for CS 2336 calls for a program that takes requests
// the user to enter various distances swimmer Diana Nyad has swam over 5
// different years and the times it took her to swim them.
// After reading in all the inputs from the user the program will output
// a formatted table containing the distance, hours taken, and her speed in mph
// lastly the program will output the average speed for the five years.

import java.util.*;


public class Gabriel_Bentley_A1_Q4 {
    
    public static void main(String[] args){
        
        Scanner input = new Scanner(System.in);
        
        // ask for and read in the data for the 5 different swimming years
        System.out.format("Enter the distance Diana Nyad swam in 1974:%n");  
        int first_distance = input.nextInt();

        System.out.format("How many hours did it take Nyad to swim the distance?%n");
        int first_hours = input.nextInt();
        
        double first_speed = (1.0 * first_distance)/first_hours; // calculate swim speed
       
        System.out.format("Enter the distance Diana Nyad swam in 1975:%n");  
        int second_distance = input.nextInt();

        System.out.format("How many hours did it take Nyad to swim the distance?%n");
        int second_hours = input.nextInt();
        
        double second_speed = (1.0 * second_distance)/second_hours; // calculate swim speed
        
        System.out.format("Enter the distance Diana Nyad swam in 1978:%n");  
        int third_distance = input.nextInt();

        System.out.format("How many hours did it take Nyad to swim the distance?%n");
        int third_hours = input.nextInt();
        
        double third_speed = (1.0 * third_distance)/third_hours; // calculate swim speed
        
        System.out.format("Enter the distance Diana Nyad swam in 1979:%n");  
        int fourth_distance = input.nextInt();

        System.out.format("How many hours did it take Nyad to swim the distance?%n");
        int fourth_hours = input.nextInt();
        
        double fourth_speed = (1.0 * fourth_distance)/fourth_hours; // calculate swim speed

        System.out.format("Enter the distance Diana Nyad swam in 2013:%n");  
        int fifth_distance = input.nextInt();

        System.out.format("How many hours did it take Nyad to swim the distance?%n");
        int fifth_hours = input.nextInt();
        System.out.format("%n");
        
        double fifth_speed = (1.0 * fifth_distance)/fifth_hours; // calculate swim speed
        
        // output the table header
        System.out.format("+-------------------------------------------------------------------+%n");
        System.out.format("| Year   | Distance (miles) | Time (hours) | Speed (miles/hour)     |%n");
        System.out.format("+-------------------------------------------------------------------+%n");
        
        // output the rows of the table
        System.out.print("  1974   | " + first_distance + " miles         |");
        System.out.println(" " + first_hours + " hours      | " + first_speed);
        
        System.out.print("  1975   | " + second_distance + " miles         |");
        System.out.println(" " + second_hours + " hours      | " + second_speed);
        
        System.out.print("  1978   | " + third_distance + " miles         |");
        System.out.println(" " + third_hours + " hours     | " + third_speed);
        
        System.out.print("  1979   | " + fourth_distance + " miles        |");
        System.out.println(" " + fourth_hours + " hours     | " + fourth_speed);
        
        System.out.print("  2013   | " + fifth_distance + " miles        |");
        System.out.println(" " + fifth_hours + " hours     | " + fifth_speed);
        
        // calculate the average speed of Nyad
        double average_speed = (first_speed + second_speed + third_speed + fourth_speed + fifth_speed)/5.0;
        
        System.out.println();
        
        // output the average speed of Nyad
        System.out.println("Diana Nyad's average speed is: " + average_speed+ " miles/hour.");
    }
    
}
