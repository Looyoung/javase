package MutilThread;

public class ThreadDomain33 {
    public void testMethod(Object lock) {
        try {
            synchronized (lock) {
                System.out.println("begin wait....");
                lock.wait();
                System.out.println("end wait....");
            }
        } catch (InterruptedException e) {
            System.out.println("wait() has been interrupting.");
            e.printStackTrace();
        }
    }
}
