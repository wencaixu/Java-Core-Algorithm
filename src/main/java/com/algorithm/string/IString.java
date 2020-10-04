package com.algorithm.string;

public interface IString {

    /**
     * 取index下标对应的字符
     *
     * @param index 下标
     * @return 字符
     */
    char charAt(int index);

    /**
     *
     * @return 字符串长度
     */
    int length();

    /**
     * 字符串比较（UNICODE）
     */
    int compareTo(MString anotherString);

    /**
     * 截取子串
     */
    MString substring(int beginIndex,int endIndex);

    /**
     * 字符串拼接
     */
    MString concat(MString after);

    /**
     * 字符串position后插入
     */
    MString insert(MString string,int position);

    /**
     * 删除beginIndex和endIndex之间的数字
     */
    MString delete(int beginIndex,int endIndex);

    /**
     * 字符串打印
     */
    void print();

    /**
     * 返回是否包含子串
     */
    boolean index(MString subString,int start);

    MStringBuilder append(MString string);
}