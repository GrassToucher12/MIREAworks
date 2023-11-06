package ru.mirea.kvbo0422.task22.Calculator;

public record BinaryOperationToken(
        OperationType operationType
) implements Token {
    @Override
    public TokenType type() {
        return TokenType.BINARY_OPERATION;
    }
}