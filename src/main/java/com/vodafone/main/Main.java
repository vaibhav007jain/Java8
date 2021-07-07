package main.java.com.vodafone.main;

import main.java.com.vodafone.service.MyFileReader;

public class Main {
    private static MyFileReader myFileReader = new MyFileReader();

    public static void main(String[] args) {
        myFileReader.readFile("/home/cloud-ops/IdeaProjects/observer-pattern/src/main/resources/numbers.txt");
    }
}
