import BBR.Bbr;
import Handlers.BbrHandler;
import Meter.Meter;
import Meter.Channel;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class domain {

    public static void main(String args[]) {

        System.out.println("abe");
        Bbr test = BbrHandler.createBbrManuelt(9876, "gade", 55, 9999, 100, "house");
        Meter meter = new Meter( 1234, 1, test);
        LocalDate today = LocalDate.now();
        Channel channelTest = new Channel("heat");
        Channel channelTest2 = new Channel("water");
        ArrayList<Channel> channelList = new ArrayList();
        channelList.add(channelTest);
        channelList.add(channelTest2);
        meter.setChannels(channelList);
        for (int i = 0; i < 100; i++) {
            Random random = new Random();
            int n = random.nextInt(100) + 1;
            channelTest.addNewDatausage(n, today, "joule");

        }

        for (int i = 0; i < 100; i++) {
            Random random = new Random();
            int n = random.nextInt(100) + 1;
            channelTest2.addNewDatausage(n, today, "flow");

        }

boolean checkBBR;
        boolean checkFalse;
        checkBBR = BbrHandler.isValidAdress(meter.getLocation().getPropertyNumber());
        checkFalse = BbrHandler.isValidAdress(5555);

        System.out.println(checkBBR);
        System.out.println(checkFalse);
       // String output = meter.generateOutput();
       // System.out.println(output);
      //  createCsvFile("c:/test/test3", output);



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

