package design.factory.abstractfactory;

public class Client {
    public static void main(String[] args){
        String databaseConfig = "mysql"; //  we only have to change here!!!!! after just changing mysql to postgre, we can generate a whole different class, never code to an implementation, code to an interface
        Database db = DatabaseFactory.getDatabaseForConfigValue(databaseConfig);
        Query q = db.getDatabaseElements().getQuery();
    }
}
