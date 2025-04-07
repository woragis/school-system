package com.woragis;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.woragis.abstracts.Vector;
import com.woragis.constants.Errors;
import com.woragis.constants.Messages;

public class Students extends Vector<Student> {
    private String name;

    public Students(String name) {
        this.values = new Student[10];
        this.size = 0;
        this.name = name;
    }

    public Students(String name, int capacity) {
        this.values = new Student[capacity];
        this.size = 0;
        this.name = name;
    }

    public void saveToFile() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(this.name + ".bin"))) {
            out.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFromFile() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(this.name + ".bin"))) {
            Students loadedStudents = (Students) in.readObject();
            for (int i = 0; i < loadedStudents.size; i++) {
                try {
                    this.add(loadedStudents.at(i));
                } catch (Exception e) {
                    System.out.println(Errors.LOADING_ERROR + ": " + e.getMessage());
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private Student at(int index) {
        return this.values[index];
    }

    private void increaseCapacity() {
        int capacity = this.values.length;
        int newCapacity = capacity + 10;

        System.out.print(Messages.INCREASING_CAPACITY);
        System.out.println("De :" + capacity + ", para: " + newCapacity);

        this.increaseCapacityTo(newCapacity);
    }

    public void increaseCapacityTo(int newCapacity) {
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
            increaseCapacity();
            this.add(newStudent);
        }
    }

    public void remove(String rgm) throws Exception {
        if (this.size > 0) {
            int studentIndex = this.searchByRGM(rgm);
            this.values[studentIndex] = null;
            this.size--;
            if (this.size == 0) {
                return;
            }
            this.order();
        } else {
            throw new Exception(Errors.EMPTY_STUDENTS_ERROR);
        }
    }

    @Override
    protected void order() throws Exception {
        if (this.size > 0) {
            mergeSort(this.values, this.size);
        } else {
            throw new Exception(Errors.EMPTY_STUDENTS_ERROR);
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
            for (int i = 0; i < this.values.length; i++) {
                System.out.println(Messages.STUDENT + " '" + i + "': " + this.values[i]);
            }
        } else {
            throw new Exception(Errors.EMPTY_STUDENTS_ERROR);
        }
    }

    public void getStudent(String rgm) {
        try {
            int studentIndex = this.searchByRGM(rgm);
            Student foundStudent = this.values[studentIndex];
            System.out.println(Messages.FOUND_STUDENT + ": " + foundStudent);
        } catch (Exception e) {
            System.out.println(Errors.SEARCHING_STUDENT_ERROR + ": " + e.getMessage());
        }
    }

    public int searchByRGM(String rgm) throws Exception {
        int index = -1;
        for (int i = 0; i < this.size; i++) {
            if (this.values[i].getRgm().equals(rgm)) {
                index = i;
            }
        }
        if (index != -1) {
            return index;
        } else {
            throw new Exception(Errors.STUDENT_NOT_FOUND);
        }
    }

}
