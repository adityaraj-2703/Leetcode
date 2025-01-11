package design.builderpattern.firstSolution;

public class Student {
    String name;
    String email;
    String phone;
    String pass;
    String address;
    int age;
    Student(String name,
    String email,
    String phone,
    String pass,
    String address,
    int age){
        this.name = name;
        this.age = age;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.pass = pass;
    }
}
