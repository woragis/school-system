package com.woragis;

public class LinkedList<T> {
    private LinkedListNode<T> head;

    public LinkedList(T head) {
        this.head = new LinkedListNode<T>(head);
    }

    public void iterateList() {
        LinkedListNode<T> current = this.head;
        int index = 0;
        while (current != null) {
            System.out.println("Value '" + index + "': " + current.getValue());
            index++;
            current = current.getNext();
        }
    }

    public void add(T value) {
        LinkedListNode<T> newHead = new LinkedListNode<T>(value, this.head);
        this.head = newHead;
    }

    public void pop() {
        this.head = this.head.getNext();
    }

    public void remove(T value) {
        LinkedListNode<T> current = this.head;
        LinkedListNode<T> previous = current;

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
