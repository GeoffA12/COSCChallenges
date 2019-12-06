package utils;


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
		int count = 0;
		int patternPointer = 0;
		boolean pf;
		if (codePointArrayStr.length >= codePointArrayPattern.length) {
			for (int x = 0; x < codePointArrayStr.length; ++x) {
				pf = true;
				if (codePointArrayStr[x] == codePointArrayPattern[patternPointer]) {
					for (int y = x; patternPointer < codePointArrayPattern.length && y < codePointArrayStr.length; patternPointer++) {
						if (codePointArrayStr[y] != codePointArrayPattern[patternPointer]) {
							pf = false;
							break;
						}
						else {
							y++;
						}
					}
					patternPointer = 0;
				}
				else {
					pf = false;
				}
				if (pf) {
					count++;
				}
			}
		}
		return count;
	}
	
	
}
