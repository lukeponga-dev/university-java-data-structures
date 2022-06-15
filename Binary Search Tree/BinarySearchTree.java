/**
 * {@index BinarySearchTree}
 * {@summary unbalanced BST using self referential nodes}
 * 
 * {@author Luke Ponga}
 */
public class BinarySearchTree {
	// Constructor
	private BSTNode root;

	public BinarySearchTree() {
		root = null;
	}

	// Methods

	/**
	 * method search
	 * 
	 * {@param s} the node to search for
	 * 
	 * @return true if found
	 */
	public boolean search(String s) {
		boolean found = searchR(root, s);
		return found;
	}

	/**
	 * recursive search
	 * 
	 * @param cRoot the current node
	 * @param s     the node being searched
	 * @return found
	 */
	private boolean searchR(BSTNode cRoot, String s) {

		boolean found = false;

		if (cRoot == null) {
			return false;
		} else if (cRoot.getValue() == s) {
			return true;
		}
		// Search the left subtree
		else if (s.compareTo(cRoot.getValue()) < 0) {
			found = searchR(cRoot.getLeft(), s);
		}
		// Search the right subtree
		else if (s.compareTo(cRoot.getValue()) > 0) {
			found = searchR(cRoot.getRight(), s);
		}
		return found;
	}

	/**
	 * insert
	 * entry point for recurisive insert method
	 * 
	 * @param s the string of the node to insert
	 */
	public void insert(String s) {
		root = insertR(root, s);
	}

	/**
	 * insertR
	 * Recursive insert method
	 * 
	 * @param cRoot
	 * @param s
	 * @return
	 */
	private BSTNode insertR(BSTNode cRoot, String s) {
		// No Tree add NewNode to cRoot
		if (cRoot == null) {
			BSTNode newNode = new BSTNode(s);
			cRoot = newNode;

		} else if (s.compareTo(cRoot.getValue()) < 0) { // left subtree
			cRoot.setLeft(insertR(cRoot.getLeft(), s));

		} else if (s.compareTo(cRoot.getValue()) > 0) { // right subtree
			cRoot.setRight(insertR(cRoot.getRight(), s));
		}
		return cRoot;
	}

	/**
	 * remove the targeted node value
	 * 
	 * @param s
	 */
	public void remove(String s) {
		root = removeR(root, s);

	}

	/**
	 * Helper method to recursively search for, and remove the BSTNode with
	 * the given data in it
	 * 
	 * @param cRoot is the node we're currently at
	 * @param s     is the data we're looking for
	 * @return the node that was removed
	 */
	private BSTNode removeR(BSTNode cRoot, String s) {
		BSTNode temp = cRoot;
		// If tree is empty return
		if (cRoot == null) {
			return cRoot;
		}

		// search down the left subtree
		if (s.compareTo(cRoot.getValue()) < 0) {
			cRoot.setLeft(removeR(cRoot.getLeft(), s));

			// search the right subtree
		} else if (s.compareTo(cRoot.getValue()) > 0) {
			cRoot.setRight(removeR(cRoot.getRight(), s));

		} else if (cRoot.getLeft() != null && cRoot.getRight() != null) {

			// traverse down leftmost right subtree
			BSTNode successor = minimumkey(temp.getRight());

			// recursive call to loop through the tree
			removeR(temp, successor.getValue());

			// set current valuesuccessor with it's successor
			temp.setValue(successor.getValue());

		} else {

			if (cRoot.getLeft() != null) {
				cRoot = cRoot.getLeft();
			} else {
				cRoot = cRoot.getRight();
			}

		}
		return cRoot;
	}

	/**
	 * Finds leftmost node in a subtree with smallest value
	 * 
	 * @param cRoot
	 * @return
	 */
	private BSTNode minimumkey(BSTNode cRoot) {
		if (cRoot.getLeft() != null) {
			cRoot = cRoot.getLeft();
		}
		return cRoot;
	}

	/**
	 * dump
	 * recursively call dumpR
	 */
	public void dump() {
		dumpR(root);
	}

	/**
	 * dumpR
	 * prints the tree to console
	 * following a in-order traversal
	 * traverses the bst and print all strings on a new line
	 * 
	 * @param cRoot
	 */
	private void dumpR(BSTNode cRoot) {
		if (cRoot == null) {
			return;
		}

		dumpR(cRoot.getLeft());
		System.out.println(cRoot.getValue());
		dumpR(cRoot.getRight());

	}

	/**
	 * Prints the BST in a tree structure
	 */
	public void printTree() {
		System.out.println("Tree");
		BSTPrinter.printNode(root);
	}

	/**
	 * height method
	 * @return, height of the tree
	 */
	public int height() {
		return heightR(root);
	}

	/**
	 * Method heightR
	 * 
	 * @param cRoot link pointer node
	 * @return maxHeight
	 */
	private int heightR(BSTNode cRoot) {
		if (cRoot == null) {
			return -1;

		} else {
			int lst = heightR(cRoot.getLeft());
			int rst = heightR(cRoot.getRight());
			int maxHeight = getMax(lst, rst);
			maxHeight++;
			return maxHeight;
		}
	}

	/**
	 * getMax
	 * 
	 * @param i
	 * @param j
	 * @return
	 */
	private int getMax(int i, int j) {
		if (i > j) {
			return i;
		} else {
			return j;
		}
	}
}