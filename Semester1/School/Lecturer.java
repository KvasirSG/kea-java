package Semester1.School;

public class Lecturer {
    private String name;
    private Subject subject;

    public Lecturer(String name, Subject subject) {
        this.name = name;
        this.subject = subject;
    }

    public void lecturerInfo() {
        System.out.println(this.name + " " + this.subject);
    }
}
