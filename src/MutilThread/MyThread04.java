package MutilThread;

public class MyThread04 extends Thread {

    static {
        System.out.println("静态块打印："+Thread.currentThread().getName());
    }

    public MyThread04(){
        System.out.println("构造方法打印："+Thread.currentThread().getName());
    }

    @Override
    public void run() {
        System.out.println("run方法打印："+Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        MyThread04 myThread04 = new MyThread04();
        myThread04.start();
    }
}
