package main.java.com.practice.java8;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BasicProgramsUsingJava8 {


    public static void main(String[] args) {

        System.out.println("Factorial: "+getFactorialOf(5));
        System.out.println("Fibonacci: ");
        getFibonacci(10);
        System.out.println("Prime numbers: ");
        getListOfPrimeNumbers(30);
    }

    private static void getListOfPrimeNumbers(int number) {
        Stream.iterate(2, n-> n+1)
                .limit(number)
                .filter(n ->{
                   for(int i=2; i<=(n/2); i++){
                       if(n%i==0){
                           return false;
                       }
                   }
                    return true;
                })
                .forEach(System.out::println);
    }

    private static void getFibonacci(int number) {
        Stream.iterate(new int[]{0, 1}, n -> new int[]{n[1], n[0]+n[1]})
                .limit(number)
                .map(n-> n[0])
                .forEach(System.out::println);
    }

    private static int getFactorialOf(int number) {

//        Stream.iterate(1, n -> n<number, n -> n+1).reduce(1, (x, y)-> x*y);  // Java 9, accepts predicate as a 2nd operator to limit the iteration
        return IntStream.rangeClosed(1, number).reduce(1, (x, y)-> x*y);
    }
}
