package main.java.com.vodafone.service;

import kotlin.jvm.internal.SpreadBuilder;
import main.java.com.vodafone.observable.MyObservableList;
import main.java.com.vodafone.observer.NumbersListObserver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MyFileReader {

    public void readFile(String filepath){
        String line;
        MyObservableList myObservableList = new MyObservableList();
        myObservableList.addObserver(new NumbersListObserver());
        try (BufferedReader br =
                     new BufferedReader(new FileReader(filepath))) {
            while((line=br.readLine())!=null){
                int number = Integer.parseInt(line);
                System.out.println("readFile() :-> Got a new number: "+number);
                myObservableList.add(number);
                Thread.sleep(1000);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
