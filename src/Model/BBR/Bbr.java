package Model.BBR;

public class Bbr {
    private int propertyNumber;
    private String address;
    private int houseNumber;
    private int zipCode;
    private double heatedSquareMeters;
    private String propertyType;

//Constructor
    public Bbr(int propertyNumber, String adress, int houseNumber, int zipCode, double heatedSquareMeters, String propertyType) {
        this.propertyNumber = propertyNumber;
        this.address = adress;
        this.houseNumber = houseNumber;
        this.zipCode = zipCode;
        this.heatedSquareMeters = heatedSquareMeters;
        this.propertyType = propertyType;
    }
//getters and setters
    public int getPropertyNumber() {
        return propertyNumber;
    }

    public void setPropertyNumber(int propertyNumber) {
        this.propertyNumber = propertyNumber;
    }

    public String getAdress() {
        return address;
    }

    public void setAdress(String adress) {
        this.address = adress;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public double getHeatedSquareMeters() {
        return heatedSquareMeters;
    }

    public void setHeatedSquareMeters(double heatedSquareMeters) {
        this.heatedSquareMeters = heatedSquareMeters;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }



//toString
    @Override
    public String toString() {
        return  propertyNumber +
                ", " + address +
                ", " + houseNumber +
                ", " + zipCode +
                ", " + heatedSquareMeters +
                ", " + propertyType;
    }
}
