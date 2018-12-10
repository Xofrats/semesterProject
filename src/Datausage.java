public class Datausage {

    private int userData;
    private int date;
    private String unitType;


    public Datausage(int userData, int date, String unitType) {
        this.date = date;
        this.unitType = unitType;
        this.userData = userData;
    }

    public int getUserData() {
        return userData;
    }

    public int getDate() {
        return date;
    }

    public String getUnitType() {
        return unitType;
    }

    public void setUserData(int userData) {
        this.userData = userData;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }
}

