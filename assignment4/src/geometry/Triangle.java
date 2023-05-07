package geometry;

public class Triangle extends GeometricShape {
    private double height;

    public Triangle(double sideLength, double height) {
        super(3, sideLength);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double getArea() {
        return (getSideLength() * height) / 2;
    }

    @Override
    public String toString() {
        return String.format("A triangle with %d sides, each of length %.2f, height %.2f, and area %.2f",
                getNumOfSides(), getSideLength(), height, getArea());
    }
}