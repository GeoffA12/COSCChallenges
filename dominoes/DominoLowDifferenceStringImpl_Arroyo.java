package dominoes;
import java.util.*;

public class DominoLowDifferenceStringImpl_Arroyo implements Domino{
	private String lowDifferenceString;
	private static final char LOW_DIFFERENCE_DELIMITER = '*';
	public static final int lowIndex = 0;
	public static final int delimiterIndex = 1;
	public static final int differenceIndex = 2;
	public static final Set<Integer> validInputsForLowPlus8TimesHigh = new HashSet<>(Arrays.asList(0, 8, 16, 24, 32, 40, 48, 9, 17, 25, 33, 41, 49, 18, 26, 34, 42, 50, 27, 35, 43, 51, 36, 44, 52, 45, 53, 54));
	
	public static final int INDEX_OF_HIGH = 0;
	public static final int INDEX_OF_SUM = 1;
	public static final int MAX_SUM = 12;
	public static final int MIN_SUM = 0;
	
	/* One argument constructor for the DominoLowDifferenceStringImpl class. 
	 * The constructor will receive an integer as its only parameter. The integer sent 
	 * By the client should be a value which is represented by a the high pip count of a domino 
	 * times 8, and then add the low pip count to get the value. In other terms, in the constructor, 
	 * we must determine whether or not the integer represents a valid low and high pip count of a 
	 * domino instance based on the formula k = (high * 8) + low. 
	 * Once we know the integer passed in is a valid integer based on our internal representations,
	 * we can use math to figure out the high and low pip counts of the instance.
	 * */
	
	public DominoLowDifferenceStringImpl_Arroyo(int lowPlus8TimesHigh) {
		assert isLowPlus8TimesHighInteger(lowPlus8TimesHigh);
		int lowPip = lowPlus8TimesHigh % 8;
		int highPip = (lowPlus8TimesHigh - lowPip) / 8;
		int difference = highPip - lowPip;
		lowDifferenceString = intToString(lowPip) + LOW_DIFFERENCE_DELIMITER + intToString(difference);
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
	
	// Helper method used to convert a character in the instance variable string
	// lowDifferenceString to a digit. 
	public static int charToDigit(char c) {
        int convertedChar = c - '0';
        return convertedChar;
    }
	
	// Helper method used to convert an integer into a string for formatting purposes. 
	public static String intToString(int k) {
		return Integer.toString(k);
	}
	
	/* One argument constructor for the DominoLowDifferenceStringImpl_Arroyo class.
	 * The constructor receives a List instance from the user. Based on preconditions, 
	 * the list will have two integer elements. The first element will represent the
	 * high pip count of the instance the user wants. The second integer in the list 
	 * represents the sum of high and low pip counts that the user wants. 
	 * This constructor will use the data inside the list to construct a lowDifferenceString
	 * instance variable. 
	 * */ 
	public DominoLowDifferenceStringImpl_Arroyo(List<Integer> highSum) {
		assert isHighSumList(highSum);
		int highPip = highSum.get(INDEX_OF_HIGH);
		int sum = highSum.get(INDEX_OF_SUM);
		int lowPip = sum - highPip;
		int difference = highPip - lowPip;
		if (difference >= 0) {
			lowDifferenceString = intToString(lowPip) + LOW_DIFFERENCE_DELIMITER + intToString(difference);
		}
		// The list which was passed in was a valid set, but no domino instance can be constructed 
		// Based on the relationship between our client-facing and internal representations
		else {
			throw new RuntimeException("I can't construct a domino with your list.");
		}
	}
	
	/* Static boolean method which will check and see if the list sent in the highSum list
	 * constructor is a valid set based on constructor preconditions. 
	 *  Return true if the list is a valid format, false if not a valid format.  
	 *  */
	public static boolean isHighSumList(List<Integer> aList) {
		boolean validList = true;
		
		if (aList.size() == 2) {
			int potentialHigh = aList.get(INDEX_OF_HIGH);
			int potentialSum = aList.get(INDEX_OF_SUM);
			if (potentialHigh > MAXIMUM_PIP_COUNT || potentialHigh < MINIMUM_PIP_COUNT) {
				validList = false;
			}
			else if (potentialSum < MIN_SUM || potentialSum > MAX_SUM) {
				validList = false;
			}
			else if (potentialHigh > potentialSum) {
				validList = false;
			}
		}
		else {
			validList = false;
		}
		return validList;
	}
	
	// Getter for highPipCount attribute of the Domino interface
	public int getHighPipCount() {
		return charToDigit(lowDifferenceString.charAt(lowIndex)) + charToDigit(lowDifferenceString.charAt(differenceIndex));
	}
	
	// Getter for the lowPipCount field of the domino interface
	public int getLowPipCount() {
		return charToDigit(lowDifferenceString.charAt(lowIndex));
	}

}
