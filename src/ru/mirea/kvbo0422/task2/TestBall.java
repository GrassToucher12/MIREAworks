package ru.mirea.kvbo0422.task2;
import java.lang.*;
import java.util.Scanner;

public class TestBall {
    public static void main(String[] args) {
        double xDisp;
        double yDisp;
        Ball k1 = new Ball( 0.0, 0.0 );
        System.out.println("Изначальное положение мяча x: "+k1.getX()+" y: "+k1.getY());
        Scanner sourceX = new Scanner(System.in);
        Scanner sourceY = new Scanner(System.in);
        System.out.print("Введите изменение положения мяча по x: ");
        xDisp = sourceX.nextDouble();
        System.out.print("Введите изменение положения мяча по y: ");
        yDisp = sourceY.nextDouble();
        k1.move(xDisp,yDisp);
        System.out.print("Новое положение мяча x: "+k1.getX()+" y: "+k1.getY());
    }
}
