package ru.mirea.kvbo0422.task4;
import static java.lang.System.out;

public class Book{
    public String bookAuthor;
    public String bookName;
    public Reader aClass;
    public Book(String bookAuthor, String bookName,Reader aClass ){
        this.bookAuthor = bookAuthor;
        this.bookName = bookName;
        this.aClass = aClass;
    }

    public String getBookName() {
        return bookName;
    }

    public void takeBook(int book_num, Book[] book_ar){
        System.out.println(this.aClass.getFullname() + " взял книг в количестве "+book_num);
        System.out.println(this.aClass.getFullname() + " взял книги: ");
        for(int i = 0; i<book_num; i++){
            System.out.println(book_ar[i].getBookName());
        }
    }
    public void returnBook(int book_num, Book[] book_ar){
        System.out.println(this.aClass.getFullname() + " вернул книг в количестве "+book_num);
        System.out.println(this.aClass.getFullname() + " вернул книги: ");
        for(int i = 0; i<book_num; i++){
            System.out.println(book_ar[i].getBookName());
        }
    }
}
