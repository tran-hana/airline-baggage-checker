/* Declaration: This is my original work and has not been plagiarized
 *	Assessment: Assignment 02
 * Student Name: Ha Nhu Y Tran
 * StudentNumber: 041165059
 * Lab Professor: James Mwangi Phd.
 * Lab section: CST 8116-331
 * Due Date: Jul 26 2024
 */

/* Class: BaggageChecker
 * This class consists of four static methods to check the baggage size and weight.
 * Method 1: to check if the baggage has a weight greater 
 * than a maximum permissible regular weight of 22.0 kg; 
 * Method 2: to calculate a surcharge for each kg that is above the maximum allowed regular weight;
 * Method 3: to check if the baggage can be used as a carry-on
 * Method 4: to check if the sum of baggage's dimension is greater than the maximum sum 
 * of dimension of 192 cm.
 *
 */

public class BaggageChecker {

	/*
	 * Constant variable MAX_REGULAR_WEIGHT, measured in 'kg'
	 */
	public static final double MAX_REGULAR_WEIGHT = 22.0;

	/*
	 * Constant variable SURCHARGE_PER_KG, unit is '$'
	 */
	public static final double SURCHARGE_PER_KG = 3.00;

	/*
	 * Constant variable MAX_CARRYON_DIMENSION, measured is 'cm'
	 */
	public static final int MAX_CARRYON_DIMENSION = 36;

	/*
	 * Constant variable MAX_SUM_DIMENSIONS, measured is 'cm'
	 */
	public static final int MAX_SUM_DIMENSIONS = 192;

	/*
	 * This methods taking Baggage object as parameter, returns true if the baggage
	 * weight surpasses MAX_REGULAR_WEIGHT, otherwise false
	 */
	public static boolean allowedWeightIsMoreThanMax(Baggage baggage) {
		return baggage.getWeight() > MAX_REGULAR_WEIGHT;
	}

	/*
	 * This methods taking Baggage object as parameter. This calculates the surcharge
	 * fee if the baggage weight is greater than MAX_REGULAR_WEIGHT; 
	 * surcharge calculated by multiplying SURCHARGE_PER_KG by 
	 * the number of kg above the MAX_REGULAR_WEIGHT 
	 */
	public static double calculateWeightSurcharge(Baggage baggage) {
		if (allowedWeightIsMoreThanMax(baggage)) {
			double overweight = baggage.getWeight() - MAX_REGULAR_WEIGHT;
			return overweight * SURCHARGE_PER_KG;
		} else {
			return 0;
		}
	}

	/*
	 * This methods taking Baggage object as parameter.This returns true if length
	 * and width and weight is less than MAX_CARRYON_DIMENSION otherwise returns
	 * false
	 */
	public static boolean canBeUsedAsACarryOn(Baggage baggage) {
		return baggage.getLength() < MAX_CARRYON_DIMENSION && baggage.getWidth() < MAX_CARRYON_DIMENSION
				&& baggage.getHeight() < MAX_CARRYON_DIMENSION;
	}

	/*
	 * This methods taking Baggage object as parameter.This returns true if sum of
	 * length, width and height is greater than MAX_SUM_DIMENSIONS otherwise returns
	 * false
	 */
	public static boolean sumDimensionsExceedsMax(Baggage baggage) {
		int dimensionSum = baggage.getLength() + baggage.getWidth() + baggage.getHeight();
		return dimensionSum > MAX_SUM_DIMENSIONS;
	}
}
