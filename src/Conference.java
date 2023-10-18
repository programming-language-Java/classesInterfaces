import interfaces.Event;

import java.time.LocalDate;

public class Conference implements Event {
    private LocalDate date;
    private String city;
    private String titleReport;

    public Conference(LocalDate date, String city, String titleReport) {
        this.date = date;
        this.city = city;
        this.titleReport = titleReport;
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

    public String getTitleReport() {
        return titleReport;
    }

    public void setTitleReport(String titleReport) {
        this.titleReport = titleReport;
    }
}