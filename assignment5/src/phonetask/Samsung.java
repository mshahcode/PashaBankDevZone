package phonetask;

public class Samsung implements Phone {
    @Override
    public void takePicture() {
        System.out.println("Taking picture with Samsung phone");
    }

    @Override
    public void printColor() {
        System.out.println("Printing in color with Samsung phone");
    }
}