package test;
import bowling.*;
public class TestBolwing
{
    public static void main(final String[] args) {
    	SinglePlayerBowlingScoreboardImpl_Arroyo s = getGame();
    	int[] pinsKnockedDownArray = new int[]{1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2};
    	for (int x = 0; x < pinsKnockedDownArray.length; ++x) {
    		s.recordRoll(pinsKnockedDownArray[x]);
    	}
    	s.getScore(10);
        testIsGameOver();
        testGetScore();
        testGetCurrentBall();
        testGetCurrentFrame();
        testGetMark();
        System.out.println("All assertions passed");
    }
    
    public static SinglePlayerBowlingScoreboardImpl_Arroyo getGame() {
        return new SinglePlayerBowlingScoreboardImpl_Arroyo("Geoff");
    }
    
    public static void testIsGameOver() {
        SinglePlayerBowlingScoreboardImpl_Arroyo s = getGame();
        assert !s.isGameOver();
        s.recordRoll(10);
        s.recordRoll(3);
        s.recordRoll(5);
        assert !s.isGameOver();
    }
    
    public static void testGetScore() {
        SinglePlayerBowlingScoreboardImpl_Arroyo s = getGame();
        boolean t = false;
        try {
            s.getScore(1);
        }
        catch (AssertionError ae) {
            t = true;
        }
        assert t;
        t = false;
        try {
            s.getScore(0);
        }
        catch (AssertionError ae) {
            t = true;
        }
        s.recordRoll(2);
        s.recordRoll(3);
        assert s.getScore(1) == 5;
        s.recordRoll(5);
        s.recordRoll(4);
        assert s.getScore(2) == 9;
        s.recordRoll(3);
        s.recordRoll(2);
        assert s.getScore(3) == 5;
        s.recordRoll(0);
        s.recordRoll(0);
        assert s.getScore(4) == 0;
        s.recordRoll(8);
        s.recordRoll(0);
        assert s.getScore(5) == 8;
        s.recordRoll(4);
        s.recordRoll(1);
        assert s.getScore(6) == 5;
        s.recordRoll(3);
        s.recordRoll(0);
        assert s.getScore(7) == 3;
        s.recordRoll(2);
        s.recordRoll(6);
        assert s.getScore(8) == 8;
        s.recordRoll(1);
        s.recordRoll(0);
        assert s.getScore(9) == 1;
    }
    
    public static void testGetCurrentBall() {
        SinglePlayerBowlingScoreboardImpl_Arroyo s = getGame();
        assert s.getCurrentBall() == 1;
        s.recordRoll(2);
        assert s.getCurrentBall() == 2;
        s.recordRoll(2);
        assert s.getCurrentBall() == 1;
        s.recordRoll(7);
        assert s.getCurrentBall() == 2;
        s.recordRoll(1);
        assert s.getCurrentBall() == 1;
    }
    
    public static void testGetCurrentFrame() {
        SinglePlayerBowlingScoreboardImpl_Arroyo s = getGame();
        assert s.getCurrentFrame() == 1;
        s.recordRoll(10);
        assert s.getCurrentFrame() == 2;
        s.recordRoll(3);
        assert s.getCurrentFrame() == 2;
        s.recordRoll(4);
        assert s.getCurrentFrame() == 3;
    }
    
    public static void testRecordRoll() {
    	SinglePlayerBowlingScoreboardImpl_Arroyo s = getGame();
    	int[] badRolls = new int[] {-1, 11, 1000, -4, 55};
    	int numFails = 0;
    	for (int x = 0; x < badRolls.length; ++x) {
    		try {
    			s.recordRoll(badRolls[x]);
    		}
    		catch(AssertionError ae) {
    			numFails++;
    		}
    	}
    	assert numFails == badRolls.length;
    	
    }
    
    public static void testGetMark() {
        final SinglePlayerBowlingScoreboardImpl_Arroyo s = getGame();
        boolean t = false;
        try {
            s.getMark(1, 1);
        }
        catch (AssertionError ae) {
            t = true;
        }
        assert t;
        s.recordRoll(3);
        assert s.getMark(1, 1) == Mark.THREE;
        s.recordRoll(4);
        assert s.getMark(1, 2) == Mark.FOUR;
        s.recordRoll(5);
        t = false;
        try {
        	assert s.getMark(2, 2) == Mark.FIVE;
        }
        catch (AssertionError ae) {
        	t = true;
        }
        assert t;
        assert s.getMark(2, 1) == Mark.FIVE;
    }
}
