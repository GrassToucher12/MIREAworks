package ru.mirea.kvbo0422.task23;

public class LinkedQueueTester {
        public static void main(String[] args) {
            Queue<Integer> queue = new LinkedQueue<>();
            queue.enqueue(23);
            queue.enqueue(70);
            queue.enqueue(9);

            System.out.println("Dequeued element: " + queue.dequeue());  // Output: Dequeued element: 10

            System.out.println("Peeked element: " + queue.peek());  // Output: Peeked element: 20

            System.out.println("Queue size: " + queue.size());  // Output: Queue size: 2

            System.out.println("Is queue empty? " + queue.isEmpty());  // Output: Is queue empty? false
        }
}
