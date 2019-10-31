package dominoes;
import java.util.*;
public class DominoHighLowImpl_Arroyo implements Domino{

	private int highPipCount;
    private int lowPipCount;

    public static final char HIGH_LOW_STRING_SEPARATOR = ':';

    public static final int INDEX_OF_SUM = 0;
    public static final int INDEX_OF_DIFFERENCE = 1;
    public static final int MAX_SUM = 12;
    
    /* Two argument constructor for the DominoHighLowSetImpl_Arroyo class. The two 
	 * arguments are both integers. The two integers represent the high and low pip counts
	 * of the domino instance the user wants. For instance, a call of new DominoHighLowSetImpl_Arroyo
	 * with arguments (4, 2) would return a new domino instance with instance variable of 
	 * highPipCount as 4 and lowPipCount as 2. 
	 * We must set high and low pip count instance variables based on our internal representation*/
    public DominoHighLowImpl_Arroyo(int highPipCount, int lowPipCount) {
        assert isValidPipCounts(highPipCount, lowPipCount);
        this.highPipCount = highPipCount;
        this.lowPipCount = lowPipCount;
    }
    
    /* One argument constructor for the DominoHighLowImpl_Arroyo class. The one
	 * argument passed in is a string. The string passed in by user represents a string
	 * of the high pip count digit character, followed by the constant high low string separator character
	 *  , followed by the low pip digit character of the domino instance the user wants.
	 *  For instance,("6:0") would return a domino instance with a highPipCount of 6 and a lowPipCount of 0.
	 *  */
    public DominoHighLowImpl_Arroyo(String highLowString) {
        assert isHighLowString(highLowString);
        highPipCount = charToDigit(highLowString.charAt(0));
        lowPipCount = charToDigit(highLowString.charAt(2));
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
    /* Static helper method which will check whether or not the string sent by the user
     * is within the client-facing table for the highLowString constructor. This method 
     * converts the string into a character array and checks each of the string preconditions
     * for our constructor. The method will check the string length, if the string has a correctly
     * placed delimiter character, and if digits inside the string are within a valid range.
     */
    public static boolean isHighLowString(String str) {
    	boolean isValidString;
        if (str != null && str.length() == 3) {
        	char[] charArray = str.toCharArray();
        	char potentialHighChar = charArray[0];
            char potentialSeparator = charArray[1];
            char potentialLowChar = charArray[2];
            if (potentialSeparator != HIGH_LOW_STRING_SEPARATOR) {
            	isValidString = false;
            }
            else if (!isValidPipCounts(charToDigit(potentialHighChar), charToDigit(potentialLowChar))) {
            	isValidString = false;
            }
            else {
                isValidString = true;
            }
        }
        else {
        	isValidString = false;
        }
        return isValidString;
    }
    
    // Helper method used for converting characters inside of strings to integers or digits. 
    public static int charToDigit(char c) {
        int convertedChar = c - '0';
        return convertedChar;
    }

    /*One argument constructor for the DominoHighLow_Impl class. This constructor will
     * take an integer array as its only argument. The integer array should have two elements. 
     * The first element represents the sum of the high and low pip counts that the user 
     * wants back. The second element in the array represents the difference between the
     * high and low pipcounts that the user wants to get back. This constructor will 
     * set the high and low pip instance variables based on the data inside the array. 
     */
    public DominoHighLowImpl_Arroyo(int[] sumDifference) {
    	assert (isValidSumDifferenceArray(sumDifference));
        int sum = sumDifference[INDEX_OF_SUM];
        int difference = sumDifference[INDEX_OF_DIFFERENCE];
       
        int potentialHigh = (sum + Math.abs(difference)) / 2;
        int potentialLow = (sum - Math.abs(difference)) / 2;
        assert(isValidPipCounts(potentialHigh, potentialLow));
        highPipCount = potentialHigh;
        lowPipCount = potentialLow;
    }
    
    /* Static helper method which is used to check whether or not the sumDifference array
     * in the sumDifference constructor is a valid array based on our client-facing representation
     * of the class. This method will check the array length, check if the sum and difference
     * elements are within a valid range of values, and check if the sum is >= the difference.
     * Return true if the array is valid, else return false.
     */
    public static boolean isValidSumDifferenceArray(int[] array) {
    	boolean isValidArray = true;
    	if (array != null && array.length == 2) {
    		int potentialSum = array[INDEX_OF_SUM]; 
    		int potentialDifference = array[INDEX_OF_DIFFERENCE];
    		if (!isValidSumAndDifference(potentialSum, potentialDifference)) {
    			isValidArray = false;
    		}
    	}
    	else {
    		isValidArray = false;
    	}
    	return isValidArray;
    }
    
    public static boolean isValidSumAndDifference(int s, int d) {
    	boolean validSumAndDif = true;
    	if (s > MAXIMUM_PIP_COUNT + MAXIMUM_PIP_COUNT || s < MINIMUM_PIP_COUNT + MINIMUM_PIP_COUNT) {
    		validSumAndDif = false;
    	}
    	else if (d > MAXIMUM_PIP_COUNT - MINIMUM_PIP_COUNT || d < 0) {
    		validSumAndDif = false;
    	}
    	else if (d > s) {
    		validSumAndDif = false;
    	}
    	return validSumAndDif;
    }

    /* One argument constructor for the DominoHighLow_Impl class. This constructor
     * will take a set instance as its only argument. This set must be either of size 1
     *  or 2 and can't contain null according to the preconditions. If the set is of size 1,
     *  then the only element represents the high and low pip counts. If the set is of size 2,
     *  then the high and low pip counts aren't the same number, but are both still represented as \
     *  elements inside the set. This constructor will set the high and low pip counts instance 
     *  variables according to the elements placed into the set. 
     *  */
    public DominoHighLowImpl_Arroyo(Set<Integer> highLowSet) {
    	assert isHighLowSet(highLowSet);
        int highPip = Collections.max(highLowSet);
        int lowPip = Collections.min(highLowSet);
        highPipCount = highPip;
        lowPipCount = lowPip;
    }
    
    /* Static helper method which will determine if the set passed into the highLowSet
     * constructor is a valid set according to the client-facing representation. 
     * This method will check the set's size, and if each element in the set is within 
     * the valid pip count range set by the Domino interface. 
     * If the set is a valid set, return true. Otherwise, return false. 
     */
    public static boolean isHighLowSet(Set<Integer> aSet) {
    	boolean isValidSet = true;
    	if (aSet != null && !aSet.contains(null) && (aSet.size() == 2 || aSet.size() == 1)) {
    		int potentialHighPip = Collections.max(aSet);
    		int potentialLowPip = Collections.min(aSet);
    		if (!isValidPipCounts(potentialHighPip, potentialLowPip)) {
    			isValidSet = false;
    		}
    	}
    	else {
    		isValidSet = false;
    	}
    	return isValidSet;
    }
    
 // Getter for highPipCount attribute of the Domino interface
    public int getHighPipCount() {
        return highPipCount;
    }

 // Getter for the lowPipCount field of the domino interface
    public int getLowPipCount() {
        return lowPipCount;
    }

}
