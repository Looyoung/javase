package mutilthread_test;

public class MyThread08 extends Thread {

    @Override
    public void run() {
        long beginTime = System.currentTimeMillis();
        int count = 0;
        for (int i = 0; i < 50000000; i++) {
            Thread.yield();
            //count = count + i + 1;
            count++;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("time consuming:" + (endTime - beginTime) + "ms"+count);
    }

    public static void main(String[] args) {
//        MyThread08 myThread08 = new MyThread08();
//        myThread08.start();
        Thread.currentThread().interrupt();
        System.out.println("是否停止1？" + Thread.interrupted());
        System.out.println("是否停止2？" + Thread.interrupted());
        System.out.println("end!");
    }
}
