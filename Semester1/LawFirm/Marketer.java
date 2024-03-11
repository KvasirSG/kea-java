package Semester1.LawFirm;

public class Marketer extends Employee{
    public Marketer(int initialYears) {
        super(initialYears);
    }

    public void advertise(){
        System.out.println("Act now while supplies last!");
    }

    @Override
    public double getSalary() {
        return super.getSalary()+10000.0;
    }
}
