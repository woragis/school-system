package com.woragis;

public class SequencialList<T> {
    private T[] values;
    private int length;

    public SequencialList() {
        this.length = 0;
    }

    public void add(T newValue) {
        this.values[this.length] = newValue;
        length++;
    }

    public void remove(T value) {
        for (int i = 0; i < values.length; i++) {
            if (this.values[i] == value) {
                this.values[i] = this.values[i + 1];
                i++;
            }
        }
    }

    public void iterate() {
        for (int i = 0; i < values.length; i++) {
            System.out.println(i + "value: " + this.values[i]);
        }
    }
}
