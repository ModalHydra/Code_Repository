//File Name: Huffman.java
//File Author: Gabriel Bentley
//Class: CS 2336.001 
//Date: October 26th, 2020
//Editor: Eclipse IDE
/*Program Purpose: 
 * The purpose of this program is to take in a string of text
 * and create a huffman tree using the characters of the text
 * as leafs and the frequency of each character as its weight.
 * The program will show the combination of each node for the 
 * huffman tree step by step and then display the huffman code 
 * for each of the unique characters in the text. finally
 * the program will rewrite the text in binary form using the 
 * huffman code and will compare the bit length of huffman code
 * to the bit length of ASCII code
 */

import java.util.*;

public class Huffman {
	
	
	// node class
	/*
	 * contains the character
	 * contains the nodes weight
	 * contains Huffman code of character
	 * pointer to parent
	 * pointer to left child
	 * pointer to right child
	 * 
	 * constructor
	 * 
	 * getter and setter methods
	 * 
	 * and a comparable interface overloading the
	 * compareTo method
	 */
	
	static public class node implements Comparable {
		
		private String value;
		private int weight;
		private String huffman;
		private node parent;
		private node left;
		private node right;
		
		public node(){
			value = "";
			weight = 1;
			huffman = "";
			left = null;
			right = null;
			parent = null;
		}
		
		public node(String v) {
			value = v;
			weight = 1;
			huffman = "";
			left = null;
			right = null;
			parent = null;
		}
		
		public node(int w, String v, node l, node r)
		{
			value = v;
			weight = w;
			huffman = "";
			left = l;
			right = r;
			parent = null;
		}
		
		public String getValue() {
			return value;
		}
		
		public int getWeight() {
			return weight;
		}
		
		public String getHuffman() {
			return huffman;
		}
		
		
		public node getLeft() {
			return left;
		}
		
		public node getRight() {
			return right;
		}
		
		public node getParent() {
			return parent;
		}
		
		public void setValue(String v) {
			value = v;
		}
		
		public void setWeight(int w) {
			weight = w;
		}
		
		public void setHuffman(String h) {
			huffman = h;
		}
		
		public void setLeft(node l) {
			left = l;
		}
		
		public void setRight(node r) {
			right = r;
		}
		
		public void setParent(node p) {
			parent = p;
		}
		

		@Override
		public int compareTo(Object o) {
			
			int comparage = ((node)o).getWeight();
			
			return this.weight - comparage;
		}

		
		
	}
	
	// create nodes method
	// Takes in a string of text and an array list of nodes
	/* will loop through all the characters to get the unique 
	 * characters and weight
	 * will create a node for each unique character
	 * will put the nodes in an array list
	 */
	
	static void createNodes(String text, ArrayList<node> array) {
		
		int length = text.length();
		int arrayLength = 0;
		String temp;
		int arrayPosition = -1;
		node addition;

		
		// loop through all the characters in the text
		for(int i = 0; i < length; i++)
		{
			// update the arrayLength
			arrayLength = array.size();
			
			// get the character
			temp = Character.toString(text.charAt(i));
						
			// see if the character is in the array list
			arrayPosition = inList(arrayLength, array, temp);
			
			// if the character is not in the array list 
			// add it to the array list
			if(arrayPosition == -1)
			{
				addition = new node(temp); 
				array.add(addition);
			}
		}
	}
	
	// inList will take in the length of the array list, a one character
	// string, and an array list of nodes as arguments
	// check to see if the leaf is in the array, if it is it increases its 
	// weight and returns the position, otherwise it returns -1
	
	static int inList(int arrayLength, ArrayList<node> array, String temp) {
		
		int position = -1;
		int w = 0;
		String holder;
		
		// looks through all the nodes in the array list
		for(int i = 0; i < arrayLength; i++) {
			
			// checks to see if any of the nodes have the character
			
			if(temp.equals(array.get(i).getValue())) {
				
				w = array.get(i).getWeight();
				
				// increment the nodes weight
				
				array.get(i).setWeight(w+1);
				
				// change the position
				position = i;
			}
			
		}
		
		return position;
	}
	
	// printTable will take in an array list of nodes
	// output value table with character weights sorted from
	// smallest to largest
	static void printTable(ArrayList<node> array) {
		
		int length = array.size();
		
		System.out.println("Character:Weight");
		
		// sorts the array list from smallest to largest
		Collections.sort(array);
		
		// outputs the value and weight of each node
		for(int i = 0; i < length; i++)
		{
			
			System.out.println(array.get(i).getValue() + ":" +
						array.get(i).getWeight());
			
		}
	}
	
	
	
	// prompt for ready to continue
	
	// call the combination method
	/*
	 * will find the two nodes with the least weight
	 * and combine them into one node
	 */
	
	
	
	// recursivePrint will take in an array list of nodes
	// the method will call the printTable method then combine
	// the two nodes in the array list with the smallest weight into 
	// one node, then the method is called again. This continues until there
	// is only one node left in the array the root.
	
	static void recursivePrint(ArrayList<node> array) {
		
		int length = array.size();
		Scanner input = new Scanner(System.in);
		node left;
		node right;
		
		// orders the list and prints out the table
		printTable(array);
		
		if(length > 1)
		{
			
			//get smallest number in list
			
			left = array.get(0);
			array.remove(0);
			
			//get second smallest number in list
			
			right = array.get(0);
			array.remove(0);
				
			// gets combined weight
			int sumWeight = right.getWeight() + left.getWeight();
				
			// gets combined value
			String combination = left.getValue() + right.getValue();
				
			// cretes a new node that is the combination of both nodes
			node concat = new node(sumWeight, combination, left, right);
				
			// set the parent for both nodes to the newly created one
			left.setParent(concat);
			right.setParent(concat);
			
			// add the new node to the array list
			array.add(concat);
				
				
			//stop request continue
			System.out.println("\nPress enter any letter to continue\n");
			input.next();
			
			System.out.println("Combined node {" + left.getValue() + "} (Weight: {" +
					left.getWeight() + "}) with node {" + right.getValue() + "} (Weight: {"
					+ right.getWeight() + "}) to get node {" + concat.getValue() 
					+ "} (Weight: {" + concat.getWeight() + "})" );
			
			// call recursively 
			
			recursivePrint(array);
	
		}
	}
	
	
	
	// findHuffman will take in a root node, an empty string and 
	// an array list of the leafs for the huffman tree
	// method for finding the huffman code for the leaf nodes
	static void findHuffman(node root, String h, ArrayList<node> array) {
		
		// get to all the leafs
		// go down the left path 
		// then go down the right path
		
	
		if(root.getLeft() != null) // if left branch add 0 to the huffman
		{
			
			root.setHuffman(h);
			findHuffman(root.getLeft(), h+"0", array);
		}
		if(root.getRight() != null) // if right branch add 1 to the huffman
		{
			
			root.setHuffman(h);
			findHuffman(root.getRight(), h+"1", array);
			
		}
		if(root.getLeft() == null && root.getRight() == null)
		{
			// reached a leaf node
			// h is the huffman code of the leaf
			System.out.print(root.getValue());
			System.out.print(" = ");
			System.out.println(h);
			root.setHuffman(h);
			array.add(root);
		}
	}
	
	// printHuffman will take in an array list of nodes, and the 
	// string of text given by the user 
	// the method will then go through each of the characters in the
	// text and find the huffman code for that character, the huffman 
	// codes will combine to output the binary form of the text
	// using huffman code
	// the method will return the length of the huffman text
	static int printHuffman(ArrayList<node> array, String original) {
		
		int length = original.length();
		String temp;
		String huffmanCode = "";
		String h;
		
		// go through each characer in the text
		for(int i = 0; i < length; i++)
		{
			
			temp = Character.toString(original.charAt(i));
			
			// checks to see if its the first character
			if(i == 0)
			{
				huffmanCode = searchHuffman(temp, array);
			}
			else
			{
				h = searchHuffman(temp, array);
				huffmanCode = huffmanCode + h;
			}
		}
		
		length = huffmanCode.length();
		
		System.out.println("The original text is now represented in binary as:\n"
				+ huffmanCode + "\nUsing " + length + " bits of length.");
		
		return length;
	}
	
	// searchHuffman takes in an one character string, and an array
	// list of leaf nodes
	// searches for huffman code of the value given and returns the 
	// huffman code
	static String searchHuffman(String v, ArrayList<node> array) {
		
		int length = array.size();
		String huff = "";
		
		// goes through all the nodes in the array
		for(int i = 0; i < length; i++) {
			
			// finds the one with the given character
			if(v.equals(array.get(i).getValue()))
			{
				huff = array.get(i).getHuffman();
			}
		}
		
		return huff;
	}
	
	// printASCII will take in the text entered by the user
	// will output the number of bits for the ASCII code of the
	// text and then return the number
	static int printASCII(String original) {
		int ascii = original.length();
		ascii = ascii * 8;
		
		System.out.println("Total number of bits using ASCII Code is: "  
							+ ascii);
		
		
		return ascii;
	}
	
	// printCompression takes in the number of bits for the 
	// huffman code and the number of bits for the ascii code
	// method for finding compression rate
	static void printCompression(int huff, int ascii) {
		
		double compress = (huff*1.0) / (ascii*1.0);
		
		
		
		System.out.printf("Compression Rate: %.3f\n",compress);
	}
	
	// main will read in the text from the user and then call the 
	// methods to create the huffman tree
	public static void main(String[] args) {
		
		int valid = 0;
		String readInput = "";
		Scanner input = new Scanner(System.in);
		ArrayList<node> huffmanTree = new ArrayList<node>();
		ArrayList<node> leafs = new ArrayList<node>();
		
		
		while (valid == 0)
		{
			valid = 1;
			
			System.out.println("Please enter your input text.");
			
			readInput = input.nextLine();
			
			if (readInput.isEmpty())
			{
				valid = 0;
				System.out.println("You have entered an invalid input");
			}
		}
		
		// fill the huffmanTree array list with the leaf nodes of the 
		// huffman tree
		createNodes(readInput, huffmanTree);
		
		// print out the character table for each concatination of the nodes
		recursivePrint(huffmanTree);
		
		// pause for the user to continue
		System.out.println("\nPress enter any letter to continue\n");
		input.next();
		
		System.out.println("The Huffman Code for each character are:");
		
		// prints out the huffman code for each character
		findHuffman(huffmanTree.get(0),"",leafs);
		
		System.out.println("\nPress enter any letter to continue\n");
		input.next();
		
		// prints out the original text in binary form and the compression
		// rate
		int a = printHuffman(leafs, readInput);
		
		int b = printASCII(readInput);
		
		printCompression(a,b);
		
		// ends the program
		System.out.println("\nThe Program has ended.");
		
	}
	
}