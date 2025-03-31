package design.composite;

public class SimpleTask implements Task {
    String title;

    public SimpleTask(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        // TODO Auto-generated method stub
        return this.title;
    }

    @Override
    public void setTitle(String title) {
        // TODO Auto-generated method stub
        this.title = title;
    }

    @Override
    public void display() {
        // TODO Auto-generated method stub
        System.out.println("Simple Task: " + this.title);
    }

}
