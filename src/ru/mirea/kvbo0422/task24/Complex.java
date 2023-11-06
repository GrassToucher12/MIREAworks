package ru.mirea.kvbo0422.task24;

public class Complex {
    private int real;
    private  int image;
    Complex(){
        this.real = 0;
        this.image = 0;
    }
    Complex(int real, int image){
        this.real = real;
        this.image = image;
    }
    @Override
    public String toString(){
        return this.real + " + " + this.image + "i" ;
    }
}
