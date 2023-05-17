import geometry.Circle;
import geometry.Square;
import geometry.Triangle;
import phonetask.Iphone;
import phonetask.Phone;
import phonetask.Samsung;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(5);
        Triangle triangle = new Triangle(3, 4, 5);
        Square square = new Square(6);

        System.out.println(circle.toString());
        System.out.println(triangle.toString());
        System.out.println(square.toString());

        Phone samsungPhone = new Samsung();
        samsungPhone.takePicture();
        samsungPhone.printColor();

        Phone iphone = new Iphone();
        iphone.takePicture();
        iphone.printColor();
    }
}