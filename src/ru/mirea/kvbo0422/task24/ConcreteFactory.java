package ru.mirea.kvbo0422.task24;

public class ConcreteFactory implements ComplexAbstractFactory {
    public int real;
    public int image;
    public ConcreteFactory(int real, int image){
        this.real = real;
        this.image = image;
    }
    @Override
    public Complex createComplex() {
        return new Complex();
    }

    @Override
    public Complex CreateComplex(int real, int image) {
        return new Complex();
    }
}
