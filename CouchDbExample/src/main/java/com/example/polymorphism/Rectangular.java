package com.example.polymorphism;

public class Rectangular implements IShape {

	private double length;
	private double height;
	
	public Rectangular(double length, double height) {
		this.length = length;
		this.height = height;
	}


	public void draw() {
		System.out.println("length : " + length + " and height : " + height +" drawed");
	}

}
