package on.io;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PartsOfPaths {
    public static void main(String[] args) {
        System.out.println(System.getProperty("os.name"));

        Path p = Paths.get("src/main/java/on/io/").toAbsolutePath();

        for (int i = 0; i < p.getNameCount(); i++) {
            System.out.println(p.getName(i));
        }

        System.out.println("ends with '.java': " + p.endsWith(".java"));
        System.out.println("ends with 'io': " + p.endsWith("io"));
    }
}
