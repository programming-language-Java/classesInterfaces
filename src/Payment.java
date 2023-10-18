import java.time.LocalDate;

public class Payment {
    private LocalDate date;
    private double sum;

    public Payment() {
        this.date = null;
        this.sum = 0;
    }

    public Payment(LocalDate date, double sum) {
        this.date = date;
        this.sum = sum;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }
}