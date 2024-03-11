package Semester1.Calculator;

import java.util.*;

/**
 * Handles parsing of arithmetic expressions and conversion from infix to
 * postfix notation.
 */
public class ExpressionParser {

    private static final Map<Character, Integer> OPERATOR_PRECEDENCE = Map.of(
            '+', 1,
            '-', 1,
            '*', 2,
            '/', 2);

    /**
     * Converts an infix expression to postfix notation.
     * 
     * @param expression The infix expression to convert.
     * @return A list of strings representing the expression in postfix notation.
     */
    public List<String> toPostfix(String expression) {
        List<String> tokens = tokenize(expression);
        return convertInfixToPostfix(tokens);
    }

    /**
     * Tokenizes the given expression into numbers and operators.
     * 
     * @param expression The expression to tokenize.
     * @return A list of tokens extracted from the expression.
     */
    private List<String> tokenize(String expression) {
        List<String> tokens = new ArrayList<>();
        expression = expression.replaceAll("\\s+", "");
        StringBuilder number = new StringBuilder();

        for (char ch : expression.toCharArray()) {
            if (Character.isDigit(ch) || ch == '.') {
                number.append(ch);
            } else {
                if (number.length() > 0) {
                    tokens.add(number.toString());
                    number = new StringBuilder();
                }
                tokens.add(String.valueOf(ch));
            }
        }

        if (number.length() > 0) {
            tokens.add(number.toString());
        }

        return tokens;
    }

    /**
     * Converts a list of tokens from infix to postfix notation.
     * 
     * @param tokens The list of tokens in infix notation.
     * @return A list of tokens in postfix notation.
     */
    private List<String> convertInfixToPostfix(List<String> tokens) {
        List<String> postfix = new ArrayList<>();
        Deque<String> operatorStack = new ArrayDeque<>();

        for (String token : tokens) {
            if (isOperator(token.charAt(0))) {
                while (!operatorStack.isEmpty() && hasHigherPrecedence(operatorStack.peek(), token)) {
                    postfix.add(operatorStack.pop());
                }
                operatorStack.push(token);
            } else {
                postfix.add(token);
            }
        }

        while (!operatorStack.isEmpty()) {
            postfix.add(operatorStack.pop());
        }

        return postfix;
    }

    /**
     * Determines if the first operator has higher or equal precedence compared to
     * the second.
     * 
     * @param op1 First operator.
     * @param op2 Second operator.
     * @return True if op1 has higher or equal precedence compared to op2, false
     *         otherwise.
     */
    private boolean hasHigherPrecedence(String op1, String op2) {
        return OPERATOR_PRECEDENCE.getOrDefault(op1.charAt(0), 0) >= OPERATOR_PRECEDENCE.getOrDefault(op2.charAt(0), 0);
    }

    /**
     * Checks if a character is an operator.
     * 
     * @param ch The character to check.
     * @return True if the character is an operator, false otherwise.
     */
    private boolean isOperator(char ch) {
        return OPERATOR_PRECEDENCE.containsKey(ch);
    }
}
