package com.algorithm.stack;

/**
 * 链栈节点
 *
 * @author wencai.xu
 */
public class LinkedStackNode {

    /**
     * 结点数据
     */
    Object element;

    /**
     * 下一个指针
     */
    LinkedStackNode next;

    /**
     * 创建头结点
     */
    public LinkedStackNode(LinkedStackNode next) {
        this.next = next;
    }

    /**
     * 设置非头节点
     */
    public LinkedStackNode(Object element, LinkedStackNode next) {
        this.element = element;
        this.next = next;
    }

    public Object getElement() {
        return element;
    }

    public void setElement(Object element) {
        this.element = element;
    }

    public LinkedStackNode getNext() {
        return next;
    }

    public void setNext(LinkedStackNode next) {
        this.next = next;
    }
}
