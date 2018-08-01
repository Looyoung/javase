package class_test;

public class LoaderTest {
    public static void main(String[] args) {
        A ab = new B();
        System.out.println("-><-><-><-><-><-><-><-><-><-><-><-><-><->-<><-");
        ab = new B();
    }
}

class A {
    static {
        System.out.println("A static run...");
    }

    {
        System.out.println("A default run...");
    }

    public A() {
        System.out.println("A constructor run...");
    }
}

class B extends A {
    static {
        System.out.println("B static run...");
    }

    {
        System.out.println("B default run...");
    }

    public B() {
        System.out.println("B constructor run...");
    }
}
