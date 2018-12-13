package Model;

import Handlers.DataGenerator;
import Model.BBR.Bbr;
import Handlers.BbrHandler;
import Model.Meter.Meter;
import Model.Meter.Channel;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class Modelhandler {

    public static void main(String args[]) {

        DataGenerator.createBbrs(10);

        Meter meter = new Meter(1111, 1, BbrHandler.getAllBbr().get(3));
        meter.addChannel(DataGenerator.randomChannel("heat", 30, "joule"));

        System.out.println(BbrHandler.getAllBbr());
        System.out.println(meter.getLocation());


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

