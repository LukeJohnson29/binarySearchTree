/******************************************
 * A node in a binary search tree
 * 
 * @author Luke Johnson
 *
 *	A class for storing a node value to be used in a 
 *	binary search tree.
 */
public class Node
{
	private Node left; // left link from node
	private Node right; // right link from node
	private Node parent; // link to parent node
	private String data; // data stored in this node
	private int numOfWord; // value used to count occurrences of a word

	/*********************************
	 * Default constructor
	 */
	public Node()
	{
		this.left = null;
		this.right = null;
		this.parent = null;
		this.data = null;
		this.numOfWord = 0;
	}

	/************************************************
	 * Constructor which accepts a string argument
	 * 
	 * @param data:
	 *           A string to be stored in the node
	 */
	public Node(String data)
	{
		this.left = null;
		this.right = null;
		this.parent = null;
		this.data = data;
		this.numOfWord = 1;
	}

	/**********************************
	 * A method to check for a left child
	 * 
	 * @return: whether left child is not null
	 */
	public boolean hasLeft()
	{
		return this.left != null;
	}

	/***********************************
	 * A method to check for a right child
	 * 
	 * @return: whether right child is not null
	 */
	public boolean hasRight()
	{
		return this.right != null;
	}

	/********************************************************************
	 *GETTERS AND SETTERS
	 */
	public Node getLeft()
	{
		return left;
	}

	public void setLeft(Node left)
	{
		this.left = left;
	}

	public Node getRight()
	{
		return right;
	}

	public void setRight(Node right)
	{
		this.right = right;
	}

	public Node getParent()
	{
		return parent;
	}

	public void setParent(Node parent)
	{
		this.parent = parent;
	}

	public String getData()
	{
		return data;
	}

	public void setData(String data)
	{
		this.data = data;
	}

	public int getNumOfWord()
	{
		return numOfWord;
	}

	public void setNumOfWord(int numOfWord)
	{
		this.numOfWord = numOfWord;
	}
}
