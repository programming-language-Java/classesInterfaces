import interfaces.Event;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("Роман", "Романов", 1);
        Student student2 = new Student("Дмитрий", "Телепов");
        ContractStudent student3 = new ContractStudent("Паша", "Соколов");

        student2.setName("Паша");
        student2.setSurname("Соколов");
        student2.setRecordBookNumber(1000);
        System.out.println("Student 2:\nИмя: " + student2.getName()
                + "\nФамилия: " + student2.getSurname()
                + "\nНомер зачётки: " + student2.getRecordBookNumber());

        student3.setSurname("Телепов");
        student3.setName("Дмитрий");
        student3.setRecordBookNumber(1001);
        student3.setYearAdmission(LocalDate.of(2020, 9, 1));
        System.out.println("Оплата: " + student3.getTuitionFee());
        student3.addPayment(new Payment(LocalDate.of(2021, 9, 1), 20000));
        student3.addPayment(new Payment(LocalDate.of(2021, 12, 1), 30000));
        System.out.println(
                "Долг: " + student3.getDebt()
                        + "\nОплачиваемая цена: " + student3.getPaidPrice()
        );
        System.out.println("Платежи");
        for (Payment payment : student3.getPayments()) {
            System.out.println(
                    "\n\tДата платежа: " + payment.getDate()
                            + "\n\tСумма платежа: " + payment.getSum()
            );
        }

        student1.setYearAdmission(LocalDate.of(2022, 9, 1));

        Olympics olympics1 = new Olympics(LocalDate.of(2023, 10, 1), "Москва", 2);
        Olympics olympics11 = new Olympics(LocalDate.of(2023, 11, 1), "Москва", 5);
        student1.addEvent(olympics1);
        student1.addEvent(olympics11);
        Event e = (Event) student1.findEventByDate(LocalDate.of(2023, 10, 1));
        System.out.println("Нашёл: " + e.getDate());

        Competition сompetition1 = new Competition(LocalDate.of(2023, 12, 1), "Санкт-Петербург", "Хороший проект", 5000);
        Competition сompetition2 = new Competition(LocalDate.of(2023, 5, 25), "Севастополь", "Какое-то имя проекта", 10000);
        Competition сompetition3 = new Competition(LocalDate.of(2023, 5, 25), "Севастополь", "Какое-то имя проекта", 10000);
        сompetition3.setDate(LocalDate.of(2022, 3, 10));
        сompetition3.setCity("Санкт-Петербург");
        сompetition3.setProjectName("Биологический прогресс");
        сompetition3.setSumWin(15000);

        System.out.println(
                "Обновили конкурс\n"
                        + "\tНаименование проекта: " + сompetition3.getProjectName()
                        + "\n\tГород: " + сompetition3.getCity()
                        + "\n\tДата " + сompetition3.getDate()
                        + "\n\tСумма выигрыша: " + сompetition3.getSumWin()
        );
        student1.addEvent(сompetition1);
        student2.addEvent(сompetition2);
        student3.addEvent(сompetition3);

        student1.removeEventByDate(LocalDate.of(2023, 12, 1));

        Conference conference2 = new Conference(LocalDate.of(2023, 11, 1), "Москва", "Нанотехнологии");
        System.out.println(
                "Конференции " + student2.getName()
                        + "\n\tНазвание: " + conference2.getTitleReport()
                        + "\n\tГород: " + conference2.getCity()
                        + "\n\tДата: " + conference2.getDate()
        );
        conference2.setTitleReport("Нанороботы");
        System.out.println("Обновили наименование: " + conference2.getTitleReport());
        student2.addEvent(conference2);


        Group group = new Group(1);
        group.addStudent(student1);
        group.addStudent(student2);
        group.addStudent(student3);
        System.out.println(
                "\nГруппа\n"
                        + "\tКоличество студентов:" + group.getQuantityStudents()
                        + "\n\tСтуденты: " + getStrArray(group.getStudents())
                        + "\n\tСтуденты активисты: " + getStrArray(group.getStudentActivists())
                        + "\n\tСтуденты победители: " + getStrArray(group.getStudentWinners())
                        + "\n\tКоличество контрактников: " + group.getQuantityContractStudents()
                        + "\n\tКоличество бюджетников: " + group.getQuantityBudgetStudents()
                        + "\n\tКоличество должников: " + group.getQuantityDebtorStudents()
                        + "\n\tКоличество активистов: " + group.getQuantityStudentActivists()
                        + "\n\tСтуденты отсортированные по фамилии: " + getStrArray(group.getStudentsSortedBySurname())
        );
    }

    private static String getStrArray(ArrayList<Student> arr) {
        StringBuilder str = new StringBuilder();
        for (Student a : arr) {
            str.append(a.getSurname()).append(" ");
        }
        return str.toString();
    }
}