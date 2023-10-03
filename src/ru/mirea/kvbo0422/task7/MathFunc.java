package ru.mirea.kvbo0422.task7;

public class MathFunc implements  MathCalculable{
    public MathFunc() {
    }

    @Override
    public double pow(double a, double b) {
        return (Math.pow(a,b));
    }

    @Override
    public double complexAbs(double a, double b) {
        return (Math.sqrt(Math.pow(a, 2) + Math.pow(b,2)));
    }

    @Override
    public double getPi() {
        return (Math.PI);
    }
}
