package dominotest;

import java.util.Arrays;
import java.util.*;
import dominoes.*;
public class DominoTestSuite {
	public static final int max = Domino.MAXIMUM_PIP_COUNT;
	public static final int min = Domino.MINIMUM_PIP_COUNT;
	public static final int expectingDominoes = findNumberOfDominoes(max, min);
	public static void main(String[] args) {
		System.out.println("MAXIMUM_PIP_COUNT is: " + max);
		System.out.println("MINIMUM_PIP_COUNT is: " + min);
		testHighLowImplDoubleInteger();
		testHighLowImplHighLowString();
		testHighLowImplSumDifferenceArray();
		testHighLowImplHighLowSet();
		testHighLowImplQuotientAndRemainder();
		
		testHighLowSetImplSumDifferenceString();
		testHighLowSetImplDoubleInteger();
		testHighLowSetImplLowPlus8TimesHigh();
		
		testLowDifferenceStringImplLowPlus8TimesHigh();
		testLowDiffereceStringImplHighSumSet();
		System.out.println("Assertions passed");
		//assert false;
		//System.out.println("Assertions not enabled");
	}
	
	public static int findNumberOfDominoes(int maximum, int minimum) {
		int startVal = maximum - minimum + 1;
		int expectingDominoes = 0;
		for (int x = startVal; x > 0; x--) {
			expectingDominoes += x;
		}
		System.out.println("There are " + expectingDominoes + " dominoes being tested in this file.");
		return expectingDominoes;
	}
	
	public static void testHighLowImplDoubleInteger() {
		Domino d1 = new DominoHighLowImpl_Arroyo(min, min);
		assert d1.getHighPipCount() == min;
		assert d1.getLowPipCount() == min;
		d1 = new DominoHighLowImpl_Arroyo(max, 4);
		assert d1.getHighPipCount() == max;
		assert d1.getLowPipCount() == 4;
		d1 = new DominoHighLowImpl_Arroyo(max, min);
		assert d1.getHighPipCount() == max;
		assert d1.getLowPipCount() == min;
		d1 = new DominoHighLowImpl_Arroyo(4, 2);
		assert d1.getHighPipCount() == 4;
		assert d1.getLowPipCount() == 2;
//		d1 = new DominoHighLowImpl_Arroyo(7, 0);
//		assert d1.getHighPipCount() == 6;
//		assert d1.getLowPipCount() == 1;
//		d1 = new DominoHighLowImpl_Arroyo(6, -1);
//		assert d1.getHighPipCount() == 6;
//		assert d1.getLowPipCount() == 1;
	}
	
	public static void testHighLowImplHighLowString() {
		Domino d1 = new DominoHighLowImpl_Arroyo("4:2");
		assert d1.getHighPipCount() == 4;
		assert d1.getLowPipCount() == 2;
		d1 = new DominoHighLowImpl_Arroyo("2:2");
		assert d1.getHighPipCount() == 2;
		assert d1.getLowPipCount() == 2;
		d1 = new DominoHighLowImpl_Arroyo("3:3");
		assert d1.getHighPipCount() == 3;
		assert d1.getLowPipCount() == 3;
		d1 = new DominoHighLowImpl_Arroyo("5:4");
		assert d1.getHighPipCount() == 5;
		assert d1.getLowPipCount() == 4;
		d1 = new DominoHighLowImpl_Arroyo("5:2");
		assert d1.getHighPipCount() == 5;
		assert d1.getLowPipCount() == 2;
//		String s = null;
//		d1 = new DominoHighLowImpl_Arroyo(s);
//		d1 = new DominoHighLowImpl_Arroyo("0:1");
//		assert d1.getHighPipCount() == 0;
//		assert d1.getLowPipCount() == 1;
//		d1 = new DominoHighLowImpl_Arroyo("7:6");
//		assert d1.getHighPipCount() == 0;
//		assert d1.getLowPipCount() == 1;
//		d1 = new DominoHighLowImpl_Arroyo("1:00");
//		assert d1.getHighPipCount() == 1;
//		assert d1.getLowPipCount() == 0;
//		d1 = new DominoHighLowImpl_Arroyo("4,2");
//		assert d1.getHighPipCount() == 4;
//		assert d1.getLowPipCount() == 2;
	}
	
	public static void testHighLowImplSumDifferenceArray() {
		Domino d1 = new DominoHighLowImpl_Arroyo(new int[]{7, 3});
		assert d1.getHighPipCount() == 5;
		assert d1.getLowPipCount() == 2;
		d1 = new DominoHighLowImpl_Arroyo(new int[]{4, 0});
		assert d1.getHighPipCount() == 2;
		assert d1.getLowPipCount() == 2;
		d1 = new DominoHighLowImpl_Arroyo(new int[]{5, 1});
		assert d1.getHighPipCount() == 3;
		assert d1.getLowPipCount() == 2;
		d1 = new DominoHighLowImpl_Arroyo(new int[]{6, 2});
		assert d1.getHighPipCount() == 4;
		assert d1.getLowPipCount() == 2;
//		d1 = new DominoHighLowImpl_Arroyo(new int[]{0, 2});
//		assert d1.getHighPipCount() == 2;
//		assert d1.getLowPipCount() == 2;
//		int[] n = null;
//		d1 = new DominoHighLowImpl_Arroyo(n);
		d1 = new DominoHighLowImpl_Arroyo(new int[]{9, 1});
		assert d1.getHighPipCount() == 5;
		assert d1.getLowPipCount() == 4;
		d1 = new DominoHighLowImpl_Arroyo(new int[]{7, 1});
		assert d1.getHighPipCount() == 4;
		assert d1.getLowPipCount() == 3;
		d1 = new DominoHighLowImpl_Arroyo(new int[]{8, 0});
		assert d1.getHighPipCount() == 4;
		assert d1.getLowPipCount() == 4;
//		d1 = new DominoHighLowImpl_Arroyo(new int[]{6, 4});
//		assert d1.getHighPipCount() == 5;
//		assert d1.getLowPipCount() == 1;
//		d1 = new DominoHighLowImpl_Arroyo(new int[]{3, 0});
//		assert d1.getHighPipCount() == 2;
//		assert d1.getLowPipCount() == 1;
	}
	
	public static void testHighLowImplHighLowSet() {
		Domino d1 = new DominoHighLowImpl_Arroyo(new HashSet<Integer>(Arrays.asList(5)));
		assert d1.getHighPipCount() == d1.getLowPipCount();
		assert d1.getHighPipCount() == 5;
		d1 = new DominoHighLowImpl_Arroyo(new HashSet<Integer>(Arrays.asList(2)));
		assert d1.getHighPipCount() == d1.getLowPipCount();
		assert d1.getLowPipCount() == 2;
		d1 = new DominoHighLowImpl_Arroyo(new HashSet<Integer>(Arrays.asList(2, 4)));
		assert d1.getHighPipCount() == 4;
		assert d1.getLowPipCount() == 2;
		d1 = new DominoHighLowImpl_Arroyo(new HashSet<Integer>(Arrays.asList(3, 3)));
		assert d1.getHighPipCount() == 3;
		assert d1.getLowPipCount() == 3;
		Set<Integer> i = null;
		try {
			d1 = new DominoHighLowImpl_Arroyo(i);
			System.out.println("I was expecting an assertion error!");
			assert false;
		}
		catch (AssertionError ae) {
			
		}
		i = new HashSet<Integer>(Arrays.asList(null, 4));
		try {
			d1 = new DominoHighLowImpl_Arroyo(i);
			System.out.println("I was expecting an assertion error!");
			assert false;
		}
		catch (AssertionError ae) {
			
		}
		
		d1 = new DominoHighLowImpl_Arroyo(new HashSet<Integer>(Arrays.asList(4)));
		assert d1.getHighPipCount() == 4;
		assert d1.getLowPipCount() == 4;
		d1 = new DominoHighLowImpl_Arroyo(new HashSet<Integer>(Arrays.asList(3, max)));
		assert d1.getHighPipCount() == max;
		assert d1.getLowPipCount() == 3;
//		d1 = new DominoHighLowImpl_Arroyo(new HashSet<Integer>(Arrays.asList(7)));
//		assert d1.getHighPipCount() == 7;
//		assert d1.getLowPipCount() == 7;
//		d1 = new DominoHighLowImpl_Arroyo(new HashSet<Integer>(Arrays.asList(0, 5, 7)));
//		assert d1.getHighPipCount() == 5;
//		assert d1.getLowPipCount() == 0;
		d1 = new DominoHighLowImpl_Arroyo(new HashSet<Integer>(Arrays.asList(max, min)));
		assert d1.getHighPipCount() == max;
		assert d1.getLowPipCount() == min;
	}
	
	public static void testHighLowImplQuotientAndRemainder() {
		Domino d1 = new DominoHighLowImpl_Arroyo(2, 2, 1, 2);
		assert d1.getHighPipCount() == 5;
		assert d1.getLowPipCount() == 2;
		d1 = new DominoHighLowImpl_Arroyo(2, 1, 0, 1);
		assert d1.getHighPipCount() == 4;
		assert d1.getLowPipCount() == 1;
		d1 = new DominoHighLowImpl_Arroyo(1, 0, 1, 0);
		assert d1.getHighPipCount() == 3;
		assert d1.getLowPipCount() == 3;
		d1 = new DominoHighLowImpl_Arroyo(0, 0, 0, 0);
		assert d1.getHighPipCount() == 0;
		assert d1.getLowPipCount() == 0;
		d1 = new DominoHighLowImpl_Arroyo(2, 2, 1, 0);
		assert d1.getHighPipCount() == 5;
		assert d1.getLowPipCount() == 3;
		d1 = new DominoHighLowImpl_Arroyo(2, 1, 0, 1);
		assert d1.getHighPipCount() == 4;
		assert d1.getLowPipCount() == 1;
		d1 = new DominoHighLowImpl_Arroyo(3, 0, 0, 0);
		assert d1.getHighPipCount() == 6;
		assert d1.getLowPipCount() == 0;
		d1 = new DominoHighLowImpl_Arroyo(2, 1, 0, 1);
		assert d1.getHighPipCount() == 4;
		assert d1.getLowPipCount() == 1;
		d1 = new DominoHighLowImpl_Arroyo(2, 2, 0, 1);
		assert d1.getHighPipCount() == 5;
		assert d1.getLowPipCount() == 1;
		int numDoms = 0;
		for (int x = min / 2; x <= max / 2; x++) {
			for (int y = 0; y < 3; y++) {
				for (int z = min / 2; z <= max / 2; z++) {
					for (int d = 0; d < 3; d++) {
						try {
							Domino d2 = new DominoHighLowImpl_Arroyo(x, y, z, d);
							numDoms++;
						}
						catch (AssertionError ae) {
							
						}
					}
				}
			}
		}
		assert numDoms == expectingDominoes;
		
		// Test bad cases here.
//		d1 = new DominoHighLowImpl_Arroyo(3, 0, 3, 2);
//		assert d1.getHighPipCount() == 4;
//		assert d1.getLowPipCount() == 1;
	}
	
	public static void testHighLowSetImplSumDifferenceString() {
		Domino d1 = new DominoHighLowSetImpl_Arroyo("6,2");
		assert d1.getHighPipCount() == 4;
		assert d1.getLowPipCount() == 2;
		d1 = new DominoHighLowSetImpl_Arroyo("10,0");
		assert d1.getHighPipCount() == 5;
		assert d1.getLowPipCount() == 5;
		d1 = new DominoHighLowSetImpl_Arroyo("7,1");
		assert d1.getHighPipCount() == 4;
		assert d1.getLowPipCount() == 3;
//		d1 = new DominoHighLowSetImpl_Arroyo("1,5");
//		assert d1.getHighPipCount() == 3;
//		assert d1.getLowPipCount() == 2;
//		d1 = new DominoHighLowSetImpl_Arroyo(null);
//		assert d1.getHighPipCount() == 6;
//		assert d1.getLowPipCount() == 6;
//		d1 = new DominoHighLowSetImpl_Arroyo("");
//		assert d1.getHighPipCount() == 6;
//		assert d1.getLowPipCount() == 5;
//		d1 = new DominoHighLowSetImpl_Arroyo("10,4");
//		assert d1.getHighPipCount() == 7;
//		assert d1.getLowPipCount() == 3;
//		d1 = new DominoHighLowSetImpl_Arroyo("8,8");
//		assert d1.getHighPipCount() == 8;
//		assert d1.getLowPipCount() == 0;
//		d1 = new DominoHighLowSetImpl_Arroyo("5:1");
//		assert d1.getHighPipCount() == 3;
//		assert d1.getLowPipCount() == 2;
		d1 = new DominoHighLowSetImpl_Arroyo("8,0");
		assert d1.getHighPipCount() == 4;
		assert d1.getLowPipCount() == 4;
		d1 = new DominoHighLowSetImpl_Arroyo("9,1");
		assert d1.getHighPipCount() == 5;
		assert d1.getLowPipCount() == 4;
		d1 = new DominoHighLowSetImpl_Arroyo("7,3");
		assert d1.getHighPipCount() == 5;
		assert d1.getLowPipCount() == 2;
		d1 = new DominoHighLowSetImpl_Arroyo("4,0");
		assert d1.getHighPipCount() == 2;
		assert d1.getLowPipCount() == 2;
	}
	
	public static void testHighLowSetImplDoubleInteger() {
		Domino d1 = new DominoHighLowSetImpl_Arroyo(4, 4);
		assert d1.getHighPipCount() == 4;
		assert d1.getLowPipCount() == 4;
		d1 = new DominoHighLowSetImpl_Arroyo(max, 2);
		assert d1.getHighPipCount() == max;
		assert d1.getLowPipCount() == 2;
		d1 = new DominoHighLowSetImpl_Arroyo(4, 3);
		assert d1.getHighPipCount() == 4;
		assert d1.getLowPipCount() == 3;
		d1 = new DominoHighLowSetImpl_Arroyo(min, min);
		assert d1.getHighPipCount() == min;
		assert d1.getLowPipCount() == min;
		d1 = new DominoHighLowSetImpl_Arroyo(max, 3);
		assert d1.getHighPipCount() == max;
		assert d1.getLowPipCount() == 3;
//		d1 = new DominoHighLowSetImpl_Arroyo(3, 4);
//		assert d1.getHighPipCount() == 4;
//		assert d1.getLowPipCount() == 3;
//		d1 = new DominoHighLowSetImpl_Arroyo(7, 0);
//		assert d1.getHighPipCount() == 7;
//		assert d1.getLowPipCount() == 0;
		d1 = new DominoHighLowSetImpl_Arroyo(max, 4);
		assert d1.getHighPipCount() == max;
		assert d1.getLowPipCount() == 4;
//		d1 = new DominoHighLowSetImpl_Arroyo(5, -1);
//		assert d1.getHighPipCount() == 5;
//		assert d1.getLowPipCount() == -1;
	}
	
	public static void testHighLowSetImplLowPlus8TimesHigh() {
		int numDominoes = 0;
		for (int x = min; x <= max; ++x) {
			for (int y = x; y <= max; ++y) {
				numDominoes++;
				int toAdd = x + (y * 8);
				Domino d1 = new DominoHighLowSetImpl_Arroyo(toAdd);
				int lowPip = toAdd % 8;
				int highPip = (toAdd - lowPip) / 8;
				assert d1.getLowPipCount() == lowPip;
				assert d1.getHighPipCount() == highPip;
			}
		}
		assert numDominoes == expectingDominoes;
		// Test Bad pip counts here 
//		Domino d1 = new DominoHighLowSetImpl_Arroyo(0);
//		assert d1.getLowPipCount() == 0;
//		assert d1.getHighPipCount() == 0;
	}
	
	public static void testLowDifferenceStringImplLowPlus8TimesHigh() {
		int numDominoes = 0;
		for (int x = min; x <= max; ++x) {
			for (int y = x; y <= max; ++y) {
				numDominoes++;
				int toAdd = x + (y * 8);
				Domino d1 = new DominoHighLowSetImpl_Arroyo(toAdd);
				int lowPip = toAdd % 8;
				int highPip = (toAdd - lowPip) / 8;
				assert d1.getLowPipCount() == lowPip;
				assert d1.getHighPipCount() == highPip;
			}
		}
		assert numDominoes == expectingDominoes;
		// Test bad pip counts here
//		Domino d1 = new DominoHighLowSetImpl_Arroyo(9);
//		assert d1.getLowPipCount() == 1;
//		assert d1.getHighPipCount() == 1;
	}
	
	public static void testLowDiffereceStringImplHighSumSet() {
		Domino d1 = new DominoLowDifferenceStringImpl_Arroyo(new ArrayList<Integer>(Arrays.asList(4, 6)));
		assert d1.getHighPipCount() == 4;
		assert d1.getLowPipCount() == 2;
		d1 = new DominoLowDifferenceStringImpl_Arroyo(new ArrayList<Integer>(Arrays.asList(2, 4)));
		assert d1.getHighPipCount() == 2;
		assert d1.getLowPipCount() == 2;
//		d1 = new DominoLowDifferenceStringImpl_Arroyo(new ArrayList<Integer>(Arrays.asList(2, 8)));
//		assert d1.getHighPipCount() == 2;
//		assert d1.getLowPipCount() == 6;
		d1 = new DominoLowDifferenceStringImpl_Arroyo(new ArrayList<Integer>(Arrays.asList(5, 10)));
		assert d1.getHighPipCount() == 5;
		assert d1.getLowPipCount() == 5;
		d1 = new DominoLowDifferenceStringImpl_Arroyo(new ArrayList<Integer>(Arrays.asList(5, 9)));
		assert d1.getHighPipCount() == 5;
		assert d1.getLowPipCount() == 4;
		d1 = new DominoLowDifferenceStringImpl_Arroyo(new ArrayList<Integer>(Arrays.asList(4, 7)));
		assert d1.getHighPipCount() == 4;
		assert d1.getLowPipCount() == 3;
		d1 = new DominoLowDifferenceStringImpl_Arroyo(new ArrayList<Integer>(Arrays.asList(4, 8)));
		assert d1.getHighPipCount() == 4;
		assert d1.getLowPipCount() == 4;
//		d1 = new DominoLowDifferenceStringImpl_Arroyo(new ArrayList<Integer>(Arrays.asList(4, 3)));
//		assert d1.getHighPipCount() == 4;
//		assert d1.getLowPipCount() == 3;
		d1 = new DominoLowDifferenceStringImpl_Arroyo(new ArrayList<Integer>(Arrays.asList(3, 5)));
		assert d1.getHighPipCount() == 3;
		assert d1.getLowPipCount() == 2;
//		List<Integer> aList = null;
//		d1 = new DominoLowDifferenceStringImpl_Arroyo(aList);
//		List<Integer> aList = new ArrayList<Integer>();
//		d1 = new DominoLowDifferenceStringImpl_Arroyo(aList);
//		d1 = new DominoLowDifferenceStringImpl_Arroyo(new ArrayList<Integer>(Arrays.asList(2, 5)));
//		assert d1.getHighPipCount() == 2;
//		assert d1.getLowPipCount() == 3;
	}
	
	
}
