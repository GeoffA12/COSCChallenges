package dominoes;
import java.util.*;

public class DominoLowDifferenceStringImpl_Arroyo implements Domino{
	private String lowDifferenceString;
	private static final char LOW_DIFFERENCE_DELIMITER = '*';
	public static final int lowIndex = 0;
	public static final int delimiterIndex = 1;
	public static final int differenceIndex = 2;
	
	
	public static final int INDEX_OF_HIGH = 0;
	public static final int INDEX_OF_SUM = 1;
	
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
		int potentialLowPip = lowPlus8TimesHigh % 8;
		int potentialHighPip = (lowPlus8TimesHigh - potentialLowPip) / 8;
		int difference = potentialHighPip - potentialLowPip;
		assert isValidPipCounts(potentialHighPip, potentialLowPip);
		lowDifferenceString = intToString(potentialLowPip) + LOW_DIFFERENCE_DELIMITER + intToString(difference);
	}
	
	public static boolean isValidPipCounts(int potentialHigh, int potentialLow) {
    	boolean isValidPips = true;
    	if (potentialHigh > MAXIMUM_PIP_COUNT || potentialHigh < MINIMUM_PIP_COUNT) {
    		isValidPips = false;
    	}
    	else if (potentialLow > MAXIMUM_PIP_COUNT || potentialLow < MINIMUM_PIP_COUNT) {
    		isValidPips = false;
    	}
    	else if (potentialLow > potentialHigh) {
    		isValidPips = false;
    	}
    	return isValidPips;
    }
	
	/* Static boolean method which will check and determine whether or not the integer 
	 * passed into the int lowPlus8TimesHigh constructor is a valid integer.
	 * This method uses a constant validInputs set which stores each of the valid client 
	 * facing integers which can be sent into our constructor to form a domino instance. 
	 * If the set contains the integer received in the constructor, then return true.
	 * Otherwise, return false. 
	 * */
	public static boolean isLowPlus8TimesHighInteger(int k) {
		boolean wasFound = false;
		for (int x = MINIMUM_PIP_COUNT; x <= MAXIMUM_PIP_COUNT; ++x) {
			for (int y = x; y <= MAXIMUM_PIP_COUNT; ++y) {
				int check = x + (y * 8);
				if (k == check) {
					wasFound = true;
				}
			}
		}
		return wasFound;
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
		assert isValidPipCounts(highPip, lowPip);
		lowDifferenceString = intToString(lowPip) + LOW_DIFFERENCE_DELIMITER + intToString(difference);
	}
	
	/* Static boolean method which will check and see if the list sent in the highSum list
	 * constructor is a valid set based on constructor preconditions. 
	 *  Return true if the list is a valid format, false if not a valid format.  
	 *  */
	public static boolean isHighSumList(List<Integer> aList) {
		boolean validList = true;
		
		if (aList != null && !aList.contains(null) && aList.size() == 2) {
			int potentialHigh = aList.get(INDEX_OF_HIGH);
			int potentialSum = aList.get(INDEX_OF_SUM);
			if (potentialHigh > MAXIMUM_PIP_COUNT || potentialHigh < MINIMUM_PIP_COUNT) {
				validList = false;
			}
			else if (!checkSumRange(potentialSum)) {
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
	
	public static boolean checkSumRange(int s) {
		return (s <= MAXIMUM_PIP_COUNT + MAXIMUM_PIP_COUNT && s >= MINIMUM_PIP_COUNT + MINIMUM_PIP_COUNT);
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
