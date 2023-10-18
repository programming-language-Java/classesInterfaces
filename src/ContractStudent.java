import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class ContractStudent extends Student {
    private final ArrayList<Payment> payments;
    private final double TUITION_FEE = 100000;

    public ContractStudent(String name, String surname) {
        super(name, surname, 0);
        this.payments = new ArrayList<Payment>();
    }

    public ContractStudent(String name, String surname, int recordBookNumber) {
        super(name, surname, recordBookNumber);
        this.payments = new ArrayList<Payment>();
    }

    public ArrayList<Payment> getPayments() {
        return payments;
    }

    public double getTuitionFee() {
        return TUITION_FEE;
    }

    public double getDebt() {
        int daysSemester = 4 * 30;
        long daysPassed = Math.abs(ChronoUnit.DAYS.between(LocalDate.now(), getYearAdmission()));
        long semesters = daysPassed / daysSemester;
        double totalFee = semesters * TUITION_FEE;
        return totalFee - getPaidPrice();
    }

    public double getPaidPrice() {
        double totalPayment = 0;
        for (Payment payment : payments) {
            totalPayment += payment.getSum();
        }
        return totalPayment;
    }

    public void addPayment(Payment payment) {
        payments.add(payment);
    }
}