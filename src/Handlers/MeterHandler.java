package Handlers;

import Model.BBR.Bbr;
import Model.Meter.Channel;
import Model.Meter.Datausage;
import Model.Meter.Meter;

import java.util.ArrayList;

public class MeterHandler {
    //her gemmes alle målere
    private static ArrayList<Meter> allMeters = new ArrayList<>();

    //alle gyldige målere skal laves med denne funktion. Den tager tre værdier, en int til idenfikation, 1 eller 0 til om den er aktivt eller ej og en BBR som modelhandlerne selv finder
    public static Meter createMeterAuto(int number, int isActive, Bbr BBR) {
        Meter createdMeter = new Meter(number, isActive, BBR);
        allMeters.add(createdMeter);
        return createdMeter;
    }

    //finder alle målerne
    public static ArrayList<Meter> getAllMeters() {
        return allMeters;
    }

    //Finder en bestemt måler ved at sammeligne det given meterNumber med de gemte måleres number.
    public static Meter getMeter(int meterNumber) {

        for (Meter meter : allMeters) {
            if (meterNumber == meter.getNumber()) {
                return meter;
            }
        }
        //Hvis der ikke er et match får brugeren en falsk måler der har ugyldige værdier.
        Meter falseMeter = new Meter(meterNumber, 0, new Bbr(0000, "nowhere", 00, 0000, 00, "none"));
        return falseMeter;
    }

    //Finder en bestemt måler og giver den en ny Bbr
    public static void addBbrToMeter(int meterNumber, Bbr BBR) {

        for (Meter meter : allMeters) {
            if (meterNumber == meter.getNumber()) {
                meter.setLocation(BBR);
            }
        }

    }

    //Gør en bestemt måler aktiv hvis den er nedlagt, og nedlagt hvis den er aktiv.
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

    //Kigger alle målerne igennem og finder alle mangler.
    public static String dataValidation(){
        String allErrors = "";
        for (Meter meter: allMeters){
            if (meter.getNumber() == 0){
                allErrors += meter.getNumber() + "missing number" + "\n";
            }

            if (meter.getIsActive() == 0){
                allErrors += meter.getNumber() + "Got data from deactivate meter" + "\n";
            }

            if (meter.getChannels() == null){
                allErrors += meter.getNumber() + "missing channels" + "\n";
            }

            for (Channel channel: meter.getChannels()){
                if (channel.getMeasureType() == ""){
                    allErrors += meter.getNumber() + " " + channel.getMeasureType() + "missing channel measure type" + "\n";
                }

                if (channel.getTotal() == 0){
                    allErrors += meter.getNumber() + " " + channel.getMeasureType() + "missing total" + "\n";
                }

                for (Datausage datausage: channel.getComsumptionData()){
                    if (datausage.getUserData() == 0){
                        allErrors += meter.getNumber() + " " + channel.getMeasureType() + " " + datausage.getUnitType() + "missing Data value" + "\n";
                    }

                    if (datausage.getDate() == null){
                        allErrors += meter.getNumber() + " " + channel.getMeasureType() + " " + datausage.getUnitType() + "missing date" + "\n";
                    }

                    if (datausage.getUnitType() == ""){
                        allErrors += meter.getNumber() + " " + channel.getMeasureType() + " " + datausage.getUnitType() + "missing unit type" + "\n";
                    }
                }
            }
        }

        return allErrors;
    }
}

