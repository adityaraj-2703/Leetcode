package design.factory.normalFactory;

public class Client {
    public static void main(String[] args){
        String databaseConfig = "postgre";
        Database db = DatabaseFactory.getDatabaseForConfigValue(databaseConfig);
        // if(databaseConfig.equals("postgre")){
        //     db = new PostGreSQLDatabase();
        // } 
        // else if(databaseConfig.equals("mysql")){
        //     db = new MySQLDatabase();
        // }
    }
}
