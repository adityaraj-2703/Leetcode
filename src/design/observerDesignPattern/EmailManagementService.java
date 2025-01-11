package design.observerDesignPattern;

public class EmailManagementService implements RegisterUserSubscriber{

    private void sendEmail(String to,String from){

    }
    private UserService userService; // singleton
    @Override
    public void handleRegisterUser() {
        sendEmail("aditya", "raj");
    }

}
