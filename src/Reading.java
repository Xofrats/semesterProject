import java.time.LocalDate;

public class Reading {
    private int value1;
    private String type;
    private LocalDate date;

    public Reading(int value1, String type, LocalDate date) {
        this.value1 = value1;
        this.type = type;
        this.date = date;
    }

    public int getValue1() {
        return value1;
    }

    public String getType() {
        return type;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setValue1(int value1) {
        this.value1 = value1;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }


}
