package ru.mirea.kvbo0422.task17;
public class CircularLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    private static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public CircularLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void add(T element) {
        Node<T> newNode = new Node<>(element);

        if (head == null) {
            head = newNode;
            tail = newNode;
            tail.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }

        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printList() {
        if (isEmpty()) {
            System.out.println("Кольцевой список пуст");
            return;
        }

        Node<T> currentNode = head;

        do {
            System.out.print(currentNode.data + "->");
            currentNode = currentNode.next;
        } while (currentNode != head);

        System.out.println();
    }

    public void remove(T element) {
        if (isEmpty()) {
            System.out.println("Кольцевой список пуст");
            return;
        }

        Node<T> currentNode = head;
        Node<T> previousNode = null;

        do {
            if (currentNode.data.equals(element)) {
                break;
            }
            previousNode = currentNode;
            currentNode = currentNode.next;
        } while (currentNode != head);


        if (currentNode == head && currentNode.data.equals(element)) {
            tail.next = head.next;
            head = head.next;
        } else if (currentNode != head) {
            previousNode.next = currentNode.next;
            if (currentNode == tail) {
                tail = previousNode;
            }
        } else {
            System.out.println("Элемент не найден в списке");
            return;
        }

        size--;
        System.out.println("Элемент успешно удален");
    }
}