package com.algorithm.string.com.algorithm.other;


import java.util.Scanner;

public class RPG {

    public static int digui(int n){
       if(n == 1){
           return 3;
       }
       if(n == 2){
           return 6;
       }
       if(n == 3){
           return 6;
       }
       return digui(n - 1) + digui(n - 2) * 2;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int N = in.nextInt();

            if(N == 1){
                System.out.println(3);
            }else if(N == 2){
                System.out.println(6);
            }else if(N == 3){
                System.out.println(6);
            }else{
                long [] A = new long[N];
                A[0] = 3;
                A[1] = 6;
                A[2] = 6;
                for(int i = 3; i < N; i++){
                    A[i] = A[i - 1] + 2 * A[i - 2];
                }
                System.out.println(A[N - 1]);
            }
        }
    }
}
