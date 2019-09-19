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
		else if (k % 2 == 0 || k % 3 == 0) return false;
		else if (Math.sqrt(k) % 1 == 0) return false;
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
		if (m == 0 && n == 0) {
			throw new IllegalArgumentException("GCF of 0 and 0 is undefined!");
		}
		else if (m == 0 && n != 0) return Math.abs(n);
		else if (m != 0 && n == 0) return Math.abs(m);
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
		return Math.abs(larger);
	}
	
	// 7, 1
	public static int getGreatestConstrainedMultiple(int k, int maximum) {
		if (k == maximum || k == 0) return k;
		int subtractAmount = ((maximum % k) + Math.abs(k)) % Math.abs(k);
		return (maximum - subtractAmount);
	}
	
	public static int getIntegerH(int h_q_3, int h_r_5) {
		 if ((h_q_3 == 0 && h_r_5 != 0) || h_q_3 > (Integer.MAX_VALUE / 3) || h_q_3 < (Integer.MIN_VALUE / 3)) {
			 throw new IllegalArgumentException("Invalid call!");
		 }
		 boolean needToDecrement = (h_q_3 < 0) ? true : false;
		 int[] range = new int[3];
		 int startVal = h_q_3 * 3;
		 for (int x = 0; x < range.length; ++x) {
			 range[x] = startVal;
			 if (needToDecrement && startVal > Integer.MIN_VALUE) {
				 startVal--;
			 }
			 else if (!needToDecrement && startVal < Integer.MAX_VALUE){
				 startVal++;
			 }
		 }
		 for (int x = 0; x < range.length; ++x) {
			 if (range[x] % 5 == h_r_5) {
				 return range[x]; 
			 }
		 }
		 throw new IllegalArgumentException("Invalid call*!");
	}
	
	public static int getMaximum(Set<Integer> integerSet) {
		if (integerSet.isEmpty() || integerSet.equals(null)) {
			throw new IllegalArgumentException("You passed an empty set, so there's no possible maximum!");
		}
		return Collections.max(integerSet);
		/*int max = Integer.MIN_VALUE;
		for (Integer i : integerSet) {
			if (i > max) {
				max = i;
			}
		}
		return max;*/
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
		if (intArray.length < 2) return true;
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
			throw new IllegalArgumentException("Can't reverse a negative number!");
		}
		String intString = String.valueOf(k);
		StringBuilder sb = new StringBuilder();
		return Integer.valueOf(sb.append(intString).reverse().toString());
		
	}
	
	public static int sumthing(long k) {
		if (k < 0) {
			throw new IllegalArgumentException("No negatives numbers allowed!");
		}
		String longString = Long.toString(k);
		long[] holder = new long[longString.length()];
		/*int startVal;
		if (longString.charAt(0) == '-') {
			holder[0] = Long.valueOf(longString.substring(0, 2));
			startVal = 2;
		}
		else {
			startVal = 0;
		}*/
		for (int x = 0; x < longString.length(); ++x) {
			holder[x] = longString.charAt(x) - '0';
		}
		System.out.println(Arrays.toString(holder));
		int sum = 0;
		for (int x = 0; x < holder.length; ++x) {
			sum += holder[x];
		}
		System.out.println(sum);
		if (sum < 10) {
			return sum;
		}
		else {
			return sumthing(sum);
		}
	}
}
