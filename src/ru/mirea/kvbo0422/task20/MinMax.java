package ru.mirea.kvbo0422.task20;

import java.util.Arrays;

public class MinMax<T extends Comparable<T>> {
    private  T [] object_array;
    public MinMax(T[] object_array){
        this.object_array = object_array;
    }

    public T minElem() {
        T value = object_array[0];
        for (int i = 0; i < object_array.length; i++) {
            if (object_array[i].compareTo(value) < 0) {
                value = object_array[i];
            }
        }
        return value;
    }

    public T maxElem(){
        T value = object_array[0];
        for (int i = 0; i < object_array.length; i++) {
            if (object_array[i].compareTo(value) > 0) {
                value = object_array[i];
            }
        }
        return value;
    }

}