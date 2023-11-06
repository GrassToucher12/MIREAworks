package ru.mirea.kvbo0422.task23;

import java.util.NoSuchElementException;

public abstract class AbstractQueue<T> implements Queue<T> {

        protected int size;

        @Override
        public void enqueue(T element) {
            if (element == null) {
                throw new NullPointerException("Элемент не должен быть равен null");
            }

            add(element);
            size++;
        }

        @Override
        public T dequeue() {
            if (isEmpty()) {
                throw new NoSuchElementException("Очередь пуста");
            }

            T element = peek();
            remove();
            size--;

            return element;
        }

        @Override
        public T peek() {
            if (isEmpty()) {
                throw new NoSuchElementException("Очередь пуста");
            }

            return get();
        }

        @Override
        public int size() {
            return size;
        }

        @Override
        public boolean isEmpty() {
            return size == 0;
        }

        protected abstract void add(T element);

        protected abstract T get();

        protected abstract void remove();
    }
