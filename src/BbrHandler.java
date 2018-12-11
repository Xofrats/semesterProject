import java.util.ArrayList;

//BBR Handler
public class BbrHandler {
    private static ArrayList<Bbr> allBbr = new ArrayList<>();

        public static Bbr createBbrManuelt(int propertyNumber, String adress, int houseNumber, int zipCode, double heatedSquareMeters, String propertyType){
        Bbr createBbr = new Bbr(propertyNumber, adress, houseNumber,zipCode,heatedSquareMeters,propertyType);
        allBbr.add(createBbr);
        return createBbr;

    }

    public static ArrayList<Bbr> getAllBbr(){
            return allBbr;
    }
}
