package ru.mirea.kvbo0422.task3;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ArrayRandom {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        int k = 0 ;
        boolean state =true;
        Random rand = new Random();
        while (state) {
            System.out.print("Enter length of the array ");
            try {
                n = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Wrong value, try again!!!\n");
                continue;
            }
                state = false;
        }
        int[] user_array = new int[n];
        for(int i=0;i<n;i++){
            user_array[i] = rand.nextInt(n+1);
        }
        for(int i=0;i<n;i++){
            System.out.print("array["+i+"] = " + user_array[i] + "\n");
        }
        System.out.print("--------------------------------\n");
        for(int i=0;i<n;i++){
            if (user_array[i] %2 ==0){
                k+= 1;
            }
        }
        Integer[] user_array2 = new Integer[k];
        k = 0;
        for (int i = 0; i < n; i++) {
            if (user_array[i] % 2 == 0) {
                user_array2[k] = user_array[i];
                k++;
            }
        }
        for(int i=0;i<k;i++){
            System.out.print("array2["+i+"] = " + user_array2[i] + "\n");
        }
    }

}

