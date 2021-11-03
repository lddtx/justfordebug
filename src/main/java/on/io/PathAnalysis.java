package on.io;

import java.io.IOException;
import java.nio.file.*;

public class PathAnalysis {
    static void say(String id, Object result) {
        System.out.print(id + ": ");
        System.out.println(result);
    }
    public static void main(String[] args) throws IOException {
        System.out.println(System.getProperty("os.name"));
        Path path = Paths.get("src/main/java/on/io/PathAnalysis.java").toAbsolutePath();
        say("Exists", Files.exists(path));
        say("IsDirectory", Files.isDirectory(path));
        say("IsReadable", Files.isReadable(path));
        say("IsRegularFile", Files.isRegularFile(path));
        say("IsWritable", Files.isWritable(path));
        say("IsHidden", Files.isHidden(path));

        say("Size", Files.size(path));
        say("Store", Files.getFileStore(path));
        say("LastModifiedTime", Files.getLastModifiedTime(path));
        say("Owner", Files.getOwner(path));
        say("ContentType", Files.probeContentType(path));
        say("IsSymbolicLink", Files.isSymbolicLink(path));
        if (FileSystems.getDefault().supportedFileAttributeViews().contains("posix")) {
            say("PosixFilePermissions", Files.getPosixFilePermissions(path));
        }
    }
}
