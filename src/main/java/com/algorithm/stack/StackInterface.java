package com.algorithm.stack;

public interface StackInterface {

    Object getTop() throws Exception;

    void push(Object element) throws Exception;

    Object pop() throws Exception;

    boolean isNotEmpty();

    int currentSize();
}
