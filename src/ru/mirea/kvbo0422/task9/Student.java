package ru.mirea.kvbo0422.task9;

public class Student implements Comparable<Student>{
    private String name;
    private Integer mark;
    public Student(String name, Integer mark) {
        this.name = name;
        this.mark = mark;
    }

    public Integer getMark() {
        return mark;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Student student){
        return this.mark.compareTo(student.mark);
    }
    @Override
    public String toString(){
        return "Student{" +
                " name=" + name +
                ", mark=" + mark + '\'' +
                '}';
    }
}
