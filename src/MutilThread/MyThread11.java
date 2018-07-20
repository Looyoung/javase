package MutilThread;

public class MyThread11 implements Runnable {

    private int i = 0;

    @Override
    public void run() {
        try {
            while (true){
                i++;
                System.out.println("i="+i);
                Thread.sleep(1000);
            }
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            MyThread11 myThread11 = new MyThread11();
            Thread thread = new Thread(myThread11);
            thread.setDaemon(true);  // 设置守护线程要在 start 之前
            thread.start();
            Thread.sleep(5000);
            System.out.println("daemon 离开了 thread 对象就不再打印啦！！！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
