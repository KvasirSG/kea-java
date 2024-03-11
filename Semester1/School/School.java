package Semester1.School;

import java.util.ArrayList;

public class School {
    String name;

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Bo", 22, "DAT24v3", Subject.SWDEV));
        students.add(new Student("James", 28, "DAT24v2", Subject.CODE));
        students.add(new Student("Mads", 25, "DAT24v1", Subject.SWDEV));
        students.add(new Student("Mikkel", 23, "DAT24v3", Subject.CODE));

        for (Student student : students) {
            student.studentInfo();
        }
    }

}
