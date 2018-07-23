package mutilthread_test;

public class MyThread13_1 extends Thread {
    private ThreadDomain13 td;
    public MyThread13_1(ThreadDomain13 td){
        this.td = td;
    }

    @Override
    public void run() {
        td.addNum("b");
    }

    public static void main(String[] args) {
        ThreadDomain13 td = new ThreadDomain13();
        MyThread13_0 mt0 = new MyThread13_0(td);
        MyThread13_1 mt1 = new MyThread13_1(td);
        mt0.start();
        mt1.start();
    }
}
