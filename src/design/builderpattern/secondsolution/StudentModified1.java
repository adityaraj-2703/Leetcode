package design.builderpattern.secondsolution;

import java.util.Map;

public class StudentModified1 {
    String name;
    String email;
    String phone;
    String pass;
    String address;
    int age;
    StudentModified1(Map<ParameterValues,Object> m){
        this.name = (String)m.get(ParameterValues.NAME);
        this.age = (int)m.get(ParameterValues.AGE);
        this.email = (String)m.get(ParameterValues.EMAIL);
        this.address = (String)m.get(ParameterValues.ADDRESS);
        this.phone = (String)m.get(ParameterValues.PHONE);
        this.pass = (String)m.get(ParameterValues.PASS);
    }
}
