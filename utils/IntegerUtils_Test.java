package utils;
import java.util.Arrays;
import java.util.Random;
import java.util.*;
public class IntegerUtils_Test implements IntegerUtils_Arroyo{

	public static void main(String[] args) {
		
		//testIsOddIntegerUtils_Arroyo();
		//testIsPrimeIntegerUtils_Arroyo();
		//testGreatestCommonFactorIntegerUtils_Arroyo();
		//System.out.println(findGCD(-196003310, -434950347));
		//System.out.println(IntegerUtils_Arroyo.greatestCommonFactor(-196003310, -434950347));
		//testGetGreatestConstrainedMultipleIntegerUtils_Arroyo();
		//testReverseIntegerUtils_Arroyo();
		//testSumthingIntegerUtils_Arroyo();
		
		System.out.println((Integer.MIN_VALUE / 3) * 3);
		System.out.println(((Integer.MIN_VALUE / 3) - 1) * 3);
		System.out.println(getIntegerH(Integer.MAX_VALUE / 3 + 1, -3));
		//testGetMaximumIntegerUtils_Arroyo();
		//testGetIntegerHIntegerUtils_Arroyo();
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
        if(number2 == 0){
            return number1;
        }
        return findGCD(number2, number1%number2);
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
		/*assert IntegerUtils_Arroyo.isPrime(2);
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
		assert IntegerUtils_Arroyo.isPrime(Integer.MAX_VALUE);*/
		Random rand = new Random();
		for (int x = 0; x < 1000000; ++x) {
			int t = rand.nextInt();
			System.out.println(t);
			assert isPrime(t) == IntegerUtils_Arroyo.isPrime(t);
		}
	}
	
	public static void testGreatestCommonFactorIntegerUtils_Arroyo() {
		/*assert IntegerUtils_Arroyo.greatestCommonFactor(25, 5) == 5;
		assert IntegerUtils_Arroyo.greatestCommonFactor(5, 25) == 5;
		assert IntegerUtils_Arroyo.greatestCommonFactor(77, 853) == 1;
		assert IntegerUtils_Arroyo.greatestCommonFactor(0, 1) == 1;
		assert IntegerUtils_Arroyo.greatestCommonFactor(Integer.MIN_VALUE, 0) == Math.abs(Integer.MIN_VALUE);
		assert IntegerUtils_Arroyo.greatestCommonFactor(182664, 154875) == 177;
		assert IntegerUtils_Arroyo.greatestCommonFactor(-53, -53) == 53;
		assert IntegerUtils_Arroyo.greatestCommonFactor(Integer.MIN_VALUE, Integer.MAX_VALUE) == 1;*/
		Random rand = new Random();
		for (int x = 0; x < 100000; ++x) {
			int t = rand.nextInt();
			int b = rand.nextInt();
			System.out.println("t is: " + t);
			System.out.println("b is: "+  b);
			assert findGCD(t, b) == IntegerUtils_Arroyo.greatestCommonFactor(t, b);
		}
	}
	
	public static void testGetGreatestConstrainedMultipleIntegerUtils_Arroyo() {
		assert IntegerUtils_Arroyo.getGreatestConstrainedMultiple(0, 500) == 0;
		assert IntegerUtils_Arroyo.getGreatestConstrainedMultiple(7, 1) == 0;
		assert IntegerUtils_Arroyo.getGreatestConstrainedMultiple(-13, -13) == -13;
		assert IntegerUtils_Arroyo.getGreatestConstrainedMultiple(7, 100) == 98;
		assert IntegerUtils_Arroyo.getGreatestConstrainedMultiple(3, -13) == -15;
		assert IntegerUtils_Arroyo.getGreatestConstrainedMultiple(3, -1000) == -1002;
		System.out.println(IntegerUtils_Arroyo.getGreatestConstrainedMultiple(-4, 2));
		assert IntegerUtils_Arroyo.getGreatestConstrainedMultiple(-4, 2) == 0;
		assert IntegerUtils_Arroyo.getGreatestConstrainedMultiple(-100, 100) == 100;
	}
	
	public static void testGetIntegerHIntegerUtils_Arroyo() {
		System.out.println(IntegerUtils_Arroyo.getIntegerH(-14, 3));
	}
	
	public static void testGetMaximumIntegerUtils_Arroyo() {
		assert IntegerUtils_Arroyo.getMaximum(new HashSet<Integer>(Arrays.asList(1, 2, 3))) == 3;
		assert IntegerUtils_Arroyo.getMaximum(new HashSet<Integer>(Arrays.asList(3, 2, 1))) == 3;
		assert IntegerUtils_Arroyo.getMaximum(new HashSet<Integer>(Arrays.asList(2, 2))) == 2;
		assert IntegerUtils_Arroyo.getMaximum(new HashSet<Integer>(Arrays.asList(5, 3, -11, 99))) == 99;
		assert IntegerUtils_Arroyo.getMaximum(new HashSet<Integer>(Arrays.asList(Integer.MAX_VALUE, 11, 0, Integer.MIN_VALUE))) == Integer.MAX_VALUE;
	}
	
	public static void testReverseIntegerUtils_Arroyo() {
		assert IntegerUtils_Arroyo.reverse(51) == 15;
		assert IntegerUtils_Arroyo.reverse(-60) == -06; // Ask kart about this 
		assert IntegerUtils_Arroyo.reverse(100) == 001;
		assert IntegerUtils_Arroyo.reverse(20000) == 00002;
		assert IntegerUtils_Arroyo.reverse(-5221567) == -7651225;
	}
	
	public static void testSumthingIntegerUtils_Arroyo() {
		assert IntegerUtils_Arroyo.sumthing(-10505) == 9;
		assert IntegerUtils_Arroyo.sumthing(29) == 2;
		assert IntegerUtils_Arroyo.sumthing(77) == 5;
		assert IntegerUtils_Arroyo.sumthing(-2567) == 7;
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
		 System.out.println(Arrays.toString(range));
		 for (int x = 0; x < range.length; ++x) {
			 if (range[x] % 5 == h_r_5) {
				 return range[x]; 
			 }
		 }
		 throw new IllegalArgumentException("Invalid call*!");
	}
	
}
