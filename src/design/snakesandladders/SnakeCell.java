package design.snakesandladders;

public class SnakeCell implements Cell {
    private int start;
    private int end;

    public SnakeCell(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int getNext() {
        // TODO Auto-generated method stub
        return this.end;
    }

}
