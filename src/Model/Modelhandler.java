package Model;

import Handlers.DataGenerator;
import Handlers.meterHandler;
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

        Meter meter = meterHandler.createMeterAuto(1111, 1, BbrHandler.getAllBbr().get(5));
        Meter meter2 = meterHandler.createMeterAuto(2222, 1, BbrHandler.getAllBbr().get(7));
        meter.addChannel(DataGenerator.randomChannel("", 1, "joule"));
        meter.addChannel(DataGenerator.randomChannel("water", 1, "flow"));
        meter2.addChannel(DataGenerator.randomChannel("heat", 1, ""));

        Meter meter3 = DataGenerator.randomMeter();
        meter3.addChannel(DataGenerator.randomChannel("water", 1, "temperature"));

        System.out.println(meterHandler.dataValidation());

        String output = meterHandler.allMetersOutput();
       // createCsvFile("c:/test/test3", output);



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

