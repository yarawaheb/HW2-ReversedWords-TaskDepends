package game;

import java.util.Scanner;

public class Game extends Board{
	
	protected Player[] players;
	
	protected Scanner s;
	
	public Game(int n, int m, Player p1, Player p2)
	{
		super(n,m);
		
		players = new Player[2];
		
		players[0] = p1;
		
		players[1] = p2;
		
		s = new Scanner(System.in);
	}
	
	private int readInt()
	{
		while(!s.hasNextInt())
		{
			s.hasNext();
		}
		
		return s.nextInt();
	}
	
	protected boolean doesWin(int i, int j)
	{		
		return ((i == 0) && (j == 0));	
	}
	
	
	protected boolean onePlay(Player p)
	{
		System.out.println(p+", "+ "please enter x and y:");
		int i = readInt();
		int j = readInt();
		
		if (false == set(i,j,p))
		{
			System.out.println("There is a piece there already ... \n");
			return onePlay(p);
		}
		return doesWin(i,j);
		
	}

	public Player play()
	{
		int pl = 0;
		while(true)
		{
			if(onePlay(players[pl]) == true)
			{
				System.out.println(super.toString());
				System.out.println("\r\n");
				return players[pl];
			}
			else
			{
				System.out.println(super.toString());
				pl = (pl==0) ? 1 : 0;
			}
		}
	}
	
}
