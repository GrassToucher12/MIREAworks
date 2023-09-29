package ru.mirea.kvbo0422.task4;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Reader {
    public String fullname;
    public Integer ticketnumber;
    public String faculty;
    public SimpleDateFormat birthdate;
    public Integer phonenumber;

    public Reader(Integer phonenumber, Integer ticketnumber,
                  String faculty, String fullname, SimpleDateFormat birthdate){
        this.fullname = fullname;
        this.ticketnumber = ticketnumber;
        this.faculty = faculty;
        this.birthdate = birthdate;
        this.phonenumber = phonenumber;
    }

    public String getFullname() {
        return fullname;
    }

    public Integer getTicketnumber() {
        return ticketnumber;
    }

    public String getFaculty() {
        return faculty;
    }

    public Integer getPhonenumber() {
        return phonenumber;
    }

    public SimpleDateFormat getBirthdate() {
        return birthdate;
    }

    @Override
    public String toString() {
        return "Reader{" +
                " fullname = " + fullname  +
                ", faculty = " + faculty +
                ", birthdate = " + birthdate +
                ", phonenumber = " + phonenumber +
                ", ticketnumber = " + ticketnumber +
                '\''+
                '}';
    }
}
