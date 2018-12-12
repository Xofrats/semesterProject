package Model.Meter;

import java.time.LocalDate;

public class Datausage {

    private int userData;
    private LocalDate date;
    private String unitType;


    public Datausage(int userData, LocalDate date, String unitType) {
        this.date = date;
        this.unitType = unitType;
        this.userData = userData;
    }

    public int getUserData() {
        return userData;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getUnitType() {
        return unitType;
    }

    public void setUserData(int userData) {
        this.userData = userData;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }
}

