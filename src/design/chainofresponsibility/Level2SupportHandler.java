package design.chainofresponsibility;

public class Level2SupportHandler implements SupportHandler {
    private SupportHandler next;

    @Override
    public void handleRequest(Request r) {
        // TODO Auto-generated method stub
        if (r.getP() == Priority.INTERMEDIATE || r.getP() == Priority.BASIC) {
            System.out.println("Handled at level 2");
        } else if (this.next != null) {
            next.handleRequest(r);
        }
    }

    @Override
    public void setNextHandler(SupportHandler s) {
        // TODO Auto-generated method stub
        this.next = s;
    }

}
