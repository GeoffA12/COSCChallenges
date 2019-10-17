package dominoes;
import java.util.*;
public class DominoHighLowImpl_Arroyo implements Domino{

	private int highPipCount;
    private int lowPipCount;

    public static final char HIGH_LOW_STRING_SEPARATOR = ':';

    public static final int INDEX_OF_SUM = 0;
    public static final int INDEX_OF_DIFFERENCE = 1;
    public static final int MAX_SUM = 12;
    public DominoHighLowImpl_Arroyo(int highPipCount, int lowPipCount) {
        assert highPipCount >= lowPipCount;
        assert highPipCount <= MAXIMUM_PIP_COUNT;
        assert lowPipCount <= MAXIMUM_PIP_COUNT;
        assert highPipCount >= MINIMUM_PIP_COUNT;
        assert lowPipCount >= MINIMUM_PIP_COUNT;
        this.highPipCount = highPipCount;
        this.lowPipCount = lowPipCount;
    }

    public DominoHighLowImpl_Arroyo(String highLowString) {
        assert isHighLowString(highLowString);
        char firstDigit = highLowString.charAt(0);
        char secondDigit = highLowString.charAt(2);
        highPipCount = charToDigit(firstDigit);
        lowPipCount = charToDigit(secondDigit);
    }

    public static boolean isHighLowString(String str) {
    	boolean isValidString;
    	char[] charArray = str.toCharArray();
        if (charArray.length != 3) {
            isValidString = false;
            return isValidString;
        }
        char firstChar = charArray[0];
        char potentialSeparator = charArray[1];
        char secondChar = charArray[2];
        if (potentialSeparator != HIGH_LOW_STRING_SEPARATOR) {
            isValidString = false;
        }
        else if (charToDigit(firstChar) > MAXIMUM_PIP_COUNT || charToDigit(firstChar) < MINIMUM_PIP_COUNT) {
            isValidString = false;
        }
        else if (charToDigit(secondChar) > MAXIMUM_PIP_COUNT || charToDigit(secondChar) < MINIMUM_PIP_COUNT) {
            isValidString = false;
        }
        else if (charToDigit(secondChar) > charToDigit(firstChar)) {
            isValidString = false;
        }
        else {
            isValidString = true;
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
    	assert isSumDifferenceArray(sumDifference);
        int sum = sumDifference[INDEX_OF_SUM]; int difference = sumDifference[INDEX_OF_DIFFERENCE];
        highPipCount = (sum + difference) / 2;
        lowPipCount = (sum - difference) / 2;
    }
    
    public static boolean isSumDifferenceArray(int[] array) {
    	boolean isValidArray = true;
    	if (array.length != 2) {
    		isValidArray = false;
    	}
    	else {
    		int sum = array[INDEX_OF_SUM]; int difference = array[INDEX_OF_DIFFERENCE];
    		if (sum > MAX_SUM || sum < MINIMUM_PIP_COUNT) {
    			isValidArray = false;
    		}
    		else if (difference > MAXIMUM_PIP_COUNT || difference < MINIMUM_PIP_COUNT) {
    			isValidArray = false;
    		}
    		else if (difference > sum) {
    			isValidArray = false;
    		}
    	}
    	return isValidArray;
    }

    // Pre-condition: 1 <= highLowSet.size() <= 2
    // Pre-condition: !highLowSet.contains(null)
    public DominoHighLowImpl_Arroyo(Set<Integer> highLowSet) {
    	assert isHighLowSet(highLowSet);
        int highPip = Collections.max(highLowSet);
        int lowPip = Collections.min(highLowSet);
        highPipCount = highPip;
        lowPipCount = lowPip;

    }
    
    public static boolean isHighLowSet(Set<Integer> aSet) {
    	boolean isValidSet = true;
    	if (aSet.size() < 1 || aSet.size() > 2) {
    		isValidSet = false;
    	}
        else {
        	for (Integer i : aSet) {
        		if (i > MAXIMUM_PIP_COUNT || i < MINIMUM_PIP_COUNT) {
        			isValidSet = false;
        		}
            }
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
