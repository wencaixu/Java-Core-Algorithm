package com.algorithm.queue;

public class QueueNode {

    Object element;

    QueueNode next;

    public QueueNode(QueueNode next) {
        this.next = next;
    }

    public QueueNode(Object element, QueueNode next) {
        this.element = element;
        this.next = next;
    }

    public Object getElement() {
        return element;
    }

    public void setElement(Object element) {
        this.element = element;
    }

    public QueueNode getNext() {
        return next;
    }

    public void setNext(QueueNode next) {
        this.next = next;
    }
}
