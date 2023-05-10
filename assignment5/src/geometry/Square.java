package geometry;

public class Square extends Shape {
    public static final int NUM_OF_SIDES = 4;
    private double side;

    public Square(double side) {
        this.side = side;
    }

    public Square() {
        this(0);
    }

    public double getSide() {
        return this.side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public double calculateArea() {
        return this.side * this.side;
    }

    @Override
    public double calculatePerimeter() {
        return NUM_OF_SIDES * this.side;
    }

    @Override
    public String toString() {
        return "A square with side length " + this.getSide() + ", perimeter " + this.calculatePerimeter() + ", and area " + this.calculateArea();
    }
}