package main.java.com.practice.inheritance;

public class A{
    int a = 10;

    public void print(){
        System.out.println("inside A: "+a);
//        String s = new String(null); // Compile time error
        Integer i = new Integer(null); // Throws NumberFormatException
        System.out.println("i: "+i);
    }

    public static void printStatic(){
        System.out.println("A: Static");
    }

    public int sum(int a, int b){
        return  a=b;
//        return true ? null : 0; // Coller gets nullPointerException
    }
}