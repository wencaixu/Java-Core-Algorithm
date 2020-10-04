package com.algorithm.string;

public class MStringBuilder implements IString {

    private char[] value;

    private int count;

    public MStringBuilder() {
        this.value = new char[0];
        this.count = 0;
    }

    public MStringBuilder(MString string) {
        this.value = string.toCharArray();
        this.count = this.value.length;
    }

    @Override
    public char charAt(int index) {
        return 0;
    }

    @Override
    public int length() {
        return 0;
    }

    @Override
    public int compareTo(MString anotherString) {
        return 0;
    }

    @Override
    public MString substring(int beginIndex, int endIndex) {
        return null;
    }

    @Override
    public MString concat(MString after) {
        return null;
    }

    @Override
    public MString insert(MString string, int position) {
        return null;
    }

    @Override
    public MString delete(int beginIndex, int endIndex) {
        return null;
    }

    @Override
    public void print() {

    }

    @Override
    public boolean index(MString subString, int start) {
        return false;
    }

    @Override
    public MStringBuilder append(MString string){
        int len = string.toCharArray().length;
        if(this.count == 0){
            this.value = string.toCharArray();
            this.count = len;
        }else{
            int newLen = this.count + len;
            char[] newChars = new char[newLen];
            System.arraycopy(this.value,0,newChars,0,this.count);
            System.arraycopy(string.toCharArray(),0,newChars,this.count,string.toCharArray().length);
            this.value = newChars;
            this.count = newLen;
        }
        return this;
    }

    @Override
    public String toString() {
        String string = "";
        for(int i = 0; i < this.count; i++){
            string += value[i];
        }
        return string;
    }

    public static void main(String[] args) {
        MStringBuilder builder = new MStringBuilder();
        builder.append(new MString("aaaa"));
        builder.append(new MString("aaaa"));
        System.out.println(builder.toString());
    }
}
