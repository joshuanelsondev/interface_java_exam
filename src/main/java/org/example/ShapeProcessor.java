package org.example;

import java.util.List;
import java.text.DecimalFormat;


public class ShapeProcessor {


    private static final double EPSILON = 0.0001;

    public int compareAreas(Shape shape1, Shape shape2) {
        double area1 = shape1.calculateArea();
        double area2 = shape2.calculateArea();

 
        if (Math.abs(area1 - area2) < EPSILON) {
            return 0;
        } else if (area1 > area2) {
            return 1;
        } else {
            return -1;
        }
    }


    public Shape findLargestShape(List<Shape> shapes) {
        if (shapes == null || shapes.isEmpty()) {
            return null;
        }

        Shape largest = shapes.get(0);
        for (int i = 1; i < shapes.size(); i++) {
            if (compareAreas(shapes.get(i), largest) > 0) {
                largest = shapes.get(i);
            }
        }

        return largest;
    }


    public String generateShapeReport(Shape shape) {
        DecimalFormat df = new DecimalFormat("#.##");

        StringBuilder report = new StringBuilder();
        report.append("Shape Report\n");
        report.append("===========\n");
        report.append("Type: ").append(shape.getType()).append("\n");
        report.append("Area: ").append(df.format(shape.calculateArea())).append("\n");
        report.append("Perimeter: ").append(df.format(shape.calculatePerimeter())).append("\n");

        return report.toString();
    }


    public String generateSummaryReport(List<Shape> shapes) {
        if (shapes == null || shapes.isEmpty()) {
            return "No shapes to report.";
        }

        DecimalFormat df = new DecimalFormat("#.##");
        double totalArea = 0;
        int circleCount = 0;
        int rectangleCount = 0;
        int triangleCount = 0;

        for (Shape shape : shapes) {
            totalArea += shape.calculateArea();

            if (shape instanceof Circle) {
                circleCount++;
            } else if (shape instanceof Rectangle) {
                rectangleCount++;
            } else if (shape instanceof Triangle) {
                triangleCount++;
            }
        }

        Shape largest = findLargestShape(shapes);

        StringBuilder report = new StringBuilder();
        report.append("Shapes Summary Report\n");
        report.append("====================\n");
        report.append("Total shapes: ").append(shapes.size()).append("\n");
        report.append("Circles: ").append(circleCount).append("\n");
        report.append("Rectangles: ").append(rectangleCount).append("\n");
        report.append("Triangles: ").append(triangleCount).append("\n");
        report.append("Total area: ").append(df.format(totalArea)).append("\n");
        report.append("Largest shape: ").append(largest).append(" (Area: ")
                .append(df.format(largest.calculateArea())).append(")\n");

        return report.toString();
    }
}