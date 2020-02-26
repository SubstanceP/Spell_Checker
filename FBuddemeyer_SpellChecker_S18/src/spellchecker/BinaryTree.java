package spellchecker;

import static sbcc.Core.*;

public class BinaryTree {

	BinaryTreeNode root;


	/**
	 * !!populate array with text file, turn array into stack !!construct complete
	 * tree using BinaryTreeClass and preorder traversal, (push the text file to a
	 * stack then use the stack to populate the tree) !!get lowest power of 2 for
	 * arrayh
	 *
	 **/

	public void add(String word) {
		// TODO Auto-generated method stub
		// comparetoignora case word.compareToIgnoreCase
		// if it exists in the dictionary then do not add, if it does not then compare
		// to cursor and add right or left
		// compare to cursor to go left or right, if there is a left or right set it to
		// the new root, then compare to the new root and repeat

		/*
		 * if (this.getRoot() == null) { this.root.value = word; this.cursor.value =
		 * word; cursor = root; return; } else if
		 * (word.compareToIgnoreCase(cursor.left.value) < 0) { if (cursor.left.value ==
		 * null) { cursor.left.value = word; cursor = cursor.left; return; } else {
		 * add(word); } } else if (word.compareToIgnoreCase(cursor.right.value) > 0) {
		 * if (cursor.right.value == null) { cursor.right.value = word; cursor =
		 * cursor.right; return; } else { add(word); }
		 * 
		 * } else { return; }
		 * 
		 * /* else { while(cursor.left != null && cursor.right != null) { if()
		 */
	}

	// Function to insert nodes in level order
	/*
	 * public BinaryTreeNode buildCompleteTree(String[] arr, BinaryTreeNode root,
	 * int i) { // Base case for recursion if (i < arr.length) { BinaryTreeNode temp
	 * = new BinaryTreeNode(arr[i]); // root = this.root; root = temp;
	 * 
	 * // insert left child root.left = buildCompleteTree(arr, root.left, 2 * i +
	 * 1);
	 * 
	 * // insert right child root.right = buildCompleteTree(arr, root.right, 2 * i +
	 * 2); } return root;
	 */
	// }
	// (i < arr.l)
	// public BinaryTreeNode
	/*
	 * public void buildTree(String[] array) { if(array.length < 0)
	 * println("empty array!"); else this.root = array[0];
	 * 
	 * }
	 */

	/*
	 * public BinaryTreeNode getRoot() { // TODO Auto-generated method stub return
	 * this.root;
	 * 
	 * }
	 */

}
