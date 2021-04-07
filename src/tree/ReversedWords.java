package tree;

import java.util.Scanner;

public class ReversedWords {
    
	public static int checkReversed()
	{
		int count = 0;
		String  inputString;
		Scanner myScn = new Scanner(System.in);
		
		Node root = new Node();
			
		while(myScn.hasNext())
		{
			inputString = myScn.next();
			if(inputString.equals("X"))
			{
				//When get "X" close the scanner and break
				myScn.close();
				break;
			}
			else
			{
				
				//Reverse the string and check if the reverse is exists in our tree
				String rev =new StringBuilder(inputString).reverse().toString();
				
			    if (root.num(rev) > 0)
			     {
				    count++;
				 }
			     
			     //Add the input string to the tree
				 root.add(inputString);
			}
		}
		return count;
	}
	

}
