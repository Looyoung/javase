package mutilthread_test;

public class MyThread33 extends Thread {
    private Object lock;

    public MyThread33(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        ThreadDomain33 td = new ThreadDomain33();
        td.testMethod(lock);
    }

    public static void main(String[] args) {
        try {
            Object lock = new Object();
            MyThread33 myThread33 = new MyThread33(lock);
            myThread33.start();
            Thread.sleep(5000);
            myThread33.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
