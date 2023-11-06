package ru.mirea.kvbo0422.task23;

import java.util.NoSuchElementException;

public class LinkedQueue<T> implements Queue<T> {

        private Node head;
        private Node tail;
        private int size;

        // Внутренний класс для представления узла связанного списка
        private class Node {
            T data;
            Node next;

            public Node(T data) {
                this.data = data;
            }
        }

        @Override
        public void enqueue(T element) {
            Node newNode = new Node(element);

            if (isEmpty()) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
            size++;
        }

        @Override
        public T dequeue() {
            if (isEmpty()) {
                throw new NoSuchElementException("Очередь пуста");
            }

            T data = head.data;
            head = head.next;
            size--;

            if (isEmpty()) {
                tail = null;
            }

            return data;
        }

        @Override
        public T peek() {
            if (isEmpty()) {
                throw new NoSuchElementException("Очередь пуста");
            }

            return head.data;
        }

        @Override
        public int size() {
            return size;
        }

        @Override
        public boolean isEmpty() {
            return size == 0;
        }
    }
