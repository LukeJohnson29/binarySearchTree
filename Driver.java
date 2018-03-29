/*****************************************************
 * @author Luke Johnson
 * Binary Search Tree, Part 1
 * 
 * Due Date: 03/30/2018
 * Input files: BSTtextfile.txt
 * 
 * This program is used to read in a text file, remove all non-letter
 * values from the beginning and end of each word read in, store the 
 * words in a binary search tree, and the output the data from the tree
 * in alphabetical order.
 */
import java.util.*;
import java.io.*;

public class Driver
{
	static Scanner reader;
	static java.io.File inFileText;

	public static void main(String[] args) throws FileNotFoundException
	{
		// set text file or exit if file does not exist
		inFileText = new java.io.File("BSTtextfile.txt");
		if (!inFileText.exists())
		{
			System.out.println("File Not Found");
			System.exit(0);
		}
		reader = new Scanner(inFileText);

		String data; // string being read in from file
		int firstChar; // integer value of first character of String, data
		int lastChar; // integer value of last character of String, data
		boolean done = false; // true false used to exit substring loops

		// A = 65: integer value of A
		// Z = 90: integer value of Z

		// set root node of tree
		Node root = new Node(reader.next().toUpperCase());
		buildTree(root, root);

		// loop executes until end of text file
		while (reader.hasNext())
		// for(int i = 0; i < 5; i++) //for debugging
		{
			// read in data, set to upper case, get int value for first and last characters of data
			data = reader.next().toUpperCase();
			// System.out.println(data); //for debug
			firstChar = (int) data.charAt(0);
			lastChar = (int) data.charAt(data.length() - 1);

			// remove any non-letter characters at beginning of String, data
			while ((firstChar < 65 || firstChar > 90) && !done)
			{
				if (data.length() > 1)
				{
					data = data.substring(1, data.length());
					firstChar = (int) data.charAt(0);
				}
				else
				{
					done = true;
				}
			}

			done = false;

			// remove any non-letter characters at end of String, data
			while ((lastChar < 65 || lastChar > 90) && !done)
			{
				if (data.length() > 1)
				{
					data = data.substring(0, data.length() - 1);
					lastChar = data.charAt(data.length() - 1);
				}
				else
				{
					done = true;
				}
			}

			// System.out.println(data); //for debugging

			// If the first character and last characters in data are letters, add to tree
			if ((firstChar >= 65 && firstChar <= 90) && (lastChar >= 65 && lastChar <= 90))
			{
				// System.out.println(data); //for debug
				Node newNode = new Node(data);
				buildTree(root, newNode);
			}
		}
		// output data from tree in alphabetical order
		printInOrder(root);
	}

	/***********************************************************
	 * Method used to output a binary tree in order
	 * 
	 * @param current:
	 *           Root of tree originally, and then will be used to traverse the tree
	 */
	public static void printInOrder(Node current)
	{
		//Recursively call until current == null to print every node in tree
		if (current != null)
		{
			printInOrder(current.getLeft());
			System.out.println(current.getData() + ": occurs " + current.getNumOfWord() + " times");
			printInOrder(current.getRight());
		}
	}

	/***********************************************************
	 * Method to build tree. Puts a node in place on a binary tree
	 * 
	 * @param root
	 * @param insertNode
	 */
	public static void buildTree(Node root, Node insertNode)
	{
		// new node string first character less than root string first character
		int compare;
		// System.out.println("in buildTree");
		// System.out.println("newNode" + insertNode.getData());
		compare = insertNode.getData().compareTo(root.getData());
		if (compare < 0)
		{
			if (root.hasLeft())
			{
				buildTree(root.getLeft(), insertNode);
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
				buildTree(root.getRight(), insertNode);
			}
			else
			{
				root.setRight(insertNode);
				insertNode.setParent(root);
			}
		}
		//Increment occurrences if words are equal
		else if (compare == 0)
		{
			root.setNumOfWord(root.getNumOfWord() + 1);
		}
	}
}
/*********************************************************
 * Part 1 Problems: Text file would not read in because the 
 * file from D2L had spaces in it. Removing the spaces fixed
 * the issue.
 */
