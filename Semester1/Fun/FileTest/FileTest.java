package Semester1.Fun.FileTest;

public class FileTest {
    public static void main(String[] args) {
        Person[] people = {
                new Person("Brian", 34),
                new Person("Bob", 22)
        };
        String filename = "Semester1/Fun/FileTest/people.txt";
        FileHandler.writeObjectsToFile(people, filename);
        Person[] myPersons = FileHandler.readObjectsFromFile(filename);
        for (Person person : myPersons) {
            System.out.println(person);
        }
    }

}
