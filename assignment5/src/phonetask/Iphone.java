package phonetask;

public class Iphone implements Phone {
    @Override
    public void takePicture() {
        System.out.println("Taking a picture with iPhone...");
    }

    @Override
    public void printColor() {
        System.out.println("Printing in color with iPhone...");
    }
}

