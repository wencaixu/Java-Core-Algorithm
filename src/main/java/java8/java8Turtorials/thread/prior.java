package java8.java8Turtorials.thread;


import java.util.concurrent.CountDownLatch;

/**
 * 线程执行顺序
 *
 * @Author wencai.xu
 * @Date 2020/12/4,0004
 * @Version V1.0
 **/
public class prior {

    private static CountDownLatch latch = new CountDownLatch(1);

    public static void main(String[] args){
        // 要求：线程1先执行，线程2后执行

        new Thread(() -> {
            System.out.println("线程1");
            latch.countDown();
        },"thread_1").start();

        new Thread(() -> {
            try {
                latch.await();
                System.out.println("线程2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"thread_2").start();

        // 匿名内部类中使用指针
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(this instanceof Runnable);
            }
        },"thread_3").start();

    }

}
