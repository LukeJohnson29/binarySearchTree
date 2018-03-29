/******************************************
 * A node in a binary search tree
 * 
 * @author Luke Johnson
 *
 */
public class Node
{
	private Node  left;	//left link from node 
	private Node  right;	//right link from node
	private Node  parent;	//link to parent node
	private String data;	//data stored in this node
	private int numOfWord;	//value used to count occurrences of a word
	
	public Node(String data)
	{
		this.left = null;
		this.right = null;
		this.parent = null;
		this.data= data;
		this.numOfWord = 1;
	}
	
	public boolean hasLeft()
	{
		return this.left != null;
	}
	
	public boolean hasRight()
	{
		return this.right != null;
	}

	public Node  getLeft()
	{
		return left;
	}

	public void setLeft(Node  left)
	{
		this.left = left;
	}

	public Node getRight()
	{
		return right;
	}

	public void setRight(Node  right)
	{
		this.right = right;
	}

	public Node  getParent()
	{
		return parent;
	}

	public void setParent(Node  parent)
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
