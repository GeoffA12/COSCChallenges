package utils;

import java.util.*;

public interface IntegerUtils_Arroyo {
	
	// Static interface method which will accept an integer as input and check whether or not the integer is even. 
	// Return true if even, false if odd. 
	// Straightforward: isEven(9) -> false
	// Extreme: isEven(Integer.MAX_VALUE + 1) -> true
	// Bizzare: isEven(0) -> true
	public static boolean isEven(int k) {
		boolean isEven = (k % 2 == 0) ? true : false;
		return isEven;
	}
	
	// Static interface method which will accept an integer as input and check whether or not the integer is odd. 
	// Return true if odd, false if even. 
	// Straightforward: isOdd(10) -> false
	// Extreme: isOdd(Integer.MAX_VALUE) -> true
	// Bizzare: isOdd(0) -> true
	public static boolean isOdd(int k) {
		boolean isOdd = (k % 2 != 0) ? true : false; 
		return isOdd;
	}
	
	// Static interface method which will accept an integer as input and check whether or not the integer is prime.
	// A prime number is a number which is divisible only by 1 and itself. 
	// Straightforward: isPrime(11) -> true
	// Extreme: isPrime(Integer.MAX_VALUE) -> true
	// Bizzare: isPrime(-5) -> false
	// Return true if the integer is prime or false if the integer isn't prime. 
	public static boolean isPrime(int k) {
		// Any integer less than 2 isn't prime by definition of primes
		if (k < 2) return false;
		
		//  2 and 3 are special cases of integers which divide by either 2 or 3, but are both prime.
		else if (k == 2 || k == 3) return true;
		
		
		else if (k % 2 == 0 || k % 3 == 0 || Math.sqrt(k) % 1 == 0) return false;
		int modulusTest = 5;
		
		// Use while loop starting at 5 because we already know the integer isn't divisible by 2 or 3, therefore not divisible by 4.
		// modulusTest will either be set to an integer which divides k evenly or break out of the while loop. 
		// If we break out of the while loop, we know the integer k is a prime because we already checked if it was divisible by 2 or 3,
		// therefore we can stop the while loop at (k/3). 
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
	
	/* Public static interface method which takes in two integers, m and n, as input, and returns the greatest common factor 
	 * of m and n.
	 * Greatest common factor is the largest possible integer which will evenly divide both and m and n without any remainder
	 * Straightforward: greatestCommonFactor(5, 10) -> 5
	 * Extreme: greatestCommonFactor(Integer.MIN_VALUE, Integer.MAX_VALUE) -> 1
	   Bizzare: greatestCommonFactor(0, 0) -> undefined */ 
	public static int greatestCommonFactor(int m, int n) {
		// gcf(0, 0) is undefined for this algorithm, therefore we need to throw an exception. 
		// Also, gcf(Integer.MIN_VALUE, Integer.MIN_VALUE) is an invalid call because we have no way of expressing the true
		// gcf of Integer.MIN_VALUE due to 2's complement. The true GCF would be -1 * (Integer.MIN_VALUE)
		if (m == 0 && n == 0 || m == Integer.MIN_VALUE && n == Integer.MIN_VALUE) {
			throw new IllegalArgumentException("GCF is undefined!");
		}
		
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
		
		// Euclid's algorithm to find the GCF of two integers - smaller and larger. 
		// Basic explanation with the while loop here is that with each iteration, we are decreasing the value of larger 
		// by assigning it to smaller. Also, smaller will decrease with each iteration like larger because of the equation on line
		// 93. Smaller will eventually become 0, we will break the while loop condition, and our larger variable will store the GCF of smaller and larger. 
		while(smaller != 0) {
			int temp = larger;
			larger = smaller;
			smaller = temp % smaller;
		}
		
		if (larger == Integer.MIN_VALUE) {
			throw new IllegalArgumentException("I can't represent Integer.MIN value in the positive domain of integers!");
		}
		
		// GCF (-25, -5) is 5 rather than -5. Euclid's algorithm on line 90 doesn't account for signs, therefore we need to here.
		return Math.abs(larger);
	}
	
	// public static interface method which accepts two integers as input - k and maximum. The method will return the greatest 
	// multiple of k which is bounded underneath the maximum int parameter. The maximum bound is inclusive to the multiple of k. 
	// For instance, 
	// Straightforward: gGCM(5, 15) -> 15
	// Straightforward: gGCM(100, 1001) -> 1000
	// Extreme: gGCM(7, -50) -> -56
	// Bizzare: gGCM(0, -51) -> undefined
	public static int getGreatestConstrainedMultiple(int k, int maximum) {
		
		// Undefined call here because when 0 is the multiple k and a negative number is the upper bound, 0 is the only multiple of 0.
		// Therefore, there is no way we can get underneath the upper bound if it's less than 0. 
		if (k == 0 && maximum < k) {
			throw new IllegalArgumentException("Can't find a greatest constrained multiple with your input!");
		}
		
		// Edge cases which my algorithm doesn't handle. I need these extra checks because the 
		// Math.abs() function on line 192 can't return the correct absolute value of Integer.MIN_VALUE. 
		else if (k == Integer.MIN_VALUE && maximum < 0) {
			return Integer.MIN_VALUE;
		}
		else if (k == Integer.MIN_VALUE && maximum >= 0) {
			return 0;
		}
		
		// If k and maximum are already set equal to each other, we can simply return one of them because the upper bound maximum
		// is inclusive. Also, if the multiple k is set to 0, we can simply return 0 because we've already weeded out cases 
		// where k is 0 and max is negative. 
		if (k == maximum || k == 0) return k;
		
		// To find the greatest constrained multiple, we can make use of the arithmetic and the modulus operator. 
		// The amount which we want to subtract maximum by on line 143 isn't always equal to the javaModulus variable because 
		// java will always return the remainder which has the same sign as the dividend. Therefore, for negative calls to this method
		// such as gGCM( 3, -29 ), we need the positiveRemainder2 variable to be set to 1 rather than -2. If 
		// we left lines 141 and 142 out, then we would get -29 - (-2), which would return the incorrect result. 
		int javaModulus = (maximum % k); 
		int positiveRemainderPart1 = javaModulus + Math.abs(k);
		int positiveRemainderPart2 = positiveRemainderPart1 % Math.abs(k);
		int retValue = maximum - positiveRemainderPart2;
		
		// This check will cover calls such as gGCM(5, Integer.MIN_VALUE), where 5 doesn't evenly divide into the Min value.
		// Therefore, there is no way we can return a valid multiple of k which is underneath max without wrapping to positive values.
		if ((Integer.signum(retValue) == -1 && Integer.signum(maximum) == 1) || (Integer.signum(retValue) == 1 && Integer.signum(maximum) == -1)) {
			throw new IllegalArgumentException("Can't find a multiple.");
		}
		else {
			return retValue;
		}
	}
	
	//public static interface method which accepts two integers as input - h_q_3 and h_r_5. The method will return an integer 
	// which when divided by, will be set equal to h_q_3. This same integer when divided by 5 must also have a remainder of h_r_5.
	// Straightforward: getIntegerH(20, 1) -> 61
	// Note that 61 / 3 is equal to 20 due to integer division. 
	// Extreme: getIntegerH(Integer.MAX_VALUE / 3, 2) -> Integer.MAX_VALUE
	// Bizzare: getIntegerH(-14, 3) -> undefined 
	public static int getIntegerH(int h_q_3, int h_r_5) {
		 if ((h_q_3 == 0 && h_r_5 != 0) || h_q_3 > (Integer.MAX_VALUE / 3) || h_q_3 < (Integer.MIN_VALUE / 3)) {
			 System.out.println("Case 1 failed.");
		 }
		 
		 // I'm using an array to store the possible range of values which could potentially be the answer based on the first condition
		 // that the integer divided by 3 is H_q_3. There will always be three values in this array, except for in extreme cases such as 
		 // when h_q_3 is equal to Integer.MAX_VALUE. 
		 // I need to know the sign of h_q_3 to determine whether or not I should be decrementing or incrementing the first valid
		 // candidate in the range array. 
		 boolean needToDecrement = (h_q_3 < 0) ? true : false;
		 int[] range = new int[3];
		 int startVal = h_q_3 * 3;
		 for (int x = 0; x < range.length; ++x) {
			 range[x] = startVal;
			 // Check bounds - make sure we're not encoutering an integer wrap 
			 if (needToDecrement && startVal > Integer.MIN_VALUE) {
				 startVal--;
			 }
			 else if (!needToDecrement && startVal < Integer.MAX_VALUE) {
				 startVal++;
			 }
		 }
		 
		 // Range array now holds all potential candidates which pass the first condition. 
		 for (int x = 0; x < range.length; ++x) { 
			 if (range[x] % 5 == h_r_5) {
				 return range[x]; 
			 }
		 }
		 
		 // Edge cases where no valid integers are found to meet the two conditions are handled by an illegalargumentexception
		 throw new IllegalArgumentException("Invalid call*!");
	}
	
	
	// public static interface method which accepts a Set as a parameter. The method getMaximum() will determine the 
	// maximum integer value in the set, and return it to the caller. 
	// Straightforward: getMaximum(new HashSet<Integer>(Arrays.asList(1, 2, 3)) -> 3
	// Extreme: getMaximum(new HashSet<Integer>(Arrays.asList(Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE))) -> Integer.MAX_VALUE
	// Bizzare: getMaximum(Collections.<Integer>emptySet()) -> undefined
	
	public static int getMaximum(Set<Integer> integerSet) {
		// undefined case for this method. Throw an exception when we receive an empty set. 
		if (integerSet.isEmpty()) {
			throw new IllegalArgumentException("You passed an empty set, so there's no possible maximum!");
		}
		
		// Assuming there's elements in the set now, we can use a max variable to track the greatest element in the set. 
		// Set the max variable to Int.MIN_VALUE to start out with.
		int max = Integer.MIN_VALUE;
		for (Integer i : integerSet) {
			if (i > max) {
				max = i;
			}
		}
		return max;
	}
	
	// public static interface method which accepts a primitive int array as the only parameter. The method will 
	// return the minimum integer value in the array. 
	// Straightforward: getMinimum(new int[] {1, 4, 5, 11, 7}) -> 1
	// Extreme: getMinimum(new int[]{5}) -> 5
	// Bizzare: getMinimum(new int[]{}) -> undefined
	public static int getMinimum(int[] intArray) {
		// If the array is null or if the array is empty, we can't return any minimum value. Therefore, throw an exception in these
		// bizarre cases 
		if (intArray == null || intArray.length == 0) {
			throw new IllegalArgumentException("You passed an empty array, so there's no possible minimum!");
		}
		
		// Use an integer (min) to track the minimum integer value in the intArray. We can use the first index as the minimum
		// because we already know the array has at least one element. 
		int min = intArray[0];
		for (int x = 1; x < intArray.length; ++x) {
			if (intArray[x] < min) {
				min = intArray[x];
			}
		}
		return min;
	}
	
	/*public static interface method which accepts a primitive int array and checks whether or not the array is sorted
	 * in ascending order. 
	 * Straightforward: isSorted(new int[] {1, 5, 1, 0}) -> false
	 * Extreme: isSorted(new int[] {1}) -> true
	 * Bizzare: isSorted(new int[]{}) -> true
	  Bizzare: isSorted(new int[] {5, 5, 5}) -> true*/
	
	public static boolean isSorted(int[] intArray) {
		if (intArray == null) {
			throw new IllegalArgumentException("Can't tell if this is sorted or not!");
		}
		// Iterate through the array starting at the first index (0-based). We can start at the first index because if the array 
		// was of size 0 or 1, the for loop conditional would fail, and would immediately return true, as we would expect. 
		for (int x = 1; x < intArray.length; ++x) {
			// Check if the array is linearly sorted. Use > rather than >= 
			if (intArray[x - 1] > intArray[x]) {
				return false;
			}
		}
		return true;
	}
	
	/* public static interface method which accepts a primitive int array and a int target as two parameters. The method will
	 * search for the target parameter in the intArray parameter and return the smallest possible index of the target inside the 
	 * array. If no target is found, return -1. 
	 * Straightforward: getSmallestIndex(new int[]{4, 3, 2}, 3) -> 1
	 * Extreme: getSmallestIndex(new int[]{4, 3, 2, 5, 5}, 10) -> -1
	   Bizzare: getSmallestIndex(new int[]{2, 2, 2, 2}, 2) -> 0 */
	public static int getSmallestIndexOfMatch(int[] intArray, int target) {
		if (intArray == null) {
			throw new IllegalArgumentException("Can't use this array!");
		}
		
		// Use a for loop to iterate through the intArray, searching each index for the target parameter
		for (int x = 0; x < intArray.length; ++x) {
			if (intArray[x] == target) return x;
		}
		
		// Return -1 if the target isn't found. 
		return -1;
	}
	
	
	/* public static interface method which accepts an integer k as a parameter. The method will return an integer which is the 
	 * reverse representation of the integer. In other words, the digits of the integer will be reversed. 
	 * Straightforward: reverse(1002) -> 2001
	 * Extreme: reverse(050) -> 50
	 * Bizzare: reverse(-9) -> undefined
	 */
	public static int reverse(int k) {
		
		// The reverse method is undefined for the domain of negative integers. Therefore, throw an exception. 
		if (k < 0) {
			throw new IllegalArgumentException("Can't reverse negatives!");
		}
		
		// Convert the parameter k to a string using the toString() method. 
		String intString = Integer.toString(k);
		
		// Seperate out each character in the integerString so that we now have an array of characters. Each index in charArray
		// Will have a single digit. 
		char[] charArray = intString.toCharArray();
		int start = 0; int end = charArray.length - 1;
		
		// Iterate through the charArray using two pointers. Swap values at each start and end index in charArray to reverse 
		// the string of characters (which are actually digits from k). 
		while (start <= end) {
			char temp = charArray[start];
			charArray[start] = charArray[end];
			charArray[end] = temp;
			start++;
			end--;
		}
		
		// Check to make sure we didn't encounter integer overflow when reversing the digits inside charArray
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
		
	}
	
	/*public static interface method which accepts a long k as its only parameter. Sumthing() will return the sum of inidividual 
	 * digits in the parameter. The catch with this method is that the sum of individual digits must be expressed as a single digit. 
	 * Straightforward: sumthing(7) ->  return 7
	 * Extreme: sumthing(29) -> 11 ->  return 2
	 * Bizzare: sumthing(-2) -> undefined
	 */
	public static int sumthing(long k) {
		
		// Handle the undefined cases using exceptions.
		if (k < 0) {
			throw new IllegalArgumentException("No negatives numbers allowed!");
		}
		String longString = Long.toString(k);
		long[] holder = new long[longString.length()];
	
		for (int x = 0; x < longString.length(); ++x) {
			// Account for the ascii value of the digit by subtracting '0' (we want to get the actual digit)
			holder[x] = longString.charAt(x) - '0';
		}
		int sum = 0;
		for (int x = 0; x < holder.length; ++x) {
			sum += holder[x];
		}
		
		// Base case 
		if (sum < 10) {
			return sum;
		}
		else {
			// We need to keep going because the sum value isn't a singular digit. We can only stop the recursive calls once we 
			// get a sum which is a singular digit.
			return sumthing(sum);
		}
	}
}