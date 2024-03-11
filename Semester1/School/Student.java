package Semester1.School;

public class Student {
    private String name;
    private int age;
    private String classID;
    private Subject subject;

    public Student(String name, int age, String classID, Subject subject) {
        this.name = name;
        this.age = age;
        this.classID = classID;
        this.subject = subject;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getClassID() {
        return this.classID;
    }

    public Subject getsubject() {
        return this.subject;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setClassID(String classID) {
        this.classID = classID;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public void studentInfo() {
        System.out
                .println("Student: " + this.name + " Age: " + this.age + " ClassID: " + classID + " swdev: " + subject);
    }
}
