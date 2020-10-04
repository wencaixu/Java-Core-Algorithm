package com.algorithm.string;


public class MString implements IString{

    private char[] value;

    private int count;

    public MString() {
        init();
    }

    /**
     * 说明：测试用例，可以自行设置
     * @param args
     */
    public static void main(String[] args) {
        MString string1 = new MString();
        MString string2 = new MString("aaaaaaa");
        char[] chars = {'1','2','3','a','b'};
        MString string3 = new MString(chars);
        MString string4 = new MString(chars,0,4);

        System.out.println("==========================构造函数========================");
        System.out.println(string1.toString()+" "+string2.toString() + " " + string3.toString() + " " + string4.toString());

        System.out.println("==========================CharAt函数测试========================");
        System.out.println("string3测试CharAt函数 " + string3.charAt(2));

        System.out.println("==========================length函数测试======================");
        System.out.println("length函数测试"+string3.length());

        System.out.println("==========================substring函数测试======================");
        System.out.println("substring函数测试"+string3.substring(0,3));

        System.out.println("==========================compareTo函数测试=======================");
        System.out.println("compareTo函数测试"+string3.compareTo(string2));

        System.out.println("======================concat函数测试=========================");
        System.out.println("concat函数测试"+string3.concat(string2).toString());

        System.out.println("======================delete函数测试=========================");
        string3.delete(0,3);
        System.out.println("delete函数测试"+string3.delete(0,3));

        System.out.println("======================print函数测试=========================");
        string3.print();
    }

    public MString(String string){
        if(string.length() != 0){
            this.count = string.length();
            this.value = string.toCharArray();
        }else{
            this.init();
        }
    }

    public MString(char[] values){
        this.count = values.length;
        this.value = values;
    }

    public MString(char[] values,int start,int len){
        if(start < 0 || start > values.length || (start + len) > values.length){
            throw new ArrayIndexOutOfBoundsException(start);
        }
        this.count = len;
        char[] valueTemp = new char[len];
        System.arraycopy(values,start,valueTemp,0,len);
        this.value = valueTemp;
    }

    private void init() {
        this.count = 0;
        this.value = new char[this.count];
    }

    @Override
    public char charAt(int index) {
        if(index < 0 || index > this.count - 1){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        return value[index];
    }

    @Override
    public int length() {
        return this.count;
    }

    @Override
    public int compareTo(MString anotherString) {
        int anotherLen = anotherString.length();
        int minLen = Math.min(this.count,anotherLen);
        int j = 0;
        while(j < minLen){
            char thisChars = this.charAt(j);
            char otherChars = anotherString.charAt(j);
            if(thisChars != otherChars){
                if(thisChars > otherChars){
                    return thisChars - otherChars;
                }
                return otherChars - thisChars;
            }
            j++;
        }
        return anotherLen - this.count;
    }

    @Override
    public MString substring(int beginIndex, int endIndex) {
        if(beginIndex < 0 || endIndex > this.count){
            throw new ArrayIndexOutOfBoundsException("参数范围异常");
        }
        int length = endIndex - beginIndex ;
        return new MString(this.value,beginIndex,length);
    }

    public char[] toCharArray(){
        return this.value;
    }

    @Override
    public MString concat(MString append) {
        char[] appendChars = append.toCharArray();
        if(this.count == 0 && append.length() > 0){
            return new MString(appendChars);
        }
        if(this.count > 0 && append.length() == 0){
            return new MString(this.value);
        }
        int appendLen = append.length();
        int newLen = this.count + appendLen;
        char[] newChars = new char[newLen];
        System.arraycopy(this.value,0,newChars,0,this.count);
        System.arraycopy(appendChars,0,newChars,this.count,appendLen);
        return new MString(newChars);
    }

    @Override
    public MString insert(MString string, int position) {
        if(position > this.count){
            throw new ArrayIndexOutOfBoundsException(position);
        }
        MString substringBefore = this.substring(0, position);
        MString substringAfter = this.substring(position, this.length());
        return substringBefore.concat(string).concat(substringAfter);
    }

    @Override
    public MString delete(int beginIndex, int endIndex) {
        if(beginIndex < 0 || endIndex > count){
            throw new StringIndexOutOfBoundsException(beginIndex);
        }
        if(beginIndex > endIndex){
            throw new StringIndexOutOfBoundsException(endIndex - beginIndex);
        }
        if(beginIndex == 0 && endIndex == count){
            return new MString();
        }else{
            MString string1 = this.substring(0,beginIndex);
            MString string2 = this.substring(endIndex,this.count);
            return string1.concat(string2);
        }
    }

    @Override
    public void print() {
        for(int i = 0; i < this.count; i++){
            System.out.print(this.value[i]);
        }
        System.out.println();
    }

    @Override
    public boolean index(MString subString, int start) {
        if(start < 0){
            throw new ArrayIndexOutOfBoundsException("参数范围错误");
        }
        if(start + subString.length() > this.count){
            return false;
        }
        boolean bfMstring = bfMstring(this, subString);
        return bfMstring;
    }

    private static boolean bfMstring(MString model,MString pattern){
        char[] modelChars = model.toCharArray();
        char[] patternChars = pattern.toCharArray();
        if(model.length() < patternChars.length){
            return false;
        }
        int m = 0, p = 0;
        while(m < modelChars.length && p < patternChars.length){
            if(model.charAt(m) == pattern.charAt(p)){
                m ++;
                p ++;
            }else{
                m = m - p + 1;
                p = 0;
            }
        }
        if(p == m){
            return true;
        }
        return false;
    }

    @Override
    public MStringBuilder append(MString string) {
        return null;
    }

    @Override
    public String toString() {
        String ans = "";
        for(int i = 0; i < value.length; i++){
            ans += value[i];
        }
        return ans;
    }
}
