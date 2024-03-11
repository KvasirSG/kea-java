package Semester1.LittleTable;

public class LittleTable {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.println();
            for (int j = 1; j <= 10; j++) {
                if (i * j < 10)
                    System.out.print(" ");
                System.out.print(" " + j * i);
            }
        }
    }
}
