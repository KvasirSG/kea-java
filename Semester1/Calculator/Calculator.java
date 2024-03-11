package Semester1.Calculator;

import java.util.Scanner;

/**
 * Main class for the calculator application.
 * Demonstrates how to parse and evaluate an arithmetic expression.
 */
public class Calculator {

    /**
     * Main method to run the calculator application.
     * 
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter your expression here: ");
        String expression = scn.nextLine();

        ExpressionParser parser = new ExpressionParser();
        PostfixEvaluator evaluator = new PostfixEvaluator();

        try {
            double result = evaluator.evaluate(parser.toPostfix(expression));
            System.out.println("Result: " + result);
        } catch (IllegalArgumentException e) {
            System.err.println("Error evaluating expression: " + e.getMessage());
        }
    }
}
