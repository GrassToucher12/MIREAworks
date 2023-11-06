package ru.mirea.kvbo0422.task24;

public class TestFactory {
    public static void main(String[] args) {
        Complex a1 = ClientComplexFactory.getComplex(new ConcreteFactory(10, 2));
        System.out.println(a1.toString());
    }
}
