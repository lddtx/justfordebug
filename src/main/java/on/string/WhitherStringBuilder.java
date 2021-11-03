package on.string;

public class WhitherStringBuilder {
    /**
     * 隐式创建StringBuilder
     */
    public String implicit(String[] strings) {
        String result = "";
        for (String string : strings) {
            result += string;
        }
        return result;
    }

    /**
     * 显式创建StringBuilder
     */
    public String explicit(String[] strings) {
        StringBuilder result = new StringBuilder();
        for (String string : strings) {
            result.append(string);
        }
        return result.toString();
    }
}
