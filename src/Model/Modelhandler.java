package Model;


import Handlers.MeterHandler;
import Model.BBR.Bbr;
import Handlers.BbrHandler;
import Model.Meter.Meter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;

public class Modelhandler {

    //kalder meterhandler for at lave en ny måler
    public static void createMeter(int meterNumber, int active, Bbr bbr){
        MeterHandler.createMeterAuto(meterNumber, active, bbr);
    }

    //kalder bbrhandler for at finde en bestemt bbr
    public static Bbr getBbr(int propertyNumber){
       Bbr gottenBbr = BbrHandler.getBbr(propertyNumber);
       return gottenBbr;
    }

    //kalder meterhandler for at ændre en målerens status
    public static void toggleActive(int meterNumber){
        MeterHandler.toggleActive(meterNumber);
    }

        //kalder meterhandler for at finde ud af en bestemt måler er aktiv
    public static int isActive(int meterNumber){
        ArrayList<Meter> allMeter = MeterHandler.getAllMeters();
        for (Meter meter: allMeter){
            if(meterNumber == meter.getNumber()){
                return meter.getIsActive();
            }
        }
        //Hvis der er indtastet noget forkert kommer værdien 3 tilbage, som er en fejlkode
        return 3;
    }

    //kalder meter handler for at ændre en bestemt målers bbr
    public static void addBbrToMeter(int meterNumber, Bbr bbr){
        MeterHandler.addBbrToMeter(meterNumber, bbr);
    }

    //Finder alle mangler
    public static String validateData(){
      String allErrors = MeterHandler.dataValidation();
      return allErrors;
    }

    //Finder en bestemt måler
    public static Meter getMeter(int meterNumber){
        Meter gottenMeter = MeterHandler.getMeter(meterNumber);
        return gottenMeter;
    }

    //Får alle målere
    public static ArrayList<Meter> getAllMeters(){
        ArrayList<Meter> allMeters =  MeterHandler.getAllMeters();
        return allMeters;
    }


    //LAver en CSV fil
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

