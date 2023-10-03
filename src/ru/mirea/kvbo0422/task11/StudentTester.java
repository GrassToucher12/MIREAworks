package ru.mirea.kvbo0422.task11;

import java.text.ParseException;
import java.util.Scanner;

public class StudentTester {
    public static void main(String[] args) throws ParseException {

        String birthDate  = "2004-01-18 00:25:15.0";
        System.out.println("Enter s for short format or f for full firmat: ");
        Scanner sc = new Scanner(System.in);
        char format = sc.next().charAt(0);
        Student st = new Student("Mike", 5, birthDate, format);
        System.out.println(st);
    }

}
