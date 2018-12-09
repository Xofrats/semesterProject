import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class domain {

    public static void main (String args[]){
    Meter meter = new Meter(new ArrayList<>(), "heat", 555);
    LocalDate today = LocalDate.now();
    meter.addReading(1000, "flow", today);
    for (int i=0; i<100; i++){
        Random random=new Random();
        int n=random.nextInt(100)+1;
        meter.addReading(n,"flow",today);

        }
    String output = meter.generateOutput();
    System.out.println(output);

    }
}
