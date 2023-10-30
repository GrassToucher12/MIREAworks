package ru.mirea.kvbo0422.task15;

public class Calculator implements CalculatorInterface{
    private double a;
    private double b;
    public Calculator(){
    }

    @Override
    public double addition(double a, double b) {
        return (a + b);
    }

    @Override
    public double subtraction(double a, double b) {
        return (a - b);
    }

    @Override
    public double multiplication(double a, double b) {
        return (a * b);
    }

    @Override
    public double diviaion(double a, double b) {
        return (a / b);
    }
}
