package com.algorithm.string.com.algorithm.query.ex;

//3.1.2
public class ArrayST<T> {

    private int capacity;

    private T[]  arrayST;

    private int  N;

    public ArrayST(int capacity) {
        this.capacity = capacity;
        arrayST = (T[]) new Object[capacity];
    }

    public int size(){
        return N;
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public T get(int i){
        if(i < 0 || i > N){
            throw new ArrayIndexOutOfBoundsException("array overflow");
        }
        return arrayST[i];
    }

    public void put(T value){
        if(N > capacity){
            throw new ArrayIndexOutOfBoundsException("array overflow");
        }
        arrayST[N++] = value;
    }


    public static void main(String[] args) {
        ArrayST<Integer> arrayST = new ArrayST<>(10);

        arrayST.put(1);
        arrayST.put(2);
        arrayST.put(3);
        arrayST.put(4);

        System.out.println(arrayST.get(1));
    }
}
