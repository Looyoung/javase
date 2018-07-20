package MutilThread;

public class MyThread07 extends Thread {

    @Override
    public void run() {
        try {
            System.out.println("run thread name ="
                    + this.getName() + " begin");
            Thread.sleep(2000);
            System.out.println("run thread name ="
                    + this.getName() + " end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MyThread07 myThread07 = new MyThread07();
        System.out.println("begin = " + System.currentTimeMillis());
        myThread07.start();
        System.out.println("end aa= " + System.currentTimeMillis());
    }
}
