package ru.mirea.kvbo0422.task3;

import java.util.Scanner;

public class StringToDouble {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter you double :) :");
        String value = sc.nextLine();
        Double new_value;
        try {
            new_value = Double.parseDouble(value);
        } catch (NumberFormatException e) {
            char[] new_char = value.toCharArray();
            Integer[] char_to_num = new Integer[value.length()];
            value = "";
            for (int i = 0; i<new_char.length; i++){
                char_to_num[i] = new_char [i] -'a'+1;
            }
            for (int i = 0; i<char_to_num.length; i++){
                value +=char_to_num[i];
            }
            new_value = Double.parseDouble(value);
        }
        System.out.print(new_value);

    }

}
