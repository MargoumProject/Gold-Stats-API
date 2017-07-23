package com.n26.controllers;

import javax.ws.rs.core.Response;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.n26.StatsApiApplication;
import com.n26.config.Configs;
import com.n26.model.Transaction;
import com.n26.utils.TimeUtils;
/**
 * 
 * @author Wael
 *
 */
@RestController
@RequestMapping(value="/transactions")
public class TransactionService 
{	
	/**
	 * Returns SUCCESS or FAILURE based on the received transaction
	 * A transaction is composed of a timestamp and the amount of the transaction
	 * The method checks if for the same timestamp, it has already reveived a transaction. In that case, the new amount will
	 * be added to the old one and the previous record's amount will be updated.
	 * In the other case, a new transaction will be stored.  
	 * @param amount transaction amount
	 * @param timestamp transaction time in epoch in millis in UTC time zone (this is not current timestamp)
	 * @return 201: SUCCESS - 204: FAILURE
	 */
	@RequestMapping(value="/",method = RequestMethod.POST)
	public Response acceptTransaction(@RequestParam(value="amount") 	double amount
		      						 ,@RequestParam(value="timestamp") 	long timestamp) 
	{
		if (TimeUtils.isTimestampAcceptable(timestamp)) 
		{
			/**
			 * Check if there is already any stored transaction with the same TIMESTAMP in the DB 
			 */
			if(StatsApiApplication.getTransactions().containsKey(timestamp))
			{
				double oldAmount = StatsApiApplication.getTransactions().get(timestamp).getAmount();
				StatsApiApplication.getTransactions().put(
										timestamp, 
										new Transaction(oldAmount + amount, timestamp));
			}else
			{
				StatsApiApplication.getTransactions().put(
										timestamp, 
										new Transaction(amount, timestamp));
		   	}
			return Response.status(Configs.TRANSACTION_SUCCESS).build();
		}
		return Response.status(Configs.TRANSACTION_FAILURE).build();
	}
}