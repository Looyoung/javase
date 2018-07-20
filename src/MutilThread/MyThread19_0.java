package MutilThread;

public class MyThread19_0 extends Thread {
    private ThreadDomain19 td;
    public MyThread19_0(ThreadDomain19 td){
        this.td = td;
    }

    @Override
    public void run() {
        td.serviceMethodA();
    }
}
