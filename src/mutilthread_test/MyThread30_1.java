package mutilthread_test;

public class MyThread30_1 extends Thread {
    private Object lock;

    public MyThread30_1(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            System.out.println("开始...notify time = " + System.currentTimeMillis());
            lock.notify();
            System.out.println("结束...notify time = " + System.currentTimeMillis());
        }
    }

    public static void main(String[] args) {
        try {
            Object lock = new Object();
            MyThread30_0 mt0 = new MyThread30_0(lock);
            mt0.start();
            Thread.sleep(3000);
            MyThread30_1 mt1 = new MyThread30_1(lock);
            mt1.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
