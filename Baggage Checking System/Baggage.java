/* Declaration: This is my original work and has not been plagiarized
 *	Assessment: Assignment 02
 * Student Name: Ha Nhu Y Tran
 * StudentNumber: 041165059
 * Lab Professor: James Mwangi Phd.
 * Lab section: CST 8116-331
 * Due Date: Jul 26 2024
 */

/* Class: Baggage
 * This class models a baggage with attributes of length, width, height in cm,
 *  and weight in kg. 
 */
public class Baggage {

	private static final int DEFAULT_LENGTH = 65; // Default length is 65 cm
	private static final int DEFAULT_WIDTH = 25; // Default width is 25 cm
	private static final int DEFAULT_HEIGHT = 50; // Default height is 50 cm
	private static final double DEFAULT_WEIGHT = 10.0; // Default weight is 10.0 kg

	private int length; // The length of baggage is measured in cm//
	private int width; // The width of baggage is measured in cm//
	private int height;// The height of baggage is measured in cm//
	private double weight; // The weight of baggage is measured in kg//

	/*
	 * No-argument constructor with default values of 65 cm (the length), 25 cm (the
	 * width), 50 cm (the height), and a weight of 10.0 kg
	 * chained to the 4-argument constructor
	 */
	public Baggage() {
		this(DEFAULT_LENGTH, DEFAULT_WIDTH, DEFAULT_HEIGHT, DEFAULT_WEIGHT);
		}

	/*
	 * Four-argument constructor with listed parameters ( length, width, height, weight)
	 */
	public Baggage(int length, int width, int height, double weight) {
		this.length = length;
		this.width = width;
		this.height = height;
		this.weight = weight;
	}

	/*
	 * Accessor for length. The returned value is in cm
	 */
	public int getLength() {
		return length;
	}

	/*
	 * Mutator for length. The passed value is in cm
	 */
	public void setLength(int length) {
		this.length = length;
	}

	/*
	 * Accessor for width. The returned value is in cm
	 */
	public int getWidth() {
		return width;
	}

	/*
	 * Mutator for width. The passed value is in cm
	 */
	public void setwidth(int width) {
		this.width = width;
	}

	/*
	 * Accessor for height. The returned value is in cm
	 */
	public int getHeight() {
		return height;
	}

	/*
	 * Mutator for height. The passed value is in cm
	 */
	public void setHeight(int height) {
		this.height = height;
	}


	/*
	 * Accessor for weight. The returned value is in kg
	 */
	public double getWeight() {
		return weight;
	}
	/*
	 * Mutator for weight. The passed value is in kg
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}

	/*
	 * This method creates a String to summarize the data held within the object and
	 * evaluate whether the baggage is overweight (surcharge is applied) or can
	 * be used as carry on by calling other static worker methods:
	 * allowedWeightIsMoreThanMax(), calculateWeightSurcharge(),
	 * canBeUsedAsACarryOn() from the class Baggage. Using method String.format to
	 * format the decimal places. Details: length formatted to decimal integer,
	 * followed by 'cm' and a comma; width formatted to decimal integer, followed by 'cm' 
	 * and a comma; height formatted to decimal integer, followed by
	 * 'cm' and a comma;  weight formatted to two decimal followed by 'kg'
	 */

	public String toString() {

		String report = String.format("This bag has length %d cm, width %d cm, height %d cm, and weight %.2f kg.",
				length, width, height, weight);

		if (BaggageChecker.canBeUsedAsACarryOn(this)) { // if length and width and height less than MAX_CARRYON_DIMENSION is true//
			report = report + String.format("\nThis bag can be used as a carry on.");
		}

		if (BaggageChecker.allowedWeightIsMoreThanMax(this)) { // if weight is greater than MAX_REGULAR_WEIGHT is true //
			report = report + String.format(
					"\nThis bag is overweight; it exceeds the allowed weight of %.2f kg. A surcharge of $%.2f applies.",
					BaggageChecker.MAX_REGULAR_WEIGHT, BaggageChecker.calculateWeightSurcharge(this));
		}

		return report;

	}

}
