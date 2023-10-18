import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Group {
    private int number;
    private final ArrayList<Student> students;

    public ArrayList<Student> get() {
        return students;
    }

    public Group(int number) {
        this.number = number;
        this.students = new ArrayList<Student>();
    }

    public Group(int number, int quantityStudents) {
        this.number = number;
        this.students = new ArrayList<Student>();
    }

    public Group(ArrayList<Student> students) {
        this.students = students;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getQuantityStudents() {
        return students.size();
    }

    public Student getStudentByRecordBookNumber(int recordBookNumber) {
        for (Student student : students) {
            if (student.getRecordBookNumber() == recordBookNumber) {
                return student;
            }
        }
        return null;
    }

    public void removeStudentByRecordBookNumber(int recordBookNumber) {
        Student student = getStudentByRecordBookNumber(recordBookNumber);
        students.remove(student);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<Student> getStudentsSortedBySurname() {
        ArrayList<Student> sortedStudents = new ArrayList<>(students);
        Collections.sort(sortedStudents, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.getSurname().compareTo(s2.getSurname());
            }
        });
        return sortedStudents;
    }

    public ArrayList<Student> getStudentActivists() {
        ArrayList<Student> studentActivists = new ArrayList<>();
        for (Student student : students) {
            if (student.getNumberEvents() > 0) {
                studentActivists.add(student);
            }
        }
        return studentActivists;
    }

    public ArrayList<Student> getStudentWinners() {
        ArrayList<Student> studentWinners = new ArrayList<>();
        for (Student student : students) {
            if (student.getQuantityPrizes() == 1) {
                studentWinners.add(student);
                continue;
            }
            for (Object event : student.getEvents()) {
                if (event instanceof Competition competition && competition.getSumWin() > 0) {
                    studentWinners.add(student);
                    break;
                }
            }
        }
        return studentWinners;
    }

    public int getQuantityStudentActivists() {
        return getStudentActivists().size();
    }

    public int getQuantityBudgetStudents() {
        int count = 0;
        for (Student student : students) {
            if (!(student instanceof ContractStudent)) {
                count++;
            }
        }
        return count;
    }

    public int getQuantityContractStudents() {
        int count = 0;
        for (Student student : students) {
            if (student instanceof ContractStudent) {
                count++;
            }
        }
        return count;
    }

    public int getQuantityDebtorStudents() {
        int count = 0;
        for (Student student : students) {
            if (student instanceof ContractStudent contractStudent
                    && contractStudent.getDebt() > 0) {
                count++;
            }
        }
        return count;
    }
}