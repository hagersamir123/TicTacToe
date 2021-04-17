package minmax;

public class MovingInfo {

    public int locX;
    public int locY;
    public int prob;
    public int totalProb;
    public int bestDepth;

    public MovingInfo(int x, int y, int prob) {
        this.locX = x;
        this.locY = y;
        this.prob = prob;
    }
}
