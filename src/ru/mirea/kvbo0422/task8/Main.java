package ru.mirea.kvbo0422.task8;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void solution(ArrayList<Integer> list, int k){

        if (( k < list.size() ) ){
            if ((k % 2 ==1 )&&(list.get(k)!=0)) {
                System.out.print(list.get(k) + "\n");
            }
            solution(list, k+1);
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        boolean state =true;
        while (state) {
            System.out.print("Enter the sequence element  ");
            try {
                n = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Wrong value, try again!!!\n");
                continue;
            }
            list.add(n);
            if (n==0) {
                state = false;
            }
        }
        solution(list, 0);
    }
}
