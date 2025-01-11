package design.phonepayAfter;


public class PhonePe {
    BankAPI bapi;

    PhonePe(BankAPI bankAPI){
        //dependency is being injected into the phonepe by the client
        this.bapi = bankAPI;
    }   


    void pay(){
        bapi.pay(123, "123123");
        boolean isSuccess = bapi.isSuccess(123);
    }
    void markSuccess(){
        bapi.pay(123, "123123");
        boolean isSuccess = bapi.isSuccess(123);
    }
    void payToFriend(){
        bapi.pay(123, "123123");
        boolean isSuccess = bapi.isSuccess(123);
    }
    void sendGift(){
        bapi.pay(123, "123123");
        boolean isSuccess = bapi.isSuccess(123);
    }
    void checkPaymentHistory(){
        bapi.pay(123, "123123");
        boolean isSuccess = bapi.isSuccess(123);
    }
    void checkBalance(){
        bapi.pay(123, "123123");
        boolean isSuccess = bapi.isSuccess(123);
    }
    void changeBankAPI(BankAPI api){
        this.bapi = api;
    }
}
