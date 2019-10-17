package dominoes;
import java.util.*;

public class DominoHighLowSetImpl_Arroyo implements Domino{
	
	private Set<Integer> highLowSet;
	public static final char SUM_DIFFERENCE_DELIMITER = ',';
	public static final int MAX_SUM = 12;
	public DominoHighLowSetImpl_Arroyo(int highPipCount, int lowPipCount) {
        if (checkPipCountRange(highPipCount) && checkPipCountRange(lowPipCount) && highPipCount >= lowPipCount) {
        	highLowSet = new HashSet<>(Arrays.asList(highPipCount, lowPipCount));
        }
        else {
        	throw new RuntimeException("I can't represent a domino with your integers.");
        }
	}
	
	public DominoHighLowSetImpl_Arroyo(String sumDifferenceString) {
		assert isSumDifferenceString(sumDifferenceString);
		int highPip;
		int lowPip;
		if (sumDifferenceString.length() == 4) {
			highPip = (Integer.parseInt(sumDifferenceString.substring(0, 2)) + charToDigit(sumDifferenceString.charAt(3))) / 2;
			lowPip = (Integer.parseInt(sumDifferenceString.substring(0, 2)) - charToDigit(sumDifferenceString.charAt(3))) / 2;
		}
		else {
			highPip = (charToDigit(sumDifferenceString.charAt(0)) + charToDigit(sumDifferenceString.charAt(2))) / 2;
			lowPip = (charToDigit(sumDifferenceString.charAt(0)) - charToDigit(sumDifferenceString.charAt(2))) / 2;
		}
		
		if (checkPipCountRange(highPip) && checkPipCountRange(lowPip) && highPip >= lowPip) {
			highLowSet = new HashSet<>(Arrays.asList(highPip, lowPip));
		}
		else {
			throw new RuntimeException("I Can't represent a domino with your string.");
		}
	}
	
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
		else {
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
	
	
	public static boolean checkIntSumRange(int i) {
		return (i <= MAX_SUM && i >= MINIMUM_PIP_COUNT);
	}
	
	public static boolean checkIntDifferenceRange(int i) {
		return (i <= MAXIMUM_PIP_COUNT && i >= MINIMUM_PIP_COUNT);
	}
	
	public static boolean checkDelimiterChar(char c) {
		return c == SUM_DIFFERENCE_DELIMITER;
	}
	
	public static boolean checkPipCountRange(int k) {
		return k <= MAXIMUM_PIP_COUNT && k >= MINIMUM_PIP_COUNT;
	}
	public static int charToDigit(char c) {
        int convertedChar = c - '0';
        return convertedChar;
    }
	public static final Set<Integer> validInputsForLowPlus8TimesHigh = new HashSet<>(Arrays.asList(0, 8, 16, 24, 32, 40, 48, 9, 17, 25, 33, 41, 49, 18, 26, 34, 42, 50, 27, 35, 43, 51, 36, 44, 52, 45, 53, 54));
	public DominoHighLowSetImpl_Arroyo(int lowPlus8TimesHigh) {
		assert isLowPlus8TimesHighInteger(lowPlus8TimesHigh);
		int lowPip = lowPlus8TimesHigh % 8;
		int highPip = (lowPlus8TimesHigh - lowPip) / 8;
		highLowSet = new HashSet<>(Arrays.asList(highPip, lowPip));
	}
	
	public static boolean isLowPlus8TimesHighInteger(int k) {
		return validInputsForLowPlus8TimesHigh.contains(k);
	}
	
	public int getHighPipCount() {
		return Collections.max(highLowSet);
	}

	
	public int getLowPipCount() {
		return Collections.min(highLowSet);
	}

}
