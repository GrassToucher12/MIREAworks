package ru.mirea.kvbo0422.task14;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Password {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите свой апроль: ");
        String password = sc.nextLine();
        String regex = "[A-Z,a-z,\\d,_]{8,}";
        Pattern p1 = Pattern.compile(regex);
        Matcher m1 = p1.matcher(password);
        boolean password_state = m1.matches();
        if (password_state){
            System.out.println("Пароль надежен");
        }
        else {
            System.out.println("Пароль ненадежен!");
        }
    }
}
