package mutilthread_test;

import java.util.concurrent.atomic.AtomicInteger;

public class MyThreadTest extends Thread {
    private AtomicInteger atomicInteger = new AtomicInteger();

    @Override
    public void run() {
        System.out.println(atomicInteger.addAndGet(100));
        System.out.println(this.getName());
        System.out.println(Thread.currentThread().getName());
    }

    public void myMethod() {
        this.atomicInteger.addAndGet(200);
    }

    public static void main(String[] args) {
        try {
            MyThreadTest mt = new MyThreadTest();
            Thread t1 = new Thread(mt);
            Thread t2 = new Thread(mt);
            t1.start();
            sleep(2000);
            t2.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
