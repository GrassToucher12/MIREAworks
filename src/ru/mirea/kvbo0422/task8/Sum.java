package ru.mirea.kvbo0422.task8;

import java.util.Scanner;
public class Sum {
    public static int sum = 0;
    public static void main(String[] args) {
        int n = 0;
        Scanner sc = new Scanner(System.in);
        boolean state = true;
        while (state) {
            System.out.print("Enter the N element  ");
            try {
                n = Integer.parseInt(sc.nextLine());
                if (n<=0){
                    System.out.print("Wrong value, try again!!!\n");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.print("Wrong value, try again!!!\n");
                continue;
            }
            state = false;
        }
        solution(n);
    }
public static void solution(int n){
        if (n!=0){
            sum += n%10;
            n=n/10;
            solution(n);
        }
        else {
            System.out.print(sum);
        }
}
}
