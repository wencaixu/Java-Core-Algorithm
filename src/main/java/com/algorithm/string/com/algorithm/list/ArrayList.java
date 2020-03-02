package com.algorithm.string.com.algorithm.list;

import java.util.Arrays;

public class ArrayList<I extends Number> {

    private int capacity;

    private int listSize;

    private int increase = 5;

    int[] elem;

    ArrayList(int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException("Argument Exception");
        }
        this.capacity = capacity;
        this.listSize = 0;
        this.elem = new int[capacity];
    }

    int delete(int index, int element) {
        if (index < 1 || index > this.capacity) {
            throw new IllegalArgumentException("Argument Exception");
        }
        element = elem[index - 1];
        for (int i = index; i <= this.listSize; i++) {
            elem[i - 1] = elem[i];
        }
        this.listSize--;

        if (this.listSize <= this.capacity / 2) {
            this.elem = Arrays.copyOf(this.elem, this.capacity / 2);
            this.capacity = this.capacity / 2;
        }
        return element;
    }

    void insert(int index, int element) {
        if (index < 1) {
            throw new IllegalArgumentException("Argument Exception");
        }
        if (index > this.capacity) {
            int capacity = this.capacity + increase;
            this.elem = Arrays.copyOf(elem, capacity);
            this.capacity = capacity;
        }

        for (int i = listSize - 1; i > index; i--) {
            elem[i] = elem[i - 1];
        }
        elem[index - 1] = element;
        this.listSize++;
    }

    int indexOf(int element) {
        int low = 0;
        int high = listSize - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (element == elem[mid]) {
                return mid + 1;
            } else if (element < elem[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        throw new NullPointerException("Not exist");
    }

    boolean isEmpty(ArrayList<Number> list) {
        return list.listSize == 0;
    }

    int get(ArrayList<Number> list, int index) {
        if (index < 1 || index > this.listSize) {
            throw new ArrayIndexOutOfBoundsException("Array Index Out of Bounds Exception");
        }
        return list.elem[index - 1];
    }

    void traverse(ArrayList<Number> list) {
        for (int i = 1; i <= list.listSize; i++) {
            System.out.println(list.get(list, i));
        }
    }

    int length() {
        return this.listSize;
    }

    void clear() {
        for (int i = 0; i < this.listSize; i++) {
            this.elem[i] = 0;
        }
    }

    public static void main(String[] args) {
        ArrayList<Number> link = new ArrayList<>(6);
        link.traverse(link);
        link.insert(1, 2);
        link.insert(2, 3);
        System.out.println("index" + link.indexOf(3));
        link.traverse(link);
        int ele = 0;
        link.delete(1, ele);
        System.out.println("listSize" + link.capacity);
        link.traverse(link);
        System.out.println(link.isEmpty(link));
        System.out.println("清空");
        link.traverse(link);
    }
}
