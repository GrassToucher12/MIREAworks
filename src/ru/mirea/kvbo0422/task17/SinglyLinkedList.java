package ru.mirea.kvbo0422.task17;

public class SinglyLinkedList<E> {

    private static class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> n) {
            next = n;
        }
    }
        private Node<E> head = null;
        private Node<E> tail = null;
        private int size = 0;
        public void SinglyLinkedList(){}
        private int size(){return  size;}
        public boolean isEmpty(){
            return  size ==0;
        }
        public E first(){
            if(isEmpty()) {return null;}
            return head.getElement();
        }
        public E last(){
            if (isEmpty()) {return null;}
            return tail.getElement();
        }
        public void addFirst(E e){
            head = new Node<>(e, head);
            if (size == 0) {
                tail = head;
            }
            size++;
        }
    public int getSize(){
        return size;
    }

        public E get(int index) {
            if (head == null || index >= size) {
                throw new IndexOutOfBoundsException();
            }

            Node<E> current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }

            return current.getElement();
        }

        public void remove(int index) {
            if (head == null || index >= size) {
                throw new IndexOutOfBoundsException();
            }

            if (index == 0) {
                if (size == 1) {
                    head = null;
                } else {
                    Node<E> last = head;
                    while (last.next != head) {
                        last = last.next;
                    }
                    head = head.next;
                    last.next = head;
                }
            } else {
                Node<E> prev = null;
                Node<E> current = head;
                for (int i = 0; i < index; i++) {
                    prev = current;
                    current = current.next;
                }
                prev.next = current.next;
            }

            size--;
        }



    //}
        public void addLast(E e){
            Node<E> newest = new Node<>(e, null);
            if(isEmpty()){
                head = newest;
            }
            else
            {
                tail.setNext(newest);
            }
            tail = newest;
            size++;
        }
        public  E removeFirst(){
            if (isEmpty()){
                return null;
            }
            E answer = head.getElement();
            head = head.getNext();
            size--;
            if(size == 0){
                tail = null;
            }
            return answer;
        }

    @Override
    public String toString() {
        String s = "{ ";
        Node<E> X = head;
        if (X == null)
            return s+" }";
        while(X.next != null){
            s += String.valueOf(X.getElement()+ "->");
            X = X.next;
        }
        s += String.valueOf(X.getElement());
        return s + " }";
    }
    }
