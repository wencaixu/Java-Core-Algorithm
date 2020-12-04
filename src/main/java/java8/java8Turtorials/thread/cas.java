package java8.java8Turtorials.thread;

/**
 * @Description: TODO
 * @Author wencai.xu
 * @Date 2020/12/4,0004
 * @Version V1.0
 **/
public class cas {

    /**
     * 自旋锁 - 如果不能获取锁，则线程处于忙等状态，直到获取资源
     */
    private enum ReadyToRun {
        /**
         * 线程1
         */
        T1,
        /**
         * 线程2
         */
        T2
    }

    private static ReadyToRun CURRENT_THREAD = ReadyToRun.T1;

    public static void main(String[] args) {
        char[] t1 = "123456789".toCharArray();
        char[] t2 = "ABCDEFGHI".toCharArray();

        // CAS自旋锁-线程1
        new Thread(() -> {
            for(char t1c : t1){
                while(CURRENT_THREAD != ReadyToRun.T1){}
                System.out.print(t1c);
                CURRENT_THREAD = ReadyToRun.T2;
            }
        },"thread_1").start();

        // CAS自旋锁-线程2
        new Thread(()->{
            for(char t2c : t2){
                while(CURRENT_THREAD != ReadyToRun.T2){}
                System.out.print(t2c);
                CURRENT_THREAD = ReadyToRun.T1;
            }
        },"thread_2").start();
    }

}
