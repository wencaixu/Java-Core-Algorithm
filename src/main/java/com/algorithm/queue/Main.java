package com.algorithm.queue;



public class Main {

    public static int array(int[] array){
        if(array.length==1) return array[0];
        int max=0,temp1=1;
        for(int i=0;i<array.length;i++){
            temp1=1;
            for(int j=i;j>=0;j--){
                temp1*=array[j];
                if(temp1>max) max=temp1;
            }
        }
        return max;
    }

    public static void main(String[] args) {

    }
}
