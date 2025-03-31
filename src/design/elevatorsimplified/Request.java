package design.elevatorsimplified;

public class Request {
    private final int srcFloor;
    private final int destFloor;

    public Request(int src, int dst) {
        this.srcFloor = src;
        this.destFloor = dst;
    }

    public int getSrcFloor() {
        return srcFloor;
    }

    public int getDestFloor() {
        return destFloor;
    }

}
