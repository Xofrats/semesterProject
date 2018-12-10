import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class domain {

    public static void main(String args[]) {
        Bbr test = BbrHandler.createBbrManuelt(1234, "gade", 55, 9999, 100, "house");
        Meter meter = new Meter("heat", 1234, 1, test);
        LocalDate today = LocalDate.now();
        meter.addReading(1000, "flow", today);
        for (int i = 0; i < 100; i++) {
            Random random = new Random();
            int n = random.nextInt(100) + 1;
            meter.addReading(n, "flow", today);

        }


        String output = meter.generateOutput();
        System.out.println(output);
        System.out.println(meter.getLocation());
        createCsvFile("c:/test/test3", output);

    }

    public static void createCsvFile(String fileName, String str) {


        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(fileName));
            writer.write(str);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

