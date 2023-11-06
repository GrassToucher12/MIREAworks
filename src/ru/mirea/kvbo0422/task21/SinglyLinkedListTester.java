package ru.mirea.kvbo0422.task21;

import ru.mirea.kvbo0422.task17.SinglyLinkedList;

public class SinglyLinkedListTester {
    static class ListNode {
        String data;
        ListNode next;

        public ListNode(String data) {
            this.data = data;
            this.next = null;
        }
    }

    public class LinkedListSort {

        public static ListNode sortLinkedList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode maxNode = head;
            ListNode prevMaxNode = null;
            ListNode currNode = head;


            while (currNode.next != null) {
                if (currNode.next.data.compareTo(maxNode.data) > 0) {
                    prevMaxNode = currNode;
                    maxNode = currNode.next;
                }
                currNode = currNode.next;
            }


            if (prevMaxNode != null) {
                prevMaxNode.next = maxNode.next;
            } else {
                head = maxNode.next;
            }

            maxNode.next = head;
            head = maxNode;


            head.next = sortLinkedList(head.next);

            return head;
        }

        public static void printLinkedList(ListNode head) {
            ListNode currNode = head;

            while (currNode != null) {
                System.out.print(currNode.data + " -> ");
                currNode = currNode.next;
            }
            System.out.println("null");
        }
    }


}
