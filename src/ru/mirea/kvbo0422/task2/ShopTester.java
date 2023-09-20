package ru.mirea.kvbo0422.task2;
import java.lang.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ShopTester {
    public static void main(String[] args) {
        String new_elem;
        String user_string;
        int str_len;
        ArrayList<String> newl = new ArrayList<String>();
        Shop one = new Shop(newl);
        Scanner source = new Scanner(System.in);
        System.out.print("Введите изначальный список в магазине ");
        user_string = source.nextLine();
        String[] words =user_string.split(" ");
        str_len = words.length;

        for( int i=0; i<str_len; i++) {
            new_elem = words[i];
            one.pushList(new_elem);
        }

        System.out.print("Введите компьютеры для удаления ");
        user_string = source.nextLine();
        words =user_string.split(" ");
        str_len = words.length;

        for( int i=0; i<str_len; i++) {
            new_elem = words[i];
            one.deletList(new_elem);
        }

        System.out.print("Введите компьютеры для поиска ");
        user_string = source.nextLine();
        words =user_string.split(" ");
        str_len = words.length;

        boolean t;

        for( int i=0; i<str_len; i++) {
            new_elem = words[i];
            t = one.searchList(new_elem);
            if (t) {
                System.out.println("есть в наличии");

            } else {
                System.out.println("Нет в наличии");
            }
        }
    }
}
