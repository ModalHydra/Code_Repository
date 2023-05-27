//File Name: Assignment_2.java
//File Author: Gabriel Bentley
//Date: September 17th, 2020
//Program Purpose: The Purpose of Assignment_2 is to simulate a shopping
// experience where you can look through separate catalogs of books or
// DVDs, add them to your cart, and check out once your done shopping

import java.util.*;


public class Assignment_2 {
	
	// class for an item holds the item number, name, and price.
	// the class also has methods to get and set the values for it's variables
	// the class is abstract because no item object will be created
	// The need for a parent class in item is due to having an array that
	// can hold both child classes of item; DVD and book.
	
	static public abstract class item { 
		
		//private variables for the item class
		private int inventoryNum;
		private String name;
		private double price;
		
		//Default constructor for item class
		public item() {
			
		}
		
		//Argument constructor for item class
		public item(int i, String n, double p)
		{
			inventoryNum = i;
			name = n;
			price = p;
		}
		
		// list of getters and setter methods for the item class
		
		public int getNum(){
			return inventoryNum;
		}
		public void setNum(int n) {
			inventoryNum = n;
		}
		
		public String getName() {
			return name;
		}
		public void setName(String n) {
			name = n;
		}

		public double getPrice() {
			return price;
		}
		public void setPrice(double p) {
			price = p;
		}
		
	}
	
	//The book class is a child class of item class
	//book uses the argument constructor from the item class
	//and variables for book name, item number, and price
	static public class book extends item{
		
		public book(int i, String n, double p){
			super(i, n, p);
		}
	}
	
	//The dvd class is a child class of item class
	//dvd uses the argument constructor from the item class
	//and variables for dvd name, item number, and price
	static public class dvd extends item{
		
		public dvd(int i, String n, double p){
			super(i, n, p);
		}
	}
	
	//The displayMenu() method will take in no argument but will return the 
	//value that the user entered to select the menu option from the menu 
	//that is written to the console by the method
	static int displayMenu() {
				
		//outputs the menu to the console
		System.out.print("**Welcome to the Comet Books and DVDs Store**\n"
						+ "\n"
						+ "Choose from the following options:\n"
						+ "1 - Browse books inventory (price low to high)\n"
						+ "2 - Browse DVDs inventory (price low to high)\n"
						+ "3 – add a book to the cart\n"
						+ "4 – add a DVD to the cart\n"
						+ "5 - View cart\n"
						+ "6 - Checkout\n"
						+ "7 - Cancel Order\n"
						+ "9 - Exit store\n");
		
		//gets user input for menu choice
		Scanner input = new Scanner(System.in);
		int menuNum = input.nextInt();		
		
		return menuNum;
	}
	
	//The displayInventory method takes in an integer variable as an argument
	//the integer variable option determines if the user selected option 1
	//or option 2 on from displayedMenu. displayInventory outputs the stores
	//books, DVDs with their prices and inventory numbers to the console
	static void displayInventory(int option) {
		
		//option 1 is selected from the display menu
		if (option == 1)
		{
			System.out.println("Inventory Number    Books                  Prices\n"
								+ "-------------------------------------------------\n"
								+ "1                   Perl                   $25.00\n"
								+ "2                   Intro to Java          $45.99\n"
								+ "3                   C#                     $49.99\n"
								+ "4                   Intro to C             $89.99\n"
								+ "5                   Python                $100.00\n");
		}
		
		//option 2 is selected from the display menu
		else 
		{
			System.out.println("Inventory Number    DVDs                   Prices\n"
								+ "-------------------------------------------------\n"
								+ "6                   Dumbo                  $17.99\n"
								+ "7                   Snow WHite             $19.99\n"
								+ "8                   Bambi                  $21.99\n"
								+ "9                   Cinderella             $24.99\n"
								+ "10                  Frozen                 $24.99\n");
		}
	}
	
	//The getInventoryNumber method take in an integer argument option, and returns
	//Integer order, containing the items inventory number.
	static int getInventoryNumber(int option) {
		
		int order = 0;
		int valid = 0;
		
		//Option 3 was selected from the store menu
		if (option == 1)
		{
			do {
				valid = 1;
				
				//requests and receives an inventory number for a book
				System.out.println("Please enter the inventory number for the"
						+ " book you wish to purchase\n"
						+ "if you don't want to purchase a book enter -1 to"
						+ " return to the menu.");
				Scanner input = new Scanner(System.in);
				order = input.nextInt();	
				
				//The if statement checks to see if the user entered
				//a book inventory number
				if(order > 5 || order <= 0)
				{
					valid = 0;
					System.out.println("The input you have entered is invalid\n");
				}
				
			}while(valid == 0); //is used to repeat request after invalid input
		}
		
		//Option 4 was selected from the store menu
		else
		{
			do {
				valid = 1;
				
				//Request and receives an inventory number for a DVD
				System.out.println("Please enter the inventory number "
						+ "for the DVD you wish to purchase\n"
						+ "if you don't want to purchase a DVD enter"
						+ " -1 to return to the menu.");
				Scanner input = new Scanner(System.in);
				order = input.nextInt();	
				
				//The if statement validates if the user entered a DVD inventory number
				if(order > 10 || order <= 5)
				{
					valid = 0;
					System.out.println("The input you have entered is invalid\n");
				}
				
			}while(valid == 0);
		}
		
		return order;
	}
	
	//The addToCart method will take in an array of item objects
	//an integer for array space, and item inventory number as arguments
	//addToCart will return the integer value for the new
	//cartSpace for the item array
	static int addToCart(item[] c,int num, int cartSpace ) {
		
		//validates if the given item array c has any space
		if(cartSpace > 9) {
			num = 0;
		}
		
		//The switch statement decides what item is added to the cart
		//based on the inventory number given to the method.
		//-1 ends the method with no item added to the cart.
		//Adding an item to the cart causes the cartSpace integer to increment 
		switch(num) {
		
			case -1:
				break;
			case 1:
				c[cartSpace] = new book(1,"perl",25.00);
				cartSpace++;
				break;
			case 2:
				c[cartSpace] = new book(2,"Intro to Java",45.99);
				cartSpace++;
				break;
			case 3:
				c[cartSpace] = new book(3,"C#",49.99);
				cartSpace++;
				break;
			case 4:
				c[cartSpace] = new book(4,"Intro to C",89.34);
				cartSpace++;
				break;
			case 5:
				c[cartSpace] = new book(5,"Python",100.00);
				cartSpace++;
				break;
			case 6:
				c[cartSpace] = new dvd(6,"Dumbo",17.99);
				cartSpace++;
				break;
			case 7:
				c[cartSpace] = new dvd(7,"Snow White",19.99);
				cartSpace++;
				break;
			case 8:
				c[cartSpace] = new dvd(8,"Bambi",21.99);
				cartSpace++;
				break;
			case 9:
				c[cartSpace] = new dvd(9,"Cinderella",24.99);
				cartSpace++;
				break;
			case 10:
				c[cartSpace] = new dvd(10,"Frozen",24.99);
				cartSpace++;
				break;
			default:
				System.out.println("Your cart is full.");
				break;
		}
		
		return cartSpace;
	}
	
	//The getTotal method will take in an array of items 
	//and an integer for the cart space as arguments
	//the method will return the double for the total cost
	//of all items in the given array
	static double getTotal(item[] c, int cartSpace){
		
		double total = 0;
		
		//loop through all items in the array and accumulate the total
		for (int i = 0; i < cartSpace; i++)
		{
			total += c[i].getPrice();
		}
		
		return total;
	}
	
	//The displayCart method will take in an array of items
	//and an integer for the cart space as arguments
	//The method will display the items currently in the array along with
	//their total price tax included.
	//displayCart will call the getTotal method to find the total
	static void displayCart(item[] c, int cartSpace) {
	
		double tax = 1.0815;
		double total = getTotal(c,cartSpace) * tax;
		String output;
		
		//validates that the cart contains an item
		if(total != 0) {
			
			System.out.println("Items             Prices\n"
					 		 + "------------------------");
			
			//loops through the array outputting the names and prices of items
			for(int i = 0; i < cartSpace; i++)
			{
				//format for a price with only 4 digits. EX: 49.99
				if(c[i].getPrice() < 100) {
					output = String.format("%-18s$%.2f", c[i].getName(),c[i].getPrice());
					System.out.println(output);
				}
				//format for a price with 5 digits. EX: 100.00
				else {
					output = String.format("%-17s$%.2f", c[i].getName(),c[i].getPrice());
					System.out.println(output);
				}
			}
			
			System.out.println("------------------------");
			
			//format for total being 4 digits
			if(total < 100) {
				output = String.format("%-18s$%.2f", "Total + Tax",total);
				System.out.println(output);
			}
			//format for total being 5 digits
			else if(total < 1000) {
				output = String.format("%-17s$%.2f\n", "Total + Tax",total);
				System.out.println(output);
			}
			//format for total being 6 digits: EX 1000.00
			else {
				output = String.format("%-16s$%.2f\n", "Total + Tax",total);
				System.out.println(output);
			}
		}
		
		//output for when your cart is empty
		else
		{
			System.out.println("Your cart is empty\n");
		}
	}
	
	//The clearCart method will take an array of items
	//and an integer for cart space as arguments
	//clearCart will loop through all the items in the array
	//and set their value to null allowing java's garbage collection
	//to get ride of the objects.
	//The method will also reset the cartSpace integer and return the value
	static int clearCart(item[] c, int cartSpace) {
		
		//loop through cart
		for(int i = 0; i < cartSpace; i++)
		{
			c[i] = null; //empty cart slot
		}
		
		cartSpace = 0; //reset cart space
		
		return cartSpace;
	}
	
	//The checkOut method will take an array of items
	//and an integer for cart space as arguments
	//checkOut will return the integer value for cartSpace. 
	//The method will call the getTotal and clearCart methods
	//to show the user their total cost
	//and empty their cart for further purchases. 
	static int checkOut(item[] c, int cartSpace) {
		
		double total = getTotal(c,cartSpace) * 1.0815; // total including tax
		
		//outputting the total cost
		String output = String.format("Your total cost is : $%.2f\n",total);
		System.out.println(output);
		
		//clearing the item array c
		cartSpace = clearCart(c,cartSpace);
		
		return cartSpace;
	}
	
	//The main function will hold a loop that will persist until
	//option 9 is selected when the displayMenu method is called.
	//Main holds a switch that calls different methods
	//based on what value is given in the displayMenu method
	public static void main(String[] args) {
		
		int choice = 0;
		int exitStore = 0;
		int inventoryNum = 0;
		int cartSpace = 0;
		
		item[] cart = new item[10]; // create the cart to store bought items
		
		do
		{
		
			choice = displayMenu();
			
			switch(choice) {
			
				case 1://option 1 to view book items is selected
					displayInventory(1);
					break;
				case 2://option 2 to view DVD items is selected
					displayInventory(2);
					break;
				case 3://option 3 to add a book item to the cart is selected
					inventoryNum = getInventoryNumber(1);
					cartSpace = addToCart(cart, inventoryNum, cartSpace);
					break;
				case 4://option 4 to add a DVD item to the cart is selected
					inventoryNum =getInventoryNumber(2);
					cartSpace = addToCart(cart, inventoryNum, cartSpace);
					break;
				case 5://option 5 to view the items in the cart is selected
					displayCart(cart, cartSpace);
					break;
				case 6://option 6 to check out is selected
					cartSpace = checkOut(cart, cartSpace);
					break;
				case 7://option 7 to clear all items in the cart was selected
					cartSpace = clearCart(cart, cartSpace);
					break;
				case 9://option 9 to exit the store was selected
					exitStore = 1;
					break;
				default://an invalid value was entered in the displayMenu method
					System.out.println("This option is not acceptable");
					break;
			}
			
		}while(exitStore == 0);		//continues until option 9 is selected
	}
}
