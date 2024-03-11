package Semester1.LawFirm;

public class Lawyer extends Employee{
    public Lawyer(int initialYears) {
        super(initialYears);
    }

    @Override
    public String getVacationForm() {
        return "pink";
    }

    @Override
    public int getVacationDays() {
        return super.getVacationDays()+5;
    }

    @Override
    public double getSalary() {
        return super.getSalary()+5000*getYears();
    }

    public void sue(){
        System.out.println("I'll see you in court!");
    }
}
