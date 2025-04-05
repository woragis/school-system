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
        return;
    }

    public void add(int value) {
        LinkedListNode newHead = new LinkedListNode(value, this.head);
        this.head = newHead;
    }
}
