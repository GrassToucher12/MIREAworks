package ru.mirea.kvbo0422.task9;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StudMain {
    public static void main(String[] args){
        Student student  = new Student("Mike", 40);
        Student student1  = new Student("Joe", 20);
        Student student2  = new Student("Lane",60);
        List<Student> students = Arrays.asList(student, student1, student2);
        System.out.println(students);

        Collections.sort(students);
        System.out.println(students);
    }
}
