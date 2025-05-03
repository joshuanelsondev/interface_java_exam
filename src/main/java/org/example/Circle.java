package org.example;


public class Circle implements Shape {

    private final double radius;
    private final double pi = 3.14159;


    public Circle(double radius) {
        if (radius <= 0) throw new IllegalArgumentException("Radius must be greater than zero.");
        this.radius = radius;
    }

    public double getRadius() {
        return this.radius;
    }

    @Override
    public double calculateArea() {
        return pi * Math.pow(this.radius, 2);
    }

    @Override
    public double calculatePerimeter() {
        return 2 * pi * this.radius;
    }

    @Override
    public String getType() {
        return "Circle";
    }

//    @Override
//    public String toString() {
//
//    }
}