package ru.mirea.kvbo0422.task15;

import java.util.Objects;

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
    public double division(double a, double b) {
        return (a / b);
    }

    @Override
    public double factorial(double a) {
        double r = a - Math.floor(a) + 1;
        for (;a>1; a-=1) {
            r *= a;
        }
        return r;
    }
    @Override
    public double exponentiation(double a, double b) {
        return (Math.pow(a, b));
    }
}
