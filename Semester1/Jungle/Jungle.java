package Semester1.Jungle;

import java.util.ArrayList;
import java.util.List;

public class Jungle {
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Elephant"));
        animals.add(new Animal("Rhino"));
        animals.add(new Animal("Moneky"));
        animals.add(new Animal("Leapard"));
        animals.add(new Animal("Wilderbeast"));
        animals.add(new Animal("antelope"));
        animals.add(new Animal("Hippo"));
        animals.add(new Animal("Giraffe"));
        animals.add(new Animal("Zebra"));
        Hunter hunter = new Hunter("Brian");
        System.out.println("=======Debug=======");
        for (Animal animal : animals) {
            checkForAnimal(animal);
        }
        System.out.println("Hunter at: " + hunter.getCoord().getX() + "," + hunter.getCoord().getY());
        System.out.println("=======End Debug=======");

        huntForAnimal(animals, hunter);

    }

    /** Checks if an is in the jungle based on a 100x100 grid. */
    public static void checkForAnimal(Animal animal) {
        for (int i = 1; i <= 100; i++) {
            for (int j = 1; j <= 100; j++) {
                if (animal.isAnimalHere(j, i)) {
                    System.out.println("You found the " + animal.getSpecies() + " here! at " + j + "," + i);
                }
            }
        }
    }

    public static void huntForAnimal(List<Animal> animals, Hunter hunter) {
        List<String> shotAnimals = new ArrayList<>();
        int shotAnimalCount = 0;
        for (int i = hunter.getCoord().getY() - 16; i <= hunter.getCoord().getY() + 16; i++) {
            for (int j = hunter.getCoord().getX() - 16; j <= hunter.getCoord().getX() + 16; j++) {
                // System.out.println("Hunter Looks for Animal at: " + j + "," + i);
                for (Animal animal : animals) {
                    if (animal.isAnimalHere(j, i)) {
                        shotAnimalCount++;
                        shotAnimals.add(animal.getSpecies());
                    }
                }
            }
        }
        System.out.println(hunter.getName() + " has shot " + shotAnimalCount + " animals: " + shotAnimals);

    }
}
