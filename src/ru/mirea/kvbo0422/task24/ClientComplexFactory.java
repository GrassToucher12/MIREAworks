package ru.mirea.kvbo0422.task24;

public class ClientComplexFactory {
    public static Complex getComplex(ComplexAbstractFactory factory){
        return factory.createComplex();
    }
}
