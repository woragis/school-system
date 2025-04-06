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

    public void remove(String rgm) throws Exception {
        if (this.size > 0) {
            int studentIndex = this.searchByRGM(rgm);
            this.values[studentIndex] = null;
            this.size--;
            this.order();
        } else {
            throw new Exception("Vector is empty");
        }
    }

    @Override
    protected void order() throws Exception {
        if (this.size > 0) {
            mergeSort(this.values, this.size);
        } else {
            throw new Exception("Vector is empty");
        }
    }

    protected void mergeSort(Student[] a, int n) {
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
        mergeSort(leftSide, mid);
        mergeSort(rightSide, n - mid);

        merge(a, leftSide, rightSide, mid, n - mid);
    }

    protected void merge(
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

    public int searchByRGM(String rgm) throws Exception {
        int rgmNumber = Integer.parseInt(rgm);
        int low, high, mid, index;
        low = 0;
        high = 0;
        index = -1;
        while (low <= high) {
            mid = low + ((high - low) / 2);
            int thisRgm = Integer.parseInt(this.values[mid].getRgm());
            if (thisRgm < rgmNumber) {
                low = mid + 1;
            } else if (thisRgm < rgmNumber) {
                high = mid - 1;
            } else if (thisRgm == rgmNumber) {
                index = mid;
            }
        }
        if (index != -1) {
            return index;
        } else {
            throw new Error("Student not found");
        }
    }

}
