package com.algorithm.list;

public interface List {

    int size();

    void insert(int index,Object value) throws Exception;

    void delete(int index) throws Exception;

    Object get(int index) ;

    boolean isEmpty();

}
