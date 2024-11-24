package lab02;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NoGarbage {
     public static void main(String[] args) {
        String filename = "/Users/andrew_ta/Andrew-Code/IT3103.744530.2024.1.20225906.TaHongPhuc/lab03/AimsProject_phucth_2/bin/lab02/test.txt";
        byte[] inputBytes = {};
        long startTime, endTime;

        try {
            inputBytes = Files.readAllBytes(Paths.get(filename));
            startTime = System.currentTimeMillis();
            StringBuilder sb = new StringBuilder();
            for (byte b : inputBytes) {
                sb.append((char) b);
            }
            String outputString = sb.toString();
            endTime = System.currentTimeMillis();
            System.out.println(endTime - startTime);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
