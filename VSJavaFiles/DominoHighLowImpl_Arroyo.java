import java.util.*;

public class DominoHighLowImpl_Arroyo implements Domino {
    private int highPipCount;
    private int lowPipCount;

    public static final char HIGH_LOW_STRING_SEPARATOR = ':';

    public static final int INDEX_OF_SUM = 0;
    public static final int INDEX_OF_DIFFERENCE = 1;

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
        this.highPipCount = charToDigit(firstDigit);
        this.lowPipCount = charToDigit(secondDigit);
    }

    public static boolean isHighLowString(String str) {
        char[] charArray = str.toCharArray();
        boolean isValidString;
        char firstChar = charArray[0];
        char potentialSeparator = charArray[1];
        char secondChar = charArray[2];
        if (charArray.length != 3) {
            isValidString = false;
        }
        else if (potentialSeparator != HIGH_LOW_STRING_SEPARATOR) {
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
        int sum = sumDifference[INDEX_OF_SUM]; int difference = sumDifference[INDEX_OF_DIFFERENCE];
        final int MAX_SUM = 12;
        assert sum <= MAX_SUM;
        assert difference <= MAXIMUM_PIP_COUNT;
        assert sum >= MINIMUM_PIP_COUNT;
        assert difference >= MINIMUM_PIP_COUNT;
        this.highPipCount = (sum + difference) / 2;
        this.lowPipCount = (sum - difference) / 2;
    }

    // Pre-condition: 1 <= highLowSet.size() <= 2
    // Pre-condition: !highLowSet.contains(null)
    public DominoHighLowImpl_Arroyo(Set<Integer> highLowSet) {
        int highPip = 0;
        int lowPip = 0;
        if (highLowSet.size() == 1) {
            for (Integer i : highLowSet) {
                assert i <= MAXIMUM_PIP_COUNT;
                assert i >= MINIMUM_PIP_COUNT;
                highPip = i;
                lowPip = i;
            }
        }
        else {
            highPip = Collections.max(highLowSet);
            lowPip = Collections.min(highLowSet);
            assert highPip <= MAXIMUM_PIP_COUNT;
            assert lowPip <= MAXIMUM_PIP_COUNT;
            assert highPip >= MINIMUM_PIP_COUNT;
            assert lowPip >= MINIMUM_PIP_COUNT;
        }
        this.highPipCount = highPip;
        this.lowPipCount = lowPip;

    }

    public int getHighPipCount() {
        return highPipCount;
    }

    public int getLowPipCount() {
        return lowPipCount;
    }
}