package bowling;

import java.util.HashMap;
import java.util.Map;

public enum Mark
{
    ZERO("ZERO", 0, "-"), 
    ONE("ONE", 1, "1"), 
    TWO("TWO", 2, "2"), 
    THREE("THREE", 3, "3"), 
    FOUR("FOUR", 4, "4"), 
    FIVE("FIVE", 5, "5"), 
    SIX("SIX", 6, "6"), 
    SEVEN("SEVEN", 7, "7"), 
    EIGHT("EIGHT", 8, "8"), 
    NINE("NINE", 9, "9"), 
    STRIKE("STRIKE", 10, "X"), 
    SPARE("SPARE", 11, "/"), 
    EMPTY("EMPTY", 12, " ");
    
    private final String stringRepresentation;
    private static Map<Integer, Mark> integerToMarkMap;
    
    static {
        (Mark.integerToMarkMap = new HashMap<Integer, Mark>()).put(0, Mark.ZERO);
        Mark.integerToMarkMap.put(1, Mark.ONE);
        Mark.integerToMarkMap.put(2, Mark.TWO);
        Mark.integerToMarkMap.put(3, Mark.THREE);
        Mark.integerToMarkMap.put(4, Mark.FOUR);
        Mark.integerToMarkMap.put(5, Mark.FIVE);
        Mark.integerToMarkMap.put(6, Mark.SIX);
        Mark.integerToMarkMap.put(7, Mark.SEVEN);
        Mark.integerToMarkMap.put(8, Mark.EIGHT);
        Mark.integerToMarkMap.put(9, Mark.NINE);
    }
    
    private Mark(final String name, final int ordinal, final String stringRepresentation) {
        this.stringRepresentation = stringRepresentation;
    }
    
    public static Mark translate(final int pinCount) {
        if (pinCount == 0) {
            return Mark.ZERO;
        }
        if (pinCount == 1) {
            return Mark.ONE;
        }
        if (pinCount == 2) {
            return Mark.TWO;
        }
        if (pinCount == 3) {
            return Mark.THREE;
        }
        if (pinCount == 4) {
            return Mark.FOUR;
        }
        if (pinCount == 5) {
            return Mark.FIVE;
        }
        if (pinCount == 6) {
            return Mark.SIX;
        }
        if (pinCount == 7) {
            return Mark.SEVEN;
        }
        if (pinCount == 8) {
            return Mark.EIGHT;
        }
        if (pinCount == 9) {
            return Mark.NINE;
        }
        return null;
    }
    
    public int getValue() {
        if (this == Mark.ZERO) {
            return 0;
        }
        if (this == Mark.ONE) {
            return 1;
        }
        if (this == Mark.TWO) {
            return 2;
        }
        if (this == Mark.THREE) {
            return 3;
        }
        if (this == Mark.FOUR) {
            return 4;
        }
        if (this == Mark.FIVE) {
            return 5;
        }
        if (this == Mark.SIX) {
            return 6;
        }
        if (this == Mark.SEVEN) {
            return 7;
        }
        if (this == Mark.EIGHT) {
            return 8;
        }
        if (this == Mark.NINE) {
            return 9;
        }
        throw new RuntimeException("DO NOT CHANGE Mark.java!");
    }
    
    @Override
    public String toString() {
        return this.stringRepresentation;
    }
}
