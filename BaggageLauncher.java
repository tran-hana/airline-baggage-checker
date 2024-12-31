/* Declaration: This is my original work and has not been plagiarized
 *	Assessment: Assignment 02
 * Student Name: Ha Nhu Y Tran
 * StudentNumber: 041165059
 * Lab Professor: James Mwangi Phd.
 * Lab section: CST 8116-331
 * Due Date: Jul 26 2024
 */

/* Class: BaggageLauncher
 * This class contain main method for the application
 */
public class BaggageLauncher {

	/*
	 * Entry point for the application The program will prompt the user to input the
	 * dimensions (length x width x height) and weight of the baggage. The program
	 * produces the message describing the properties of the baggage and informing
	 * user if the baggage is over-sized or overweight with applied surcharge fee,
	 * or is a carry-on.The user will be able to have multiple entries of baggage
	 * data until they choose to exit the program. If they want to stop,the program
	 * will output the message of the number of valid baggage and the total weight
	 * and informing that the program is terminated, along with programmer's name.
	 */

	public static void main(String[] args) {
		String finalReport;
		String shouldContinueInput;
		int validBaggage = 0;
		double totalWeight = 0;
		int length;
		int width;
		int height;
		double weight;

		System.out.println("Welcome to Baggage Handler Software Program");

		do {
			// Prompt user to input the length of baggage
			length = InputData.validateInt("Enter the length of the baggage (in cm): ");

			// Prompt user to input the width of baggage
			width = InputData.validateInt("Enter the width of the baggage (in cm): ");

			// Prompt user to input the height of baggage
			height = InputData.validateInt("Enter the height of the baggage (in cm): ");

			// Prompt user to input the weight of baggage
			weight = InputData.validateDouble("Enter the weight of the baggage (in kg): ");

			// Calling 4-argument constructor to instantiate a new baggage object
			Baggage baggage = new Baggage(length, width, height, weight);

			// if the sum of length, width, height of baggage object  greater than MAX_SUM_DIMENSIONS is true
			if (BaggageChecker.sumDimensionsExceedsMax(baggage)) { 
				System.out.println("This is oversized; it is not acceptable."); 
			} 
			else {

				totalWeight += baggage.getWeight(); // Summing the weight of valid baggage that are entered
				validBaggage++;// Counting the number of valid baggage

				/*
				 * Call method toString to describe data held within the baggage object and
				 * result of checking baggage dimensions and weight
				 */
				finalReport = baggage.toString();

				System.out.println(finalReport); // output finalReport

			}

			// Prompt user to answer if they want to continue//
			shouldContinueInput = InputData
					.validateString("\nDo you wish to continue? Enter 'No' to quit, anything else to continue: ");
		}

		// Exit the loop if user chooses to stop by answering 'no' case-insensitive//
		while (!shouldContinueInput.equalsIgnoreCase("no"));

		// Output the total number of valid bags//
		System.out.println("The total number of valid bags entered was: " + validBaggage);

		/*
		 * Output the total weight that were entered, formatted to two decimal places
		 */
		System.out.printf("The total weight entered was: %.2f kg%n", totalWeight);
		System.out.println("The program has terminated.");
		System.out.println("Program by Ha Nhu Y Tran");

	}
}
