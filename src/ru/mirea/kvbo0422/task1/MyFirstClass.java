package ru.mirea.kvbo0422.task1;
import java.util.Scanner;
public class MyFirstClass {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int min = 0;
        int max = 0;
        float av =0;
        int sum = 0;
        System.out.println("Введите размер массива: ");
        int user_num = sc.nextInt();
        int[] user_array = new int[user_num];
         for( int i=0; i<user_num; i++) {
             user_array[i]= sc.nextInt();
             sum=sum+user_array[i];
         }
        min = user_array[1];
        max = user_array[1];
        for( int i=0; i<user_num; i++){
             if (max<user_array[i]) {
                 max=user_array[i];

             }
             if (min>user_array[i]) {
                 min=user_array[i];

             }
         }
         av = sum/user_num;
         System.out.println("Минимальный элемент массива: "+ min);
         System.out.println("Максимальный элемент массива: "+ max);
        System.out.println("Среднее значение: "+ av);
    }
}