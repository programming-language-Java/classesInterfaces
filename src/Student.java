import interfaces.Activist;
import interfaces.Event;

import java.time.LocalDate;
import java.util.ArrayList;

public class Student implements Activist {
    private String name;
    private String surname;
    private LocalDate yearAdmission;
    private int recordBookNumber;
    private final ArrayList<Object> events;

    public Student(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.recordBookNumber = 0;
        this.events = new ArrayList<>();
    }

    public Student(String name, String surname, int recordBookNumber) {
        this.name = name;
        this.surname = surname;
        this.recordBookNumber = recordBookNumber;
        this.events = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getRecordBookNumber() {
        return recordBookNumber;
    }

    public void setRecordBookNumber(int recordBookNumber) {
        this.recordBookNumber = recordBookNumber;
    }

    public LocalDate getYearAdmission() {
        return yearAdmission;
    }

    public void setYearAdmission(LocalDate yearAdmission) {
        this.yearAdmission = yearAdmission;
    }

    public int getNumberEvents() {
        return events.size();
    }

    @Override
    public int getQuantityPrizes() {
        int count = 0;
        for (Object event : events) {
            count += isPrize(event);
        }
        return count;
    }

    private int isPrize(Object event) {
        if (event instanceof Olympics olympic && olympic.getPlace() <= 3) {
            return 1;
        }
        return 0;
    }

    @Override
    public int getQuantityReport() {
        int count = 0;
        for (Object event : events) {
            if (event instanceof Conference) count++;
        }
        return count;
    }

    @Override
    public StringBuilder getProjectNames() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Object event : events) {
            if (event instanceof Competition competition
                    && competition.getSumWin() > 0) {
                String newString = competition.getProjectName() + "\n";
                stringBuilder.append(newString);
            }
        }
        return stringBuilder;
    }

    // Методы работы со списком событий
    public void addEvent(Object event) {
        events.add(event);
    }

    public Object findEventByDate(LocalDate date) {
        for (Object event : events) {
            boolean isEvent = event instanceof Event iEvent
                    && iEvent.getDate().equals(date);
            if (isEvent) return event;
        }
        return null;
    }

    public void removeEventByDate(LocalDate date) {
        Object eventToRemove = null;
        for (Object event : events) {
            boolean isEvent = event instanceof Event iEvent
                    && iEvent.getDate().equals(date);
            if (isEvent) {
                eventToRemove = event;
                break;
            }
        }
        if (eventToRemove == null) {
            System.out.println("Событие не найдено");
        } else {
            events.remove(eventToRemove);
            System.out.println("Событие удалено " + date);
        }
    }

    public ArrayList<Object> getEvents() {
        return events;
    }
}
