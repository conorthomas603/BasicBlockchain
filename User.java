package blockchain;

public class User {

	private String name;
	private String acctNum;
	private double balance;
	
	//Create new user on blockchain
	public User(String name, String acctNum, double balance) {
		super();
		this.name = name;
		this.acctNum = acctNum;
		this.balance = balance;
	}
	
	public void addCash(double amt)
	{
		this.balance += amt;
	}
	
	public void subCash(double amt)
	{
		if (amt > this.balance) {
			throw new RuntimeException("Insufficient Funds");
		} else {
			this.balance -= amt;
		}
		
	}
	public User getUser(String acctNum) {
		return this;
	}
	
	public String getName() {
		return name;
	}
	private void setName(String name) {
		this.name = name;
	}
	public String getAcctNum() {
		return acctNum;
	}
	private void setAcctNum(String acctNum) {
		this.acctNum = acctNum;
	}
	public double getBalance() {
		return balance;
	}
	private void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", acctNum=" + acctNum + ", balance=" + balance + "]";
	}
	
	
}
