package ru.mirea.kvbo0422.task25;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите свой email: ");
        String email = sc.nextLine();
        String regex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"+ "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        Pattern p1 = Pattern.compile(regex);
        Matcher m1 = p1.matcher(email);
        if (m1.find()){
            System.out.println("email правильный");
        }
        else {
            System.out.println("email неправильный!");
        }
    }
}
