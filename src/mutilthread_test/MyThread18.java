package mutilthread_test;

public class MyThread18 extends Thread {
    private ThreadDomain18 td;
    public MyThread18(ThreadDomain18 td){
        this.td = td;
    }

    @Override
    public void run() {
        try {
            td.doLongTimeTask();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        ThreadDomain18 td = new ThreadDomain18();
        MyThread18 mt0 = new MyThread18(td);
        MyThread18 mt1 = new MyThread18(td);
        mt0.start();
        mt1.start();
    }
}
