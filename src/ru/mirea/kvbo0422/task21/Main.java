package ru.mirea.kvbo0422.task21;

import static ru.mirea.kvbo0422.task21.SinglyLinkedListTester.LinkedListSort.printLinkedList;
import static ru.mirea.kvbo0422.task21.SinglyLinkedListTester.LinkedListSort.sortLinkedList;

public class Main {
    public static void main(String[] args) {

        SinglyLinkedListTester.ListNode head = new SinglyLinkedListTester.ListNode("One");
        head.next = new SinglyLinkedListTester.ListNode("Two");
        head.next.next = new SinglyLinkedListTester.ListNode("Three");
        head.next.next.next = new SinglyLinkedListTester.ListNode("Four");

        head = sortLinkedList(head);

        printLinkedList(head);
    }
}
