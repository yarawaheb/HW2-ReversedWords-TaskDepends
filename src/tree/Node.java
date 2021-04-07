package tree;

public class Node {
	
	private int count;
	
	private Node[] children;
	
	public Node()
	{
		count = 0;
		
		children = new Node[26];
	}
	
	public int num(String s)
	{
		if(s.equals("") )
			return count;
		
		int index = s.charAt(0) - 'a';
		
		//If no string is present return 0
		if(children[index] == null)
		   return 0;
		
		s = s.substring(1);
		
		//call the next children in the string
		return children[index].num(s);
	}
	
	public void add(String s)
	{
	  //Stop when you get empty string	
      if(s.equals(""))
    	  return;
      
      char tmpChar = s.charAt(0);
       
      int index = tmpChar - 'a';
      // Case it is the first add new instance
      if(children[index] == null)
      {
    	    children[index] = new Node();
    	    //If the string len is 1 add to the count 
    	    if(s.length() == 1)
    	    	children[index].count++;
      }
      else
      {
    	  //Whe you reach to the end of the string add 1 to the count
    	  if(s.length() == 1)
    		  children[index].count++;
      }
      
      s = s.substring(1);
      
      children[index].add(s);
	}
		
}
