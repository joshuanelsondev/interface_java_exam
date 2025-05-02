package org.example;


public class Rectangle implements Shape {

    private final double width;
    private final double height;


    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }


    public double getWidth() {
        return this.width;
    }


    public double getHeight() {
        return this.height;
    }

    @Override
    public double calculateArea() {
        return this.width * this.height;
    }

    @Override
    public double calculatePerimeter() {
        return (this.width * 2) + (this.height * 2);
    }

    @Override
    public String getType() {
        if ((this.calculateArea() / this.width) == this.height) {
            return "Square";
        }

        return "Rectangle";
    }

    @Override
    public String toString() {
       
    }
}