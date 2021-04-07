package game;

public class FourInARow extends Game{
	
	public FourInARow(String player1, String player2)
	{
		super(6,7, new Player(player1,'W'), new Player(player2, 'B'));
			
	}
	
	@Override 
	protected boolean doesWin(int i, int j)
	{
		boolean res;
		res = (super.maxLineContaining(i, j) == 4) ? true : false;
		
		return res;
	}
	
	
	private int FindNextRow(int column)
	{
		int nextRow = n-1;
		while(nextRow >= 0)
		{
			if(board[nextRow][column] == null)
				return nextRow;
			else
				nextRow--;
		}
		
		return nextRow;
	}
	
	private int readColumn()
	{
		while(!s.hasNextInt())
		{
			s.hasNext();
		}
		
		return s.nextInt();
	}
	

	@Override
	protected boolean onePlay(Player p)
	{
		int column; 
		
		System.out.println(p+", "+"please eneter column:");
		
		column = readColumn();
		
	    int row = FindNextRow(column);
	    if(row < 0 )
	    {
	    	return onePlay(p);	
		}
	    else
	    {
	    	set(row,column, p);
	    }
		
		return doesWin(row, column);
	}
		
}
