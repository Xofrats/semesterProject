import java.time.LocalDate;
import java.util.ArrayList;

public class Meter {
    private ArrayList<Reading> readings = new ArrayList<>();
    private String MeasureType;
    private int number;

    public Meter(ArrayList<Reading> readings, String measureType, int number) {
        this.readings = readings;
        this.MeasureType = measureType;
        this.number = number;
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
        output = date + ", " + value + ", " + type + ", " + measureType + ", " + number + "\n";
        allOutput += output;

        }
        return allOutput;
    }
}
