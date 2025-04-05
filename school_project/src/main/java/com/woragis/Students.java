package com.woragis;

public class Students extends Vector<Student> {
    boolean orderByRgm = true;

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
            if (this.orderByRgm) {
                mergeSortByRGM(this.values, this.size);
            } else {
                mergeSortByName(this.values, this.size);
            }
        } else {
            throw new Exception("Vector is empty");
        }
    }

    public void setOrderByRgm() {
        this.orderByRgm = true;
    }

    public void setOrderByName() {
        this.orderByRgm = false;
    }

    protected void mergeSortByName(Student[] a, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        Student[] leftSide = new Student[mid];
        Student[] rightSide = new Student[n - mid];

        for (int i = 0; i < mid; i++) {
            leftSide[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            rightSide[i - mid] = a[i];
        }
        mergeSortByName(leftSide, mid);
        mergeSortByName(rightSide, n - mid);

        mergeByName(a, leftSide, rightSide, mid, n - mid);
    }

    protected void mergeByName(
            Student[] a, Student[] leftSide, Student[] rightSide, int leftPointer, int rightPointer) {
        int i = 0, j = 0, k = 0;
        while (i < leftPointer && j < rightPointer) {
            int leftName = Integer.parseInt(leftSide[i].getName());
            int rightName = Integer.parseInt(rightSide[j].getName());
            if (leftName <= rightName) {
                a[k++] = leftSide[i++];
            } else {
                a[k++] = rightSide[j++];
            }
        }
        while (i < leftPointer) {
            a[k++] = leftSide[i++];
        }
        while (j < rightPointer) {
            a[k++] = rightSide[j++];
        }
    }

    protected void mergeSortByRGM(Student[] a, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        Student[] leftSide = new Student[mid];
        Student[] rightSide = new Student[n - mid];

        for (int i = 0; i < mid; i++) {
            leftSide[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            rightSide[i - mid] = a[i];
        }
        mergeSortByRGM(leftSide, mid);
        mergeSortByRGM(rightSide, n - mid);

        mergeByRGM(a, leftSide, rightSide, mid, n - mid);
    }

    protected void mergeByRGM(
            Student[] a, Student[] leftSide, Student[] rightSide, int leftPointer, int rightPointer) {
        int i = 0, j = 0, k = 0;
        while (i < leftPointer && j < rightPointer) {
            int leftRgm = Integer.parseInt(leftSide[i].getRgm());
            int rightRgm = Integer.parseInt(rightSide[j].getRgm());
            if (leftRgm <= rightRgm) {
                a[k++] = leftSide[i++];
            } else {
                a[k++] = rightSide[j++];
            }
        }
        while (i < leftPointer) {
            a[k++] = leftSide[i++];
        }
        while (j < rightPointer) {
            a[k++] = rightSide[j++];
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
