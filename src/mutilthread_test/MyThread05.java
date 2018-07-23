package mutilthread_test;

public class MyThread05 extends Thread {

    public MyThread05() {
        System.out.println("Thread05 begin...");
        System.out.println("Thread.currentThread().getName()--->" +
                Thread.currentThread().getName());
        System.out.println("this.getName()--->" + this.getName());
        System.out.println("Thread05 end...");
    }

    @Override
    public void run() {
        System.out.println("run begin...");
        System.out.println("Thread.currentThread().getName()--->" +
                Thread.currentThread().getName());
        System.out.println("this.getName()--->" + this.getName());
        System.out.println("run end....");
    }

    public static void main(String[] args) {
        MyThread05 myThread05 = new MyThread05();
        myThread05.start();
    }
}
