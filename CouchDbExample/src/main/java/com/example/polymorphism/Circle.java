package com.example.polymorphism;

public class Circle implements IShape {

	private double radius;
	
	
	public Circle(double radius) {
		this.radius = radius;
	}


	public void draw() {
		System.out.println("radius : " + radius + " circle drawed");
	}
}
