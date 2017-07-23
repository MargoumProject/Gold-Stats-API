package com.n26;

import java.util.HashMap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.n26.model.Transaction;
/**
 * 
 * @author Wael
 *
 */
@SpringBootApplication
public class StatsApiApplication {

	/**
	 * The Hashmap will store all the incoming transactions
	 */
	private static HashMap<Long,Transaction> hmTransactions;
	
	public static void main(String[] args) {
	
		hmTransactions = new HashMap<Long,Transaction>();
 
		SpringApplication.run(StatsApiApplication.class, args);
	}
	
	/**
	 * Returns an instance of the Transactions database
	 * @return list of the stored Transactions
	 */
	public static HashMap<Long,Transaction> getTransactions(){
		return hmTransactions;
	}
}
