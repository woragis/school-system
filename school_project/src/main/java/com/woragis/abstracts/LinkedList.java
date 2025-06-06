package com.woragis.abstracts;

import java.io.Serializable;

public abstract class LinkedList<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    protected LinkedListNode<T> head;

    public LinkedList() {
        this.head = new LinkedListNode<T>(null);
    }

    public void visualizarLista() {
        LinkedListNode<T> current = this.head;
        int index = 0;
        while (current != null) {
            System.out.println("Value '" + index + "': " + current.getValue());
            index++;
            current = current.getNext();
        }
    }

    public void adicionar(T value) {
        LinkedListNode<T> newHead = new LinkedListNode<T>(value, this.head);
        this.head = newHead;
    }

    public void removerUltimo() {
        this.head = this.head.getNext();
    }

}
