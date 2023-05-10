package geometry;

public class Triangle extends GeometricShape {
    private static final int NUM_OF_SIDES = 3;

    private double height;

    public Triangle(double sideLength, double height) {
        super(NUM_OF_SIDES, sideLength);
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
        return (super.getSideLength() * this.height) / 2;
    }

    @Override
    public String toString() {
        return String.format("A triangle with %d sides, each of length %.2f, height %.2f, and area %.2f",
                super.getNumOfSides(), super.getSideLength(), this.height, this.getArea());
    }
}
