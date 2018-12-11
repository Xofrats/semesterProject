import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class domain {

    public static void main(String args[]) {
        Bbr test = BbrHandler.createBbrManuelt(1234, "gade", 55, 9999, 100, "house");
        Meter meter = new Meter( 1234, 1, test);
        LocalDate today = LocalDate.now();
        Channel channelTest = new Channel("heat", new ArrayList<>());
        ArrayList<Channel> channelList = new ArrayList();
        channelList.add(channelTest);
        meter.setChannels(channelList);
        for (int i = 0; i < 100; i++) {
            Random random = new Random();
            int n = random.nextInt(100) + 1;
            channelTest.addNewDatausage(n, today, "joule");

        }


        String output = meter.generateOutput();
        System.out.println(output);



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

