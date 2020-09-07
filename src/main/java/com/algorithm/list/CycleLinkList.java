package com.algorithm.list;

public class CycleLinkList implements List {

    /**
     * 头指针
     */
    private ListedNode head;

    /**
     * 当前节点对象
     */
    private ListedNode current;

    /**
     * 节点个数
     */
    private int size;

    /**
     * 创建空的链表
     */
    public CycleLinkList() {
        // 初始化头节点，头指针指向头节点，当前节点对象等于头节点
        this.head = current = new ListedNode(null);
        // 单项链表初始长度
        this.size = 0;
        // 双线循环链表与单项循环列表区别
        this.head.next = head;
    }

    @Override
    public int size() {
        return this.size;
    }

    /**
     * 获取当前对象的前一个节点，将当前节点定位到要操作节点的前一个元素，思考
     * @param index
     * @throws Exception
     */
    private void index(int index) throws Exception {
        // 小于-1，以首元节点索引为0，头节点为-1
        if(index < -1 || index > size - 1){
            throw new Exception("参数错误");
        }
        // 在头节点之后操作
        if(index == -1){
            return;
        }
        int j = 0;
        current = head.next;
        while(current != head && j < index){
            current = current.next;
            j++;
        }
    }

    @Override
    public void insert(int index, Object obj) throws Exception {
        // TODO Auto-generated method stub
        if(index <0 ||index >size)
        {
            throw new Exception("参数错误！");
        }
        //定位到要操作结点的前一个结点对象。
        index(index-1);
        current.setNext(new ListedNode(obj,current.next));
        size++;
    }

    @Override
    public void delete(int index) throws Exception {
        if(isEmpty()){
            throw new Exception("链表为空，无法删除!!");
        }
        check(index, 0, "参数范围错误");
        index(index - 1);
        current.setNext(current.next.next);
        this.size --;
    }

    private void check(int index, int i, String message) throws Exception {
        if (index < i || index > size) {
            throw new Exception(message);
        }
    }

    @Override
    public Object get(int index) throws Exception {
        check(index, 0, "参数范围错误");
        index(index);
        return current.getElement();
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    public static void main(String[] args) throws Exception {
        CycleLinkList list = new CycleLinkList();
        for(int i = 0; i < 10; i++){
            int t = (int) ((Math.random()*100) % 100);
            list.insert(i,t);
            System.out.print(t+" ");
        }
        // 删除第五个元素
        list.delete(4);
        System.out.println("删除之后");
        for(int i = 0; i < list.size;i++){
            System.out.print(list.get(i) + " ");
        }
    }
}
