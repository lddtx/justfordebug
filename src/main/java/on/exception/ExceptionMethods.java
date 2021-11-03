package on.exception;

public class ExceptionMethods {
    public static void main(String[] args) {
        try {
            throw new Exception("My Exception");
        } catch (Exception e) {
            e.printStackTrace(System.out);
            e.printStackTrace();
        }
    }
}
