import interfaces.Event;

import java.time.LocalDate;

public class Competition implements Event {
    private LocalDate date;
    private String city;
    private String projectName;

    private int sumWin;

    public Competition(LocalDate date, String city, String projectName, int sumWin) {
        this.date = date;
        this.city = city;
        this.projectName = projectName;
        this.sumWin = sumWin;
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

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public int getSumWin() {
        return sumWin;
    }

    public void setSumWin(int sumWin) {
        this.sumWin = sumWin;
    }
}