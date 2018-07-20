package MutilThread;

public class MyThread13_0 extends Thread {
    private ThreadDomain13 td;
    public MyThread13_0(ThreadDomain13 td){
        this.td = td;
    }

    @Override
    public void run() {
        td.addNum("a");
    }
}
