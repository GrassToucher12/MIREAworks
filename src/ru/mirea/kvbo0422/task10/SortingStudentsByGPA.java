package ru.mirea.kvbo0422.task10;

import ru.mirea.kvbo0422.task9.Student;
import ru.mirea.kvbo0422.task9.StudentComp;

import java.util.ArrayList;

public class SortingStudentsByGPA {
    public static void main(String[] args) {
        Student[] IDNumbers = new Student[]{
                new Student("Mike", 40),
                new Student("Joe", 20),
                new Student("Lane", 60),
                new Student("Kevin", 10)
        };
        outArray(IDNumbers);
        System.out.println();
        quickSort(IDNumbers, IDNumbers.length - 1, 0);
        outArray(IDNumbers);
    }

    public static void outArray(Student[] IDNumbers){
        for (Student s : IDNumbers) {
            System.out.println(s);
        }
    }
    private  static StudentComp comp = new StudentComp();
    public static void quickSort(Object[] array, int high, int low){
        if(array == null || array.length == 0) return;
        if(high <= low) return;

        Object middle = array[(low + high)/2];
        ArrayList<Object> left = new ArrayList<>();
        ArrayList<Object> right = new ArrayList<>();
        ArrayList<Object> eq = new ArrayList<>();
        for(int i = low; i <= high; i++){
            if(comp.compare(array[i], middle) < 0){
                right.add(array[i]);
            }
            else if (comp.compare(array[i], middle) > 0)
                left.add(array[i]);
            else eq.add(array[i]);
        }
        Object[] leftArr;
        Object[] rightArr;
        if(left.size()>0) {
            leftArr = left.toArray();
            quickSort(leftArr, left.size() - 1, 0);
            System.arraycopy(leftArr, 0, array, low, left.size());
        }
        System.arraycopy(eq.toArray(), 0, array, low+left.size(), eq.size());

        if(right.size() > 0) {
            rightArr = right.toArray();
            quickSort(rightArr, right.size() - 1, 0);
            System.arraycopy(rightArr, 0, array, low+left.size() + eq.size(), right.size());

        }

    }

}

