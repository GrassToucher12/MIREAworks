package ru.mirea.kvbo0422.task2;

import java.util.Scanner;
public class HowMany {

    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        System.out.print("Enter your string ");
        String user_string = sc.nextLine();
        int k = 1;
        int str_len=user_string.length();
        char[] chars = new char[str_len];
        for( int i=0; i<str_len; i++) {
            chars[i] = user_string.charAt(i);
        }
        for( int i=0; i<str_len-1; i++) {
            if (( chars[i] == ' ') ) {
                k+=1;
            }
        }
        System.out.println("Number of words in your string is: "+ k);
    }
}
