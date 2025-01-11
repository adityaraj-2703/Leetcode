package design.factory.normalFactory;

public class MySQLDatabase implements Database{

    @Override
    public String getUrl() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUrl'");
    }

    @Override
    public int getConnectionLimit() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getConnectionLimit'");
    }

    @Override
    public String getDescriptor() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDescriptor'");
    }

    @Override
    public Query getQuery() {
        // TODO Auto-generated method stub
        return new MySQLQuery();
    }

}
