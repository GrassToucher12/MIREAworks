package ru.mirea.kvbo0422.task23;
    public interface Queue<T> {
        void enqueue(T element);
        T dequeue();
        T peek();
        int size();
        boolean isEmpty();
    }
