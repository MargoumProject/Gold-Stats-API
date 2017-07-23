package com.n26.model;
/**
 * 
 * @author Wael
 *
 */

public class Transaction 
{
	private long 	id;
	private double 	amount;
	private long 	timestamp;
	
	public Transaction() {
	}
	
	public Transaction(double amount, long timestamp) {
		this.id			= timestamp;
		this.amount 	= amount;
		this.timestamp 	= timestamp;
	}

	public long getId() {
		return id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	
	@Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", amount='" + amount + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}
