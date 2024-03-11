package Semester1.Calculator;

import java.util.*;

/**
 * Evaluates a given postfix expression.
 */
public class PostfixEvaluator {

    /**
     * Evaluates the given postfix expression and returns the result.
     * 
     * @param postfix The postfix expression to evaluate, as a list of tokens.
     * @return The result of evaluating the postfix expression.
     */
    public double evaluate(List<String> postfix) {
        Deque<Double> stack = new ArrayDeque<>();

        for (String token : postfix) {
            if (token.length() == 1 && isOperator(token.charAt(0))) {
                double rightOperand = stack.pop();
                double leftOperand = stack.pop();
                double result = applyOperation(leftOperand, rightOperand, token.charAt(0));
                stack.push(result);
            } else {
                stack.push(Double.parseDouble(token));
            }
        }

        return stack.pop();
    }

    /**
     * Applies an arithmetic operation to two operands.
     * 
     * @param leftOperand  The left operand.
     * @param rightOperand The right operand.
     * @param operator     The operator character.
     * @return The result of applying the specified operation to the operands.
     */
    private double applyOperation(double leftOperand, double rightOperand, char operator) {
        switch (operator) {
            case '+':
                return leftOperand + rightOperand;
            case '-':
                return leftOperand - rightOperand;
            case '*':
                return leftOperand * rightOperand;
            case '/':
                if (rightOperand == 0)
                    throw new IllegalArgumentException("Cannot divide by zero.");
                return leftOperand / rightOperand;
            default:
                throw new IllegalArgumentException("Unsupported operator: " + operator);
        }
    }

    /**
     * Checks if a character is an arithmetic operator.
     * 
     * @param ch The character to check.
     * @return True if the character is an operator, false otherwise.
     */
    private boolean isOperator(char ch) {
        return "+-*/".indexOf(ch) >= 0;
    }
}
