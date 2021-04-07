package tasks;


public class Tasks {
 private int[] ord;
 private int maxIndex;
 
 public Tasks(int num) {
	 ord=new int[num];
	 for(int i=0;i<ord.length;i++)
		 ord[i]=-1;
	 maxIndex=0;
 }
 
 public boolean dependsOn(int task1, int task2) {
	 if(task1 >= ord.length ||task1 < 0 || task2 >= ord.length ||task2 < 0)
		 return false;
	 ord[task1]=task2;
	 return true;
 }
 
 //keys for this method :
 //   -1 -> this task does'nt depends on another task
 //   -2 -> this task is already written
 public int[] order() {
	 int[] newOrder=new int[ord.length];
	 int countMoves,j=0,k;
	 for(int i=0;i<ord.length;i++) {
		 j=i;
		 while(ord[j]!=-2) {
			 i=j;
		     countMoves=0;
		     while(ord[i]!=-1 && countMoves<ord.length) { 
			    k=i;
			    i=ord[i];
			    countMoves++;
			    if(ord[i]==-2) {
				  i=k;
				  ord[i]=-1;
			    }
		      }
		      if(countMoves>=ord.length)return null;
		      if(ord[i]==-1) {
			     newOrder[maxIndex++]=i; 
			     ord[i]=-2;
		      }
	     	 i=j;
	       }
	 }
	 return newOrder;
 }

}
