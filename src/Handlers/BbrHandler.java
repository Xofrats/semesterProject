package Handlers;

import Model.BBR.Bbr;

import java.util.ArrayList;

//Model.BBR Handler
public class BbrHandler {
    private static ArrayList<Bbr> allBbr = new ArrayList<>();

        public static Bbr createBbrManuelt(int propertyNumber, String adress, int houseNumber, int zipCode, int heatedSquareMeters, String propertyType){
        Bbr createBbr = new Bbr(propertyNumber, adress, houseNumber,zipCode,heatedSquareMeters,propertyType);
        allBbr.add(createBbr);
        return createBbr;

    }

    public static ArrayList<Bbr> getAllBbr(){
            return allBbr;
    }

    public static boolean isValidAdress(int propertyNumber){
            boolean isValid = false;
            for (Bbr bbr: allBbr){
                if (propertyNumber == bbr.getPropertyNumber()){
                    isValid = true;
                    break;
                }
            }
            return isValid;
    }
}
