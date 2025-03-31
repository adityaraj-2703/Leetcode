package design.builderpattern.finalsolution;

import java.security.InvalidParameterException;

public class StudentModified3 {
    private String name;
    private String email;
    private String phone;
    private String pass;
    private String address;
    private int age;

    private StudentModified3() {

    }

    private StudentModified3(Builder b) {
        this.name = b.name;
        this.email = b.email;
        this.phone = b.phone;
        this.pass = b.pass;
        this.address = b.address;
        this.age = b.age;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public static class Builder {
        private String name;
        private String email;
        private String phone;
        private String pass;
        private String address;
        private int age;

        private Builder() {

        }

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

        public StudentModified3 build() {
            return new StudentModified3(this);
        }

        public StudentModified3 validateAndBuild() throws RuntimeException {
            if (this.age < 18) {
                throw new InvalidParameterException();
            }
            return new StudentModified3(this);
        }

    }

    public void client() {
        StudentModified3 s;
        try {
            s = StudentModified3.getBuilder()
                    .setName("adi")
                    .setEmail("adi1")
                    .setPass("1234")
                    .build();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        Student1 s = Student1.getBuilder().setVal1(0).setVal2(0).build();
    }

}

class Student1 {
    private int val1;
    private int val2;

    private Student1() {

    }

    public static Builder1 getBuilder() {
        return new Builder1();
    }

    private Student1(Builder1 b) {
        this.val1 = b.val1;
        this.val2 = b.val2;
    }

    public static class Builder1 {
        private int val1;
        private int val2;

        private Builder1() {

        }

        public Builder1 setVal1(int val1) {
            this.val1 = val1;
            return this;
        }

        public Builder1 setVal2(int val1) {
            this.val2 = val1;
            return this;
        }

        public Student1 build() {
            return new Student1(this);
        }
    }
}
