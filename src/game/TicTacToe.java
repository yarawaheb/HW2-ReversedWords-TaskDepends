package game;

public class TicTacToe  extends Game {
	
	public TicTacToe(String player1, String player2)
	{
		super(3,3,new Player(player1,'X'), new Player(player2,'O'));
	}
	
	@Override 
	protected boolean doesWin(int x, int y)
	{
		boolean res;
		res = (super.maxLineContaining(x, y) == 3) ? true : false;
		
		return res;
	}

}
