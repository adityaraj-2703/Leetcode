package design.singleton;

public class SingleTonClass {
    private static SingleTonClass instance = null;
    private SingleTonClass(){

    }
    public static SingleTonClass getInstance(){
        if(instance == null){
            synchronized(SingleTonClass.class){
                if(instance==null){
                    instance = new SingleTonClass();
                }
            }
        }
        return instance;
    }
}
