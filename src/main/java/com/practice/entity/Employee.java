package main.java.com.practice.entity;

public class Employee {
    public String name;
    public int retirementAge;

    public  Employee(){}
    public Employee(String name, int retirementAge){
        this.name=name;
        this.retirementAge=retirementAge;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRetirementAge() {
        return retirementAge;
    }

    public void setRetirementAge(int retirementAge) {
        this.retirementAge = retirementAge;
    }
}
