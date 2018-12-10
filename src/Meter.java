import java.time.LocalDate;
import java.util.ArrayList;

public class Meter {
    private ArrayList<Reading> readings = new ArrayList<>();
    private String MeasureType;
    private int number;
    private int isActive;
    private Bbr location;

    public Meter(String measureType, int number, int isActive, Bbr location) {

        MeasureType = measureType;
        this.number = number;
        this.isActive = isActive;
        this.location = location;
    }

    public ArrayList<Reading> getReadings() {
        return readings;
    }

    public void setReadings(ArrayList<Reading> readings) {
        this.readings = readings;
    }

    public String getMeasureType() {
        return MeasureType;
    }

    public void setMeasureType(String measureType) {
        MeasureType = measureType;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }


    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    public Bbr getLocation() {
        return location;
    }

    public void setLocation(Bbr location) {
        this.location = location;
    }

    public void addReading(int value1, String type, LocalDate date){
        Reading reading = new Reading(value1, type, date);
        readings.add(reading);
    }

    public String generateOutput(){

        String allOutput = "";

        for (Reading reading: readings) {
        String output;
        int value = reading.getValue1();
        String type = reading.getType();
        LocalDate date = reading.getDate();
        String measureType = this.MeasureType;
        int number = this.number;
        output = date + ", " + value + ", " + type + ", " + measureType + ", " + number + ", " + isActive + "\n";
        allOutput += output;

        }
        return allOutput;
    }
}
