package on.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class Writing {
    static Random random = new Random(47);
    static final int SIZE = 1000;
    public static void main(String[] args) throws IOException {
        byte[] bytes = new byte[SIZE];
        random.nextBytes(bytes);
        Files.write(Paths.get("bytes.txt"), bytes);
        System.out.println("bytes.txt size: " + Files.size(Paths.get("bytes.txt")));

        List<String> lines = Files.readAllLines(Paths.get("src/main/java/on/io/Writing.java"));
        Files.write(Paths.get("Writing.txt"), lines);
        System.out.println("Writing.txt size: " + Files.size(Paths.get("Writing.txt")));
    }
}
