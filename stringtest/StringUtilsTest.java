package stringtest;
import utils.StringUtils_Arroyo;
public class StringUtilsTest {
	public static void main(String[] args) {
//		assert false;
//		System.out.println("Assertions aren't enabled.");
		
		testStringUtilsReverse();
		testStringUtilsIsPalindrome();
		testStringUtilsGetCount();
		System.out.println("Assertions passed :)");
	}
	
	public static void testStringUtilsReverse() {
		assert StringUtils_Arroyo.reverse("abc").equals("cba");
		assert StringUtils_Arroyo.reverse("aaa").equals("aaa");
		assert StringUtils_Arroyo.reverse("   ").equals("   ");
		assert StringUtils_Arroyo.reverse("c t y c").equals("c y t c");
		
		boolean c = false;
		try {
			String g = StringUtils_Arroyo.reverse(null);
		}
		catch(AssertionError ae) {
			c = true;
		}
		assert c;
		
		assert StringUtils_Arroyo.reverse("!9?><~~").equals("~~<>?9!");
		assert StringUtils_Arroyo.reverse("anna").equals("anna");
		assert StringUtils_Arroyo.reverse("Anna").equals("annA");
		assert StringUtils_Arroyo.reverse("   H a H a h a \t").equals("\t a h a H a H   ");
		assert StringUtils_Arroyo.reverse("\n\t\"\"").equals("\"\"\t\n");
		assert StringUtils_Arroyo.reverse("").equals("");
		assert StringUtils_Arroyo.reverse("   ThAnK YoU ").equals(" UoY KnAhT   ");
		assert StringUtils_Arroyo.reverse("\uD834\uDD1Elol").equals("lol\uD834\uDD1E");
		assert StringUtils_Arroyo.reverse("Unicode\u00B0\u00BF\u1166").equals("\u1166\u00BF\u00B0edocinU");
	}
	
	public static void testStringUtilsIsPalindrome() {
		assert !StringUtils_Arroyo.isPalindrome("abc");
		assert StringUtils_Arroyo.isPalindrome("d");
		assert StringUtils_Arroyo.isPalindrome("$!$");
		assert !StringUtils_Arroyo.isPalindrome("!!2@!!");
		assert !StringUtils_Arroyo.isPalindrome("aaba");
		assert StringUtils_Arroyo.isPalindrome("  ");
		assert StringUtils_Arroyo.isPalindrome("");
		assert !StringUtils_Arroyo.isPalindrome("Anna");
		assert StringUtils_Arroyo.isPalindrome("anna");
		assert StringUtils_Arroyo.isPalindrome("rotor");
		assert StringUtils_Arroyo.isPalindrome("    ");
		assert StringUtils_Arroyo.isPalindrome("\t");
		assert StringUtils_Arroyo.isPalindrome("\n\nLOL\n\n");
		assert !StringUtils_Arroyo.isPalindrome("\t\tLOL\t\t\n");
		assert !StringUtils_Arroyo.isPalindrome("t\t");
		assert !StringUtils_Arroyo.isPalindrome("~~YY");
		assert StringUtils_Arroyo.isPalindrome("8989898");
		assert !StringUtils_Arroyo.isPalindrome("]}{[");
		
		boolean t = false;
		try {
			boolean s = StringUtils_Arroyo.isPalindrome(null);
		}
		catch(AssertionError ae) {
			t = true;
		}
		
		assert t;
		assert StringUtils_Arroyo.isPalindrome("\u00E9ef fe\u00E9");
		assert StringUtils_Arroyo.isPalindrome("\uD804\uDD2C\u0114\uD804\uDD2C");
		assert !StringUtils_Arroyo.isPalindrome("\uD83E\uDD84\u5ECC  UNICODE  \u5ECC");
		assert StringUtils_Arroyo.isPalindrome("\uD83E\uDD84");
	}
	
	public static void testStringUtilsGetCount() {
		assert StringUtils_Arroyo.getCount("AAA", "a") == 0;
		assert StringUtils_Arroyo.getCount("bbaab", "b") == 3;
		assert StringUtils_Arroyo.getCount("\n\nHello\n", "\n") == 3;
		assert StringUtils_Arroyo.getCount("555", "5555") == 0;
		assert StringUtils_Arroyo.getCount("76ABC", "76abc") == 0;
		assert StringUtils_Arroyo.getCount("76 ABC", "76 ABC") == 1;
		assert StringUtils_Arroyo.getCount("a ^ $ ^^", "^") == 3;
		assert StringUtils_Arroyo.getCount("a ^ $ ^^", "^^") == 1;
		
		int b;
		boolean c = false;
		try {
			b = StringUtils_Arroyo.getCount(null, null);
		}
		catch (AssertionError ae) {
			c = true;
		}
		assert c;
		c = false;
		try {
			b = StringUtils_Arroyo.getCount(null, "Hi");
		}
		catch (AssertionError ae) {
			c = true;
		}
		assert c;
		c = false;
		try {
			b = StringUtils_Arroyo.getCount("Hi", null);
		}
		catch (AssertionError ae) {
			c = true;
		}
		assert c;
		
		c = false;
		try {
			b = StringUtils_Arroyo.getCount("Hi", "");
		}
		catch (AssertionError ae) {
			c = true;
		}
		assert c;
		
		c = false;
		try {
			b = StringUtils_Arroyo.getCount("", "");
		}
		catch (AssertionError ae) {
			c = true;
		}
		assert c;
		
		assert StringUtils_Arroyo.getCount("a ^ $ ^^", " ") == 3;
		assert StringUtils_Arroyo.getCount("a ^ $ ^^", "  ") == 0;
		assert StringUtils_Arroyo.getCount("45554", "55") == 2;
		assert StringUtils_Arroyo.getCount(" 55555     ", "555") == 3;
		assert StringUtils_Arroyo.getCount("aaabbccabbcac", "bc") == 2;
		assert StringUtils_Arroyo.getCount("	bba", "\tbb") == 1;
		assert StringUtils_Arroyo.getCount("", "abc") == 0; 
		assert StringUtils_Arroyo.getCount("\uD804\uDD2C\u0114\uD804\uDD2C", "\uD804\uDD2C") == 2;
		assert StringUtils_Arroyo.getCount("\uD83D\uDE0E\u0114\uD804\uDD2C", "\uD83D") == 0;
	}
	
}
