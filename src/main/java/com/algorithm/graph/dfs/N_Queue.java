package com.algorithm.graph.dfs;

import java.util.Scanner;

public class N_Queue {

    static int m;
    static int map[]=new int[11];

    static public boolean can(int k,int a[]){
        int i;
        for(i=1;i<k;i++){

            if(a[i]==a[k]||Math.abs(a[k]-a[i])==k-i){
                return false;
            }
        }
        return true;
    }

    static public void nqueen(int k,int a[],int n){
        int i;

        for(i=1;i<=n;i++){
            a[k]=i;
            if(can(k, a)){
                if(k==n){
                    m++;
                }
                else{
                    nqueen(k+1,a,n);
                }
            }
        }
    }

    public static void main(String[] args) {
        int n,i;
        Scanner in=new Scanner(System.in);

        for(i=1;i<=10;i++){
            int a[]=new int[i+1];
            m=0;
            nqueen(1,a,i);
            map[i]=m;
        }
        while(in.hasNext()){
            n=in.nextInt();
            if(n==0){break;}
            System.out.println(map[n]);
        }
    }
}
