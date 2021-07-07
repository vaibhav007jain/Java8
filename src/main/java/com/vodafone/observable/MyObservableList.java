package main.java.com.vodafone.observable;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class MyObservableList extends Observable {

    private List<Integer> numbers = new ArrayList<>();
    private int index = 0;

    public boolean add(int number) {
        if(numbers.add(number)) {
            setChanged();
            notifyObservers();
        }
        return false;
    }

    public boolean hasNext(){
        if(index < numbers.size()){
            return true;
        }
        return false;
    }

    public synchronized int getNext(){
        int nextNumber = 0;
        if(index < numbers.size()){
            nextNumber = numbers.get(index);
            index++;
        }
        return nextNumber;
    }
}
