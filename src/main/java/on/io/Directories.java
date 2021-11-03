package on.io;

import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Directories {
    static Path test = Paths.get("test");
    static String sep = FileSystems.getDefault().getSeparator();
    static List<String> parts = Arrays.asList("foo", "bar", "baz", "bag");

    static Path makeVariant() {
        Collections.rotate(parts, 1);
        return Paths.get("test", String.join(sep, parts));
    }

    static void refreshTestDir() throws Exception {
        if (Files.exists(test))
            RmDir.rmdir(test);
        if (!Files.exists(test))
            Files.createDirectory(test);
    }

    static void populateTestDir() throws Exception {
        for (int i = 0; i < parts.size(); i++) {
            Path variant = makeVariant();
            if (!Files.exists(variant)) {
                Files.createDirectories(variant);
                Files.copy(Paths.get("pom.xml"),
                        variant.resolve("File.txt"));
                Files.createTempFile(variant, null, null);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        refreshTestDir();
        Files.createFile(test.resolve("Hello.txt"));

        populateTestDir();
        Path tempDir = Files.createTempDirectory(test, "DIR_");
        Files.createTempFile(tempDir, "pre", ".non");
        Files.newDirectoryStream(test).forEach(System.out::println);
        System.out.println("*********");
        Files.walk(test).forEach(System.out::println);
    }
}
