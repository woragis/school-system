package com.woragis;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        LinkedList myList = new LinkedList(0);
        myList.add(20);
        myList.add(30);
        myList.add(50);
        myList.add(60);
        myList.add(70);
        myList.add(80);
        myList.iterateList();
        myList.remove(30);
        myList.iterateList();
    }
}