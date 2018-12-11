import java.time.LocalDate;
import java.util.ArrayList;

public class Meter {
    private ArrayList<Channel> channels = new ArrayList<>();
    private int number;
    private int isActive;
    private Bbr location;

    public Meter(int number, int isActive, Bbr location) {


        this.number = number;
        this.isActive = isActive;
        this.location = location;
    }

    public ArrayList<Channel> getChannels() {
        return channels;
    }

    public void setChannels(ArrayList<Channel> channels) {
        this.channels = channels;
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

    public void addChannel(String measureType){
        Channel channel = new Channel(measureType);
        channels.add(channel);

    }

    public String generateOutput(){

        String allOutput = "";

        for (Channel channel: channels) {
            for (Datausage datausage: channel.getComsumptionData()){
                int userData = datausage.getUserData();
                LocalDate date= datausage.getDate();
                String unitType = datausage.getUnitType();

                String type = channel.getMeasureType();
                int total = channel.getTotal();

                int number = this.number;
                int isActive = this.isActive;
                Bbr bbr = this.location;
                String output = date + ", " + number + ", " + type + ", " + userData + ", " + unitType +  ", " + total + ", " + isActive +  ", " + bbr + "\n";
                allOutput += output;
            }






        }
        return allOutput;
    }
}
