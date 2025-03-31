package design.snakesandladders;

public class BaseCell implements Cell {
    private int position;

    @Override
    public int getNext() {
        // TODO Auto-generated method stub
        return this.position + 1;
    }

}
