package com.n26.utils;
/**
 * 
 * @author Wael
 *
 */
public class CompareUtils 
{
	/**
	 * Returns the Maximun value of the provided parameters
	 * @param x first element of comparison
	 * @param y second element of comparison
	 * @return returns the max from X and Y
	 */
	public static double getMax(double x, double y)
	{
		if (x > y) {
			return x;
		}
		return y;
	}
	
	/**
	 * Returns the Minimum value of the provided parameters
	 * @param x first element of comparison
	 * @param y second element of comparison
	 * @return returns the min from X and Y
	 */
	public static double getMin(double x, double y)
	{
		if (x < y) {
			return x;
		}
		return y;
	}
}
