package utils;

import java.util.*;

public interface IntegerUtils_Arroyo {
	public static boolean isEven(int k) {
		return (k % 2 == 0) ? true : false;
	}
	public static boolean isOdd(int k) {
		return (k % 2 != 0) ? true : false; 
	}
	
	public static boolean isPrime(int k) {
		if (k < 2) return false;
		else if (k == 2 || k == 3) return true;
		else if (k % 2 == 0 || k % 3 == 0 || Math.sqrt(k) % 1 == 0) return false;
		int modulusTest = 5;
		while (modulusTest <= (k / 3)) {
			if (k % modulusTest == 0) {
				return false;
			}
			else {
				modulusTest+=2;
			}
		}
		return true;
	}
	
	public static int greatestCommonFactor(int m, int n) {
		if (m == 0 && n == 0 || m == Integer.MIN_VALUE && n == Integer.MIN_VALUE) {
			throw new IllegalArgumentException("GCF is undefined!");
		}
//		else if (m == 0 && n != 0) return Math.abs(n);
//		else if (m != 0 && n == 0) return Math.abs(m);
//		else if (m == n) return Math.abs(m);
		int smaller;
		int larger;
		if (Math.abs(m) >= Math.abs(n)) {
			smaller = n;
			larger = m;
		}
		else {
			smaller = m;
			larger = n;
		}
		while(smaller != 0) {
			int temp = larger;
			larger = smaller;
			smaller = temp % smaller;
		}
		if (larger == Integer.MIN_VALUE) {
			throw new IllegalArgumentException("I can't represent Integer.MIN value in the positive domain of integers!");
		}
		return Math.abs(larger);
	}
	
	// 7, 1
	public static int getGreatestConstrainedMultiple(int k, int maximum) {
		if (k == 0 && maximum < k || k == Integer.MIN_VALUE) {
			throw new IllegalArgumentException("Can't find a greatest constrained multiple with your input!");
		}
		
		if (k == maximum || k == 0) return k;
		int subtractAmount = (maximum % k); 
		int f1 = subtractAmount + Math.abs(k);
		int f2 = f1 % Math.abs(k);
		int retValue = maximum - f2;
		if ((Integer.signum(retValue) == -1 && Integer.signum(maximum) == 1) || (Integer.signum(retValue) == 1 && Integer.signum(maximum) == -1)) {
			throw new IllegalArgumentException("Can't find a multiple.");
		}
		else {
			return retValue;
		}
	}
	
	public static int getIntegerH(int h_q_3, int h_r_5) {
		 if ((h_q_3 == 0 && h_r_5 != 0) || h_q_3 > (Integer.MAX_VALUE / 3) || h_q_3 < (Integer.MIN_VALUE / 3)) {
			 //throw new IllegalArgumentException("Invalid call!");
			 System.out.println("Case 1 failed.");
		 }
		 boolean needToDecrement = (h_q_3 < 0) ? true : false;
		 int[] range = new int[3];
		 int startVal = h_q_3 * 3;
		 for (int x = 0; x < range.length; ++x) {
			 range[x] = startVal;
			 if (needToDecrement && startVal > Integer.MIN_VALUE) {
				 startVal--;
			 }
			 else if (!needToDecrement && startVal < Integer.MAX_VALUE) {
				 startVal++;
			 }
		 }
		 for (int x = 0; x < range.length; ++x) {
			 if (range[x] % 5 == h_r_5) {
				 return range[x]; 
			 }
		 }
		 System.out.println("No valid integer were found.");
		 return -1;
		 //throw new IllegalArgumentException("Invalid call*!");
	}
	
	public static int getMaximum(Set<Integer> integerSet) {
		if (integerSet.isEmpty()) {
			throw new IllegalArgumentException("You passed an empty set, so there's no possible maximum!");
		}
		// return Collections.max(integerSet);
		int max = Integer.MIN_VALUE;
		for (Integer i : integerSet) {
			if (i > max) {
				max = i;
			}
		}
		return max;
	}
	
	public static int getMinimum(int[] intArray) {
		if (intArray == null || intArray.length == 0) {
			throw new IllegalArgumentException("You passed an empty array, so there's no possible minimum!");
		}
		int min = intArray[0];
		for (int x = 1; x < intArray.length; ++x) {
			if (intArray[x] < min) {
				min = intArray[x];
			}
		}
		return min;
	}
	
	public static boolean isSorted(int[] intArray) {
		for (int x = 1; x < intArray.length; ++x) {
			if (intArray[x - 1] > intArray[x]) {
				return false;
			}
		}
		return true;
	}
	
	public static int getSmallestIndexOfMatch(int[] intArray, int target) {
		for (int x = 0; x < intArray.length; ++x) {
			if (intArray[x] == target) return x;
		}
		return -1;
	}
	
	public static int reverse(int k) {
		if (k < 0) {
			throw new IllegalArgumentException("Can't reverse negatives!");
		}
		String intString = Integer.toString(k);
		char[] charArray = intString.toCharArray();
		int start = 0; int end = charArray.length - 1;
		while (start <= end) {
			char temp = charArray[start];
			charArray[start] = charArray[end];
			charArray[end] = temp;
			start++;
			end--;
		}
		int[] maxChecker = new int[] {2, 1, 4, 7, 4, 8, 3, 6, 4, 7};
		if (charArray.length == maxChecker.length) {
			for (int x = 0; x < charArray.length; ++x) {
				if (charArray[x] - '0' < maxChecker[x]) {
					break;
				}
				else if (charArray[x] - '0' == maxChecker[x]) {
					continue;
				}
				else {
					throw new IllegalArgumentException("Uh oh! Integer overflow!");
				}
			}
		}
		return Integer.valueOf(new String(charArray));
		/*String intString = String.valueOf(k);
		StringBuilder sb = new StringBuilder();
		Integer reverseInt = Integer.valueOf(sb.append(intString).reverse().toString());
		
		if (reverseInt <= Integer.MAX_VALUE) {
			return reverseInt;
		}
		else {
			throw new NumberFormatException("Number is too big!");
		}*/
		
	}
	
	public static int sumthing(long k) {
		if (k < 0) {
			throw new IllegalArgumentException("No negatives numbers allowed!");
		}
		String longString = Long.toString(k);
		long[] holder = new long[longString.length()];
	
		for (int x = 0; x < longString.length(); ++x) {
			holder[x] = longString.charAt(x) - '0';
		}
		int sum = 0;
		for (int x = 0; x < holder.length; ++x) {
			sum += holder[x];
		}
		if (sum < 10) {
			return sum;
		}
		else {
			return sumthing(sum);
		}
	}
}
