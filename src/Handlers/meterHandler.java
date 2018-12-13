package Handlers;

import Model.BBR.Bbr;
import Model.Meter.Meter;

import java.util.ArrayList;

public class meterHandler {

    private static ArrayList<Meter> allMeters = new ArrayList<>();

    public static Meter createMeterAuto(String measureType, int number, int isActive, Bbr BBR) {
        Meter createdMeter = new Meter(number, isActive, BBR);
        allMeters.add(createdMeter);
        return createdMeter;
    }

    public static Meter createMeterManuelt(String measureType, int number, int isActive, int propertyNumber, String address, int houseNumber, int zipCode, int heatedSquareMeter, String propertyType) {
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
}

