package design.singleton;

public enum SingleTonEnum {
    INSTANCE("Naman");
    private String name;
    SingleTonEnum(String name){
        this.name = name;
    }
    void printHello(){
        System.out.println("Hello" + this.name);
    }
}
