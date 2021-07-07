package main.java.com.practice.producerconsumer;

import java.util.List;

public class Producer implements Runnable{
    /*private final List<Integer> taskQueue;
    private final int MAX_CAPACITY;

    public Producer(List<Integer> sharedQueue, int capacity){
        this.taskQueue=sharedQueue;
        this.MAX_CAPACITY=capacity;
    }

    @Override
    public void run() {
        int counter=0;
        while(true){
            try{
                produce(counter++);
            }catch (InterruptedException e){
                System.out.println("Some error occurred. ");
                e.printStackTrace();
            }
        }
    }

    private void produce(int counter) throws InterruptedException{
        synchronized (taskQueue){
            while (taskQueue.size()==MAX_CAPACITY){
                System.out.println("Task Queue is full. "+Thread.currentThread().getName() + " is waiting.");
                taskQueue.wait();
            }
            taskQueue.add(counter);
            System.out.println("Produced: "+counter);
            taskQueue.notifyAll();
        }
        Thread.sleep(1000);
    }*/

    private List<Integer> taskQueue;
    private int MAX_CAPACITY;

    public Producer(List<Integer> taskQueue, int MAX_CAPACITY) {
        this.taskQueue = taskQueue;
        this.MAX_CAPACITY = MAX_CAPACITY;
    }


    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        int counter=0;
        while(true) {
            try {
                produce(counter++);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void produce(int counter) throws InterruptedException {
        synchronized (taskQueue){
            if(taskQueue.size() == MAX_CAPACITY){
                System.out.println("Queue is Full."+ Thread.currentThread().getName()+" producer thread is waiting...");
                taskQueue.wait();
            }
            taskQueue.add(counter);
            System.out.println("Produced: "+counter);
            taskQueue.notify();
        }
        Thread.sleep(1000);
    }
}
