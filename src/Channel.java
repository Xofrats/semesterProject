import java.util.ArrayList;

public class Channel {

    public ArrayList<Datausage> FetchComsumptionData=new ArrayList<>();

    public void addNewDatausage(int userData, int date, String unitType){
    FetchComsumptionData.add(new Datausage(userData, date, unitType));
    }
}
