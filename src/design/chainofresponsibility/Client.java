package design.chainofresponsibility;

public class Client {
    public static void main(String[] args) {
        SupportHandler l1 = new Level1SupportHandler();
        SupportHandler l2 = new Level2SupportHandler();
        SupportHandler l3 = new Level3SupportHandler();

        l1.setNextHandler(l2);
        l2.setNextHandler(l3);

        Request r1 = new Request(Priority.BASIC);
        Request r2 = new Request(Priority.INTERMEDIATE);
        Request r3 = new Request(Priority.CRITICAL);

        l2.handleRequest(r1);
    }

}
