package ru.mirea.kvbo0422.task22.Calculator;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PostfixConverter {
    public List<Token> convertToPostfix(List<Token> source) {
        List<Token> postfixExpression = new ArrayList<>();
        Deque<Token> operationStack = new LinkedList<>();
        for (Token token : source) {
            switch (token.type()) {
                case NUMBER -> postfixExpression.add(token);
                case OPEN_BRACKET -> operationStack.push(token);
                case CLOSE_BRACKET -> {
                    while (!operationStack.isEmpty() && operationStack.peek().type() != TokenType.OPEN_BRACKET) {
                        postfixExpression.add(operationStack.pop());
                    }
                    operationStack.pop();
                }
                case BINARY_OPERATION -> {
                    while (!operationStack.isEmpty() && getPriority(operationStack.peek()) >= getPriority(token)) {
                        postfixExpression.add(operationStack.pop());
                    }
                    operationStack.push(token);
                }
            }
        }
        while (!operationStack.isEmpty()) {
            postfixExpression.add(operationStack.pop());
        }
        return postfixExpression;
    }

    private int getPriority(Token token) {
        if (token instanceof BinaryOperationToken operation) {
            return switch (operation.operationType()) {
                case ADDITION, SUBTRACTION -> 1;
                case MULTIPLICATION, DIVISION -> 2;
                case EXPONENTIATION -> 3;
                case FACTORIAL -> 4;
            };
        }
        return 0;
    }
}
