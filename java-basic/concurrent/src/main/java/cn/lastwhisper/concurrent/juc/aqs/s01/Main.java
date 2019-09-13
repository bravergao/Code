package cn.lastwhisper.concurrent.juc.aqs.s01;

/**
 * @author lastwhisper
 */
public class Main {
    private static int m = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[100];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    m++;
                }
            });
        }

        for (Thread t : threads) t.start();
        for (Thread t : threads) t.join();//等待所有线程运行结束

        System.out.println(m);
    }
}
