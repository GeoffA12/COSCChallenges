package utils;

import java.util.stream.IntStream;

public interface StringUtils_Arroyo {
	public static String reverse(String str) {
		assert str != null : "String was null in reverse.";
		int[] codePointArray = str.codePoints().toArray();
		int start = 0;
		int end = codePointArray.length - 1;
		while(start < end) {
			int temp = codePointArray[start];
			codePointArray[start] = codePointArray[end];
			codePointArray[end] = temp;
			start++;
			end--;
		}
		return new String(codePointArray, 0, codePointArray.length);
	}
	
	public static boolean isPalindrome(String str) {
		return (new String(reverse(str)).equals(str));
	}
	
	// Difference str - pattern 
	// length 6 
	// while difference > 0
	public static int getCount(String str, String pattern) {
		assert (str != null && pattern != null && !pattern.equals(""));
		int[] codePointArrayStr = str.codePoints().toArray();
		int[] codePointArrayPattern = pattern.codePoints().toArray();
		String codePointStr = new String(codePointArrayStr, 0, codePointArrayStr.length);
		String codePointPattern = new String(codePointArrayPattern, 0, codePointArrayPattern.length);
		int count = 0;
		int start = 0;
		while (start + codePointArrayPattern.length <= codePointArrayStr.length) {
			if (codePointPattern.equals(codePointStr.substring(start, start + codePointArrayPattern.length))) {
				count++;
			}
			start++;
		}
		return count;
	}
	
}
