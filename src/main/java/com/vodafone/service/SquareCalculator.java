package main.java.com.vodafone.service;

import java.util.concurrent.Callable;

public class SquareCalculator implements Callable<Integer> {

    private int number;

    public SquareCalculator(int number){
        this.number = number;
    }

    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public Integer call() throws Exception {
        System.out.println("Call() :-> Calculating square of "+number+ " by Thread: ");
        return number*number;
    }
}
