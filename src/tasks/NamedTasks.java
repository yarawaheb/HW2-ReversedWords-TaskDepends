package tasks;

public class NamedTasks extends Tasks {
	private String[] names;

	public NamedTasks(String[] names) {
		super(names.length);
		this.names=new String[names.length];
		for(int i=0;i<names.length;i++)
			this.names[i]=names[i];
	}
	
	public boolean dependsOn(String task1, String task2) {
		int indexT1=-1,indexT2=-1;
		for(int i=0;i<names.length;i++) {
			if(names[i].equals(task1))indexT1=i;
			if(names[i].equals(task2))indexT2=i;
		}
		if(indexT1==-1||indexT2==-1)return false;
		return super.dependsOn(indexT1, indexT2);
	}

	public String[] nameOrder() {
		String[] newOrdNames = new String[names.length];
		int[] newOrdIndex = new int[names.length];
		newOrdIndex=super.order();
		for(int i=0;i<names.length;i++)
			newOrdNames[i]=names[newOrdIndex[i]];
		return newOrdNames;
	}

}
