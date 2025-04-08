package com.woragis.implementations;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.woragis.abstracts.List;
import com.woragis.constants.Errors;
import com.woragis.constants.Messages;

public class Students extends List<Student> {
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
                    System.out.println(Errors.ERRO_CARREGANDO_BACKUP + ": " + e.getMessage());
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

        System.out.print(Messages.AUMENTANDO_CAPACIDADE);
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
            throw new Exception(Errors.LISTA_VAZIA_ERRO);
        }
    }

    @Override
    protected void order() throws Exception {
        if (this.size > 0) {
            compact();
            mergeSort(this.values, this.size);
        } else {
            throw new Exception(Errors.LISTA_VAZIA_ERRO);
        }
    }

    private void compact() {
        int writeIndex = 0;
        for (int readIndex = 0; readIndex < this.values.length; readIndex++) {
            if (this.values[readIndex] != null) {
                this.values[writeIndex++] = this.values[readIndex];
            }
        }
        // Fill the rest with nulls
        for (int i = writeIndex; i < this.values.length; i++) {
            this.values[i] = null;
        }
        this.size = writeIndex;
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
    public void view() throws Exception {
        if (this.size > 0) {
            for (int i = 0; i < this.size; i++) {
                System.out.println(Messages.TEXTO_ESTUDANTE + " '" + i + "': " + this.values[i]);
            }
            System.out.println();
        } else {
            throw new Exception(Errors.LISTA_VAZIA_ERRO);
        }
    }

    public Student getStudent(String rgm) throws Exception {
        try {
            int studentIndex = this.searchByRGM(rgm);
            Student foundStudent = this.values[studentIndex];
            System.out.println(Messages.ESTUDANTE_ENCONTRADO + ": " + foundStudent);
            return foundStudent;
        } catch (Exception e) {
            throw new Exception(Errors.PESQUISANDO_ESTUDANTE_ERRO + ": " + e.getMessage());
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
            throw new Exception(Errors.ESTUDANTE_NAO_ECONTRADO);
        }
    }

}
