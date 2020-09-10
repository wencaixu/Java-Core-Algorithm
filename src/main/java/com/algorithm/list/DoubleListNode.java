package com.algorithm.list;

/**
 * @author wencai.xu
 */
public class DoubleListNode {

    /**
     * 节点值
     */
     Object element;

    /**
     * 前驱
     */
     DoubleListNode prior;

    /**
     * 后继
     */
     DoubleListNode next;

    /**
     * 头节点
     * @param nextval
     */
    public DoubleListNode(DoubleListNode nextval) {
        this.next = nextval;
    }

    /**
     * 非头节点
     * @param element
     * @param next
     */
    public DoubleListNode(Object element, DoubleListNode next) {
        this.element = element;
        this.next = next;
    }

    public Object getElement() {
        return element;
    }

    public void setElement(Object element) {
        this.element = element;
    }

    public DoubleListNode getPrior() {
        return prior;
    }

    public void setPrior(DoubleListNode prior) {
        this.prior = prior;
    }

    public DoubleListNode getNext() {
        return next;
    }

    public void setNext(DoubleListNode next) {
        this.next = next;
    }

    @Override
    public String toString(){
        return this.element.toString();
    }
}
