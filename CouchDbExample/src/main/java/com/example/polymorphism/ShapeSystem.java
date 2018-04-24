package com.example.polymorphism;

public class ShapeSystem {

	public static void main(String[] args) {
		IShape circle = getCircle();
		IShape rectangular = getRectangular();
		
		circle.draw();
		rectangular.draw();
		
	}

	private static IShape getCircle() {
		double radius = 5.0;
		return  new Circle(radius);
	}

	private static IShape getRectangular() {
		double length = 3.0;
		double height = 4.0;
		return new Rectangular(length, height);
	}
}
