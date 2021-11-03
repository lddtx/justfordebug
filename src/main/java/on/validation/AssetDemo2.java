package on.validation;

public class AssetDemo2 {
    public static void main(String[] args) {
        ClassLoader.getSystemClassLoader().setDefaultAssertionStatus(true);
        assert false;
    }
}