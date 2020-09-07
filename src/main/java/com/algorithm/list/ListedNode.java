package com.algorithm.list;


public class ListedNode {

    Object element;

    ListedNode next;


    public ListedNode(ListedNode next){
        this.next = next;
    }

    public ListedNode(Object element, ListedNode next){
        this.element = element;
        this.next = next;
    }

    public void setElement(Object element) {
        this.element = element;
    }

    public Object getElement() {
        return element;
    }

    public ListedNode getNext() {
        return next;
    }

    public void setNext(ListedNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return this.element.toString();
    }
}
