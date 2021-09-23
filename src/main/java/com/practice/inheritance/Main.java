package main.java.com.practice.inheritance;


public class Main {

    public static void main(String[] args) {
        A a = new B();
        System.out.println(a.sum(3,5));
        System.out.println(a.a);
        a.print();

        B.printStatic();
        A.printStatic();

        int i = 10 + + 11 - - 12 + + 13 - - 14 + + 15;
        System.out.println("SUM i="+i);
        System.out.println(method());

        String test =  "sentence";
        String lastWord = test.substring(test.lastIndexOf(" ")+1);
        System.out.println(lastWord);


    }

    public static String method(){
        try {
            System.out.println("Inside Try");
            return "return from try";
        }catch (Exception e){
            System.out.println("Inside Catch");
            return "return from catch";
        }finally {
            System.out.println("Inside finally");
            return "returned from Finally";
        }
//        return "method return"; // unreachable code
    }
}
