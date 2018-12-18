package Handlers;

import Model.BBR.Bbr;

import java.util.ArrayList;

//Model.BBR Handler
public class BbrHandler {
    //Gemmer alle bbr'er
    private static ArrayList<Bbr> allBbr = new ArrayList<>();

        // laver et bbr objekt
        public static Bbr createBbrManuelt(int propertyNumber, String address, int houseNumber, int zipCode, int heatedSquareMeters, String propertyType){
        Bbr createBbr = new Bbr(propertyNumber, address, houseNumber,zipCode,heatedSquareMeters,propertyType);
        allBbr.add(createBbr);
        return createBbr;

    }

    //viser alle bbr'er
    public static ArrayList<Bbr> getAllBbr(){
            return allBbr;
    }

    // kigger all brr'er igennem for at se om der er en med det given propertynumber
    public static boolean isValidAddress(int propertyNumber){
            boolean isValid = false;
            for (Bbr bbr: allBbr){
                if (propertyNumber == bbr.getPropertyNumber()){
                    isValid = true;
                    break;
                }
            }
            return isValid;
    }

    //henter en bestemt bbr
    public static Bbr getBbr(int propertyNumber){
            for (Bbr brr: allBbr){
                if (propertyNumber == brr.getPropertyNumber()){
                    return brr;
                }
            }
            Bbr bbr = new Bbr(0000, "None", 00, 0000, 00, "none");
            return bbr;
    }
}
