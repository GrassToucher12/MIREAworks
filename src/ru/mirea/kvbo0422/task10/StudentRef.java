package ru.mirea.kvbo0422.task10;

public class StudentRef implements Comparable<StudentRef>{
    private String name;
    private Integer mark;
    public StudentRef(String name, Integer mark) {
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
    public int compareTo(StudentRef student){
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
