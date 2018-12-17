package Model.BBR;

public class Bbr {
    private int propertyNumber;
    private String address;
    private int houseNumber;
    private int zipCode;
    private int heatedSquareMeters;
    private String propertyType;

//Constructor
    public Bbr(int propertyNumber, String address, int houseNumber, int zipCode, int heatedSquareMeters, String propertyType) {
        this.propertyNumber = propertyNumber;
        this.address = address;
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

    public void setAdress(String address) {
        this.address = address;
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

    public int getHeatedSquareMeters() {
        return heatedSquareMeters;
    }

    public void setHeatedSquareMeters(int heatedSquareMeters) {
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
