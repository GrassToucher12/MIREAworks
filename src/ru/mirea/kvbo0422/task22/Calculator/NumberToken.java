package ru.mirea.kvbo0422.task22.Calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public record NumberToken(double value) implements Token {
    @Override
    public TokenType type() {
        return TokenType.NUMBER;
    }

    public static class Lexer {
        private static final String DELIMITERS = " +-*/!^()";

        public List<Token> getTokens(String source) {
            StringTokenizer tokenizer = new StringTokenizer(source, DELIMITERS, true);
            List<Token> tokens = new ArrayList<>();
            while (tokenizer.hasMoreTokens()) {
                String token = tokenizer.nextToken();
                if (token.isBlank()) {
                    continue;
                } else if (isNumber(token)) {
                    tokens.add(new NumberToken(Double.parseDouble(token)));
                    continue;
                }
                tokens.add(
                        switch (token) {
                            case "!" -> new BinaryOperationToken(OperationType.FACTORIAL);
                            case "^" -> new BinaryOperationToken(OperationType.EXPONENTIATION);
                            case "+" -> new BinaryOperationToken(OperationType.ADDITION);
                            case "-" -> new BinaryOperationToken(OperationType.SUBTRACTION);
                            case "*" -> new BinaryOperationToken(OperationType.MULTIPLICATION);
                            case "/" -> new BinaryOperationToken(OperationType.DIVISION);
                            case "(" -> new OtherToken(TokenType.OPEN_BRACKET);
                            case ")" -> new OtherToken(TokenType.CLOSE_BRACKET);
                            default -> throw new RuntimeException("Unexpected token: " + token);
                        }
                );
            }
            return tokens;
        }

        private boolean isNumber(String token) {
            try {
                Double.parseDouble(token);
                return true;
            } catch(NumberFormatException e){
                return false;
            }
        }
    }
}
