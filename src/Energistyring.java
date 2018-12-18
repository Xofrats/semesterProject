import Handlers.BbrHandler;
import Handlers.DataGenerator;
import Handlers.MeterHandler;
import Javafx.Ui;
import Model.Meter.Meter;

public class Energistyring {

    public static void main (String args[]){

        DataGenerator.createBbrs(10);

    /*    Meter meter = meterHandler.createMeterAuto(1111, 1, BbrHandler.getAllBbr().get(5));
        Meter meter2 = meterHandler.createMeterAuto(2222, 1, BbrHandler.getAllBbr().get(7));
        meter.addChannel(DataGenerator.randomChannel("", 1, "joule"));
        meter.addChannel(DataGenerator.randomChannel("water", 1, "flow"));
        meter2.addChannel(DataGenerator.randomChannel("heat", 1, ""));

        Meter meter3 = DataGenerator.randomMeter();
        meter3.addChannel(DataGenerator.randomChannel("water", 1, "temperature"));*/

        System.out.println(MeterHandler.dataValidation());

        //String output = meterHandler.allMetersOutput();
        // createCsvFile("c:/test/test3", output);



        Ui.UI(args);

    }

}
