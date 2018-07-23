package mutilthread_test;

public class ThreadDomain13 {
    private int num = 0;

    public synchronized void addNum(String username){
        try {
            if("a".equals(username)){
                num = 100;
                System.out.println("a set over...");
                Thread.sleep(2000);
            }
            else {
                num = 200;
                System.out.println("b set over...");
            }
            System.out.println(username+" num = "+num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
