package ru.mirea.kvbo0422.task11;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Student implements Comparable<Student>{
    private String name;
    private Integer mark;
    private String birthDate;
    private char format;
    public Student(String name, Integer mark, String birthDate, char format) {
        this.name = name;
        this.mark = mark;
        this.birthDate = birthDate;
        this.format = format;
    }

    public Integer getMark() {
        return mark;
    }

    public String getName() {
        return name;
    }

    public char getFormat() {
        return format;
    }

    @Override
    public int compareTo(Student student){
        return this.mark.compareTo(student.mark);
    }
    @Override
    public String toString() {
        Date date = null;
        SimpleDateFormat dt1 = null;
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        switch (format) {
            case 'f':
                try {
                    date = dt.parse(birthDate);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                dt1 = new SimpleDateFormat("yyyy-MM-dd hh:MM:ss");
                break;
            case 's':
                try {
                    date = dt.parse(birthDate);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                dt1 = new SimpleDateFormat("dd.MM.yyyy");
                break;
        }
        return "Student{" +
                ", name = " + name +",\n"+
                ", birthDate = " + dt1.format(date) +",\n"+
                ", mark = " + mark +",\n" +
                " name = " + name +",\n"+
                " birthDate = " + dt1.format(date) +",\n"+
                " mark = " + mark +",\n" +
                '}';
    }
}
