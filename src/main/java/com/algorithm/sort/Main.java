package com.algorithm.sort;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Main{

    public static int i = 0;
    public static void main(String[] args) throws InterruptedException {
        long cur = System.currentTimeMillis();

        TimerTask task1 = new TimerTask() {
            @Override
            public void run() {
                i++;
                if(i == 66){
                    this.cancel();
                }
                System.out.println("hello" + "A");
            }
        };

        TimerTask task2 = new TimerTask() {
            @Override
            public void run() {
                i++;
                if(i == 66){
                    this.cancel();
                }
                System.out.println("hello" + "B");
            }
        };

        TimerTask task3 = new TimerTask() {
            @Override
            public void run() {
                i++;
                if(i == 66){
                    this.cancel();
                }
                System.out.println("hello" + "C");
            }
        };

        Timer timer = new Timer();
        timer.schedule(task1,new Date(cur),2000);
        timer.schedule(task2,new Date(cur),2000);
        timer.schedule(task3,new Date(cur),2000);

        Thread.sleep(Integer.MAX_VALUE);
    }
}
