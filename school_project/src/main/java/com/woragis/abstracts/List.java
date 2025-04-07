package com.woragis.abstracts;

import java.io.Serializable;

public class List<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    protected T[] values;
    protected int size;

    protected void add(T newValue) throws Exception {
    }

    protected void view() throws Exception {
    }

    protected void order() throws Exception {
    }
}
