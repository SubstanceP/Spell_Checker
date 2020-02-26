package spellchecker;

import static sbcc.Core.*;

import java.util.*;

import java.util.Collections.*;

import sbcc.Core;

public class BasicDictionary extends BinaryTree implements Dictionary {

	BinaryTreeNode root;


	@Override
	public void importFile(String filename) throws Exception {
		// TODO Auto-generated method stub

		// int left is counter for left values and right is counter for right values -
		// one starts at size of arraylist other starts at 0

		// if (content.size() > 0)
		// root.value = content.get(0);
		// else
		// println("Null test!");

		List<String> content = readFileAsLines(filename);
		Collections.shuffle(content);

		if (content.size() > 0) {
			for (int i = 0; i < content.size(); i++) {
				// this.root.left.value = content.get(i);
				// this.root.right.value = content.get(right);
				// right--;
				add(content.get(i));
			}
		}

		// String[] array = content.toArray(new String[0]);
		// BasicDictionary current = new BasicDictionary();
		// println(Arrays.toString(array));
		// println(array.length);
		// buildCompleteTree(array, root, 0);

		// filename = "full_dictionary.txt";

	}


	@Override
	public void load(String filename) throws Exception {
		// TODO Auto-generated method stub
		List<String> content = readFileAsLines(filename);

		if (content.size() > 0) {
			for (int i = 0; i < content.size(); i++) {
				// this.root.left.value = content.get(i);
				// this.root.right.value = content.get(right);
				// right--;
				add(content.get(i));
			}
		}

	}


	// document stirng builder, pattern and matcher reference variables
	@Override
	public void save(String filename) throws Exception {
		// get values from tree in preorder using tree and append it to a string builder
		// with newline

		StringBuilder sb = new StringBuilder();
		BinaryTreeNode cur = root;
		// if(root == null) return;
		// sb.append(root + "/n");
		// sb.append(root.left + "/n");*/
		Stack<BinaryTreeNode> preOrderStack = new Stack<BinaryTreeNode>();
		preOrderStack.push(cur);
		sb.append(cur.value + "\n");
		while (preOrderStack.size() > 0) {
			if (cur.right != null)
				preOrderStack.push(cur.right);
			if (cur.left != null) {
				sb.append(cur.left.value + "\n");
				cur = cur.left;
			} else {
				cur = preOrderStack.pop();
				if (!cur.equals(root))
					sb.append(cur.value + "\n");
			}
		}

		String save = sb.toString();
		writeFile(filename, save);

	}


	@Override
	public String[] find(String word) {
		String previous = "", next = "";
		word = word.trim();
		// BinaryTreeNode cursor = root;
		BinaryTreeNode cursor = root;
		while (cursor != null) {
			if (word.compareToIgnoreCase(cursor.value) == 0) {
				return null;
			} else if (word.compareToIgnoreCase(cursor.value) > 0) {
				previous = cursor.value;
				cursor = cursor.right;
			} else if (word.compareToIgnoreCase(cursor.value) < 0) {
				next = cursor.value;
				cursor = cursor.left;
			}
		}
		return new String[] { previous, next };
	}


	@Override
	public void add(String word) {
		// TODO Auto-generated method stub
		// comparetoignora case word.compareToIgnoreCase
		// if it exists in the dictionary then do not add, if it does not then compare
		// to cursor and add right or left
		// compare to cursor to go left or right, if there is a left or right set it to
		// the new root, then compare to the new root and repeat

		/*
		 * BinaryTreeNode r; r = this.root; // r.value = word; BinaryTreeNode cursor;
		 * cursor = r; if (root == null) { r.value = word; cursor.value = word; return;
		 * } else if (word.compareToIgnoreCase(cursor.left.value) < 0) { if
		 * (cursor.left.value == null) { BinaryTreeNode temp; temp = cursor.left;
		 * temp.value = cursor.left.value; temp.value = word; return; } else {
		 * add(word); } } else if (word.compareToIgnoreCase(cursor.right.value) > 0) {
		 * if (cursor.right.value == null) { BinaryTreeNode temp; temp = cursor.right;
		 * temp.value = cursor.right.value; temp.value = word; return; } else {
		 * add(word); }
		 * 
		 * } else { return; }
		 * 
		 * /* else { while(cursor.left != null && cursor.right != null) { if()
		 */
		word = word.trim();
		// BinaryTreeNode cursor = root;
		BinaryTreeNode cursor = root;
		if (root == null) {
			root = new BinaryTreeNode(word);
		} else {
			while (cursor != null) {
				if (word.compareToIgnoreCase(cursor.value) > 0) {
					if (cursor.right == null) {
						cursor.right = new BinaryTreeNode(word);
						return;
					}
					cursor = cursor.right;
				} else if (word.compareToIgnoreCase(cursor.value) < 0) {
					if (cursor.left == null) {
						cursor.left = new BinaryTreeNode(word);
						return;
					}
					cursor = cursor.left;
				} else
					return;
			}
		}

		/*
		 * while (cursor.left != null && cursor.right != null) { if
		 * (cursor.value.compareToIgnoreCase(root.value) > 0) root.left = cursor; if
		 * (cursor.value.compareToIgnoreCase(root.value) < 0) root.right = cursor; }
		 */
	}


	@Override
	public BinaryTreeNode getRoot() {
		// TODO Auto-generated method stub
		return root;

	}


	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

}
