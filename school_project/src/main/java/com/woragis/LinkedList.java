package com.woragis;

public class LinkedList {
    public LinkedListNode head;

    public LinkedList(int head) {
        this.head = new LinkedListNode(head);
    }

    public void iterateList() {
        LinkedListNode current = this.head;
        int index = 0;
        while (current != null) {
            System.out.println("Value '" + index + "': " + current.value);
            index++;
            current = current.next;
        }
    }

    public void add(int value) {
        LinkedListNode newHead = new LinkedListNode(value, this.head);
        this.head = newHead;
    }

    public void pop() {
        this.head = this.head.next;
    }

    public void remove(int value) {
        LinkedListNode current = this.head;
        LinkedListNode previous = current;

        while (current != null) {
            if (current.value == value) {
                previous.next = current.next;
            } else {
                previous = current;
            }
            current = current.next;
        }
    }
}
