package geometry;

public class Triangle extends Shape {
    private double side1;
    private double side2;
    private double side3;

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public Triangle() {
        this(0, 0, 0);
    }

    public double getSide1() {
        return this.side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return this.side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return this.side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    @Override
    public double calculatePerimeter() {
        return this.side1 + this.side2 + this.side3;
    }

    @Override
    public double calculateArea() {
        double s = calculatePerimeter() / 2;
        return Math.sqrt(s * (s - this.side1) * (s - this.side2) * (s - this.side3));
    }

    @Override
    public String toString() {
        return "Triangle with sides " + this.getSide1() + ", " + this.getSide2() + ", " + this.getSide3() +
                ", perimeter " + this.calculatePerimeter() + ", area " + this.calculateArea();
    }

}
