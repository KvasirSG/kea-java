package Semester1.LiquorShop;

import java.util.ArrayList;

public class LiquorShop {
    static ArrayList<Person> people = new ArrayList<>();
    static int legalAge = 18;

    public static void main(String[] args) {
        people.add(new Person(12, true));
        people.add(new Person(12, false));
        people.add(new Person(16, false));
        people.add(new Person(16, true));
        people.add(new Person(20, true));
        people.add(new Person(20, false));

        for (Person person : people) {
            if (person.getAge() >= legalAge)
                if (person.getHasMoney())
                    System.out.println("Sale is ok - The customer is old enough and can pay");
                else
                    System.out.println("Sale aborted - The customer is old enough but have no money");
            else
                System.out.println("Sale aborted - The customer is under age and/or has no money");
        }
    }
}
