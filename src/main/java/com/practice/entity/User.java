package main.java.com.practice.entity;

import java.util.ArrayList;
import java.util.List;

public class User {
    private long id;
    private String name;
    private int age;
    private double salary;
    private String gender;

    private List<String> books;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public User(int id, String name, int age, double salary, String gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.gender = gender;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<String> getBooks() {
        if (this.books == null){
            this.books = new ArrayList<>();
        }
        return this.books;
    }

    public void setBooks(List<String> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "\nUser{" +
                id +
                ", " + name +
                ", " + age +
                ", " + salary +
                ", " + gender +
                '}' ;
    }
}
