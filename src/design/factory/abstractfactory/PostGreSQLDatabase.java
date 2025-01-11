package design.factory.abstractfactory;

public class PostGreSQLDatabase implements Database{

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
    public DatabaseElements getDatabaseElements() {
        // TODO Auto-generated method stub
        return new PostGreSQLDatabaseElements();
    }

    

}
