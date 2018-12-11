import java.time.LocalDate;
import java.util.ArrayList;

public class Channel {
    private String measureType;
    private ArrayList<Datausage> comsumptionData;

    public Channel(String measureType, ArrayList<Datausage> comsumptionData) {
        this.measureType = measureType;
        this.comsumptionData = comsumptionData;
    }

    public String getMeasureType() {
        return measureType;
    }

    public void setMeasureType(String measureType) {
        this.measureType = measureType;
    }

    public ArrayList<Datausage> getComsumptionData() {
        return comsumptionData;
    }

    public void setComsumptionData(ArrayList<Datausage> comsumptionData) {
        this.comsumptionData = comsumptionData;
    }

    public void addNewDatausage(int userData, LocalDate date, String unitType){
    comsumptionData.add(new Datausage(userData, date, unitType));
    }

    }

