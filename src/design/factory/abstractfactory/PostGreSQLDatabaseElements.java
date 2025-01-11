package design.factory.abstractfactory;

public class PostGreSQLDatabaseElements implements DatabaseElements{

    @Override
    public Query getQuery() {
        // TODO Auto-generated method stub
        return new PostGreSQLQuery();
    }

    @Override
    public Connection getConection() {
        // TODO Auto-generated method stub
        return new PostGreSQLConnection();
    }

    @Override
    public Transaction getTransaction() {
        // TODO Auto-generated method stub
        return new PostGreSQLTransaction();
    }

}
