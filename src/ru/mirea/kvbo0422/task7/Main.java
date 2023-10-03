package ru.mirea.kvbo0422.task7;

public class Main {
    public static void main(String[] args) {
        MathCalculable mc1 = new MathFunc();
        System.out.print("Число Пи "+mc1.getPi()+"\n");
        double a =1.2;
        double b = 7.8;
        System.out.print("Vодуль комплексного числа "+a+"+"+b+"*i " +mc1.complexAbs(a,b)+"\n");
        int R=5;
        System.out.print("Длина окружности с радусом 5 "+2*mc1.getPi()*R+"\n");
        System.out.print("Возведение числа 2 в 5-ую степень "+mc1.pow(2,5)+"\n");
    }
}
