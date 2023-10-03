package ru.mirea.kvbo0422.task10;
import ru.mirea.kvbo0422.task9.Student;

import java.util.Comparator;

public class StudentComp implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        if(!(o1 instanceof Student && o2 instanceof Student))
            throw new IllegalArgumentException("Объекты не являются студентами!");

        return ((Student) o1).getMark() - ((Student) o2).getMark();
    }
}
