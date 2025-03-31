package design.chainofresponsibility;

public interface SupportHandler {
    void handleRequest(Request r);

    void setNextHandler(SupportHandler s);

}
