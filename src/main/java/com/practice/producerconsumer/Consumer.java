package main.java.com.practice.producerconsumer;

import java.util.List;

public class Consumer implements Runnable{
    private final List<Integer> taskQueue;

    public Consumer(List<Integer> sharedQueue){
        this.taskQueue=sharedQueue;
    }

    @Override
    public void run() {
        while(true){
            try{
                consume();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    private void consume() throws InterruptedException{
        synchronized (taskQueue){
            while(taskQueue.isEmpty()){
                System.out.println("Queue is empty. "+ Thread.currentThread().getName()+ " is waiting for an item to consume.");
                taskQueue.wait();
            }
            int item = (Integer) taskQueue.remove(0);
            System.out.println("Consumed: "+item);
            taskQueue.notifyAll();
        }
        Thread.sleep(800);
    }
}
