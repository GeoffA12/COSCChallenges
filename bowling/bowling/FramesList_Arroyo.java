package bowling;

import java.util.ArrayList;
import java.util.List;

public class FramesList_Arroyo
{
    private List<Frames_Arroyo> frameArrayList;
    private static final int MAX_FRAMES = 10;
    
    public FramesList_Arroyo() {
        this.frameArrayList = new ArrayList<Frames_Arroyo>(10);
    }
    
    public int findNextFrame() {
        return this.frameArrayList.size() + 1;
    }
    
    public int findCurrentFrameNumber() {
        return this.frameArrayList.size();
    }
    
    public Frames_Arroyo findCurrentFrame() {
        return this.frameArrayList.get(this.findCurrentFrameNumber() - 1);
    }
    
    public Frames_Arroyo getFrameByFrameNumber(final int frameNumber) {
        return this.frameArrayList.get(frameNumber);
    }
    
    public Mark getMarkByBoxIndex(final int frameNumber, final int boxIndex) {
        return this.getFrameByFrameNumber(frameNumber).getMarkByBoxIndex(frameNumber, boxIndex);
    }
    
    public int findFrameScore(final int frame) {
        assert frame > 0;
        return this.frameArrayList.get(frame - 1).getFrameScore(frame);
    }
    
    public void addFrame(final Frames_Arroyo f) {
        assert this.frameArrayList.size() < 10;
        this.frameArrayList.add(f);
    }
}
