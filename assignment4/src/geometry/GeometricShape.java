package geometry;

public class GeometricShape implements Cloneable {
    private final int numOfSides;
    private final double sideLength;
    private double area;

    public GeometricShape(int numOfSides, double sideLength) {
        this.numOfSides = numOfSides;
        this.sideLength = sideLength;
        this.area = getArea();
    }

    public int getNumOfSides() {
        return numOfSides;
    }

    public double getSideLength() {
        return sideLength;
    }

    public double getArea() {
        return (numOfSides * sideLength * sideLength) / (4 * Math.tan(Math.PI / numOfSides));
    }

    @Override
    public String toString() {
        return "A shape with " + numOfSides + " sides, each of length " + sideLength + ", and area " + area;
    }

    @Override
    public GeometricShape clone() {
        try {
            return (GeometricShape) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Cloning not supported");
        }
    }

}
