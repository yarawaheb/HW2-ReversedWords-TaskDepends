package bank;

public class Account {
 private int amount;
 private String name;
 
public Account(String name) {
	this.name=name;
	amount=0;
}
public int getShekels() {
	return amount;
}
public String getName() {
	return name;
}
public void add(int amount) {
	this.amount+=amount;
}
public String toString() {
	return name+" has "+amount+" shekels";
}
}
