package design.singleton;

public class SingleTonClass {
    private static SingleTonClass instance = null;

    private SingleTonClass() {

    }

    public static SingleTonClass getInstance() {
        if (instance == null) {
            synchronized (SingleTonClass.class) {
                if (instance == null) {
                    instance = new SingleTonClass();
                }
            }
        }
        return instance;
    }
}

class SingleTon2 {
    private static SingleTon2 instance = null;

    private SingleTon2() {

    }

    public SingleTon2 getInstance() {
        if (instance == null) {
            synchronized (SingleTon2.class) {
                if (instance == null) {
                    instance = new SingleTon2();
                }
            }
        }
        return instance;
    }
}
