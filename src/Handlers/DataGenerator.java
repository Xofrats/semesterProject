package Handlers;

import Model.BBR.Bbr;
import Model.Meter.Channel;
import Model.Meter.Datausage;
import Model.Meter.Meter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class DataGenerator {

    // random date

    public static LocalDate randomDate(){
        Random random = new Random();
        int minusDay = random.nextInt(1050) + 1;
        LocalDate randomDate = LocalDate.now();
        randomDate.minusDays(minusDay);
        return randomDate;
}


//random datauasge and channel for meters
public static ArrayList<Datausage> randomDatauage(int total, String unitType){
        Random random = new Random();
        int userData = random.nextInt(100) + 1;
        ArrayList<Datausage> generatedList = new ArrayList<>();
        for (int i = 0; i < total; i++){
            Datausage createdDatausage = new Datausage(userData, randomDate(), unitType);
            generatedList.add(createdDatausage);
    }
    return generatedList;
}

public static Channel randomChannel(String measureType,  int length, String unitType){
        Channel createdChannel = new Channel(measureType);
        createdChannel.setComsumptionData(randomDatauage(length, unitType));
        return createdChannel;
}

// Random meter
    public static Meter randomMeter(){
        Random random = new Random();
        Meter createdMeter = MeterHandler.createMeterAuto(random.nextInt(9000) + 1, 1, BbrHandler.getAllBbr().get(random.nextInt(BbrHandler.getAllBbr().size())));
        return createdMeter;
    }



//Random BBR
    public static void createBbrs(int total){
        ArrayList<String> randomAddresses = new ArrayList<>(Arrays.asList("Fredensvej", "Vestergade", "Silkeborgvej"));
        ArrayList<String> randomPropertyTypes = new ArrayList<>(Arrays.asList("hus", "Etage-ejendom"));
        Random random = new Random();
        for (int i = 0; i<total; i++){
            String randomAddress = randomAddresses.get(random.nextInt(randomAddresses.size()));
            String randomPropertyType = randomPropertyTypes.get(random.nextInt(randomPropertyTypes.size()));
            BbrHandler.createBbrManuelt(i, randomAddress, random.nextInt(20)+1, random.nextInt(9999) + 1, random.nextInt(400) + 1, randomPropertyType);
        }
    }
}
