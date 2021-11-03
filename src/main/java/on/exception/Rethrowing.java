package on.exception;

public class Rethrowing {
    public static void f() throws Exception {
        System.out.println("Originating the exception on f()");
        throw new Exception("throw from f()");
    }

    public static void g() throws Exception {
        try {
            f();
        } catch (Exception e) {
            System.out.println("Inside g()");
            e.printStackTrace();
            throw e;
        }
    }

    public static void h() throws Exception {
        try {
            f();
        } catch (Exception e) {
            System.out.println("Inside h()");
            e.printStackTrace();
            throw (Exception) e.fillInStackTrace();
        }
    }

    public static void main(String[] args) {
//        try {
//            g();
//        } catch (Exception e) {
//            System.out.println("main");
//            e.printStackTrace();
//        }

        try {
            h();
        } catch (Exception e) {
            System.out.println("main");
            e.printStackTrace();
        }
    }
}
