

public class meterHandler {

    public static Meter createMeterAuto(String measureType, int number, int isActive, Bbr BBR){
        Meter createdMeter = new Meter(number, isActive, BBR);
        return createdMeter;
    }

    public static Meter createMeterManuelt(String measureType, int number, int isActive, int propertyNumber, String address, int houseNumber, int zipCode, double heatedSquareMeter, String propertyType){
        Meter createdMeter = new Meter(number, isActive,BbrHandler.createBbrManuelt(propertyNumber, address, houseNumber, zipCode, heatedSquareMeter, propertyType) );
        return createdMeter;
    }
}
