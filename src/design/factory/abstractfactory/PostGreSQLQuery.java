package design.factory.abstractfactory;

public class PostGreSQLQuery implements Query{

    @Override
    public String getQueryString() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void execute() {
        // TODO Auto-generated method stub
        System.out.println("postgre query is getting executed");
    }

}
