package com.woragis;

import com.woragis.abstracts.LinkedList;
import com.woragis.abstracts.LinkedListNode;

public class Courses
        extends LinkedList<Course> {
    public Courses() {
        this.head = new LinkedListNode<Course>(null);
    }

    @Override
    public void add(Course value) {
        super.add(value);
    }

    @Override
    public void iterateList() {
        super.iterateList();
    }

    @Override
    public void pop() {
        super.pop();
    }

    public void remove(String courseName) {
        LinkedListNode<Course> current = this.head;
        LinkedListNode<Course> previous = current;

        while (current != null) {
            if (current.getValue().getName() == courseName) {
                previous.setNext(current.getNext());
            } else {
                previous = current;
            }
            current = current.getNext();
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
