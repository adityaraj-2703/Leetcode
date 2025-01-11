package design.builderpattern.thirdsolution;

class Builder{
    String name;
    String email;
    String phone;
    String pass;
    String address;
    int age;
    public Builder setName(String name) {
        this.name = name;
        return this;
    }
    public Builder setEmail(String email) {
        this.email = email;
        return this;
    }
    public Builder setPhone(String phone) {
        this.phone = phone;
        return this;
    }
    public Builder setPass(String pass) {
        this.pass = pass;
        return this;
    }
    public Builder setAddress(String address) {
        this.address = address;
        return this;
    }
    public Builder setAge(int age) {
        this.age = age;
        return this;
    }
    public static void client(){
        Builder b = new Builder()
            .setName("adi")
            .setEmail("123")
            .setPass("1234");
        StudentModified2 s = new StudentModified2(b);
    }

}

public class StudentModified2 {
    String name;
    String email;
    String phone;
    String pass;
    String address;
    int age;
    StudentModified2(Builder builder){
        this.name = builder.name;
        this.email = builder.email;
        this.phone = builder.phone;
        this.pass = builder.pass;
        this.address = builder.address;
        this.age = builder.age;
    }
    
}
