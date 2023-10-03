package ru.mirea.kvbo0422.task8;

import java.util.Scanner;

public class AB {
    public static int sum = 0;
    public static void main(String[] args) {
        int A = 0;
        Scanner sc = new Scanner(System.in);
        boolean state = true;
        while (state) {
            System.out.print("Enter A element  ");
            try {
                A = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Wrong value, try again!!!\n");
                continue;
            }
            state = false;
        }
        state =true;
        int B= 0;
        while (state) {
            System.out.print("Enter B element  ");
            try {
                B = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Wrong value, try again!!!\n");
                continue;
            }
            state = false;
        }
        if (A == B){
            System.out.print("Wrong value!!!");
        }else{
            if (A>B){
                A++;
            }
            else{
                B++;
            }
            AB(A,B);
        }
    }
    public static void AB(int A, int B){
        if (A>B){
            System.out.print(B+"\n");
            AB(A,B+1);
        }
        if (A<B){
            System.out.print(A+"\n");
            AB(A+1,B);
        }
        }
    }
