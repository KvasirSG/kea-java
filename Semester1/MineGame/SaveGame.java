package Semester1.MineGame;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * This class provides static methods to save and load game state by serializing
 * and deserializing arrays of Coord objects.
 */
public class SaveGame {

    /**
     * Writes an array of Coord objects to a file.
     * This method serializes the given array of Coord objects and writes them to
     * the specified file.
     *
     * @param objects  An array of Coord objects to be serialized and written to
     *                 file.
     * @param filename The name of the file where the Coord objects will be saved.
     */
    public static void writeObjectsToFile(Coord[] objects, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(objects);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Reads an array of Coord objects from a file.
     * This method deserializes the content of the specified file back into an array
     * of Coord objects.
     *
     * @param filename The name of the file from which the Coord objects are to be
     *                 read.
     * @return An array of Coord objects read from the file. Returns null if an
     *         error occurs during file reading.
     * @throws IOException            If an I/O error occurs while reading from the
     *                                file.
     * @throws ClassNotFoundException If the class of a serialized object cannot be
     *                                found.
     */
    public static Coord[] readObjectsFromFile(String filename) {
        Coord[] objects = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            objects = (Coord[]) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return objects;
    }
}
