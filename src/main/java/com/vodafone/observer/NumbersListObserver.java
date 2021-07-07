package main.java.com.vodafone.observer;

import main.java.com.vodafone.observable.MyObservableList;
import main.java.com.vodafone.service.SquareCalculator;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.*;

public class NumbersListObserver implements Observer {

    private ExecutorService service = Executors.newFixedThreadPool(3);

    /**
     * This method is called whenever the observed object is changed. An
     * application calls an <tt>Observable</tt> object's
     * <code>notifyObservers</code> method to have all the object's
     * observers notified of the change.
     *
     * @param o   the observable object.
     * @param arg an argument passed to the <code>notifyObservers</code>
     */
    @Override
    public void update(Observable o, Object arg) {
        MyObservableList myObservableList = (MyObservableList) o;
        while (myObservableList.hasNext()){
            int number = myObservableList.getNext();
            Callable squareCalculator = new SquareCalculator(number);
            Future<Integer> square = service.submit(squareCalculator);

            while(!square.isDone()){
                System.out.println("square.isDone() : "+square.isDone());
                try {
                    System.out.println("update() :-> Square of " + number +" is: "+square.get()+".\n");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
