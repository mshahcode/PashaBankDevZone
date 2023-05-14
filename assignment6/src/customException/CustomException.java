package customException;

public class CustomException {
    // Example of a custom exception
    public static class CustomExceptionDemo extends Exception {
        public CustomExceptionDemo(String message) {
            super(message);
        }
    }

    public static void throwCustomException() throws CustomExceptionDemo {
        throw new CustomExceptionDemo("Custom exception occurred");
    }

    public static void main(String[] args) {
        try {
            throwCustomException();
        } catch (CustomExceptionDemo e) {
            System.err.println("Custom exception: " + e.getMessage());
        }
    }
}
