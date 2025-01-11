package design.phonepe;

public class PhonePe {
    YesBankAPI yapi = new YesBankAPI();


    void pay(){
        yapi.makePayments(123, "123123", 1234);
        boolean isSuccess = yapi.checkSuccess(123);
    }
    void markSuccess(){
        yapi.makePayments(123, "123123", 1234);
        boolean isSuccess = yapi.checkSuccess(123);
    }
    void payToFriend(){
        yapi.makePayments(123, "123123", 1234);
        boolean isSuccess = yapi.checkSuccess(123);
    }
    void sendGift(){
        yapi.makePayments(123, "123123", 1234);
        boolean isSuccess = yapi.checkSuccess(123);
    }
    void checkPaymentHistory(){
        yapi.makePayments(123, "123123", 1234);
        boolean isSuccess = yapi.checkSuccess(123);
    }
    void checkBalance(){
        yapi.makePayments(123, "123123", 1234);
        boolean isSuccess = yapi.checkSuccess(123);
    }

}
