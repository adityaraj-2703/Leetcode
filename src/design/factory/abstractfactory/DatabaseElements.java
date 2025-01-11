package design.factory.abstractfactory;

public interface DatabaseElements {
    Query getQuery();
    Connection getConection();
    Transaction getTransaction();

}
