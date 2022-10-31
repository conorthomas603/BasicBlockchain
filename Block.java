package blockchain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//Top 10 msot traded world currencies
enum CurrencyType {USD, EUR, JPY, GBP, AUD, CAD, CHF, CNH, HKD, NZD};

public class Block {

	private Transaction transactions;
	private int blockHash; 
	private int previousBlockHash;
	private List<User> users;
	private CurrencyType TransactionCur;

	
	public Block(Transaction txn, int previousBlockHash, CurrencyType cur) {
		super();
		this.transactions = txn;
		this.previousBlockHash = previousBlockHash;
		this.blockHash = Arrays.hashCode(new int[] { transactions.toString().hashCode() , this.previousBlockHash});
//		this.users = userList;
		this.TransactionCur = cur;
	}

	@Override
	public String toString() {
		return "Block [transactions=" + transactions.toString() + ", blockHash=" + blockHash
				+ ", previousBlockHash=" + previousBlockHash + ", users=" + users + ", TransactionCur=" + TransactionCur
				+ "]";
	}

	public Transaction getTransactions() {
		return transactions;
	}

	public int getBlockHash() {
		return blockHash;
	}

	public int getPreviousBlockHash() {
		return previousBlockHash;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public CurrencyType getTransactionCur() {
		return TransactionCur;
	}

	public void setTransactionCur(CurrencyType transactionCur) {
		TransactionCur = transactionCur;
	}
	
	
}
