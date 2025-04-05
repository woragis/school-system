package com.woragis;

public class Students extends Vector<Student> {
    public Students(int capacity) {
        this.values = new Student[capacity];
        this.size = 0;
    }

    public void increaseSize(int newCapacity) {
        Student[] increasedVector = new Student[newCapacity];
        for (int i = 0; i < this.values.length; i++) {
            increasedVector[i] = this.values[i];
        }
        this.values = increasedVector;
    }

    @Override
    public void add(Student newStudent) throws Exception {
        if (this.size < this.values.length) {
            this.values[this.size] = newStudent;
            this.size++;
            this.order();
        } else {
            throw new Exception("Vector is full");
        }
    }

    @Override
    public void remove(Student student) throws Exception {
        if (this.size > 0) {
            this.size--;
            this.order();
        } else {
            throw new Exception("Vector is empty");
        }
    }

    @Override
    protected void order() throws Exception {
        if (this.size > 0) {
            for (int i = 0; i < values.length; i++) {
            }
        } else {
            throw new Exception("Vector is empty");
        }
    }

    @Override
    protected void view() throws Exception {
        if (this.size > 0) {
            for (int i = 0; i < values.length; i++) {
                System.out.println("Student '" + i + "': " + this.values[i]);
            }
        } else {
            throw new Exception("Vector is empty");
        }
    }

}
