package interfaces;

import java.time.LocalDate;

public interface Event {
    LocalDate getDate();

    void setDate(LocalDate date);

    String getCity();

    void setCity(String city);
}
