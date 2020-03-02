package com.algorithm.string.com.algorithm.list;


class Node<T> {
    T date;
    Node nextNode;
}

public class LinkedList<I extends Number> {

    /**
     * 初始化
     * @param header
     * @return
     */
    public Node init(Node header) {
        header = new Node();
        header.date = 0;
        header.nextNode = null;
        return header;
    }

    /**
     * 链表长度
     * @param header
     * @return
     */
    public int size(Node header) {
        Node TMP = header.nextNode;
        int counter = 0;
        while (TMP != null) {
            TMP = TMP.nextNode;
            counter++;
        }
        return counter;
    }

    /**
     * 链表遍历
     * @param header
     */
    public void traverse(Node header) {
        int i = 0;
        Node TMP = header.nextNode;
        int len = size(TMP);
        while (i < len + 1) {
            System.out.printf(TMP.date + " ");
            TMP = TMP.nextNode;
            i++;
        }
        System.out.println();
    }

    /**
     * 插入数据
     * @param header
     * @param index
     * @param date
     * @throws Exception
     */
    public void insert(Node header, int index, int date) throws Exception {
        if (index < 0) {
            throw new Exception("Index is unformatted");
        }
        int i = 0;
        while (i < index && header != null) {
            i++;
            header = header.nextNode;
        }
        Node newNode = new Node();
        newNode.date = date;
        newNode.nextNode = header.nextNode;
        header.nextNode = newNode;
    }

    /**
     * 删除数据
     * @param header
     * @param index
     * @throws Exception
     */
    public void delete(Node header, int index) throws Exception {
        if (index < 0 || index > size(header)) {
            throw new Exception("Index is overflow");
        }
        int i = 0;
        while (i < index - 1) {
            header = header.nextNode;
            i++;
        }
        header.nextNode = header.nextNode.nextNode;
    }

    /**
     * 删除倒数第K个元素
     *
     * @param header
     * @param rk
     */
    public void deleteLastKthNode(Node header, int rk) {
        Node TMP = header;
        while (TMP != null) {
            rk--;
            TMP = TMP.nextNode;
        }
        if (rk > 0) {
            return;
        }
        if (rk == 0) {
            header = header.nextNode;
        }
        if (rk < 0) {
            while (header != null) {
                header = header.nextNode;
                rk++;
                if (rk == 0) {
                    header = header.nextNode;
                    break;
                }
            }
        }
    }

    /**
     * 删除倒数第K个
     *
     * @param header
     * @param rk
     * @throws Exception
     */
    public void deleteRK(Node header, int rk) throws Exception {

        int index = size(header) - rk;

        if (index < 0 || index > size(header)) {
            throw new Exception("Index is overflow");
        }
        int i = 0;
        while (i < index - 1) {
            header = header.nextNode;
            i++;
        }
        header.nextNode = header.nextNode.nextNode;
    }

    /**
     * 获取第index位置的值
     *
     * @param header
     * @param index
     * @return
     */
    public int get(Node header, int index) {
        int i = 0;
        while (i < index && header.nextNode != null) {
            header = header.nextNode;
            i++;
        }
        return (int) header.date;
    }

    /**
     * 合并
     *
     * @param header1
     * @param header2
     * @return
     * @throws Exception
     */
    public Node merge(Node header1, Node header2) throws Exception {
        if (header1 == null || header2 == null) {
            return header1 == null ? header2 : header1;
        }
        header1 = header1.nextNode;
        header2 = header2.nextNode;
        Node newNode = new Node();
        int counter = 0;
        while (header1 != null && header2 != null) {
            int header1Date = (int) header1.date;
            int header2Date = (int) header2.date;
            if (header1Date < header2Date) {
                insert(newNode, counter++, header1Date);
                header1 = header1.nextNode;
            } else {
                insert(newNode, counter++, header2Date);
                header2 = header2.nextNode;
            }
        }
        while (header1 != null) {
            insert(newNode, counter++, (int) header1.date);
            header1 = header1.nextNode;
        }
        if (header2 != null) {
            insert(newNode, counter++, (int) header2.date);
            newNode.nextNode = header2;
        }
        return newNode;
    }

    /**
     * 求出交集
     *
     * @param header1
     * @param header2
     */
    public void intersection(Node header1, Node header2) {
        header1 = header1.nextNode;
        header2 = header2.nextNode;
        while (header1 != null && header2 != null) {
            if ((int) header1.date < (int) header2.date) {
                header1 = header1.nextNode;
            } else if ((int) header1.date > (int) header2.date) {
                header2 = header2.nextNode;
            } else {
                System.out.printf(String.valueOf((int) header1.date));
                header1 = header1.nextNode;
                header2 = header2.nextNode;
            }
        }
    }

    /**
     * 单链表反转
     * @param head
     * @return
     */
    public Node reverse(Node head){
        Node prep = null;
        Node next = null;
        while(head != null){
            next = head.nextNode;
            head.nextNode = prep;
            prep = head;
            head = next;
        }
        return prep;
    }

    public static void main(String[] args) throws Exception {
        Node n = null;
        Node n1 = null;
        LinkedList<Number> numberLinkedList = new LinkedList<>();

        Node init = numberLinkedList.init(n);
        numberLinkedList.insert(init, 0, 1);
        numberLinkedList.insert(init, 1, 2);
        numberLinkedList.insert(init, 2, 3);
        numberLinkedList.insert(init, 3, 5);

        //链表反转
        Node reverse = numberLinkedList.reverse(init);
        //反转输出
        numberLinkedList.traverse(reverse);

        Node init2 = numberLinkedList.init(n1);
        numberLinkedList.insert(init2, 0, 2);
        numberLinkedList.insert(init2, 1, 4);

        Node merge = numberLinkedList.merge(init, init2);
        numberLinkedList.traverse(merge);
        System.out.println("intersection!!!");
        numberLinkedList.intersection(init, init2);
        numberLinkedList.deleteLastKthNode(init,3);
        //numberLinkedList.deleteRK(init, 3);
        numberLinkedList.traverse(init);
        //numberLinkedList.traverse(init);
        //System.out.println(init == null);
        //numberLinkedList.delete(init,2);
        //numberLinkedList.traverse(init);
        //System.out.println(numberLinkedList.get(init,2));


    }

}
