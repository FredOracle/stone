package com.example.demo.java.object;

import java.io.FileInputStream;
import java.io.FilterInputStream;

public class Test {

    public static void main(String[] args){
        Animal duck = new Duck("Duck", "SW",true);

        duck.sayHello();

        Duck dd = new Duck("Duck", "SW", true);
        dd.duckSelf();

        
    }
}
