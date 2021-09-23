package main.java.com.practice.inheritance;


public class B extends A {
    int a =20;
    public void print(){
        System.out.println("outside A: "+super.a);
        System.out.println("B: "+a);
    }

    public static void printStatic(){
        System.out.println("B: Static");
    }

}