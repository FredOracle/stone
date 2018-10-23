package com.example.demo.patterns.structural.decorator;

public class RedShapeDecorator extends ShapeDecorator {

	public RedShapeDecorator(Shape decorateShape) {
		super(decorateShape);
	}
	
	public void draw(){
		decoratedShape.draw();
		setRedBorder(decoratedShape);
	}
	
	private void setRedBorder(Shape decoratedShape){
		decoratedShape.draw();
		System.out.println("   Border Color: Red");
	}

}
