package Handlers;

import Model.BBR.Bbr;
import Model.Meter.Channel;
import Model.Meter.Datausage;
import Model.Meter.Meter;

import java.util.ArrayList;

public class meterHandler {

    private static ArrayList<Meter> allMeters = new ArrayList<>();

    public static Meter createMeterAuto(int number, int isActive, Bbr BBR) {
        Meter createdMeter = new Meter(number, isActive, BBR);
        allMeters.add(createdMeter);
        return createdMeter;
    }

    public static Meter createMeterManuelt(int number, int isActive, int propertyNumber, String address, int houseNumber, int zipCode, int heatedSquareMeter, String propertyType) {
        Meter createdMeter = new Meter(number, isActive, BbrHandler.createBbrManuelt(propertyNumber, address, houseNumber, zipCode, heatedSquareMeter, propertyType));
        allMeters.add(createdMeter);
        return createdMeter;
    }

    public static ArrayList<Meter> getAllMeters() {
        return allMeters;
    }

    public static Meter getMeter(int meterNumber) {

        for (Meter meter : allMeters) {
            if (meterNumber == meter.getNumber()) {
                return meter;
            }
        }
        Meter falseMeter = new Meter(meterNumber, 0, new Bbr(0000, "nowhere", 00, 0000, 00, "none"));
        return falseMeter;
    }

    public static void addBbrToMeter(int meterNumber, Bbr BBR) {

        for (Meter meter : allMeters) {
            if (meterNumber == meter.getNumber()) {
                meter.setLocation(BBR);
            }
        }

    }

    public static void toggleActive(int meterNumber){
        for (Meter meter : allMeters) {
            if (meterNumber == meter.getNumber()) {
               if(meter.getIsActive() == 1){
                   meter.setIsActive(0);
               } else {
                   meter.setIsActive(1);
               }
            }
        }
    }

    //Generated output for all meters

    public static String allMetersOutput(){
        String allOutput = "";
        for (Meter meter: allMeters){
            allOutput += meter.generateOutput();
        }
        return allOutput;
    }

    public static String dataValidation(){
        String allErrors = "";
        for (Meter meter: allMeters){
            if (meter.getNumber() == 0){
                allErrors += meter + "missing number" + "\n";
            }

            if (meter.getIsActive() == 0){
                allErrors += meter + "Got data from deactive meter" + "\n";
            }

            if (meter.getChannels() == null){
                allErrors += meter + "missing channels" + "\n";
            }

            for (Channel channel: meter.getChannels()){
                if (channel.getMeasureType() == ""){
                    allErrors += meter + " " + channel + "missing channel measure type" + "\n";
                }

                if (channel.getTotal() == 0){
                    allErrors += meter + " " + channel + "missing total" + "\n";
                }

                for (Datausage datausage: channel.getComsumptionData()){
                    if (datausage.getUserData() == 0){
                        allErrors += meter + " " + channel + " " + datausage + "missing Data value" + "\n";
                    }

                    if (datausage.getDate() == null){
                        allErrors += meter + " " + channel + " " + datausage + "missing date" + "\n";
                    }

                    if (datausage.getUnitType() == ""){
                        allErrors += meter + " " + channel + " " + datausage + "missing unit type" + "\n";
                    }
                }
            }
        }

        return allErrors;
    }
}

