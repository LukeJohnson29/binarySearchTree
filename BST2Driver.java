/*****************************************************
 * @author Luke Johnson
 * Binary Search Tree, Part 2
 * 
 * Due Date: 04/06/2018
 * Input files: BSTtextfile.txt
 * 
 * This program is used to read in a text file, remove all non-letter
 * values from the beginning and end of each word read in, store the 
 * words in a binary search tree, and the output the data from the tree
 * in alphabetical order.
 * 
 * The program then traverses the tree and deletes all nodes that have too many words
 */
import java.util.*;
import java.io.*;

public class BST2Driver
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
		int maxWordOccurrences; // max number of times a word may occur (totalWords * allowedPercentage)
		double allowedPercentage = 0.01; // percentage of total words used to get maxWordOccurrences

		// A = 65: integer value of A
		// Z = 90: integer value of Z

		// create a node and a binary search tree object, then build the tree
		Node root = new Node(reader.next().toUpperCase());
		BinarySearchTree tree = new BinarySearchTree(root);
		tree.insertNode(root, root);

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
				//don't delete one letter words
				if (data.length() > 1)
				{
					data = data.substring(1, data.length());
					firstChar = (int) data.charAt(0);
				}
				//exit loop
				else
				{
					done = true;
				}
			}

			done = false;

			// remove any non-letter characters at end of String, data
			while ((lastChar < 65 || lastChar > 90) && !done)
			{
				//don't delete one letter words
				if (data.length() > 1)
				{
					data = data.substring(0, data.length() - 1);
					lastChar = data.charAt(data.length() - 1);
				}
				//exit loop
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
				tree.insertNode(root, newNode);
				tree.setTotalWords(tree.getTotalWords() + 1);
			}
		}

		// Set maximum number of times a word may be repeated before its' node will be deleted
		maxWordOccurrences = (int) (allowedPercentage * tree.getTotalWords());

		// output data from tree in-order, post order, or pre-order
		tree.printInOrder(root);
		// tree.printPreOrder(root);
		// tree.printPostOrder(root);

		System.out.println("\nTotal words: " + tree.getTotalWords());
		System.out.println("Maximum times that a word may be used: " + maxWordOccurrences);
		System.out.println("Purging the tree.....\n\n\n");

		// remove nodes with too many words and then output the tree and new number of total words
		purgeTree(tree.getRoot(), tree, maxWordOccurrences);
		System.out.println("Tree after the purge:\n");
		tree.printInOrder(root);
		// tree.printPreOrder(root);
		// tree.printPostOrder(root);
		System.out.println("\nTotal words remaining after the purge: " + tree.getTotalWords());

	}

	/*******************************************************************************************************************
	 * Method used to delete all nodes from a tree that exceed the maximum allowable amount of words
	 * 
	 * @param root:
	 *           Root of the tree being dealt with
	 * 
	 * @return root: return the root of the tree
	 */
	public static Node purgeTree(Node root, BinarySearchTree tree, int maxWordOccurrences)
	{
		//only execute if current node is not null
		if (root != null)
		{
			//delete node if it has too many words
			if (root.getNumOfWord() > maxWordOccurrences)
			{
				tree.deleteNode(root);
				tree.setTotalWords(tree.getTotalWords() - root.getNumOfWord());
			}

			//continue traversing tree
			purgeTree(root.getLeft(), tree, maxWordOccurrences);
			purgeTree(root.getRight(), tree, maxWordOccurrences);

		}

		return root;
	}

}
/*********************************************************
 * Part 1 Problems: Text file would not read in because the file from D2L had spaces in it. Removing the spaces fixed
 * the issue.
 * 
 * Part 2 Problems: None. It worked on the first try!
 */
