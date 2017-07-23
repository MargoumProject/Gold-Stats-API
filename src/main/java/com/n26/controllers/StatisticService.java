package com.n26.controllers;

import javax.ws.rs.Produces;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.n26.StatsApiApplication;
import com.n26.model.Result;
import com.n26.utils.CompareUtils;
import com.n26.utils.TimeUtils;
/**
 * 
 * @author Wael
 *
 */
@RestController
@RequestMapping(value="/statistics")
public class StatisticService 
{
	/**
	 * returns the statistic based on the transactions which happened in the last 60 seconds.
	 * @return JSON response containing five elements of the statistics: SUM, AVG, MAX, MIN, COUNT.
	 */
	@RequestMapping(value="/",method = RequestMethod.GET)
	@Produces("application/json")
	public Result getAllStudents()
	{
		Result result = processStats();
		return result;
	}
	
	private Result processStats() 
	{
		final int LOOP_UNROLL_COUNT 			= 10;
		final int INSTRUCTIONS_PER_LOOP_CYCLE 	= 6;
		
		double sum = 0;
		double avg = 0;
		double max = 0;
		double min = Double.MAX_VALUE;
		long count = 0;
		
		long timeAcceptanceThreshold = TimeUtils.getTimeAcceptanceThreshold();
		for (int i = 0; i < LOOP_UNROLL_COUNT; i++) 
		{
			long timestamp_0 = timeAcceptanceThreshold + i * INSTRUCTIONS_PER_LOOP_CYCLE 	;
			long timestamp_1 = timeAcceptanceThreshold + i * INSTRUCTIONS_PER_LOOP_CYCLE + 1;
			long timestamp_2 = timeAcceptanceThreshold + i * INSTRUCTIONS_PER_LOOP_CYCLE + 2;
			long timestamp_3 = timeAcceptanceThreshold + i * INSTRUCTIONS_PER_LOOP_CYCLE + 3;
			long timestamp_4 = timeAcceptanceThreshold + i * INSTRUCTIONS_PER_LOOP_CYCLE + 4;
			long timestamp_5 = timeAcceptanceThreshold + i * INSTRUCTIONS_PER_LOOP_CYCLE + 5;
			long timestamp_6 = timeAcceptanceThreshold + i * INSTRUCTIONS_PER_LOOP_CYCLE + 6;
			
			if(StatsApiApplication.getTransactions().containsKey(timestamp_0))
			{
				sum    += StatsApiApplication.getTransactions().get(timestamp_0).getAmount();
				avg    += StatsApiApplication.getTransactions().get(timestamp_0).getAmount();
				max 	= CompareUtils.getMax(max, StatsApiApplication.getTransactions().get(timestamp_0).getAmount());
				min 	= CompareUtils.getMin(min, StatsApiApplication.getTransactions().get(timestamp_0).getAmount());
				count  += 1;
			}
			if(StatsApiApplication.getTransactions().containsKey(timestamp_1))
			{
				sum    += StatsApiApplication.getTransactions().get(timestamp_1).getAmount();
				avg    += StatsApiApplication.getTransactions().get(timestamp_1).getAmount();
				max 	= CompareUtils.getMax(max, StatsApiApplication.getTransactions().get(timestamp_1).getAmount());
				min 	= CompareUtils.getMin(min, StatsApiApplication.getTransactions().get(timestamp_1).getAmount());
				count  += 1;
			}
			if(StatsApiApplication.getTransactions().containsKey(timestamp_2))
			{
				sum    += StatsApiApplication.getTransactions().get(timestamp_2).getAmount();
				avg    += StatsApiApplication.getTransactions().get(timestamp_2).getAmount();
				max 	= CompareUtils.getMax(max, StatsApiApplication.getTransactions().get(timestamp_2).getAmount());
				min 	= CompareUtils.getMin(min, StatsApiApplication.getTransactions().get(timestamp_2).getAmount());
				count  += 1;
			}
			if(StatsApiApplication.getTransactions().containsKey(timestamp_3))
			{
				sum    += StatsApiApplication.getTransactions().get(timestamp_3).getAmount();
				avg    += StatsApiApplication.getTransactions().get(timestamp_3).getAmount();
				max 	= CompareUtils.getMax(max, StatsApiApplication.getTransactions().get(timestamp_3).getAmount());
				min 	= CompareUtils.getMin(min, StatsApiApplication.getTransactions().get(timestamp_3).getAmount());
				count  += 1;
			}
			if(StatsApiApplication.getTransactions().containsKey(timestamp_4))
			{
				sum    += StatsApiApplication.getTransactions().get(timestamp_4).getAmount();
				avg    += StatsApiApplication.getTransactions().get(timestamp_4).getAmount();
				max 	= CompareUtils.getMax(max, StatsApiApplication.getTransactions().get(timestamp_4).getAmount());
				min 	= CompareUtils.getMin(min, StatsApiApplication.getTransactions().get(timestamp_4).getAmount());
				count  += 1;
			}
			if(StatsApiApplication.getTransactions().containsKey(timestamp_5))
			{
				sum    += StatsApiApplication.getTransactions().get(timestamp_5).getAmount();
				avg    += StatsApiApplication.getTransactions().get(timestamp_5).getAmount();
				max 	= CompareUtils.getMax(max, StatsApiApplication.getTransactions().get(timestamp_5).getAmount());
				min 	= CompareUtils.getMin(min, StatsApiApplication.getTransactions().get(timestamp_5).getAmount());
				count  += 1;
			}
			if(StatsApiApplication.getTransactions().containsKey(timestamp_6))
			{
				sum    += StatsApiApplication.getTransactions().get(timestamp_6).getAmount();
				avg    += StatsApiApplication.getTransactions().get(timestamp_6).getAmount();
				max 	= CompareUtils.getMax(max, StatsApiApplication.getTransactions().get(timestamp_6).getAmount());
				min 	= CompareUtils.getMin(min, StatsApiApplication.getTransactions().get(timestamp_6).getAmount());
				count  += 1;
			}
		}
		if (count != 0) avg = avg / count;
		if (min == Double.MAX_VALUE) min = -1;
		return new Result(sum, avg, max, min, count);
	}
}
