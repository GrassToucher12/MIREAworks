package ru.mirea.kvbo0422.task22.Calculator;

import java.util.List;

public class Calc {
    private final NumberToken.Lexer lexer = new NumberToken.Lexer();
    private final PostfixConverter converter = new PostfixConverter();
    private final StackMachine stackMachine = new StackMachine();

    public double calculate(String expression) {
        List<Token> tokens = lexer.getTokens(expression);
        List<Token> postfixExpression = converter.convertToPostfix(tokens);
        double result = stackMachine.evaluate(postfixExpression);
        System.out.println(result);
        return result;
    }
}
