package design.factory.abstractfactory;

public interface Database {
    String getUrl();
    int getConnectionLimit();
    String getDescriptor();
    //return a object of corresponding query =>Factory Method
    DatabaseElements getDatabaseElements();

}
