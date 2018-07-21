package MutilThread;

public class MyThread29 extends Thread {
    private ThreadDomain29 td;

    public MyThread29(ThreadDomain29 td) {
        this.td = td;
    }

    @Override
    public void run() {
        td.addNum();
    }


}
