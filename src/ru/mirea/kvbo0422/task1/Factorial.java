package ru.mirea.kvbo0422.task1;
import java.util.Scanner;
public class Factorial {

    public static int Factorial(int n){
        int fact=1;
        for(int i=1; i<=n; i++){
            fact*=i;
        }
        return fact;
    }
    public static void main(String[] args) {
        int fact=1;
        Scanner sc = new Scanner(System.in);
        System.out.printf("Введите число для расчета факториала: ");
        int n = sc.nextInt();
        if (n<0){
            System.out.println("Неподходящие значения ");
        }
        else {
            fact = Factorial.Factorial(n);
            System.out.printf("Факториал числа "+ fact);
        }
    }
}
