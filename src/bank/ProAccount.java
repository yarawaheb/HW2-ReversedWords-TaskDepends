package bank;

public class ProAccount extends Account{
	private int[] moves;
	
	public ProAccount(String name) {
		super(name);
		moves=new int[0];
	}
	//In this method we add to the moves array the amount after every change
	@Override
	public void add(int amount) {
		super.add(amount);
		int[] b = new int[moves.length +1];
		for (int i=0; i<moves.length; i++)
		    b[i] = moves[i];
		moves = b;
		moves[moves.length-1]=super.getShekels();
	}
	
	@Override
	public String toString() {
		String s="[";
		for(int i=0;i<moves.length;i++)
			s+=moves[i]+",";
		s=s.substring(0, s.length()-1);
		s+="]";
		return super.toString()+" "+s;
	}
	
    public static void transfer(ProAccount from, ProAccount to, int amount) {
	from.add(-amount);
	to.add(amount);
    }

}
