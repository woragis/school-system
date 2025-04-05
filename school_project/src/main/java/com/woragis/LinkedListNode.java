package com.woragis;

public class LinkedListNode {
    private Course value;
    private LinkedListNode next;

    public LinkedListNode(Course value) {
        this.value = value;
        this.next = null;
    }

    public LinkedListNode(Course value, LinkedListNode next) {
        this.value = value;
        this.next = next;
    }

    public Course getValue() {
        return value;
    }

    public LinkedListNode getNext() {
        return next;
    }

    public void setValue(Course value) {
        this.value = value;
    }

    public void setNext(LinkedListNode next) {
        this.next = next;
    }
}
