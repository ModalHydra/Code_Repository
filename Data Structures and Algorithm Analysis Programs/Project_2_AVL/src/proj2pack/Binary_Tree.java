package proj2pack;

// This class needs some work
// create using random numbers to fill the tree

public class Binary_Tree {
	/* Class containing left and right child of current
	node and key value*/
	public static class BTNode
	{
		int key;
		BTNode left, right;

		public BTNode(int item)
		{
			key = item;
			left = right = null;
		}
	}

	// A Java program to introduce Binary Tree
	public static class BinaryTree
	{
		// Root of Binary Tree
		BTNode root;

		// Constructors
		BinaryTree(int key)
		{
			root = new BTNode(key);
		}

		BinaryTree()
		{
			root = null;
		}
		

	}
	
	
	
	public static void main(String[] args)
	{
		BinaryTree tree = new BinaryTree();

		/*create root*/
		tree.root = new BTNode(1);

		/* following is the tree after above statement

			1
			/ \
		null null	 */

		tree.root.left = new BTNode(2);
		tree.root.right = new BTNode(3);

		/* 2 and 3 become left and right children of 1
			1
			/ \
			2	 3
		/ \ / \
		null null null null */


		tree.root.left.left = new BTNode(4);
		/* 4 becomes left child of 2
					1
				   / \
				  2   3
			     / \ / \
			    4  n n  n
		       / \
		     null null
		*/
	}

}
