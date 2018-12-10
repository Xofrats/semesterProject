//BBR Handler
public class BbrHandler {
        public static Bbr createBbrManuelt(int propertyNumber, String adress, int houseNumber, int zipCode, double heatedSquareMeters, String propertyType){
        Bbr createBbr = new Bbr(propertyNumber, adress, houseNumber,zipCode,heatedSquareMeters,propertyType);
        return createBbr;
    }
}
