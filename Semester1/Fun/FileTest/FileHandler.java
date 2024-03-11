package Semester1.Fun.FileTest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileHandler {

    public static void writeObjectsToFile(Person[] objects, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(objects);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Person[] readObjectsFromFile(String filename) {
        Person[] objects = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            objects = (Person[]) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return objects;
    }

    // readfile

    // writefile
}
