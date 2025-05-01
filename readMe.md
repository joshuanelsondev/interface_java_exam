# Shape Calculator Exercise - Interface Practice

## Overview

This exercise tests your understanding of interfaces through a geometric shape calculator system. The goal is to create a flexible system that can calculate different properties of various shapes using interfaces.

## Requirements

### Core Components

1. **Shape Interface**: Defines methods for calculating properties of shapes
2. **Shape Implementations**: Various concrete shapes (Circle, Rectangle, Triangle)
3. **Shape Processor**: A class that works with any shape
4. **Unit Tests**: Tests to verify the system works correctly

### Interface Design

Create a `Shape` interface with these methods:
- `double calculateArea()`
- `double calculatePerimeter()`
- `String getType()`

### Implementation Requirements

1. Implement at least 3 shapes:
    - `Circle` (needs radius)
    - `Rectangle` (needs width and height)
    - `Triangle` (needs three sides)

2. Create a `ShapeProcessor` class that can:
    - Accept any shape
    - Compare areas of two shapes
    - Find the largest shape in a list
    - Generate a shape report with details

3. Write test cases to verify:
    - Calculations for each shape are correct
    - The processor works with different shapes
    - Shape comparisons work properly

## Expected Files

```
src/
├── main/
│   └── java/
│       └── org/
│           └── example/
│               ├── Shape.java (interface)
│               ├── Circle.java
│               ├── Rectangle.java
│               ├── Triangle.java
│               └── ShapeProcessor.java
└── test/
    └── java/
        └── org/
            └── example/
                └── ShapeTest.java
```

## Guidelines

1. Make your interface clean and focused
2. Implement each shape independently
3. ShapeProcessor should only depend on the interface, not concrete shapes
4. Use appropriate formulas for calculations:
    - Circle area: πr²
    - Rectangle area: width × height
    - Triangle area: Heron's formula
    - Consider edge cases like invalid dimensions

## Success Criteria

Your solution shows mastery of interfaces if:
1. The `ShapeProcessor` works with any `Shape` implementation
2. New shapes can be added without changing existing code
3. Tests verify all functionality works correctly
4. Code follows good object-oriented design principles

## Getting Started

1. Create the Shape interface first
2. Implement one shape at a time
3. Create the ShapeProcessor
4. Write tests to verify everything works correctly

Good luck!