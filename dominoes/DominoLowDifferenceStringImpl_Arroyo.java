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
	
	public DominoLowDifferenceStringImpl_Arroyo(int lowPlus8TimesHigh) {
		assert isLowPlus8TimesHighInteger(lowPlus8TimesHigh);
		int lowPip = lowPlus8TimesHigh % 8;
		int highPip = (lowPlus8TimesHigh - lowPip) / 8;
		int difference = highPip - lowPip;
		lowDifferenceString = intToString(lowPip) + LOW_DIFFERENCE_DELIMITER + intToString(difference);
	}
	
	public static boolean isLowPlus8TimesHighInteger(int k) {
		return validInputsForLowPlus8TimesHigh.contains(k);
	}
	
	public static int charToDigit(char c) {
        int convertedChar = c - '0';
        return convertedChar;
    }
	
	public static String intToString(int k) {
		return Integer.toString(k);
	}
	
	public DominoLowDifferenceStringImpl_Arroyo(List<Integer> highSum) {
		assert isHighSumList(highSum);
		int highPip = highSum.get(INDEX_OF_HIGH);
		int sum = highSum.get(INDEX_OF_SUM);
		int lowPip = sum - highPip;
		int difference = highPip - lowPip;
		if (difference >= 0) {
			lowDifferenceString = intToString(lowPip) + LOW_DIFFERENCE_DELIMITER + intToString(difference);
		}
		else {
			throw new RuntimeException("I can't construct a domino with your list.");
		}
	}
	
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
	
	public int getHighPipCount() {
		return charToDigit(lowDifferenceString.charAt(lowIndex)) + charToDigit(lowDifferenceString.charAt(differenceIndex));
	}

	public int getLowPipCount() {
		return charToDigit(lowDifferenceString.charAt(lowIndex));
	}

}
