package Semester1.LawFirm;

public class LegalSecretary extends Employee{
    public LegalSecretary(int initialYears) {
        super(initialYears);
    }

    public void fileLegalBriefs() {
        System.out.println("I could file all day!");
    }

    @Override
    public double getSalary() {
        return super.getSalary()+5000.0;
    }
}
