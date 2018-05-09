/*********************************************************************
 * A class used to implement a binary search tree of strings
 *
 * @author Luke Johnson
 *
 *         This class is used to create a binary search tree for strings. It implements methods for inserting a node,
 *         printing in order, pre-order, and post order, as well as deleting a predetermined node.
 *
 */
public class BinarySearchTree
{
	Node root; // Root node of a binary tree object
	int totalWords; // number of words stored in the tree

	/************************************
	 * Default Constructor
	 */
	public BinarySearchTree()
	{
		this.root = null;
		this.totalWords = 0;
	}

	/*************************************
	 * Constructor with Node parameter
	 *
	 * @param root:
	 *           Node to be root of the tree
	 */
	public BinarySearchTree(Node root)
	{
		this.root = root;
		this.totalWords = 1;
	}

	/***********************************************************
	 * Method to add a node to a tree. Puts a node in place on a binary tree
	 *
	 * @param root:
	 *           Root of the tree that the node is being added to
	 * @param insertNode:
	 *           Node being inserted into the tree
	 */
	public void insertNode(Node root, Node insertNode)
	{
		if (insertNode != null)
		{
			// new node string first character less than root string first character
			int compare;
			// System.out.println("in insertNode");
			// System.out.println("newNode" + insertNode.getData());
			compare = insertNode.getData().compareTo(root.getData());
			if (compare < 0)
			{
				if (root.hasLeft())
				{
					insertNode(root.getLeft(), insertNode);
				}
				else
				{
					root.setLeft(insertNode);
					insertNode.setParent(root);
				}
			}
			// Add to or move right if node string first character greater than root string first character
			else if (compare > 0)
			{
				if (root.hasRight())
				{
					insertNode(root.getRight(), insertNode);
				}
				else
				{
					root.setRight(insertNode);
					insertNode.setParent(root);
				}
			}
			// Increment occurrences if words are equal
			else if (compare == 0)
			{
				root.setNumOfWord(root.getNumOfWord() + 1);
			}
		}
	}

	/***********************************************************
	 * Method used to output a binary tree in order
	 *
	 * @param current:
	 *           Root of tree originally, and then will be used to traverse the tree
	 */
	public void printInOrder(Node current)
	{
		// Recursively call until current == null to print every node in tree
		if (current != null)
		{
			printInOrder(current.getLeft());
			// print occurrences and "times" if more than 1, "time" if only 1
			System.out.println(current.getData() + ": occurs "
					+ (current.getNumOfWord() > 1 ? current.getNumOfWord() + " times" : current.getNumOfWord() + " time"));
			printInOrder(current.getRight());
		}
	}

	/*************************************************************
	 * Method used to output a binary tree in post order
	 *
	 * @param current:
	 *           Root of tree originally, and then will be used to traverse the tree
	 */
	public void printPostOrder(Node current)
	{
		// Recursively call until current == null to print every node in tree
		if (current != null)
		{
			printPostOrder(current.getLeft());
			printPostOrder(current.getRight());
			// print occurrences and "times" if more than 1, "time" if only 1
			System.out.println(current.getData() + ": occurs "
					+ (current.getNumOfWord() > 1 ? current.getNumOfWord() + " times" : current.getNumOfWord() + " time"));
		}
	}

	/*************************************************************
	 * Method used to output a binary tree in pre-order
	 *
	 * @param current:
	 *           Root of tree originally, and then will be used to traverse the tree
	 */
	public void printPreOrder(Node current)
	{
		if (current != null)
		{
			// print occurrences and "times" if more than 1, "time" if only 1
			System.out.println(current.getData() + ": occurs "
					+ (current.getNumOfWord() > 1 ? current.getNumOfWord() + " times" : current.getNumOfWord() + " time"));
			printPreOrder(current.getLeft());
			printPreOrder(current.getRight());
		}
	}

	/***********************************************************************
	 * Method to delete one predetermined node from the binary tree
	 *
	 * @param current:
	 *           The node to be deleted
	 */
	public void deleteNode(Node current)
	{
		// only execute if current is not null
		if (current != null)
		{
			// move left side, most right node to root
			if (current == this.root)
			{
				current = current.getLeft();
				// traverse tree to left side's inner most right node
				while (current.getRight() != null)
				{
					current = current.getRight();
				}
				if (current.hasLeft())
				{
					current.getParent().setRight(current.getLeft());
				}
				// left, inner most right node becomes root
				current.setLeft(root.getLeft());

				current.setRight(root.getRight());
				current.setParent(null);

				this.root = current;
			}

			// current is left child of parent, set parent's left link to current's left link
			else if (current.getParent().getLeft() == current)
			{
				current.getParent().setLeft(current.getLeft());
				current.getLeft().setParent(current.getParent());
				// if current has a right child, insert it
				if (current.getRight() != null)
				{
					insertNode(this.root, current.getRight());
				}
			}
			// current is right child of parent, set parent's right link to current's right link
			else if (current.getParent().getRight() == current)
			{
				current.getParent().setRight(current.getRight());
				current.getRight().setParent(current.getParent());
				// if current has a left child, insert it
				if (current.getLeft() != null)
				{
					insertNode(this.root, current.getLeft());
				}
			}
		}
	}

	/************************************************************************************************************************/
	// GETTERS AND SETTERS
	public Node getRoot()
	{
		return root;
	}

	public void setRoot(Node root)
	{
		this.root = root;
	}

	public int getTotalWords()
	{
		return totalWords;
	}

	public void setTotalWords(int totalWords)
	{
		this.totalWords = totalWords;
	}

}
