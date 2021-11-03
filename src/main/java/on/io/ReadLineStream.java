package on.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadLineStream {
    public static void main(String[] args) throws IOException {
        Files.lines(Paths.get("src/main/java/on/io/ReadLineStream.java"))
                .skip(6)
                .findFirst()
                .ifPresent(System.out::println);
    }
}
