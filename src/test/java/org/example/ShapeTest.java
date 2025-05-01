package org.example;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ShapeTest {

    private Circle circle;
    private Rectangle rectangle;
    private Rectangle square;
    private Triangle equilateralTriangle;
    private Triangle isoscelesTriangle;
    private Triangle scaleneTriangle;
    private ShapeProcessor processor;

    @BeforeEach
    void setUp() {

        circle = new Circle(5);
        rectangle = new Rectangle(4, 6);
        square = new Rectangle(4, 4);
        equilateralTriangle = new Triangle(5, 5, 5);
        isoscelesTriangle = new Triangle(5, 5, 8);
        scaleneTriangle = new Triangle(3, 4, 5);
        processor = new ShapeProcessor();
    }


    @Test
    void testCircleArea() {
        assertEquals(Math.PI * 25, circle.calculateArea(), 0.0001);
    }

    @Test
    void testCirclePerimeter() {
        assertEquals(2 * Math.PI * 5, circle.calculatePerimeter(), 0.0001);
    }

    @Test
    void testCircleType() {
        assertEquals("Circle", circle.getType());
    }

    @Test
    void testCircleInvalidRadius() {
        assertThrows(IllegalArgumentException.class, () -> new Circle(-1));
        assertThrows(IllegalArgumentException.class, () -> new Circle(0));
    }



    @Test
    void testRectangleArea() {
        assertEquals(24, rectangle.calculateArea(), 0.0001);
    }

    @Test
    void testRectanglePerimeter() {
        assertEquals(20, rectangle.calculatePerimeter(), 0.0001);
    }

    @Test
    void testRectangleType() {
        assertEquals("Rectangle", rectangle.getType());
    }

    @Test
    void testSquareTypeIsStillRectangle() {
        assertEquals("Square", square.getType());
    }

    @Test
    void testRectangleInvalidDimensions() {
        assertThrows(IllegalArgumentException.class, () -> new Rectangle(-1, 5));
        assertThrows(IllegalArgumentException.class, () -> new Rectangle(5, -1));
        assertThrows(IllegalArgumentException.class, () -> new Rectangle(0, 5));
        assertThrows(IllegalArgumentException.class, () -> new Rectangle(5, 0));
    }



    @Test
    void testEquilateralTriangleArea() {
    
        double expectedArea = (Math.sqrt(3) / 4) * 25;
        assertEquals(expectedArea, equilateralTriangle.calculateArea(), 0.0001);
    }

    @Test
    void testScaleneTriangleArea() {
     
        assertEquals(6, scaleneTriangle.calculateArea(), 0.0001);
    }

    @Test
    void testTrianglePerimeter() {
        assertEquals(15, equilateralTriangle.calculatePerimeter(), 0.0001);
        assertEquals(12, scaleneTriangle.calculatePerimeter(), 0.0001);
    }

    @Test
    void testTriangleTypes() {
        assertEquals("Equilateral Triangle", equilateralTriangle.getType());
        assertEquals("Isosceles Triangle", isoscelesTriangle.getType());
        assertEquals("Scalene Triangle", scaleneTriangle.getType());
    }

    @Test
    void testTriangleInvalidSides() {
  
        assertThrows(IllegalArgumentException.class, () -> new Triangle(-1, 2, 2));
        assertThrows(IllegalArgumentException.class, () -> new Triangle(2, -1, 2));
        assertThrows(IllegalArgumentException.class, () -> new Triangle(2, 2, -1));
        assertThrows(IllegalArgumentException.class, () -> new Triangle(0, 2, 2));

  
        assertThrows(IllegalArgumentException.class, () -> new Triangle(1, 2, 10));
        assertThrows(IllegalArgumentException.class, () -> new Triangle(10, 1, 2));
        assertThrows(IllegalArgumentException.class, () -> new Triangle(1, 10, 2));
    }

 

    @Test
    void testCompareAreas() {
  
        ShapeProcessor processor = new ShapeProcessor();

    
        Circle circle = new Circle(5); 
        Rectangle rectangle = new Rectangle(4, 6); 
        assertEquals(1, processor.compareAreas(circle, rectangle),
                "Circle should have larger area than rectangle");

 
        assertEquals(-1, processor.compareAreas(rectangle, circle),
                "Rectangle should have smaller area than circle");


        Rectangle square1 = new Rectangle(5, 5); 
        Rectangle square2 = new Rectangle(5, 5); 
        assertEquals(0, processor.compareAreas(square1, square2),
                "Shapes with equal areas should return 0");
    }

    @Test
    void testFindLargestShape() {
        List<Shape> shapes = new ArrayList<>();


        assertNull(processor.findLargestShape(shapes));


        shapes.add(circle);
        assertEquals(circle, processor.findLargestShape(shapes));

        shapes.add(rectangle);
        shapes.add(square);
        shapes.add(equilateralTriangle);
        assertEquals(circle, processor.findLargestShape(shapes));

     
        Circle largerCircle = new Circle(10);
        shapes.add(largerCircle);
        assertEquals(largerCircle, processor.findLargestShape(shapes));
    }

    @Test
    void testGenerateShapeReport() {
        String report = processor.generateShapeReport(circle);

        assertTrue(report.contains("Shape Report"));
        assertTrue(report.contains("Type: Circle"));
        assertTrue(report.contains("Area: " + String.format("%.2f", Math.PI * 25)));
        assertTrue(report.contains("Perimeter: " + String.format("%.2f", 2 * Math.PI * 5)));
    }

    @Test
    void testGenerateSummaryReport() {
        List<Shape> shapes = new ArrayList<>();
        shapes.add(circle);
        shapes.add(rectangle);
        shapes.add(square);
        shapes.add(equilateralTriangle);

        String report = processor.generateSummaryReport(shapes);

        assertTrue(report.contains("Shapes Summary Report"));
        assertTrue(report.contains("Total shapes: 4"));
        assertTrue(report.contains("Circles: 1"));
        assertTrue(report.contains("Rectangles: 2"));
        assertTrue(report.contains("Triangles: 1"));


        shapes.clear();
        assertEquals("No shapes to report.", processor.generateSummaryReport(shapes));
    }
}