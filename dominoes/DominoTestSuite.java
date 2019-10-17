package dominoes;

import java.util.Arrays;
import java.util.*;
public class DominoTestSuite {
	
	public static void main(String[] args) {
		testHighLowImplDoubleInteger();
		testHighLowImplHighLowString();
		testHighLowImplSumDifferenceArray();
		testHighLowImplHighLowSet();
		
		testHighLowSetImplSumDifferenceString();
		testHighLowSetImplDoubleInteger();
		testHighLowSetImplLowPlus8TimesHigh();
		
		testLowDifferenceStringImplLowPlus8TimesHigh();
		testLowDiffereceStringImplHighSumSet();
		System.out.println("Assertions passed");
		//assert false;
		//System.out.println("Assertions not enabled");
	}
	
	
	public static void testHighLowImplDoubleInteger() {
		Domino d1 = new DominoHighLowImpl_Arroyo(0, 0);
		assert d1.getHighPipCount() == 0;
		assert d1.getLowPipCount() == 0;
		d1 = new DominoHighLowImpl_Arroyo(5, 4);
		assert d1.getHighPipCount() == 5;
		assert d1.getLowPipCount() == 4;
		d1 = new DominoHighLowImpl_Arroyo(6, 1);
		assert d1.getHighPipCount() == 6;
		assert d1.getLowPipCount() == 1;
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
		d1 = new DominoHighLowImpl_Arroyo("2:1");
		assert d1.getHighPipCount() == 2;
		assert d1.getLowPipCount() == 1;
		d1 = new DominoHighLowImpl_Arroyo("3:0");
		assert d1.getHighPipCount() == 3;
		assert d1.getLowPipCount() == 0;
		d1 = new DominoHighLowImpl_Arroyo("6:6");
		assert d1.getHighPipCount() == 6;
		assert d1.getLowPipCount() == 6;
		d1 = new DominoHighLowImpl_Arroyo("5:1");
		assert d1.getHighPipCount() == 5;
		assert d1.getLowPipCount() == 1;
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
		Domino d1 = new DominoHighLowImpl_Arroyo(new int[]{5, 1});
		assert d1.getHighPipCount() == 3;
		assert d1.getLowPipCount() == 2;
		d1 = new DominoHighLowImpl_Arroyo(new int[]{6, 2});
		assert d1.getHighPipCount() == 4;
		assert d1.getLowPipCount() == 2;
		d1 = new DominoHighLowImpl_Arroyo(new int[]{4, 0});
		assert d1.getHighPipCount() == 2;
		assert d1.getLowPipCount() == 2;
		d1 = new DominoHighLowImpl_Arroyo(new int[]{3, 3});
		assert d1.getHighPipCount() == 3;
		assert d1.getLowPipCount() == 0;
//		d1 = new DominoHighLowImpl_Arroyo(new int[]{0, 2});
//		assert d1.getHighPipCount() == 2;
//		assert d1.getLowPipCount() == 2;
		d1 = new DominoHighLowImpl_Arroyo(new int[]{2, 2});
		assert d1.getHighPipCount() == 2;
		assert d1.getLowPipCount() == 0;
		d1 = new DominoHighLowImpl_Arroyo(new int[]{1, 1});
		assert d1.getHighPipCount() == 1;
		assert d1.getLowPipCount() == 0;
		d1 = new DominoHighLowImpl_Arroyo(new int[]{5, 3});
		assert d1.getHighPipCount() == 4;
		assert d1.getLowPipCount() == 1;
		d1 = new DominoHighLowImpl_Arroyo(new int[]{6, 4});
		assert d1.getHighPipCount() == 5;
		assert d1.getLowPipCount() == 1;
//		d1 = new DominoHighLowImpl_Arroyo(new int[]{3, 0});
//		assert d1.getHighPipCount() == 2;
//		assert d1.getLowPipCount() == 1;
	}
	
	public static void testHighLowImplHighLowSet() {
		Domino d1 = new DominoHighLowImpl_Arroyo(new HashSet<Integer>(Arrays.asList(5)));
		assert d1.getHighPipCount() == d1.getLowPipCount();
		assert d1.getHighPipCount() == 5;
		d1 = new DominoHighLowImpl_Arroyo(new HashSet<Integer>(Arrays.asList(0)));
		assert d1.getHighPipCount() == d1.getLowPipCount();
		assert d1.getLowPipCount() == 0;
		d1 = new DominoHighLowImpl_Arroyo(new HashSet<Integer>(Arrays.asList(0, 5)));
		assert d1.getHighPipCount() == 5;
		assert d1.getLowPipCount() == 0;
		d1 = new DominoHighLowImpl_Arroyo(new HashSet<Integer>(Arrays.asList(0, 0)));
		assert d1.getHighPipCount() == 0;
		assert d1.getLowPipCount() == 0;
		d1 = new DominoHighLowImpl_Arroyo(new HashSet<Integer>(Arrays.asList(4, 1)));
		assert d1.getHighPipCount() == 4;
		assert d1.getLowPipCount() == 1;
		d1 = new DominoHighLowImpl_Arroyo(new HashSet<Integer>(Arrays.asList(0, 5)));
		assert d1.getHighPipCount() == 5;
		assert d1.getLowPipCount() == 0;
//		d1 = new DominoHighLowImpl_Arroyo(new HashSet<Integer>(Arrays.asList(7)));
//		assert d1.getHighPipCount() == 7;
//		assert d1.getLowPipCount() == 7;
//		d1 = new DominoHighLowImpl_Arroyo(new HashSet<Integer>(Arrays.asList(0, 5, 7)));
//		assert d1.getHighPipCount() == 5;
//		assert d1.getLowPipCount() == 0;
		d1 = new DominoHighLowImpl_Arroyo(new HashSet<Integer>(Arrays.asList(6, 5)));
		assert d1.getHighPipCount() == 6;
		assert d1.getLowPipCount() == 5;
	}
	
	public static void testHighLowSetImplSumDifferenceString() {
		Domino d1 = new DominoHighLowSetImpl_Arroyo("6,2");
		assert d1.getHighPipCount() == 4;
		assert d1.getLowPipCount() == 2;
		d1 = new DominoHighLowSetImpl_Arroyo("10,2");
		assert d1.getHighPipCount() == 6;
		assert d1.getLowPipCount() == 4;
		d1 = new DominoHighLowSetImpl_Arroyo("7,1");
		assert d1.getHighPipCount() == 4;
		assert d1.getLowPipCount() == 3;
//		d1 = new DominoHighLowSetImpl_Arroyo("1,5");
//		assert d1.getHighPipCount() == 3;
//		assert d1.getLowPipCount() == 2;
		d1 = new DominoHighLowSetImpl_Arroyo("12,0");
		assert d1.getHighPipCount() == 6;
		assert d1.getLowPipCount() == 6;
		d1 = new DominoHighLowSetImpl_Arroyo("11,1");
		assert d1.getHighPipCount() == 6;
		assert d1.getLowPipCount() == 5;
//		d1 = new DominoHighLowSetImpl_Arroyo("10,4");
//		assert d1.getHighPipCount() == 7;
//		assert d1.getLowPipCount() == 3;
//		d1 = new DominoHighLowSetImpl_Arroyo("8,8");
//		assert d1.getHighPipCount() == 8;
//		assert d1.getLowPipCount() == 0;
		d1 = new DominoHighLowSetImpl_Arroyo("5,3");
		assert d1.getHighPipCount() == 4;
		assert d1.getLowPipCount() == 1;
		d1 = new DominoHighLowSetImpl_Arroyo("8,4");
		assert d1.getHighPipCount() == 6;
		assert d1.getLowPipCount() == 2;
	}
	
	public static void testHighLowSetImplDoubleInteger() {
		Domino d1 = new DominoHighLowSetImpl_Arroyo(4, 4);
		assert d1.getHighPipCount() == 4;
		assert d1.getLowPipCount() == 4;
		d1 = new DominoHighLowSetImpl_Arroyo(6, 2);
		assert d1.getHighPipCount() == 6;
		assert d1.getLowPipCount() == 2;
		d1 = new DominoHighLowSetImpl_Arroyo(6, 0);
		assert d1.getHighPipCount() == 6;
		assert d1.getLowPipCount() == 0;
		d1 = new DominoHighLowSetImpl_Arroyo(0, 0);
		assert d1.getHighPipCount() == 0;
		assert d1.getLowPipCount() == 0;
		d1 = new DominoHighLowSetImpl_Arroyo(5, 3);
		assert d1.getHighPipCount() == 5;
		assert d1.getLowPipCount() == 3;
//		d1 = new DominoHighLowSetImpl_Arroyo(3, 4);
//		assert d1.getHighPipCount() == 4;
//		assert d1.getLowPipCount() == 3;
//		d1 = new DominoHighLowSetImpl_Arroyo(7, 0);
//		assert d1.getHighPipCount() == 7;
//		assert d1.getLowPipCount() == 0;
		d1 = new DominoHighLowSetImpl_Arroyo(6, 1);
		assert d1.getHighPipCount() == 6;
		assert d1.getLowPipCount() == 1;
//		d1 = new DominoHighLowSetImpl_Arroyo(5, -1);
//		assert d1.getHighPipCount() == 5;
//		assert d1.getLowPipCount() == -1;
	}
	
	public static void testHighLowSetImplLowPlus8TimesHigh() {
		Domino d1 = new DominoHighLowSetImpl_Arroyo(52);
		assert d1.getHighPipCount() == 6;
		assert d1.getLowPipCount() == 4;
		d1 = new DominoHighLowSetImpl_Arroyo(54);
		assert d1.getHighPipCount() == 6;
		assert d1.getLowPipCount() == 6;
		d1 = new DominoHighLowSetImpl_Arroyo(35);
		assert d1.getHighPipCount() == 4;
		assert d1.getLowPipCount() == 3;
		d1 = new DominoHighLowSetImpl_Arroyo(45);
		assert d1.getHighPipCount() == 5;
		assert d1.getLowPipCount() == 5;
		d1 = new DominoHighLowSetImpl_Arroyo(50);
		assert d1.getHighPipCount() == 6;
		assert d1.getLowPipCount() == 2;
		d1 = new DominoHighLowSetImpl_Arroyo(42);
		assert d1.getHighPipCount() == 5;
		assert d1.getLowPipCount() == 2;
		d1 = new DominoHighLowSetImpl_Arroyo(49);
		assert d1.getHighPipCount() == 6;
		assert d1.getLowPipCount() == 1;
		d1 = new DominoHighLowSetImpl_Arroyo(43);
		assert d1.getHighPipCount() == 5;
		assert d1.getLowPipCount() == 3;
		d1 = new DominoHighLowSetImpl_Arroyo(51);
		assert d1.getHighPipCount() == 6;
		assert d1.getLowPipCount() == 3;
		d1 = new DominoHighLowSetImpl_Arroyo(27);
		assert d1.getHighPipCount() == 3;
		assert d1.getLowPipCount() == 3;
		d1 = new DominoHighLowSetImpl_Arroyo(0);
		assert d1.getHighPipCount() == 0;
		assert d1.getLowPipCount() == 0;
		d1 = new DominoHighLowSetImpl_Arroyo(8);
		assert d1.getHighPipCount() == 1;
		assert d1.getLowPipCount() == 0;
		d1 = new DominoHighLowSetImpl_Arroyo(9);
		assert d1.getHighPipCount() == 1;
		assert d1.getLowPipCount() == 1;
		d1 = new DominoHighLowSetImpl_Arroyo(16);
		assert d1.getHighPipCount() == 2;
		assert d1.getLowPipCount() == 0;
		d1 = new DominoHighLowSetImpl_Arroyo(33);
		assert d1.getHighPipCount() == 4;
		assert d1.getLowPipCount() == 1;
		d1 = new DominoHighLowSetImpl_Arroyo(41);
		assert d1.getHighPipCount() == 5;
		assert d1.getLowPipCount() == 1;
		d1 = new DominoHighLowSetImpl_Arroyo(25);
		assert d1.getHighPipCount() == 3;
		assert d1.getLowPipCount() == 1;
//		d1 = new DominoHighLowSetImpl_Arroyo(19);
//		assert d1.getHighPipCount() == 2;
//		assert d1.getLowPipCount() == 3;
//		d1 = new DominoHighLowSetImpl_Arroyo(38);
//		assert d1.getHighPipCount() == 4;
//		assert d1.getLowPipCount() == 6;
	}
	
	public static void testLowDifferenceStringImplLowPlus8TimesHigh() {
		Domino d1 = new DominoLowDifferenceStringImpl_Arroyo(52);
		assert d1.getHighPipCount() == 6;
		assert d1.getLowPipCount() == 4;
		d1 = new DominoLowDifferenceStringImpl_Arroyo(54);
		assert d1.getHighPipCount() == 6;
		assert d1.getLowPipCount() == 6;
		d1 = new DominoLowDifferenceStringImpl_Arroyo(35);
		assert d1.getHighPipCount() == 4;
		assert d1.getLowPipCount() == 3;
		d1 = new DominoLowDifferenceStringImpl_Arroyo(45);
		assert d1.getHighPipCount() == 5;
		assert d1.getLowPipCount() == 5;
		d1 = new DominoLowDifferenceStringImpl_Arroyo(50);
		assert d1.getHighPipCount() == 6;
		assert d1.getLowPipCount() == 2;
		d1 = new DominoLowDifferenceStringImpl_Arroyo(42);
		assert d1.getHighPipCount() == 5;
		assert d1.getLowPipCount() == 2;
		d1 = new DominoLowDifferenceStringImpl_Arroyo(49);
		assert d1.getHighPipCount() == 6;
		assert d1.getLowPipCount() == 1;
		d1 = new DominoLowDifferenceStringImpl_Arroyo(43);
		assert d1.getHighPipCount() == 5;
		assert d1.getLowPipCount() == 3;
		d1 = new DominoLowDifferenceStringImpl_Arroyo(51);
		assert d1.getHighPipCount() == 6;
		assert d1.getLowPipCount() == 3;
		d1 = new DominoLowDifferenceStringImpl_Arroyo(27);
		assert d1.getHighPipCount() == 3;
		assert d1.getLowPipCount() == 3;
		d1 = new DominoLowDifferenceStringImpl_Arroyo(0);
		assert d1.getHighPipCount() == 0;
		assert d1.getLowPipCount() == 0;
		d1 = new DominoLowDifferenceStringImpl_Arroyo(8);
		assert d1.getHighPipCount() == 1;
		assert d1.getLowPipCount() == 0;
		d1 = new DominoLowDifferenceStringImpl_Arroyo(9);
		assert d1.getHighPipCount() == 1;
		assert d1.getLowPipCount() == 1;
		d1 = new DominoLowDifferenceStringImpl_Arroyo(16);
		assert d1.getHighPipCount() == 2;
		assert d1.getLowPipCount() == 0;
		d1 = new DominoLowDifferenceStringImpl_Arroyo(33);
		assert d1.getHighPipCount() == 4;
		assert d1.getLowPipCount() == 1;
		d1 = new DominoLowDifferenceStringImpl_Arroyo(41);
		assert d1.getHighPipCount() == 5;
		assert d1.getLowPipCount() == 1;
		d1 = new DominoLowDifferenceStringImpl_Arroyo(25);
		assert d1.getHighPipCount() == 3;
		assert d1.getLowPipCount() == 1;
//		d1 = new DominoLowDifferenceStringImpl_Arroyo(19);
//		assert d1.getHighPipCount() == 2;
//		assert d1.getLowPipCount() == 3;
//		d1 = new DominoLowDifferenceStringImpl_Arroyo(11);
//		assert d1.getHighPipCount() == 1;
//		assert d1.getLowPipCount() == 3;
	}
	
	public static void testLowDiffereceStringImplHighSumSet() {
		Domino d1 = new DominoLowDifferenceStringImpl_Arroyo(new ArrayList<Integer>(Arrays.asList(4, 6)));
		assert d1.getHighPipCount() == 4;
		assert d1.getLowPipCount() == 2;
		d1 = new DominoLowDifferenceStringImpl_Arroyo(new ArrayList<Integer>(Arrays.asList(1, 2)));
		assert d1.getHighPipCount() == 1;
		assert d1.getLowPipCount() == 1;
//		d1 = new DominoLowDifferenceStringImpl_Arroyo(new ArrayList<Integer>(Arrays.asList(2, 8)));
//		assert d1.getHighPipCount() == 2;
//		assert d1.getLowPipCount() == 6;
		d1 = new DominoLowDifferenceStringImpl_Arroyo(new ArrayList<Integer>(Arrays.asList(6, 12)));
		assert d1.getHighPipCount() == 6;
		assert d1.getLowPipCount() == 6;
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
		d1 = new DominoLowDifferenceStringImpl_Arroyo(new ArrayList<Integer>(Arrays.asList(3, 3)));
		assert d1.getHighPipCount() == 3;
		assert d1.getLowPipCount() == 0;
		d1 = new DominoLowDifferenceStringImpl_Arroyo(new ArrayList<Integer>(Arrays.asList(0, 0)));
		assert d1.getHighPipCount() == 0;
		assert d1.getLowPipCount() == 0;
		d1 = new DominoLowDifferenceStringImpl_Arroyo(new ArrayList<Integer>(Arrays.asList(3, 5)));
		assert d1.getHighPipCount() == 3;
		assert d1.getLowPipCount() == 2;
	}
	
}
