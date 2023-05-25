package proj2pack;
import java.util.*;
import java.io.*;
import proj2pack.AVL_Tree.*;
import proj2pack.Binary_Tree.*;

public class Project_2 {

	// function to execute the gui of the program
	
	public static boolean gui(ArrayList<AVLNode> array) {
		
		AVLTree tree = new AVLTree();
		BinaryTree randBinaryTreeRoot = new BinaryTree();
		BinaryTree BSTree = new BinaryTree(10);
		BinaryTree AVLTree = new BinaryTree(20);
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int choice = 0, numNodes = 0, keySize = 0;
		boolean valid = false;
		
		System.out.println("Please select an option from the list by entering the number\n"
				+ "1. Output Part A of Project 2\n"
				+ "2. Output Part B of Project 2\n"
				+ "3. Output test that a BST can be detected\n"
				+ "4. Output test that an AVL tree can be detected\n"
				+ "5. Exit the program\n"
				+ "Choice: ");
		
		while(!valid) {
			choice = input.nextInt();
			
			if(choice < 6 && choice > 0) {
				valid = true;
			}
			else {
				System.out.println("\nInvalid input please enter a number from the list\n");
			}
		}
		
		switch(choice) {
			case 1: 
				System.out.println("Outputting AVL Tree Corrections for bookList");
				
				for(int i = 0; i < array.size(); i++) {
					
					tree.root = tree.insert(tree.root, array.get(i).key);
				}
				System.out.println();
				break;
			case 2:
				valid = false;
				
				System.out.println("Please enter the number of nodes for the binary tree being created\n"
						+ "Number of Nodes: ");
				
				while(!valid) {
					numNodes = input.nextInt();
					
					if(numNodes > 0) {
						valid = true;
					}
					else {
						System.out.println("\nInvalid input please enter a number greater than 0\n");
					}
				}
				
				System.out.println("Please enter the maximum size of the key for each node in the binary tree\n"
						+ "Max size: ");
				
				valid = false;
				
				while(!valid) {
					keySize = input.nextInt();
					
					if(keySize > 0) {
						valid = true;
					}
					else {
						System.out.println("\nInvalid input please enter a number greater than 0\n");
					}
				}
				
				randBinaryTreeRoot.root = randomBT(numNodes, keySize);
				
				System.out.println("Outputting binary tree from a deapth first traversal\n"
						+ "\nRoot Depth 0");
				
				printBT(randBinaryTreeRoot.root, 0);
				
				if(isBST(randBinaryTreeRoot.root, true)) {
					
					System.out.println("\nThe tree is a binary search tree");
					
					if(isAVL(randBinaryTreeRoot.root, true)) {
						
						System.out.println("The tree is an AVL tree");
						
					}
					else {
						
						System.out.println("The tree is not an AVL tree");
						
					}
				}
				else {
					
					System.out.println("\nThe tree is not a binary search tree");
					
				}
				
				System.out.println();
				break;
			case 3:
				
				BSTree.root.left = new BTNode(5);
				BSTree.root.right = new BTNode(15);
				BSTree.root.right.right = new BTNode(20);
				BSTree.root.right.right.right = new BTNode(25);
				
				System.out.println("Outputting binary tree from a deapth first traversal\n"
						+ "\nRoot Depth 0");
				
				printBT(BSTree.root, 0);
				
				if(isBST(BSTree.root, true)) {
					
					System.out.println("\nThe tree is a binary search tree");
					
					if(isAVL(BSTree.root, true)) {
						
						System.out.println("The tree is an AVL tree");
						
					}
					else {
						
						System.out.println("The tree is not an AVL tree");
						
					}
				}
				else {
					
					System.out.println("\nThe tree is not a binary search tree");
					
				}
				
				System.out.println();
				break;
			case 4:
				AVLTree.root.left = new BTNode(10);
				AVLTree.root.right = new BTNode(30);
				AVLTree.root.right.right = new BTNode(35);
				AVLTree.root.right.left = new BTNode(25);
				
				System.out.println("Outputting binary tree from a deapth first traversal\n"
						+ "\nRoot Depth 0");
				
				printBT(AVLTree.root, 0);
				
				if(isBST(AVLTree.root, true)) {
					
					System.out.println("\nThe tree is a binary search tree");
					
					if(isAVL(AVLTree.root, true)) {
						
						System.out.println("The tree is an AVL tree");
						
					}
					else {
						
						System.out.println("The tree is not an AVL tree");
						
					}
				}
				else {
					
					System.out.println("\nThe tree is not a binary search tree");
					
				}
				
				System.out.println();
				break;
			case 5:
				valid = false;
				break;
			default:
				valid = false;
				break;
		}
		
		return valid;
	}
	
	// function to read text from a file, in this case it is the bookList file located in Project 2
	
	public static void readFile(ArrayList<AVLNode> array, String fileName) {
		
		String author = "", title = "", ISBN = "";
		Book tempBook;
		AVLNode tempAVL;
		
		try  
		{  
		File file = new File(fileName);   
		Scanner sc = new Scanner(file);     //file to be scanned  
		while (sc.hasNextLine()) {        //returns true if and only if scanner has another token     
		
		if(sc.hasNext()) {
			ISBN = sc.next();
			title = sc.next();
			author = sc.next();
		}
		
		tempBook = new Book(title, author);
		
		tempAVL = new AVLNode(ISBN, tempBook);
		
		array.add(tempAVL);
		}
		
		sc.close();
		}
		catch(Exception e)  
		{  
		e.printStackTrace();  
		} 
		   
		
		
	}
	
	
	// will create a random Binary tree with x nodes recursivly 
	public static BTNode randomBT(int x, int y) {
		
		BTNode root = null;
		
		if(x != 0) {
		Random random = new Random();		
		int key = 0;
		int leftNumNodes = random.nextInt(x);
		int rightNumNodes = x - leftNumNodes - 1;
		
		//random.setSeed(System.currentTimeMillis());
		
		key = random.nextInt(y);
		//System.out.println(num);
		root = new BTNode(key);
		//System.out.println(root.key);
		
		root.left = randomBT(leftNumNodes, y);
		root.right = randomBT(rightNumNodes, y);
		
		// instead of print will create a node and 
		}
		
		return root;
	}
	
	// makes use of a depth first search approach to print the binary tree
	public static BTNode printBT(BTNode root, int depth) {
		
		if(root != null) {
			System.out.println(root.key);
			
			if(root.left != null) {
				System.out.println("Left child of Depth " + (depth + 1));
				printBT(root.left, depth + 1);
			}
			
			if(root.right != null) {
				System.out.println("Right child of Depth " + (depth + 1));
				printBT(root.right, depth + 1);
			}
			
		}
		
		return root;
	}
	
	// checks if all nodes of a binary tree fall under a BST recursivly
	public static boolean isBST(BTNode tree, boolean passes) {
		
		if(tree.left != null) {
			if(tree.left.key > tree.key) {
				passes = false;
			}
			passes = isBST(tree.left, passes);
		}
		if(tree.right != null) {
			if(tree.right.key < tree.key) {
				passes = false;
			}
			passes = isBST(tree.right, passes);
		}

		return passes;
	}
	
	// checks the balance of each node in the tree to see if it is
	// an AVL tree
	public static boolean isAVL(BTNode tree, boolean passes) {
		
		int balance = height(tree.left) - height(tree.right);
		
		if(Math.abs(balance) > 1) {
			passes = false;
		}
		
		if(tree.left != null) {
			passes = isAVL(tree.left, passes);
		}
		if(tree.right != null) {
			passes = isAVL(tree.right, passes);
		}
		
		return passes;
	}
	
	// recursivly travels down a tree starting at the given node, finding the height
	public static int height(BTNode node) {
		
		int h;
		
		if(node == null) {
			h = 0;
		}
		else {
			h = 1 + Math.max(height(node.left), height(node.right));
		}
		
		
		return h;
	}
	
	// calls the readFile and gui methods in a loop until the user exits the program
	public static void main(String[] args) {
		

		boolean valid = true;
		
		do {
		ArrayList<AVLNode> array = new ArrayList<AVLNode>();
		
		readFile(array, "bookList");
		
		valid = gui(array);
		
		}
		while(valid);
		
	}
}
