package com.example.demo.patterns.structural.decorator;

public abstract class ShapeDecorator implements Shape {
	
	protected Shape decoratedShape;

	public ShapeDecorator(Shape decorateShape) {
		super();
		this.decoratedShape = decorateShape;
	}
	
	@Override
	public void draw() {
		decoratedShape.draw();
	}

}
