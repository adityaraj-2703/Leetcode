package design.factory.abstractfactory;

public class MySQLQuery implements Query{

    @Override
    public String getQueryString() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void execute() {
        // TODO Auto-generated method stub
        System.out.println("mysql query is getting executed");
    }

}
