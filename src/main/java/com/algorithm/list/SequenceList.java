package com.algorithm.list;


/**
 *@author  wencai.xu
 */
public class SequenceList implements List  {

    /**
     * 当前数组长度
     */
    private int currentSize;

    /**
     * 最大长度
     */
    private int maxSize;

    /**
     * 默认长度
     */
    private int defaultSize = 10;

    /**
     * 数组
     */
    private Object[] array;

    public SequenceList() {
        init(defaultSize);
    }

    public SequenceList(int maxSize){
        init(maxSize);
    }

    private void init(int maxSize){
        this.maxSize = maxSize;
        this.currentSize = 0;
        array = new Object[maxSize];
    }

    @Override
    public int size() {
        return this.currentSize;
    }

    @Override
    public void insert(int index, Object value) throws Exception {
        if(size() >= maxSize){
            throw new Exception("数组已满, 无法插入！");
        }
        check(index, maxSize, "数组越界, 抛出异常");
        for(int j = size(); j > index; j--){
            array[j] = array[j - 1];
        }
        array[index] = value;
        currentSize++;
    }


    @Override
    public void delete(int index) throws Exception {
        if(isEmpty()){
            throw new Exception("当前数组内容为空");
        }
        check(index, size(), "数组越界, 抛出异常");
        for(int i = index; i < size(); i++){
            array[i] = array[i+1];
        }
        currentSize --;
    }

    private void check(int index, int size, String s) throws Exception {
        if (index < 0 || index > size) {
            throw new Exception(s);
        }
    }

    @Override
    public Object get(int index) {
        return array[index];
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    public static void main(String[] args) throws Exception {
        SequenceList list = new SequenceList(6);
        list.insert(0,10);
        list.insert(1,11);
        list.insert(2,12);
        list.insert(3,13);
        list.insert(4,14);

        System.out.println(list.get(1));

        list.delete(5);
        System.out.println(list.get(0));

        System.out.println(list.size());
        System.out.println(list.isEmpty());
    }
}
