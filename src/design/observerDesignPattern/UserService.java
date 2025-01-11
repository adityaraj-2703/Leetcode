package design.observerDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class UserService {
     
    List<RegisterUserSubscriber> registerUserSubscriber = new ArrayList<>();
    List<LoginUserSubscriber> loginUserSubscriber = new ArrayList<>();
    List<DeleteUserSubscriber> deleteUserSubscriber = new ArrayList<>();

    void subscribeRegisterUser(RegisterUserSubscriber registerUserSubscriber){
        this.registerUserSubscriber.add(registerUserSubscriber);
    }
    void unsubscribeReisterUser(RegisterUserSubscriber registerUserSubscriber){
        this.registerUserSubscriber.remove(registerUserSubscriber);
    }
    
    public void registerUser(String a,String b){
        String a1 = "a";
        for(RegisterUserSubscriber subscriber : registerUserSubscriber){
            subscriber.handleRegisterUser();
        }

    }
    public void loginUser(String a,String b){

    }
    public void deleteUser(String a,String b){

    }


}


/*
 * producer has:
 * subscribe()
 * unsubscribe()
 * 
 * Subscriber is an interface
 * subscriber composes singleton producer
 * subscriber subscribes itself by calling subscribe() on producer
 * 
 * Producer calls notify() for evry producer when action takes place
 */