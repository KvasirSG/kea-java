package Semester1.Jungle;

public class Animal {
    private String species;
    private Coord coord;

    public Animal(String species) {
        this.species = species;
        coord = new Coord(100);
    }

    public String getSpecies() {
        return species;
    }

    public boolean isAnimalHere(int x, int y) {
        if (x == coord.getX()) {
            if (y == coord.getY()) {
                return true;
            }
        }
        return false;
    }
}
