package utils;
import java.util.Arrays;
import java.util.Random;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
public class IntegerUtils_Test implements IntegerUtils_Arroyo{

	public static void main(String[] args) {
		
		testIsEvenIntegerUtils_Arroyo();
		testIsOddIntegerUtils_Arroyo();
		testIsPrimeIntegerUtils_Arroyo();
		testGreatestCommonFactorIntegerUtils_Arroyo();
		testGetGreatestConstrainedMultipleIntegerUtils_Arroyo();
		
		
		testSumthingIntegerUtils_Arroyo();
		
		System.out.println(((Integer.MIN_VALUE / 3) - 1) * 3);
		testGetMaximumIntegerUtils_Arroyo();
		testGetMinimumIntegerUtils_Arroyo();
		testIsSortedIntegerUtils_Arroyo();
		testGetSmallestIndexOfMatch();
		testReverseIntegerUtils_Arroyo();
		testGetIntegerHIntegerUtils_Arroyo();
		System.out.println("Assertions all passed.");
		//assert false;
		//System.out.println("Assertions aren't enabled.");
	}
	
	public static boolean isPrime(int n) 
    { 
        // Corner cases 
        if (n <= 1) 
            return false; 
        if (n <= 3) 
            return true; 
  
        // This is checked so that we can skip 
        // middle five numbers in below loop 
        if (n % 2 == 0 || n % 3 == 0) 
            return false; 
  
        for (int i = 5; i * i <= n; i = i + 6) 
            if (n % i == 0 || n % (i + 2) == 0) 
                return false; 
  
        return true; 
    }
	
	private static int findGCD(int number1, int number2) {
        //base case
        if(number2 == 0) {
            return number1;
        }
        return findGCD(number2, number1%number2);
    }
	
	public static void testIsEvenIntegerUtils_Arroyo() {
		assert IntegerUtils_Arroyo.isEven(4);
		assert IntegerUtils_Arroyo.isEven(-14);
		assert IntegerUtils_Arroyo.isEven(0);
		assert IntegerUtils_Arroyo.isEven(Integer.MIN_VALUE);
		assert !IntegerUtils_Arroyo.isEven(Integer.MAX_VALUE);
	}
	
	public static void testIsOddIntegerUtils_Arroyo() {
		assert IntegerUtils_Arroyo.isOdd(15);
		assert IntegerUtils_Arroyo.isOdd(-117);
		assert !IntegerUtils_Arroyo.isOdd(0);
		assert !IntegerUtils_Arroyo.isOdd(464);
		assert IntegerUtils_Arroyo.isOdd(1000001);
		assert !IntegerUtils_Arroyo.isOdd(Integer.MIN_VALUE);
		assert IntegerUtils_Arroyo.isOdd(Integer.MAX_VALUE);
	}
	
	public static void testIsPrimeIntegerUtils_Arroyo() {
		assert IntegerUtils_Arroyo.isPrime(2);
		assert IntegerUtils_Arroyo.isPrime(5);
		assert IntegerUtils_Arroyo.isPrime(11);
		assert !IntegerUtils_Arroyo.isPrime(121);
		assert !IntegerUtils_Arroyo.isPrime(289);
		assert IntegerUtils_Arroyo.isPrime(631);
		assert !IntegerUtils_Arroyo.isPrime(913);
		assert !IntegerUtils_Arroyo.isPrime(777);
		assert IntegerUtils_Arroyo.isPrime(773);
		assert IntegerUtils_Arroyo.isPrime(1999);
		assert !IntegerUtils_Arroyo.isPrime(1833);
		assert IntegerUtils_Arroyo.isPrime(8960453);
		assert IntegerUtils_Arroyo.isPrime(5800079);
		assert !IntegerUtils_Arroyo.isPrime(5800073);
		assert !IntegerUtils_Arroyo.isPrime(0);
		assert !IntegerUtils_Arroyo.isPrime(-11);
		assert IntegerUtils_Arroyo.isPrime(Integer.MAX_VALUE);
		assert IntegerUtils_Arroyo.isPrime(1000000007);
		assert IntegerUtils_Arroyo.isPrime(1000000007);
		assert IntegerUtils_Arroyo.isPrime(1000001789);
		assert !IntegerUtils_Arroyo.isPrime(1000001797);

	}
	
	public static void testGreatestCommonFactorIntegerUtils_Arroyo() {
		assert IntegerUtils_Arroyo.greatestCommonFactor(25, 5) == 5;
		assert IntegerUtils_Arroyo.greatestCommonFactor(5, 25) == 5;
		assert IntegerUtils_Arroyo.greatestCommonFactor(-25, -5) == 5;
		assert IntegerUtils_Arroyo.greatestCommonFactor(77, 853) == 1;
		assert IntegerUtils_Arroyo.greatestCommonFactor(0, 111) == 111;
		assert IntegerUtils_Arroyo.greatestCommonFactor(182664, 154875) == 177;
		assert IntegerUtils_Arroyo.greatestCommonFactor(-53, -53) == 53;
		assert IntegerUtils_Arroyo.greatestCommonFactor(53, 53) == 53;
		assert IntegerUtils_Arroyo.greatestCommonFactor(-53, 0) == 53;
		assert IntegerUtils_Arroyo.greatestCommonFactor(Integer.MAX_VALUE, Integer.MAX_VALUE) == Integer.MAX_VALUE;
		assert IntegerUtils_Arroyo.greatestCommonFactor(1100, 55) == 55;
		assert IntegerUtils_Arroyo.greatestCommonFactor(Integer.MIN_VALUE, Integer.MAX_VALUE) == 1;
		//System.out.println(IntegerUtils_Arroyo.greatestCommonFactor(0, Integer.MIN_VALUE));
		System.out.println(IntegerUtils_Arroyo.greatestCommonFactor(-55, Integer.MIN_VALUE));
	}
	
	public static void testGetGreatestConstrainedMultipleIntegerUtils_Arroyo() {
		assert IntegerUtils_Arroyo.getGreatestConstrainedMultiple(0, 500) == 0;
		assert IntegerUtils_Arroyo.getGreatestConstrainedMultiple(7, 1) == 0;
		assert IntegerUtils_Arroyo.getGreatestConstrainedMultiple(-13, -13) == -13;
		assert IntegerUtils_Arroyo.getGreatestConstrainedMultiple(7, 100) == 98;
		assert IntegerUtils_Arroyo.getGreatestConstrainedMultiple(3, -13) == -15;
		assert IntegerUtils_Arroyo.getGreatestConstrainedMultiple(3, -1000) == -1002;
		assert IntegerUtils_Arroyo.getGreatestConstrainedMultiple(-4, 2) == 0;
		assert IntegerUtils_Arroyo.getGreatestConstrainedMultiple(-100, 100) == 100;
		assert IntegerUtils_Arroyo.getGreatestConstrainedMultiple(1, Integer.MIN_VALUE) == Integer.MIN_VALUE;
		assert IntegerUtils_Arroyo.getGreatestConstrainedMultiple(1, Integer.MAX_VALUE) == Integer.MAX_VALUE;
		assert IntegerUtils_Arroyo.getGreatestConstrainedMultiple(Integer.MIN_VALUE, 0) == 0;
		assert IntegerUtils_Arroyo.getGreatestConstrainedMultiple(Integer.MIN_VALUE, -11) == Integer.MIN_VALUE;
		assert IntegerUtils_Arroyo.getGreatestConstrainedMultiple(Integer.MIN_VALUE, 100) == 0;
		assert IntegerUtils_Arroyo.getGreatestConstrainedMultiple(Integer.MIN_VALUE + 1, Integer.MAX_VALUE) == Integer.MAX_VALUE;
		assert IntegerUtils_Arroyo.getGreatestConstrainedMultiple(Integer.MAX_VALUE, Integer.MIN_VALUE + 1) == Integer.MIN_VALUE + 1;
		assert IntegerUtils_Arroyo.getGreatestConstrainedMultiple(Integer.MIN_VALUE, Integer.MAX_VALUE) == 0;
		assert IntegerUtils_Arroyo.getGreatestConstrainedMultiple(8, Integer.MIN_VALUE) == Integer.MIN_VALUE;
//		for (int x = 0; x < 200; ++x) {
//			int k = ThreadLocalRandom.current().nextInt(-1000, 1000);
//			int max = ThreadLocalRandom.current().nextInt(-1000, 1000);
//			System.out.println("k is: "+ k + " max is: " + max);
//			System.out.println(IntegerUtils_Arroyo.getGreatestConstrainedMultiple(k, max));
//		}
	}
	
	public static void testGetIntegerHIntegerUtils_Arroyo() {
		
		
	}
	
	public static void testGetMaximumIntegerUtils_Arroyo() {
		assert IntegerUtils_Arroyo.getMaximum(new HashSet<Integer>(Arrays.asList(1, 2, 3))) == 3;
		assert IntegerUtils_Arroyo.getMaximum(new HashSet<Integer>(Arrays.asList(3, 2, 1))) == 3;
		assert IntegerUtils_Arroyo.getMaximum(new HashSet<Integer>(Arrays.asList(2, 2))) == 2;
		assert IntegerUtils_Arroyo.getMaximum(new HashSet<Integer>(Arrays.asList(5, 3, -11, 99))) == 99;
		//assert IntegerUtils_Arroyo.getMaximum(Collections.<Integer>emptySet()) == 3;
		assert IntegerUtils_Arroyo.getMaximum(new HashSet<Integer>(Arrays.asList(Integer.MAX_VALUE, 11, 0, Integer.MIN_VALUE))) == Integer.MAX_VALUE;
		assert IntegerUtils_Arroyo.getMaximum(new HashSet<Integer>(Arrays.asList(Integer.MAX_VALUE, Integer.MAX_VALUE - 1, Integer.MAX_VALUE + 1))) == Integer.MAX_VALUE;
		assert IntegerUtils_Arroyo.getMaximum(new HashSet<Integer>(Arrays.asList(Integer.MIN_VALUE, 00500))) == 320;
		assert IntegerUtils_Arroyo.getMaximum(new HashSet<Integer>(Arrays.asList(07, 7, 4, 41, 41, 42, 42))) == 42;
		assert IntegerUtils_Arroyo.getMaximum(new HashSet<Integer>(Arrays.asList(Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE))) == Integer.MAX_VALUE;
	}
	
	public static void testGetMinimumIntegerUtils_Arroyo() {
		assert IntegerUtils_Arroyo.getMinimum(new int[]{3, 3, 3, Integer.MIN_VALUE}) == Integer.MIN_VALUE;
		//assert IntegerUtils_Arroyo.getMinimum(new int[] {}) == Integer.MIN_VALUE;
		assert IntegerUtils_Arroyo.getMinimum(new int[]{5, -1000, 900, 455, 455, -1, -600000, 500}) == -600000;
		assert IntegerUtils_Arroyo.getMinimum(new int[]{6}) == 6;
		assert IntegerUtils_Arroyo.getMinimum(new int[]{56, 56, 56}) == 56;
		assert IntegerUtils_Arroyo.getMinimum(new int[]{00500, 10000, 1000}) == 320;
		assert IntegerUtils_Arroyo.getMinimum(new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE + 1, Integer.MAX_VALUE + 2}) == Integer.MIN_VALUE;
	}
	
	public static void testIsSortedIntegerUtils_Arroyo() {
		assert IntegerUtils_Arroyo.isSorted(new int[] {0, 0, 0});
		assert !IntegerUtils_Arroyo.isSorted(new int[] {Integer.MIN_VALUE, -77, 77, -77});
		assert !IntegerUtils_Arroyo.isSorted(new int[] {10, 0, -100, 100, 200});
		assert IntegerUtils_Arroyo.isSorted(new int[] {6});
		assert IntegerUtils_Arroyo.isSorted(new int[] {});
		assert IntegerUtils_Arroyo.isSorted(new int[] {-66, -65});
		assert !IntegerUtils_Arroyo.isSorted(new int[] {-3, -4, -5});
		assert !IntegerUtils_Arroyo.isSorted(new int[] {77, 89, 15, Integer.MIN_VALUE, Integer.MAX_VALUE});
		assert IntegerUtils_Arroyo.isSorted(new int[] {6, 6, 6});
		assert !IntegerUtils_Arroyo.isSorted(new int[] {-6, -6, -6, -5, -3, -4});
		assert !IntegerUtils_Arroyo.isSorted(new int[] {5, 5, 5, 5, -40, 40});
		assert !IntegerUtils_Arroyo.isSorted(new int[] {Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE + 1});
	}
	
	public static void testGetSmallestIndexOfMatch() {
		assert IntegerUtils_Arroyo.getSmallestIndexOfMatch(new int[] {}, 10) == -1;
		assert IntegerUtils_Arroyo.getSmallestIndexOfMatch(new int[] {10, 35, 10, 10, 55}, 10) == 0;
		assert IntegerUtils_Arroyo.getSmallestIndexOfMatch(new int[] {9, 9, 9, 9, 8}, 8) == 4;
		assert IntegerUtils_Arroyo.getSmallestIndexOfMatch(new int[] {Integer.MAX_VALUE, 5, 5, 5, 4, 3, 4, 5, Integer.MIN_VALUE, Integer.MIN_VALUE}, 5) == 1;
		assert IntegerUtils_Arroyo.getSmallestIndexOfMatch(new int[] {4}, Integer.MIN_VALUE) == -1;
		assert IntegerUtils_Arroyo.getSmallestIndexOfMatch(new int[] {00500, 11, 15, -900}, 320) == 0;
	}
	
	public static void testReverseIntegerUtils_Arroyo() {
		assert IntegerUtils_Arroyo.reverse(51) == 15;
		assert IntegerUtils_Arroyo.reverse(100) == 001; 
		assert IntegerUtils_Arroyo.reverse(20000) == 00002;
		assert IntegerUtils_Arroyo.reverse(20000) == 2;
		assert IntegerUtils_Arroyo.reverse(00500) == 23;
		assert IntegerUtils_Arroyo.reverse(4333371) == 1733334;
		assert IntegerUtils_Arroyo.reverse(101) == 101;
		assert IntegerUtils_Arroyo.reverse(005) == 5;
		assert IntegerUtils_Arroyo.reverse(1463847412) == 2147483641;
		assert IntegerUtils_Arroyo.reverse(1995563412) == 2143655991;
		assert IntegerUtils_Arroyo.reverse(1800081) == 1800081;
		//assert IntegerUtils_Arroyo.reverse(Integer.MAX_VALUE) == Integer.MAX_VALUE;
	}
	
	public static void testSumthingIntegerUtils_Arroyo() {
		assert IntegerUtils_Arroyo.sumthing(29) == 2;
		assert IntegerUtils_Arroyo.sumthing(77) == 5;
		assert IntegerUtils_Arroyo.sumthing(0) == 0;
		assert IntegerUtils_Arroyo.sumthing(99996745) == 4;
		assert IntegerUtils_Arroyo.sumthing(24569872) == 7;
		assert IntegerUtils_Arroyo.sumthing(Integer.MAX_VALUE) == 1;
	}
	
	
}