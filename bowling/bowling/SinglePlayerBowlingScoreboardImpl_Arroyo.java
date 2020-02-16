package bowling;

import java.util.Arrays;

public class SinglePlayerBowlingScoreboardImpl_Arroyo implements SinglePlayerBowlingScoreboard, AssignmentMetaData
{
    private static final int MAXIMUM_ROLLS = 21;
    private static final int MIN_BOX_COUNT = 1;
    private static final int MAX_BOX_COUNT_10_FRAME = 3;
    private static final int MAX_BOX_COUNT_SINGLE_FRAME = 2;
    private static final int MAX_FRAMES = 10;
    private static final int MAX_FRAMES_MINUS_LAST_FRAME = 9;
    private static final int MIN_FRAMES = 1;
    private String playerName;
    private int[] pinsKnockedDownArray;
    private int rollCount;
    public final int strike = 10;
    private static final String VERTICAL_SEPARATOR = "#";
    private static final String HORIZONTAL_SEPARATOR = "#";
    private static final String LEFT_EDGE_OF_SMALL_SQUARE = "[";
    private static final String RIGHT_EDGE_OF_SMALL_SQUARE = "]";
    
    public SinglePlayerBowlingScoreboardImpl_Arroyo(final String playerName) {
        this.pinsKnockedDownArray = new int[21];
        this.rollCount = 0;
        assert playerName != null : "playerName is null!";
        this.playerName = playerName;
    }
    
    public String getPlayerName() {
        return playerName;
    }
   
    //use Helper methods 
    public boolean isGameOver() {
    	boolean lastMarkTaken;
    	boolean secondLastMarkTaken;
    	boolean gameIsOver;
    	Mark lastMark = null;
    	Mark secondLastMark = null;
    	Mark thirdLastMark = null;
    	try {
    		lastMark = getMark(10, 3);
    		lastMarkTaken = true;
    	}
    	catch (AssertionError ae) {
    		lastMarkTaken = false;
    	}
    	if (!lastMarkTaken) {
    		try {
    			secondLastMark = getMark(10, 2);
    			secondLastMarkTaken = true;
    			thirdLastMark = getMark(10, 1);
    		}
    		catch(AssertionError ae) {
    			secondLastMarkTaken = false;
    		}
    		if (secondLastMarkTaken) {
    			if (secondLastMark.equals(Mark.STRIKE) || secondLastMark.equals(Mark.SPARE) || thirdLastMark.equals(Mark.STRIKE) ) {
    				gameIsOver = true;
    			}
    			else {
    				gameIsOver = false;
    			}
    				
    		}
    		else {
    			gameIsOver = false;
    		}
    	}
    	else {
    		gameIsOver = true;
    	}
    	return gameIsOver;
    }
    
    // If given a frame of 1 and 3 frames have been played,
    // return 6
    // If given a frame of 2 and 3 frames have been played,
    // return 12
    public int getScore(int frameNumber) {
        assert frameNumber >= 1 && frameNumber <= 10;
        assert this.getCurrentFrame() > frameNumber;
        int frameScore = 0;
        if (frameNumber >= 1 && frameNumber <= 9) {
        	frameScore = singleDigitFrameGetScore(frameNumber);
        }
        else {
        	frameScore = tenthFrameGetScore();
        }
        // THIS APPROACH ONLY WORKS FOR NO STRIKES AND SPARES, NO 10th frame
        return frameScore;
    }
    
    public Mark getMark(int frameNumber, int boxIndex) {
        assert frameInBounds(10, frameNumber);
        assert boxIndexInBounds(frameNumber, boxIndex);
        if (frameNumber < 10) {
        	assert getCurrentFrame() >= frameNumber;
            assert boxIndex >= 1 && boxIndex <= 2;
        }
        else {
            assert boxIndex >= 1 && boxIndex <= 3;
        }
        
        Mark mark = null;
        if (frameNumber < 10) {
            mark = getMarkSingleDigitFrameNumber(frameNumber, boxIndex);
        }
        else {
        	mark = getMarkTenthFrame(boxIndex);
        }
        assert mark != null : "mark is null!";
        return mark;
    }
    
    public int getCurrentFrame() {
        assert !isGameOver() : "Game is over!";
        int nonStrikeRolls = rollCount - numStrikesInPinsArray(pinsKnockedDownArray);
        int strikeRolls = numStrikesInPinsArray(pinsKnockedDownArray);
        // Frames are 1 based so we add 1 to our calculation before returning a value
        // Bottleneck occurs when the player rolls two strikes on the 10th frame.
       
        return findSingleDigitCurrentFrame(nonStrikeRolls, strikeRolls);
    }
    
    public int getCurrentBall() {
        assert !isGameOver() : "Game is over!";
        int ballNumber = 1;
        // move down the pinsArray, incrementing ballNumber if the number of pins hit isn't a strike
        // reset the ballNumber to 2 if we get to a value greater than 2 because (not counting 10th frame)
        // this means we've arrived at a new frame, and the ballNumber should be 1. 
        if (getCurrentFrame() < 10) {
        	int nonStrikeRolls = rollCount - numStrikesInPinsArray(pinsKnockedDownArray);
        	ballNumber = (nonStrikeRolls % 2 == 0) ? 1 : 2;
//        	boolean foundAStrike = nonStrikeRolls < rollCount;
//        	if (foundAStrike && isStrike(getCurrentFrame() - 1)) {
//        		ballNumber = 1;
//        	}
//        	else {
//        		ballNumber = (nonStrikeRolls % 2 == 0) ? 1 : 2;
//        	}
        }
        else {
        	// find number of rolls before 10th frame using formula
        	// do rollCount - numRollsBefore10th frame
        	// getCurrentBall() should be set to the difference + 1.
        	ballNumber = (rollCount - findNumRollsUpToFrame(MAX_FRAMES, pinsKnockedDownArray)) + 1;
        }
        return ballNumber;
//        for (int x = 0; x < rollCount; ++x) {
//            if (pinsKnockedDownArray[x] == strike) {
//                ballNumber = 1;
//            }
//            else {
//                ++ballNumber;
//            }
//            // DOESNT WORK FOR THE 10TH FRAME. We'll need to move this to a 3 for 10th frame
//            if (ballNumber > 2) {
//                ballNumber = 1;
//            }
//        }
//        return ballNumber;
    }
    
    public void recordRoll(final int pinsKnockedDown) {
        assert pinsKnockedDown >= 0 : "pinsKnockedDown = " + pinsKnockedDown + " < 0!";
        assert pinsKnockedDown <= 10 : "pinsKnockedDown = " + pinsKnockedDown + " > 10!";
        // frame overflow check ONLY FOR SINGLE DIGIT FRAME, 10TH FRAME NOT YET IMPLEMENTED
        assert !didFrameOverflow(getCurrentFrame(), pinsKnockedDown);
     
        // If you're on ball 3, you better be on frame 10 and have had a roll on frame 10 ball 2 which was a strike or spare !
        // OR, if we're on ball 2 and the frame isn't the 10th frame, then our total pinsKnockedDown (prev + current) must be <= 10
        //assert this.getCurrentBall() == 3 && ((this.getCurrentFrame() == 10 && this.isStrikeOrSpare(this.getMark(10, 2))) || this.pinsKnockedDownArray[this.rollCount - 1] + pinsKnockedDown <= 10);
        assert !this.isGameOver() : "Game is over!";
        
        pinsKnockedDownArray[rollCount] = pinsKnockedDown;
        ++rollCount;
    }
    
    private static int findNumRollsUpToFrame(int frame, int[] pins) {
    	int numFrames = 1;
    	final int strike = 10;
    	int rolls = 0;
    	int ballCounter = 0;
    	// could end up in an index out of bounds if the frane
    	while (numFrames < frame) {
    		ballCounter++;
    		if (pins[rolls] == strike) {
    			numFrames++;
    			ballCounter = 0;
    		}
    		else if (ballCounter >= 2) {
    			numFrames++;
    			ballCounter = 0;
    		}
    		rolls++;
    	}
    	//System.out.println(rolls);
    	return rolls;
    }
    
    
    private boolean didFrameOverflow(int frame, int pinsHit) {
    	boolean overflow = false;
    	if (frame < 10) {
    		if (getCurrentBall() == 2) {
            	int prevPins = pinsKnockedDownArray[rollCount - 1];
            	if (prevPins + pinsHit > 10) {
            		overflow = true;
            	}
            }
    	}
    	else {
    		if (getCurrentBall() == 3) {
    			overflow = isStrikeOrSpare(getMark(10, 2));
    		}
    		else if (getCurrentBall() == 2) {
    			throw new RuntimeException("NOT IMPLEMENTED YET");
    		}
    	}
    	return overflow;
    }
    
    private int numStrikesInPinsArray(final int[] pins) {
    	int numStrikes = 0;
    	for (int x = 0 ; x < pins.length; ++x) {
    		if (pins[x] == strike) {
    			numStrikes++;
    		}
    	}
    	return numStrikes;
    }
    
    private int singleDigitFrameGetScore(int frame) {
    	int frameScore = 0;
    	if (isStrike(frame)) {
    		throw new RuntimeException("NOT IMPLEMENTED YET!");
    	}
    	else if (isSpare(frame)){
    		throw new RuntimeException("NOT IMPLEMENTED YET!");
    	}
    	else {
    		int lastBoxOfFrame = frame * 2;
            for (int x = 0; x < lastBoxOfFrame; ++x) {
            	frameScore += pinsKnockedDownArray[x];
            }
    	}
    	return frameScore;
    }
    
    private int tenthFrameGetScore() {
    	throw new RuntimeException("NOT IMPLEMENTED YET");
    }
    
    private static int findSingleDigitCurrentFrame(int nonStrikeRolls, int strikeRolls) {
    	 return (nonStrikeRolls / 2) + strikeRolls + 1;
    }
    
    // Refactor
    private Mark getMarkSingleDigitFrameNumber(int frameNumber, final int boxIndex) {
        final int frameLimit = 9;
        assert frameInBounds(frameLimit, frameNumber);
        assert boxIndexInBounds(frameNumber, boxIndex);
        final int numFrames = 1;
        final int strike = 10;
        int frameStoppingPointPinsIndex = 0;
        while (frameNumber > 1) {
            frameStoppingPointPinsIndex += 2;
            --frameNumber;
        }
        return Mark.translate(this.pinsKnockedDownArray[boxIndex - 1 + frameStoppingPointPinsIndex]);
    }
    
    private Mark getMarkTenthFrame(final int boxIndex) {
    	int numRollsBefore10th = findNumRollsUpToFrame(MAX_FRAMES, pinsKnockedDownArray);
    	int searchPinsIndex = boxIndex + numRollsBefore10th - 1;
    	// Interesting case where we're currently on the 10th frame, but the boxIndex is ahead of
    	// the last roll index in the pinsKnockedDownArray 
    	assert rollCount > searchPinsIndex;
    	System.out.println("Mark that i'm returning: " + Mark.translate(pinsKnockedDownArray[searchPinsIndex]));
    	return Mark.translate(pinsKnockedDownArray[searchPinsIndex]);
    }
    
    // Refactor
    private int getRollIndexOfFirstBall(final int frameNumber) {
        if (getCurrentBall() == 2) {
        	return rollCount - 1;
        }
        else {
        	return rollCount;
        }
    }
    
    private boolean isStrike(final int frameNumber) {
        return false;
    }
    
    private boolean isSpare(final int frameNumber) {
    	return false;
    }
    
    private boolean isStrikeOrSpare(final Mark mark) {
        return (mark == Mark.STRIKE || mark == Mark.SPARE);
    }
    
    private static boolean boxIndexInBounds(final int frame, final int boxIndex) {
        final int max = (frame == 10) ? 3 : 2;
        return boxIndex <= max && boxIndex >= 1;
    }
    
    private static boolean frameInBounds(final int frameLimit, final int frameNumber) {
        final int max = (frameLimit < 10) ? 9 : 10;
        return frameNumber <= max && frameNumber >= 1;
    }
    
    public String toString() {
        return Arrays.toString(pinsKnockedDownArray);
    }
    
    private String getScoreboardDisplay() {
        final StringBuffer frameNumberLineBuffer = new StringBuffer();
        final StringBuffer markLineBuffer = new StringBuffer();
        final StringBuffer horizontalRuleBuffer = new StringBuffer();
        final StringBuffer scoreLineBuffer = new StringBuffer();
        frameNumberLineBuffer.append("#");
        markLineBuffer.append("#");
        horizontalRuleBuffer.append("#");
        scoreLineBuffer.append("#");
        for (int frameNumber = 1; frameNumber <= 9; ++frameNumber) {
            frameNumberLineBuffer.append("  " + frameNumber + "  ");
            markLineBuffer.append(" ");
            markLineBuffer.append(this.getMark(frameNumber, 1));
            markLineBuffer.append("[");
            markLineBuffer.append(this.getMark(frameNumber, 2));
            markLineBuffer.append("]");
            final int CHARACTER_WIDTH_SCORE_AREA = 5;
            for (int i = 0; i < 5; ++i) {
                horizontalRuleBuffer.append("#");
            }
            if (this.isGameOver() || frameNumber < this.getCurrentFrame()) {
                final int score = this.getScore(frameNumber);
                final int PADDING_NEEDED_BEHIND_SCORE = 1;
                for (int PADDING_NEEDED_IN_FRONT_OF_SCORE = 5 - new StringBuilder().append(score).toString().length() - 1, j = 0; j < PADDING_NEEDED_IN_FRONT_OF_SCORE; ++j) {
                    scoreLineBuffer.append(" ");
                }
                scoreLineBuffer.append(score);
                for (int j = 0; j < 1; ++j) {
                    scoreLineBuffer.append(" ");
                }
            }
            else {
                for (int i = 0; i < 5; ++i) {
                    scoreLineBuffer.append(" ");
                }
            }
            frameNumberLineBuffer.append("#");
            markLineBuffer.append("#");
            horizontalRuleBuffer.append("#");
            scoreLineBuffer.append("#");
        }
        final String THREE_SPACES = "   ";
        frameNumberLineBuffer.append("   10   ");
        markLineBuffer.append(" ");
        markLineBuffer.append(this.getMark(10, 1));
        markLineBuffer.append("[");
        markLineBuffer.append(this.getMark(10, 2));
        markLineBuffer.append("]");
        markLineBuffer.append("[");
        markLineBuffer.append(this.getMark(10, 3));
        markLineBuffer.append("]");
        final int CHARACTER_WIDTH_SCORE_AREA = 8;
        for (int i = 0; i < 8; ++i) {
            horizontalRuleBuffer.append("#");
        }
        if (this.isGameOver()) {
            final int score = this.getScore(10);
            final int PADDING_NEEDED_BEHIND_SCORE = 1;
            for (int PADDING_NEEDED_IN_FRONT_OF_SCORE = 8 - new StringBuilder().append(score).toString().length() - 1, j = 0; j < PADDING_NEEDED_IN_FRONT_OF_SCORE; ++j) {
                scoreLineBuffer.append(" ");
            }
            scoreLineBuffer.append(score);
            for (int j = 0; j < 1; ++j) {
                scoreLineBuffer.append(" ");
            }
        }
        else {
            for (int i = 0; i < 8; ++i) {
                scoreLineBuffer.append(" ");
            }
        }
        frameNumberLineBuffer.append("#");
        markLineBuffer.append("#");
        horizontalRuleBuffer.append("#");
        scoreLineBuffer.append("#");
        return String.valueOf(this.getPlayerName()) + "\n" + horizontalRuleBuffer.toString() + "\n" + frameNumberLineBuffer.toString() + "\n" + horizontalRuleBuffer.toString() + "\n" + markLineBuffer.toString() + "\n" + scoreLineBuffer.toString() + "\n" + horizontalRuleBuffer.toString();
    }
    
    public String getFirstNameOfSubmitter() {
        return "Geoff";
    }
    
    public String getLastNameOfSubmitter() {
        return "Arroyo";
    }
    
    public double getHoursSpentWorkingOnThisAssignment() {
        return 15.0;
    }
    
    public int getScoreAgainstTestCasesSubset() {
        return 80;
    }
}
