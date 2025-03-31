package design.chainofresponsibility;

public class Request {
    private Priority p;

    public Request(Priority p) {
        this.p = p;
    }

    public Priority getP() {
        return p;
    }

}
