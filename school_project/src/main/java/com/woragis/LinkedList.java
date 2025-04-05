package com.woragis;

public class LinkedList {
    private LinkedListNode head;

    public LinkedList(Course head) {
        this.head = new LinkedListNode(head);
    }

    public void iterateList() {
        LinkedListNode current = this.head;
        int index = 0;
        while (current != null) {
            System.out.println("Value '" + index + "': " + current.getValue());
            index++;
            current = current.getNext();
        }
    }

    public void add(Course value) {
        LinkedListNode newHead = new LinkedListNode(value, this.head);
        this.head = newHead;
    }

    public void pop() {
        this.head = this.head.getNext();
    }

    public void remove(Course value) {
        LinkedListNode current = this.head;
        LinkedListNode previous = current;

        while (current != null) {
            if (current.getValue() == value) {
                previous.setNext(current.getNext());
            } else {
                previous = current;
            }
            current = current.getNext();
        }
    }
}
