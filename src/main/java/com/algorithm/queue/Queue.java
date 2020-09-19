package com.algorithm.queue;

public interface Queue {

    void append(Object element) throws Exception;

    Object delete() throws Exception;

    boolean isEmpty();

    Object getFront() throws Exception;

}
