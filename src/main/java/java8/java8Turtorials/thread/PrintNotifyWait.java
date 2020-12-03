package java8.java8Turtorials.thread;/**
 * 文件注释
 * Description: <br/>
 * date: 2020/12/3 23:35<br/>
 *
 * @author wencaixu<br />
 * @version
 * @since JDK 1.8
 */



public class PrintNotifyWait{

    private static Object o = new Object();

    public static void main(String[] args) {

        char[] t1 = "123456789".toCharArray();
        char[] t2 = "ABCDEFGHIJ".toCharArray();

        new Thread(() -> {
            synchronized (o){
                for(char t2c : t2){
                    System.out.print(t2c);
                    try {
                        o.notify();
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                o.notify();
            }
        },"thread-1").start();

        new Thread(() -> {
            synchronized (o){
                for(char t1c : t1){
                    System.out.print(t1c);
                    try {
                        o.notify();
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                o.notify();
            }
        },"thread-2").start();
    }
}
