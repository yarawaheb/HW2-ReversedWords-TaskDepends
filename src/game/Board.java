package game;

public class Board {
   protected Player[][] board;
   protected int n,m;
   private int countFull;

   public Board(int n, int m) {
	   countFull=0;
	   this.n=n;
	   this.m=m;
	   board=new Player[n][m];
   }
   protected boolean set(int i, int j, Player p) {
	   if(!isEmpty(i, j))return false;
	   board[i][j]=p;
	   countFull++;
	   return true;
   }
   public boolean isEmpty(int i, int j) {
	   if(board[i][j]==null)return true;
	   return false;
   }
   public Player get(int i, int j) {
	   if (isEmpty(i, j))return null;
	   return board[i][j];
   }
   public boolean isFull() {
	   if(countFull==(n*m))return true;
	   return false;
   }
   public String toString() {
	   String s=new String();
	   for(int i=0;i<n;i++) {
		   
		   for(int j=0;j<m;j++) {
			   if(isEmpty(i, j))s+=".";
			   else s+= get(i, j).getMark();
		   }
		   s+="\n";
	   }
	   return s;
   }
   private int search(int i, int j, String dir, Player p)
   {
   int count = 0;
   switch(dir)
   {
    case "East" :
    {
    if(j > (m - 1))
    return count;
    
    if(board[i][j] == null)
    return count;
    
    if((board[i][j].getMark() != p.getMark()))
    return count;
    
    count += 1 + search(i,j+1,dir, p);
    }
    break;
    
    case "West" :
    {
    if(j < 0)
    return count;
    
    if(board[i][j] == null)
    return count;
    
    if(board[i][j].getMark() != p.getMark())
    return count;
    
    count += 1 + search(i,j-1,dir, p);
    }
        break;
        
    case "North" :
    {
    if( i < 0)
    return count;
    
    if(board[i][j] == null)
    return count;
    
    if(board[i][j].getMark() != p.getMark())
    return count;
    count += 1 + search(i-1,j,dir, p);
    }
        break;
        
    case "South" :
    {
    if( i > (n - 1))
    return count;
    
    if(board[i][j] == null)
    return count;
    
    if(board[i][j].getMark() != p.getMark())
    return count;
    
   count += 1 + search(i+1,j,dir, p);
    }
        break;
        
    case "SouthEast" :
    {
    if( (i > (n - 1)) || ( j > (m -1 )))
    return count;
    
    if(board[i][j] == null)
    return count;
    
    if(board[i][j].getMark() != p.getMark())
    return count;
    
    count += 1 + search(i+1, j+1, dir, p);
    }
    break;
    
    case "SouthWest" :
    {
    if( (i > (n - 1)) || ( j < 0) )
      return count;
    
    if(board[i][j] == null)
    return count;
    
    if(board[i][j].getMark() != p.getMark())
    return count;
    
    count += 1 + search(i+1, j-1, dir, p);
    }
    break;
    
    case "NorthEast" :
    {
    if( (i < 0) || ( j > (m -1 ) ))
      return count;
    
    if(board[i][j] == null)
    return count;
    
    if(board[i][j].getMark() != p.getMark())
    return count;
    
    count += 1 + search(i-1, j+1, dir, p);
    }
    break;
    
    case "NorthWest" :
    {
    if( (i < 0) || ( j < 0 ))
      return count;
    
    if(board[i][j] == null)
    return count;
    
    if(board[i][j].getMark() != p.getMark())
    return count;
    
    count += 1 + search(i-1, j-1, dir, p);
    }
    break;
    
   }

   return count;
   }

  protected int maxLineContaining(int i, int j)
				{
					int res = 0;
					
					int max = -1;
					
					res = search(i,j,"East", board[i][j]);
					max = (res > max ) ? res : max;
					
					res += search(i,j,"West", board[i][j]);
					max = (res > max ) ? res : max;
					
					res = search(i,j,"North", board[i][j]);
					max = (res > max ) ? res : max;
					
					res += search(i,j,"South", board[i][j]);
					max = (res > max ) ? res : max;
					
					res = search(i,j,"SouthEast", board[i][j]);
					max = (res > max ) ? res : max;				
					
					res += search(i,j,"NorthWest", board[i][j]);
					max = (res > max ) ? res : max;
					
					res = search(i,j,"SouthWest", board[i][j]);
					max = (res > max ) ? res : max;
					
					res += search(i,j,"NorthEast", board[i][j]);
					max = (res > max ) ? res : max;
				
					
					return max-1;
		}


/*   
   public static void main(String[] args) {
   Player p1 = new Player("Bibi", 'B');
   Player p2 = new Player("Gantz", 'G');
   Board b = new Board(3,4);
   b.set(0, 0, p1);
   b.set(1, 0, p1);
   b.set(2, 2, p2);
   b.set(0, 0, p2);
   b.set(0, 1, p1);
   System.out.print(b+"\n");
System.out.println(b.maxLineContaining(1, 0));
System.out.println(b.maxLineContaining(2, 2));
   }*/
}
