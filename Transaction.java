package blockchain;

import java.util.List;

public class Transaction {

	public User payer;
	public User payee;
	private double transAmt;

	public Transaction(User payer1, User payee1, double amt) {
		this.payer = payer1;
		this.payee = payee1;
		this.transAmt = amt;
		transfer();
	}
	
	public void transfer() {
		payer.subCash(transAmt);
		payer.addCash(transAmt);
	}
	
	public User getPayer() {
		return payer;
	}

	public User getPayee() {
		return payee;
	}

	public double getTransAmt() {
		return transAmt;
	}

	@Override
	public String toString() {
		return "Transaction [payer=" + payer + ", payee=" + payee + ", transAmt=" + transAmt + "]";
	}
	
	
}
