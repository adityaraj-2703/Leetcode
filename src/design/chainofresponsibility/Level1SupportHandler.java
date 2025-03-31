package design.chainofresponsibility;

public class Level1SupportHandler implements SupportHandler {
    private SupportHandler next;

    @Override
    public void handleRequest(Request r) {

        if (r.getP() == Priority.BASIC) {
            System.out.println("Handled at level 1");
        } else if (next != null) {
            next.handleRequest(r);
        }
    }

    @Override
    public void setNextHandler(SupportHandler s) {
        // TODO Auto-generated method stub
        this.next = s;
    }

}
