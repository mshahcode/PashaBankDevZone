import geometry.GeometricShape;
import geometry.Triangle;

public class Main {
    public static void main(String[] args) {

        GeometricShape shape1 = new GeometricShape(4, 5.0);
        System.out.println(shape1);

        GeometricShape shape2 = shape1.clone();
        System.out.println(shape2);

        Triangle triangle1 = new Triangle(3.0, 4.0);
        System.out.println(triangle1);

        Triangle triangle2 = (Triangle) triangle1.clone();
        System.out.println(triangle2.toString());

        triangle2.setHeight(5.0);
        System.out.println(triangle1);
        System.out.println(triangle2);

    }

}
