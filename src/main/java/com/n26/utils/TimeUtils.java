package com.n26.utils;
/**
 * 
 * @author Wael
 *
 */
public class TimeUtils 
{
	public static final long ONE_SECOND_IN_MILLIS = 1000;
	public static final long ONE_MINUTE_IN_MILLIS = 60 * ONE_SECOND_IN_MILLIS;
	
	/**
	 * Returns True if the provided timestamp is not older that 60 seconds. False otherwise.
	 * @param timestamp the time that the method should test
	 * @return The final decision (Could that time be accepted or not)
	 */
	public static boolean isTimestampAcceptable(long timestamp)
	{
		long timeAcceptanceThreshold = getTimeAcceptanceThreshold();
		if (timestamp > timeAcceptanceThreshold) 
		{
			return true;
		}
		return false;
	}
	
	/**
	 * Calculate the time before 60 seconds from Now.
	 * @return the time time 60 seconds earlier
	 */
	public static long getTimeAcceptanceThreshold()
	{
		return System.currentTimeMillis() - ONE_MINUTE_IN_MILLIS;
	}
}
