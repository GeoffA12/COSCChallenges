package dominoes;
import java.util.*;

public class DominoHighLowSetImpl_Arroyo implements Domino{
	
	private Set<Integer> highLowSet;
	public static final char SUM_DIFFERENCE_DELIMITER = ',';
	public static final int MAX_SUM = 12;
	
	/* Two argument constructor for the DominoHighLowSetImpl_Arroyo class. The two 
	 * arguments are both integers. The two integers represent the high and low pip counts
	 * of the domino instance the user wants. For instance, a call of new DominoHighLowSetImpl_Arroyo
	 * with arguments (4, 2) would return a new domino instance with instance variable of 
	 * highPipCount as 4 and lowPipCount as 2. We must use a fill a set with high and 
	 * low pip values based on our internal representation.
	 * */
	public DominoHighLowSetImpl_Arroyo(int highPipCount, int lowPipCount) {
		// Test the input from the user to make sure the two integers passed in are within 
		// the client-facing table for this constructor.
        if (checkPipCountRange(highPipCount) && checkPipCountRange(lowPipCount) && highPipCount >= lowPipCount) {
        	highLowSet = new HashSet<>(Arrays.asList(highPipCount, lowPipCount));
        }
        // We received a valid combination of integers, but we can't form a domino instance
        // based on our client-facing and internal tables. 
        else {
        	throw new RuntimeException("I can't represent a domino with your integers.");
        }
	}
	
	/* One argument constructor for the DominoHighLowSetImpl_Arroyo class. The one
	 * argument passed in is a string. The string passed in by user represents a string
	 * of the sum digit of high pip count plus low pip count, followed by a constant
	 *  sum_difference delimiter character, followed by the difference digit between
	 *  the high and low pip count of the domino instance the user wants. For instance,
	 *  ("6:0") would return a domino instance with a highPipCount of 3 and a lowPipCount of 3.
	 *  */
	public DominoHighLowSetImpl_Arroyo(String sumDifferenceString) {
		assert isSumDifferenceString(sumDifferenceString);
		int highPip;
		int lowPip;
		// The high and low pip count calculations will be different depending on the length
		// of the string passed in (sum could be 1 or 2 characters based on preconditions).
		if (sumDifferenceString.length() == 4) {
			highPip = (Integer.parseInt(sumDifferenceString.substring(0, 2)) + charToDigit(sumDifferenceString.charAt(3))) / 2;
			lowPip = (Integer.parseInt(sumDifferenceString.substring(0, 2)) - charToDigit(sumDifferenceString.charAt(3))) / 2;
		}
		else {
			highPip = (charToDigit(sumDifferenceString.charAt(0)) + charToDigit(sumDifferenceString.charAt(2))) / 2;
			lowPip = (charToDigit(sumDifferenceString.charAt(0)) - charToDigit(sumDifferenceString.charAt(2))) / 2;
		}
		
		// At this point, the user has sent in a valid string. However, we're not sure if we can 
		// construct an instance yet. We need to check preconditions to see if user has violated
		// still. 
		if (checkPipCountRange(highPip) && checkPipCountRange(lowPip) && highPip >= lowPip) {
			highLowSet = new HashSet<>(Arrays.asList(highPip, lowPip));
		}
		else {
			throw new RuntimeException("I Can't represent a domino with your string.");
		}
	}
	
	/* Helper method which will check to see if the user has violated preconditions on
	* string formatting for the sumDifferenceString constructor.
	* The method will check string lengths, number format exceptions, null pointer exceptions,
	* and ranges of the sum and difference digits in the string. T
	* One of Two paths of testing will be taken depending on the length of the string, assuming
	* that it's either 3 or 4 characters.
	*/
	public static boolean isSumDifferenceString(String str) {
		boolean validString = true; 
		if (str.length() != 4 && str.length() != 3) {
			validString = false;
		}
		int potentialSum;
		int potentialDifference;
		if (str.length() == 4) {
			if (!isValidSumDifferenceStringLength4Sum(str)) {
				validString = false;
			}
		}
		else if (str.length() == 3){
			if (!isValidSumDifferenceStringLength3(str)) {
				validString = false;
			}
		}
		
		if (validString) {
			if (str.length() == 4) {
				potentialSum = Integer.parseInt(str.substring(0, 2), 10);
				potentialDifference = charToDigit(str.charAt(3));
			}
			else {
				potentialSum = charToDigit(str.charAt(0));
				potentialDifference = charToDigit(str.charAt(2));
			}
			if (potentialSum < potentialDifference) {
				validString = false;
			}
		}
		return validString;
	}
	
	// Helper method which checks digit range for sum and difference in a length 3 string
	public static boolean isValidSumDifferenceStringLength3(String str) {
		int potentialSum = charToDigit(str.charAt(0));
		int potentialDifference = charToDigit(str.charAt(2));
		char potentialDelimiter = str.charAt(1);
		boolean rv = true;
		if (!checkIntSumRange(potentialSum)) {
			rv = false;
		}
		else if (!checkIntDifferenceRange(potentialDifference)) {
			rv = false;
		}
		else if (potentialDelimiter != SUM_DIFFERENCE_DELIMITER) {
			rv = false;
		}
		return rv;
	}
	
	// Helper method which checks digit range for sum and difference in a length 4 string
	public static boolean isValidSumDifferenceStringLength4Sum(String str) {
		boolean rv = true;
		int potentialSum;
		if (str.charAt(2) == SUM_DIFFERENCE_DELIMITER) {
			try {
				Integer.parseInt(str.substring(0, 2), 10);
			}
			catch (NumberFormatException | NullPointerException npe) {
				rv = false;
			}
			if (rv) {
				potentialSum = Integer.parseInt(str.substring(0, 2), 10);
				if (!checkIntSumRange(potentialSum)) {
					rv = false;
				}
				else if (!checkIntDifferenceRange(charToDigit(str.charAt(3)))) {
					rv = false;
				}
			}
		}
		else {
			rv = false;
		}
		return rv;
		
	}
	
	// Helper method which checks to see if an integer is within the valid sum range.
	// Based on preconditions, sum must be between 12 and 0 to return true. 
	public static boolean checkIntSumRange(int i) {
		return (i <= MAX_SUM && i >= MINIMUM_PIP_COUNT);
	}
	
	// Helper method which checks to see if an integer is within the valid difference range.
	// Based on preconditions, sum must be between 6 and 0 to return true
	public static boolean checkIntDifferenceRange(int i) {
		return (i <= MAXIMUM_PIP_COUNT && i >= MINIMUM_PIP_COUNT);
	}
	
	public static boolean checkDelimiterChar(char c) {
		return c == SUM_DIFFERENCE_DELIMITER;
	}
	
	// Helper method which checks to see if an integer is within the valid pipCount range.
	// Based on preconditions, pipCount must be between 6 and 0 to return true
	public static boolean checkPipCountRange(int k) {
		return k <= MAXIMUM_PIP_COUNT && k >= MINIMUM_PIP_COUNT;
	}
	
	public static int charToDigit(char c) {
        int convertedChar = c - '0';
        return convertedChar;
    }
	
	public static final Set<Integer> validInputsForLowPlus8TimesHigh = new HashSet<>(Arrays.asList(0, 8, 16, 24, 32, 40, 48, 9, 17, 25, 33, 41, 49, 18, 26, 34, 42, 50, 27, 35, 43, 51, 36, 44, 52, 45, 53, 54));
	/* One argument constructor  which takes in an integer from user. The integer passed in
	 * represents a value which is 8 times the high pip count plus the low pip count of 
	 * the domino instance the user wants to receive. 
	 * In other terms, in the constructor, 
	 * we must determine whether or not the integer represents a valid low and high pip count of a 
	 * domino instance based on the formula k = (high * 8) + low. 
	 * Once we know the integer passed in is a valid integer based on our internal representations,
	 * we can use math to figure out the high and low pip counts of the instance.
	 *  */
	public DominoHighLowSetImpl_Arroyo(int lowPlus8TimesHigh) {
		assert isLowPlus8TimesHighInteger(lowPlus8TimesHigh);
		int lowPip = lowPlus8TimesHigh % 8;
		int highPip = (lowPlus8TimesHigh - lowPip) / 8;
		highLowSet = new HashSet<>(Arrays.asList(highPip, lowPip));
	}
	
	/* Static boolean method which will check and determine whether or not the integer 
	 * passed into the int lowPlus8TimesHigh constructor is a valid integer.
	 * This method uses a constant validInputs set which stores each of the valid client 
	 * facing integers which can be sent into our constructor to form a domino instance. 
	 * If the set contains the integer received in the constructor, then return true.
	 * Otherwise, return false. 
	 * */
	public static boolean isLowPlus8TimesHighInteger(int k) {
		return validInputsForLowPlus8TimesHigh.contains(k);
	}
	
	// Getter for highPipCount attribute of the Domino interface
	public int getHighPipCount() {
		return Collections.max(highLowSet);
	}

	// Getter for the lowPipCount field of the domino interface
	public int getLowPipCount() {
		return Collections.min(highLowSet);
	}

}

