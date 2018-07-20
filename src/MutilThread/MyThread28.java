package MutilThread;

public class MyThread28 extends Thread {
    private volatile boolean isRunning = true;
    public boolean isRunning(){
        return isRunning;
    }
    public void setRunning(boolean isRunning){
        this.isRunning = isRunning;
    }

    @Override
    public void run() {
        System.out.println("进入 run 方法了....");
        while (isRunning){}
        System.out.println("线程被停止了...");
    }

    public static void main(String[] args) {
        try {
            MyThread28 myThread28 = new MyThread28();
            myThread28.start();
            Thread.sleep(2000);
            myThread28.setRunning(false);
            System.out.println("已赋值为false");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
