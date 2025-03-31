package design.chainofresponsibility;

public class Level3SupportHandler implements SupportHandler {

    @Override
    public void handleRequest(Request r) {
        // TODO Auto-generated method stub
        if (r.getP() == Priority.CRITICAL || r.getP() == Priority.INTERMEDIATE || r.getP() == Priority.BASIC) {
            System.out.println("Handled at level 3");
        } else {
            System.out.println("request cant be handled");
        }
    }

    @Override
    public void setNextHandler(SupportHandler s) {
        // TODO Auto-generated method stub

    }

}
