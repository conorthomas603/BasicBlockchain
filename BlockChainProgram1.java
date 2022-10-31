package blockchain;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//enum CurrencyType {USD, EUR, JPY, GBP, AUD, CAD, CHF, CNH, HKD, NZD};

public class BlockChainProgram1 {

	
	public static void main(String[] args) throws FileNotFoundException {

		//Master User List
		List<User> userMasterList = new ArrayList<User>();
		//Master Block List
		ArrayList<Block> blockChain = new ArrayList<Block>();
		//BaseBlock
		Block base;
		
	    File text = new File("/Users/user/Documents/Blockcode/BlockchainInput.csv");
	     
        //Creating Scanner instance to read File in Java
        Scanner scnr = new Scanner(text);
     
        //Reading each line of the file using Scanner class
        int lineNumber = 1;
        while(scnr.hasNextLine()){
        	//scan in line
            String line = scnr.nextLine();
            //csv parsing into tokens
            String[] token = line.split(",");
            
            //if first token is createUser, then create new User and add to master list of all users
            if (token[0].equals("createUser")) {
            	User user = new User(token[2], token[1], Double.valueOf(token[3]));
            	System.out.println("New user: " + user.getName()  + " : " + user.getAcctNum() + " : " + user.getBalance());
            	userMasterList.add(user);
            }
            else if (token[0].equals("transaction")) {
            	//Prints master list
            	for (User user: userMasterList) {
            		System.out.println(user.toString() + " ");
            	}
            	
            	//Real fun begins: get CSV transaction items
            	Transaction trans = new Transaction(findUser(token[1], userMasterList), findUser(token[2], userMasterList), Double.valueOf(token[3]));
            	if (blockChain.size() == 0) {
            		base = new Block(trans, 0, CurrencyType.USD);
            		blockChain.add(base);
            	} else {
            		Block b = new Block(trans, blockChain.get(blockChain.size() - 1).getBlockHash(), CurrencyType.USD);
            		blockChain.add(b);
            	}
            } 
            lineNumber++;
         }
            
//            System.out.println("user: " + user  + " :" + line);      
//		ArrayList<Block> blockChain = new ArrayList<Block>();
//		
//		//FirstBlock
//		String[] initialValues = {"55667788 has 160000.10", "11223344 has 6000.00"};
//		Block firstBlock = new Block(initialValues, 0, CurrencyType.USD);
//		blockChain.add(firstBlock);
//		System.out.println("First Block is " + firstBlock.toString());
//		System.out.println("The block chain is " + blockChain.toString());
        for (Block b: blockChain) {
    		System.out.println(b.toString() + " ");
    	}

		//close scanner 
		scnr.close();

	}
	
	public static User findUser(String acctNum, List<User> userList) {
		
		for (User user: userList) {
			if (user.getAcctNum().equals(acctNum)) {
				return user;
			}
		}
		return null;
		
	}

}
