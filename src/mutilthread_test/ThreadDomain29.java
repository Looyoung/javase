package mutilthread_test;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadDomain29 {
    public static AtomicInteger atomicInteger = new AtomicInteger();

    public void addNum() {
        System.out.println(Thread.currentThread().getName()
                + "加了100之后的结果：" +
                atomicInteger.addAndGet(100));
        atomicInteger.addAndGet(1);
    }
}
