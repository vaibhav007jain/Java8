package main.java.com.practice.producerconsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> sharedQueue = new ArrayList<>();
        int MAX_CAPACITY=5;

        ExecutorService executor = Executors.newFixedThreadPool(2);

        Thread producer = new Thread(new Producer(sharedQueue, MAX_CAPACITY), "producer");
        Thread consumer = new Thread(new Consumer(sharedQueue), "consumer");

        executor.submit(producer);
        executor.submit(consumer);

        producer.join();
        executor.shutdown();

//        producer.start();
//        consumer.start();
//        consumer.join();

    }
}
