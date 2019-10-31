package com.tools;


public class Main {

    public static void test1(){}

    synchronized public static void test2(){}

    public static void test1(int a){}

    public static void main(String[] args) {
        test1();
        test2();
        test1(2);
    }
}
