package mutilthread_test;

public class MyThread00 extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 5; i++){
            System.out.println(Thread.currentThread().getName()+"运行中...");
        }
    }

    public static void main(String[] args) {
        MyThread00 myThread00 = new MyThread00();
        myThread00.start();
        for (int i = 0; i < 5; i++){
            System.out.println(Thread.currentThread().getName()+"运行中...");
        }
    }
}
