import interfaces.Event;

import java.time.LocalDate;

public class Olympics implements Event {
    private LocalDate date;
    private String city;
    private int place;

    public Olympics(LocalDate date, String city, int place) {
        this.date = date;
        this.city = city;
        this.place = place;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }
}