package design.factory.abstractfactory;

public class MySQLDatabaseElements implements DatabaseElements{

    @Override
    public Query getQuery() {
        // TODO Auto-generated method stub
        return new MySQLQuery();
    }

    @Override
    public Connection getConection() {
        // TODO Auto-generated method stub
        return new MySQLConnection();
    }

    @Override
    public Transaction getTransaction() {
        // TODO Auto-generated method stub
        return new MYSQLTransaction();
    }

}
