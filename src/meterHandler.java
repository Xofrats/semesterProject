

public class meterHandler {

    public static Meter createMeterAuto(){
        Meter createdMeter = new Meter("heat", 9876, 1,BbrHandler.createBbrManuelt(1234, "gade", 12, 5555, 100, "hus") );
        return createdMeter;
    }
}
