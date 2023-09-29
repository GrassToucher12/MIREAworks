package ru.mirea.kvbo0422.task4;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class TestReader {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите имя студента: ");
        String fullname = sc.nextLine();
        System.out.println("Введите номер читательского билета: ");
        int ticketnumber = sc.nextInt();
        sc.nextLine();
        System.out.println("Введите факультет студента: ");
        String faculty = sc.nextLine();
        System.out.println("Введите номер телефона студента: ");
        int phonenumber = sc.nextInt();
        sc.nextLine();
        System.out.println("Введите дату рождения студента: ");
        String cl = sc.nextLine();
        SimpleDateFormat formatter = new SimpleDateFormat(cl);
        SimpleDateFormat birthdate = formatter;
        System.out.println("Введите количесвто книг: ");
        int book_num = sc.nextInt();
        sc.nextLine();
        Reader p1 = new Reader(phonenumber, ticketnumber, faculty, fullname, birthdate);
        Book[] book_ar = new Book[book_num];
        for (int i = 0; i<book_num; i++){
            System.out.println("Введите автора книги: ");
            String bookAuthor = sc.nextLine();
            System.out.println("Введите название книги: ");
            String bookName = sc.nextLine();
             book_ar[i] = new Book(bookAuthor, bookName, p1);
        }
        book_ar[0].takeBook(book_num,book_ar);

        System.out.println("Введите количесвто книг: ");
        book_num = sc.nextInt();
        sc.nextLine();

        Book[] book_ar2 = new Book[book_num];
        for (int i = 0; i<book_num; i++){
            System.out.println("Введите автора книги: ");
            String bookAuthor = sc.nextLine();
            System.out.println("Введите название книги: ");
            String bookName = sc.nextLine();
            book_ar2[i] = new Book(bookAuthor, bookName, p1);
        }
        book_ar2[0].returnBook(book_num,book_ar2);
    }
}
