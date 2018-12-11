import java.time.LocalDate;
import java.util.ArrayList;

public class Channel {
    private String measureType;
    private ArrayList<Datausage> comsumptionData;
    private int total;

    public Channel(String measureType) {
        this.measureType = measureType;
        comsumptionData = new ArrayList<>();
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

    public int getTotal(){
        total = 0;
        for (Datausage datausage: comsumptionData){
            total += datausage.getUserData();
        }
        return total;
    }

    public void addNewDatausage(int userData, LocalDate date, String unitType){
    comsumptionData.add(new Datausage(userData, date, unitType));
    }

    }

