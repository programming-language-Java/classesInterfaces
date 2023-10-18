import interfaces.Event;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("�����", "�������", 1);
        Student student2 = new Student("�������", "�������");
        ContractStudent student3 = new ContractStudent("����", "�������");

        student2.setName("����");
        student2.setSurname("�������");
        student2.setRecordBookNumber(1000);
        System.out.println("Student 2:\n���: " + student2.getName()
                + "\n�������: " + student2.getSurname()
                + "\n����� �������: " + student2.getRecordBookNumber());

        student3.setSurname("�������");
        student3.setName("�������");
        student3.setRecordBookNumber(1001);
        student3.setYearAdmission(LocalDate.of(2020, 9, 1));
        System.out.println("������: " + student3.getTuitionFee());
        student3.addPayment(new Payment(LocalDate.of(2021, 9, 1), 20000));
        student3.addPayment(new Payment(LocalDate.of(2021, 12, 1), 30000));
        System.out.println(
                "����: " + student3.getDebt()
                        + "\n������������ ����: " + student3.getPaidPrice()
        );
        System.out.println("�������");
        for (Payment payment : student3.getPayments()) {
            System.out.println(
                    "\n\t���� �������: " + payment.getDate()
                            + "\n\t����� �������: " + payment.getSum()
            );
        }

        student1.setYearAdmission(LocalDate.of(2022, 9, 1));

        Olympics olympics1 = new Olympics(LocalDate.of(2023, 10, 1), "������", 2);
        Olympics olympics11 = new Olympics(LocalDate.of(2023, 11, 1), "������", 5);
        student1.addEvent(olympics1);
        student1.addEvent(olympics11);
        Event e = (Event) student1.findEventByDate(LocalDate.of(2023, 10, 1));
        System.out.println("�����: " + e.getDate());

        Competition �ompetition1 = new Competition(LocalDate.of(2023, 12, 1), "�����-���������", "������� ������", 5000);
        Competition �ompetition2 = new Competition(LocalDate.of(2023, 5, 25), "�����������", "�����-�� ��� �������", 10000);
        Competition �ompetition3 = new Competition(LocalDate.of(2023, 5, 25), "�����������", "�����-�� ��� �������", 10000);
        �ompetition3.setDate(LocalDate.of(2022, 3, 10));
        �ompetition3.setCity("�����-���������");
        �ompetition3.setProjectName("������������� ��������");
        �ompetition3.setSumWin(15000);

        System.out.println(
                "�������� �������\n"
                        + "\t������������ �������: " + �ompetition3.getProjectName()
                        + "\n\t�����: " + �ompetition3.getCity()
                        + "\n\t���� " + �ompetition3.getDate()
                        + "\n\t����� ��������: " + �ompetition3.getSumWin()
        );
        student1.addEvent(�ompetition1);
        student2.addEvent(�ompetition2);
        student3.addEvent(�ompetition3);

        student1.removeEventByDate(LocalDate.of(2023, 12, 1));

        Conference conference2 = new Conference(LocalDate.of(2023, 11, 1), "������", "��������������");
        System.out.println(
                "����������� " + student2.getName()
                        + "\n\t��������: " + conference2.getTitleReport()
                        + "\n\t�����: " + conference2.getCity()
                        + "\n\t����: " + conference2.getDate()
        );
        conference2.setTitleReport("����������");
        System.out.println("�������� ������������: " + conference2.getTitleReport());
        student2.addEvent(conference2);


        Group group = new Group(1);
        group.addStudent(student1);
        group.addStudent(student2);
        group.addStudent(student3);
        System.out.println(
                "\n������\n"
                        + "\t���������� ���������:" + group.getQuantityStudents()
                        + "\n\t��������: " + getStrArray(group.getStudents())
                        + "\n\t�������� ���������: " + getStrArray(group.getStudentActivists())
                        + "\n\t�������� ����������: " + getStrArray(group.getStudentWinners())
                        + "\n\t���������� �������������: " + group.getQuantityContractStudents()
                        + "\n\t���������� �����������: " + group.getQuantityBudgetStudents()
                        + "\n\t���������� ���������: " + group.getQuantityDebtorStudents()
                        + "\n\t���������� ����������: " + group.getQuantityStudentActivists()
                        + "\n\t�������� ��������������� �� �������: " + getStrArray(group.getStudentsSortedBySurname())
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