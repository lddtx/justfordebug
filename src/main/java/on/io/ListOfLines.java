package on.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ListOfLines {
    public static void main(String[] args) throws IOException {
        Files.readAllLines(Paths.get("src/main/java/on/io/ListOfLines.java"))
                .stream()
                .filter(line -> !line.startsWith("package"))
                .map(String::toUpperCase)
                .forEachOrdered(System.out::println);
    }
}
