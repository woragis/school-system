package com.woragis;

public class LinkedListNode<T> {
    private T value;
    private LinkedListNode<T> next;

    public LinkedListNode(T value) {
        this.value = value;
        this.next = null;
    }

    public LinkedListNode(T value, LinkedListNode<T> next) {
        this.value = value;
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public LinkedListNode<T> getNext() {
        return next;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void setNext(LinkedListNode<T> next) {
        this.next = next;
    }
}
