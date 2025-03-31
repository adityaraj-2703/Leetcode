package design.snakesandladders;

public class LadderCell implements Cell {
    private int start;
    private int end;

    public LadderCell(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int getNext() {
        // TODO Auto-generated method stub
        return this.end;
    }

}
