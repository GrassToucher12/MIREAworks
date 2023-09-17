package ru.mirea.kvbo0422.task2;

import java.util.Scanner;

public class ArraySwap {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        String swap = "";
        System.out.printf("Enter length of the array ");
        int user_num = sc.nextInt();
        user_num=user_num+1;
        String[] user_array = new String[user_num];
        for( int i=0; i<user_num; i++) {
            user_array[i]= sc.nextLine();
        }
        for( int i=0; i<user_num/2; i++) {
            swap=user_array[user_num-i-1];
            user_array[user_num-i-1]=user_array[i];
            user_array[i]=swap;
        }
        for( int i=0; i<user_num; i++) {
            System.out.printf(user_array[i]);
        }
    }
}