package com.woragis.implementations;

import com.woragis.abstracts.LinkedList;
import com.woragis.abstracts.LinkedListNode;
import com.woragis.constants.Errors;
import com.woragis.constants.Messages;

public class Courses
        extends LinkedList<Course> {
    public Courses() {
        this.head = new LinkedListNode<Course>(null);
    }

    @Override
    public void adicionar(Course value) {
        super.adicionar(value);
    }

    @Override
    public void visualizarLista() {
        LinkedListNode<Course> current = this.head;
        if (current.getValue() == null) {
            System.out.println(Errors.NENHUMA_DISCIPLINA_ERRO);
            return;
        }
        int index = 0;
        while (current.getValue() != null) {
            System.out.println(Messages.TEXTO_DISCIPLINA + " '" + index + "': " + current.getValue());
            index++;
            current = current.getNext();
        }
    }

    @Override
    public void removerUltimo() {
        super.removerUltimo();
    }

    public void removerEscolhido(String courseName) {
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
