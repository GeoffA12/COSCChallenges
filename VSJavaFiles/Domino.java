
public interface Domino {
    public static final int MINIMUM_PIP_COUNT = 0;
    public static final int MAXIMUM_PIP_COUNT = 6;
    // Post-condition: MINIMUM_PIP_COUNT <= rv <= MAXIMUM_PIP_COUNT
    // Post-condition: getLowPipCount() <= rv
    public int getHighPipCount();
    // Post-condition: rv <= getHighPipCount()
    public int getLowPipCount();
}