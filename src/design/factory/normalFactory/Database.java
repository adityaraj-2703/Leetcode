package design.factory.normalFactory;

public interface Database {
    String getUrl();
    int getConnectionLimit();
    String getDescriptor();
    //return a object of corresponding query =>Factory Method
    Query getQuery();
    // Connection getConection();
    // Transaction getTransaction();

}
