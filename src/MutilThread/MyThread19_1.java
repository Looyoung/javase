package MutilThread;

public class MyThread19_1 extends Thread {
    private ThreadDomain19 td;
    public MyThread19_1(ThreadDomain19 td){
        this.td = td;
    }

    @Override
    public void run() {
        td.serviceMethodB();
    }

    public static void main(String[] args) {
        ThreadDomain19 td = new ThreadDomain19();
        MyThread19_0 td0 = new MyThread19_0(td);
        MyThread19_1 td1 = new MyThread19_1(td);
        td0.start();
        td1.start();
    }
}
