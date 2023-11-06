package ru.mirea.kvbo0422.task22.Calculator;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class StackMachine {
    public double evaluate(List<Token> postfixExpression) {
        Deque<Double> valueStack = new LinkedList<>();
        for (Token token : postfixExpression) {
            if (token instanceof NumberToken number) {
                valueStack.push(number.value());
            } else if (token instanceof BinaryOperationToken operation) {
                double right = valueStack.pop();
                double left = valueStack.pop();

                double result = switch (operation.operationType()) {
                    case FACTORIAL -> {
                        if (left <0){
                            throw new RuntimeException("Negative value in the factorial!");
                        }
                            double r = left - Math.floor(left) + 1;
                            for (;left>1; left-=1) {
                                r *= left;
                            }
                            yield r;
                    }
                    case EXPONENTIATION -> Math.pow(left, right);
                    case ADDITION -> left + right;
                    case SUBTRACTION -> left - right;
                    case MULTIPLICATION -> left * right;
                    case DIVISION -> {
                        if (right == 0) {
                            throw new RuntimeException("Divide by zero!");
                        }
                        yield left / right;
                    }
                };
                valueStack.push(result);
            }
        }
        return valueStack.pop();
    }
}
