
// Base class
class Shape {
    public void area() {
        System.out.println("Area of shape cannot be defined.");
    }
}

// Derived class: Circle
class Circle extends Shape {
    private double radius;

    // Constructor to initialize radius
    public Circle(double radius) {
        this.radius = radius;
    }

    // Overriding area() method
    @Override
    public void area() {
        double result = Math.PI * radius * radius;
        System.out.println("Area of Circle: " + result);
    }
}

// Derived class: Rectangle
class Rectangle extends Shape {
    private double length;
    private double width;

    // Constructor to initialize length and width
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    // Overriding area() method
    @Override
    public void area() {
        double result = length * width;
        System.out.println("Area of Rectangle: " + result);
    }
}

// Main class
public class hierarchialinheritance {
    public static void main(String[] args) {
        // Create Circle object
        Circle c = new Circle(5.0);
        c.area();

        // Create Rectangle object
        Rectangle r = new Rectangle(4.0, 6.0);
        r.area();
    }
}
