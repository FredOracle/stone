package com.example.demo.java.object;

/**
 * @author Fred
 */
public class Duck extends Animal{

    public Duck(){
        super();
    }

    public Duck(String name, String runType, Boolean swimmingAble){

        super(name, runType, swimmingAble);
    }

    public void duckSelf() {
        System.out.println(super.getName() + "   hhhhhhh");
    }
}
