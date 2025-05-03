package org.example;


public class Triangle implements Shape {

    private final double sideA;
    private final double sideB;
    private final double sideC;


    public Triangle(double sideA, double sideB, double sideC) {
        if (sideA <= 0 || sideB <= 0 || sideC <= 0) throw new IllegalArgumentException("All sides must be greater than zero");
        if ((sideA + sideB < sideC) || (sideB + sideC < sideA) || (sideA + sideC < sideB)) throw new IllegalArgumentException("Sides must create a valid triangle");
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }


    public double getSideA() {
        return this.sideA;
    }


    public double getSideB() {
        return this.sideB;
    }


    public double getSideC() {
        return this.sideC;
    }

    @Override
    public double calculateArea() {
        double halfPerimeter = this.calculatePerimeter() / 2;
        return Math.sqrt(halfPerimeter * (halfPerimeter - this.sideA) * (halfPerimeter - this.sideB) * (halfPerimeter - this.sideC));

    }

    @Override
    public double calculatePerimeter() {
        return this.sideA + this.sideB + this.sideC;
    }

    @Override
    public String getType() {
       if (this.sideA == this.sideB && this.sideB == this.sideC) {
           return "Equilateral Triangle";
       } else if (this.sideA == this.sideB || this.sideB == this.sideC || this.sideA == this.sideC) {
              return "Isosceles Triangle";
       } else {
           return "Scalene Triangle";
       }
   
    }

//    @Override
//    public String toString() {
//
//    }
}