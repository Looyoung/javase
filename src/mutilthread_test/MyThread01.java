package mutilthread_test;

public class MyThread01 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName() + "运行中...");
        }
    }

    public static void main(String[] args) {
        MyThread01 myThread01 = new MyThread01();
        Thread thread = new Thread(myThread01);
        thread.start();
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName() + "运行中...");
        }
    }
}
