package Semester1.Fun;

public class Fibonacci {
    public static void main(String[] args) {
        int n = 20; // Number of elements to print
        int firstTerm = 0;
        int secondTerm = 1;

        System.out.println("Fibonacci Series till " + n + " terms:");

        for (int i = 1; i <= n; ++i) {
            System.out.print(firstTerm + ", ");

            // Compute the next term
            int nextTerm = firstTerm + secondTerm;
            firstTerm = secondTerm;
            secondTerm = nextTerm;
        }
    }

}
