package com.example.demo.patterns.structural.decorator;


public class Decorator {


  public static void main(String[] args) {
    Shape redCircle = new RedShapeDecorator(new Circle());
    Shape redRectangle = new RedShapeDecorator(new Rectangle());

    redCircle.draw();
    redRectangle.draw();

  }

}