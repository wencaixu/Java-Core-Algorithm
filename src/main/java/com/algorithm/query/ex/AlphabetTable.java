package com.algorithm.query.ex;


import java.util.Scanner;

//3.1.1
public class AlphabetTable<Key extends Comparable<Key>,Value> {

    private Key[] alphabet;

    private Value[]  score;

    private  int  capacity;

    private int N = 0;

    public AlphabetTable(int capacity) {
        this.capacity = capacity;
        alphabet = (Key[]) new Comparable[capacity];
        score    = (Value[]) new Object[capacity];
    }

    public boolean isEmpty(){
        return N==0;
    }

    public Value get(Key key){
        Value value = null;
        if(isEmpty()) return null;
        for(int i = 0; i < N; i++){
            if(key.compareTo(alphabet[i]) == 0){
               value = score[i];
               break;
            }
        }
        return value;
    }

    public void put(Key key,Value value){

        if(N > capacity){
            throw new ArrayIndexOutOfBoundsException("overflow capacity");
        }

        alphabet[N] = key;
        score[N]    = value;
        N++;
    }

    public static void main(String[] args) {

       AlphabetTable<String,Double> table = new AlphabetTable<>(11);

       String[] alphabet = {"A+","A","A-","B+","B","B-","C+","C","C-","D","F"};
       Double[] score    = {4.33,4.00,3.67,3.33,3.00,2.67,2.33,2.00,1.67,1.00,0.00};

       for(int i = 0; i < alphabet.length; i++){
           table.put(alphabet[i],score[i]);
       }

       double sum  = 0;
       Scanner in = new Scanner(System.in);
       for(int i = 0;i < 3; i++){
           String input = in.next();
           System.out.println(input);
           sum += table.get(input);
       }
       System.out.println("average score" + sum/3);

    }


}
