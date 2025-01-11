package design.factory.abstractfactory;

public class DatabaseFactory {

    public static Database getDatabaseForConfigValue(String configValue){
        if(configValue.equals("postgre")){
            return new PostGreSQLDatabase();
        }
        else if(configValue.equals("mysql")){
            return new MySQLDatabase();
        }
        else{
            return null;
        }
    }
}
