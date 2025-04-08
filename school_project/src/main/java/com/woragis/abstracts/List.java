package com.woragis.abstracts;

import java.io.Serializable;

public class List<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    protected T[] values;
    protected int size;

    protected void adicionar(T newValue) throws Exception {
    }

    protected void visualizarEstudantes() throws Exception {
    }

    protected void ordenar() throws Exception {
    }
}
