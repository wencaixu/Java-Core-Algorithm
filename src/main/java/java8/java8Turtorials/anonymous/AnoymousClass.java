package java8.java8Turtorials.anonymous;

/**
 * 匿名类，内含有一道面试题
 *
 * @author wencaixu<br />
 * @since JDK 1.8
 */
public class AnoymousClass {

    private final int five = 5;

    /**
     * 面试问题，看输出结果
     */
    public void doIt() {
        final int five = 7;
        Runnable runnable = new Runnable() {
            final int five = 6;

            @Override
            public void run() {
                //this指的是runnable
                System.out.println(this.five);
            }
        };
        runnable.run();
    }


    public static void main(String[] args) {
        new AnoymousClass().doIt();
    }
}
