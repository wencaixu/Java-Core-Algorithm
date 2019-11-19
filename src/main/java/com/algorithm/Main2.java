package com.algorithm;

/**
 * 面试准备
 *
 * @author Jerry Hsu  徐文才
 */
public class Main2 {

    private static final double THRESHOLD = 0.00001;

    public static double sqrt(double y){

        double leftEdge = 0;
        double rightEdge = y;

        double mid = (leftEdge + rightEdge) / 2;

        while(y - mid * mid > THRESHOLD || y - mid * mid <= 0){
            if(mid * mid < y){
                leftEdge = mid;
            }else if(mid * mid > y){
                rightEdge = mid;
            }else{
                break;
            }
            mid = (leftEdge + rightEdge) / 2;
        }

        return mid;
    }

    public static void main(String[] args) {
        System.out.println(sqrt(6.25));
    }
}
