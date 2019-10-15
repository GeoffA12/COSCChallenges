package dominoes;
import java.util.*;

public class DominoHighLowSetImpl_Arroyo implements Domino{
	
	private Set<Integer> highLowSet;
	public static final char SUM_DIFFERENCE_DELIMITER = ',';
	public static final int MAX_SUM = 12;
	public DominoHighLowSetImpl_Arroyo(int highPipCount, int lowPipCount) {
		assert highPipCount >= lowPipCount;
        assert highPipCount <= MAXIMUM_PIP_COUNT;
        assert lowPipCount <= MAXIMUM_PIP_COUNT;
        assert highPipCount >= MINIMUM_PIP_COUNT;
        assert lowPipCount >= MINIMUM_PIP_COUNT;
        highLowSet = new HashSet<>(Arrays.asList(highPipCount, lowPipCount));
	}
	
	public DominoHighLowSetImpl_Arroyo(String sumDifferenceString) {
		assert isSumDifferenceString(sumDifferenceString);
		int highPip;
		int lowPip;
		if (sumDifferenceString.length() == 4) {
			highPip = Integer.parseInt(sumDifferenceString.substring(0, 2));
			lowPip = charToDigit(sumDifferenceString.charAt(3));
		}
		else {
			highPip = charToDigit(sumDifferenceString.charAt(0));
			lowPip = charToDigit(sumDifferenceString.charAt(2));
		}
		
		highLowSet = new HashSet<>(Arrays.asList(highPip, lowPip));
	}
	
	public static boolean isSumDifferenceString(String str) {
		if (str.length() != 4 && str.length() != 3) {
			return false;
		}
		boolean validString = true;
		int potentialSum;
		int potentialDifference;
		char[] strCharArray = str.toCharArray();
		if (str.length() == 4) {
			if (!checkDelimiterChar(strCharArray[2])) {
				validString = false;
			}
			potentialSum = Integer.parseInt(str.substring(0, 2));
			if (!checkIntSumRange(potentialSum)) {
				validString = false;
			}
			potentialDifference = charToDigit(strCharArray[strCharArray.length - 1]);
			if (!checkIntDifferenceRange(potentialDifference)) {
				validString = false;
			}
			else if (potentialSum < potentialDifference) {
				validString = false;
			}
		}
		else {
			if (!checkDelimiterChar(strCharArray[1])) {
				validString = false;
			}
			potentialSum = charToDigit(strCharArray[0]);
			if (!checkIntSumRange(potentialSum)) {
				validString = false;
			}
			potentialDifference = charToDigit(strCharArray[2]);
			if (!checkIntDifferenceRange(potentialDifference)) {
				validString = false;
			}
			else if (potentialSum < potentialDifference) {
				validString = false;
			}
		}
		return validString;
	}
	
	public static boolean checkIntSumRange(int i) {
		return (i <= MAX_SUM && i >= 0);
	}
	
	public static boolean checkIntDifferenceRange(int i) {
		return (i <= MAXIMUM_PIP_COUNT && i >= 0);
	}
	
	public static boolean checkDelimiterChar (char c) {
		return c == SUM_DIFFERENCE_DELIMITER;
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
