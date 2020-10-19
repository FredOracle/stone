package com.example.demo.java.object;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class Animal {

    private String name;

    private String runType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRunType() {
        return runType;
    }

    public void setRunType(String runType) {
        this.runType = runType;
    }

    public Boolean getSwimmingAble() {
        return swimmingAble;
    }

    public void setSwimmingAble(Boolean swimmingAble) {
        this.swimmingAble = swimmingAble;
    }

    private Boolean swimmingAble;

    public Animal(){
    }

    public Animal(String name, String runType, Boolean swimmingAble){
        this.name = name;
        this.runType = runType;
        this.swimmingAble = swimmingAble;
    }



    public void sayHello() {
        System.out.println(this.name + " say Hello to you.");
    }

    public String run(){

        return this.name + ">>>" + this.runType;
    }

    public String swimming(){
        return this.name + (this.swimmingAble ? "Can swimming":"Can not swimming");
    }
}
