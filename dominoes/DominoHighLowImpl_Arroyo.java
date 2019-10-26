package dominoes;
import java.util.*;
public class DominoHighLowImpl_Arroyo implements Domino{

private int highPipCount;
    private int lowPipCount;

    public static final char HIGH_LOW_STRING_SEPARATOR = ':';

    public static final int INDEX_OF_SUM = 0;
    public static final int INDEX_OF_DIFFERENCE = 1;

    public DominoHighLowImpl_Arroyo(int highPipCount, int lowPipCount) {
        assert isValidPipCounts(highPipCount, lowPipCount);
        this.highPipCount = highPipCount;
        this.lowPipCount = lowPipCount;
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
    
    public DominoHighLowImpl_Arroyo(String highLowString) {
        assert isHighLowString(highLowString);
        char firstDigit = highLowString.charAt(0);
        char secondDigit = highLowString.charAt(2);
        this.highPipCount = charToDigit(firstDigit);
        this.lowPipCount = charToDigit(secondDigit);
    }

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

    public static int charToDigit(char c) {
        int convertedChar = c - '0';
        return convertedChar;
    }

    // Pre-condition: sumDifference.length == 2
    // Pre-condition: sumDifference[INDEX_OF_SUM] >= sumDifference[INDEX_OF_DIFFERENCE]
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
    
    // Pre-condition: 1 <= highLowSet.size() <= 2
    // Pre-condition: !highLowSet.contains(null)
    public DominoHighLowImpl_Arroyo(Set<Integer> highLowSet) {
    	assert isValidHighLowSet(highLowSet);
        int highPip = Collections.max(highLowSet);
        int lowPip = Collections.min(highLowSet);
        this.highPipCount = highPip;
        this.lowPipCount = lowPip;

    }
    
    // Make sure you test the null set here. 
    public static boolean isValidHighLowSet(Set<Integer> aSet) {
    	boolean isValidSet = true;
    	if (!aSet.isEmpty() && (aSet.size() == 2 || aSet.size() == 1)) {
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
    
    public int getHighPipCount() {
        return highPipCount;
    }

    public int getLowPipCount() {
        return lowPipCount;
    }


}
