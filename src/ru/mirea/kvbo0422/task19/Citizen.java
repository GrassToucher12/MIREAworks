package ru.mirea.kvbo0422.task19;

import java.text.SimpleDateFormat;

public class Citizen {
    public String firstName;
    public String lastName;
    public String fatherName;
    public String INN;

    public Citizen( String firstName, String lastName, String fatherName, String INN){
        this.firstName = firstName;
        this.lastName = lastName;
        this.fatherName = fatherName;
        this.INN = INN;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public String getINN() {return INN;}



    @Override
    public String toString() {
        return "Citizen{" +
                " first name = " + firstName  +
                ", last name = " + lastName +
                ", father name = " + fatherName +
                ", INN = " + INN +
                '\''+
                '}';
    }
}
