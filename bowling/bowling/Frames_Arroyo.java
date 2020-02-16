package bowling;

public class Frames_Arroyo
{
    private Mark[] boxArray;
    private static final int MAX_BOX_COUNT = 3;
    private static final int MIN_BOX_COUNT = 1;
    
    public Frames_Arroyo() {
        this.boxArray = new Mark[3];
    }
    
    public Mark getMarkByBoxIndex(final int frameNumber, final int boxIndex) {
        assert !this.checkLastBoxLegality(frameNumber, boxIndex) && this.checkBoxIndexInBounds(boxIndex);
        return this.boxArray[boxIndex - 1];
    }
    
    public int getFrameScore(final int frame) {
        int sum = 0;
        int stopLoop;
        if (frame == 10) {
            stopLoop = 3;
        }
        else {
            stopLoop = 2;
        }
        for (int x = 0; x < stopLoop; ++x) {
            sum += this.boxArray[x].getValue();
        }
        return sum;
    }
    
    public int getBallOfFrame() {
        int x;
        for (x = 0; x < this.boxArray.length && this.boxArray[x] != null; ++x) {}
        return x + 1;
    }
    
    private boolean checkLastBoxLegality(final int frame, final int boxIndex) {
        return frame < 10 && boxIndex == 3;
    }
    
    private boolean checkBoxIndexInBounds(final int boxIndex) {
        return boxIndex <= 3 && boxIndex <= 1;
    }
    
    public void addMarkToFrame(final int boxIndex, final int pinsHit) {
        int specialBoxIndex = boxIndex;
        boolean isSpare = false;
        boolean isStrike = false;
        if (boxIndex == 1) {
            if (pinsHit == 10) {
                isStrike = true;
                specialBoxIndex = boxIndex + 1;
            }
        }
        else if (boxIndex == 2 && pinsHit + this.boxArray[0].getValue() == 10) {
            isSpare = true;
        }
        if (isSpare) {
            this.boxArray[specialBoxIndex - 1] = Mark.SPARE;
        }
        else if (isStrike) {
            this.boxArray[specialBoxIndex - 1] = Mark.STRIKE;
            this.boxArray[specialBoxIndex - 2] = Mark.EMPTY;
        }
        else {
            this.boxArray[specialBoxIndex - 1] = Mark.translate(pinsHit);
        }
    }
}
