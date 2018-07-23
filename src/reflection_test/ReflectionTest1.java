package reflection_test;

/**
 * 测试 class 和 ClassLoader
 */
public class ReflectionTest1 {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("reflection_test.Reflection");
        Reflection[] reflections = new Reflection[2];
        System.out.println("getName: " + clazz.getName()); //reflection_test.Reflection
        System.out.println("getClass: " + clazz.getClass()); //class java.lang.Class
        System.out.println("getSuperClass: " + clazz.getSuperclass()); //class java.lang.Object
        System.out.println("getClassLoader: " + clazz.getClassLoader()); //sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println("getClassLoader: " + clazz.getClassLoader().getParent()); //sun.misc.Launcher$ExtClassLoader@1540e19d
        System.out.println("getClassLoader: " + clazz.getClassLoader().getParent().getParent()); //null
        System.out.println("getInterfaces: " + clazz.getInterfaces()[0] + ", " + clazz.getInterfaces()[1]);
        System.out.println("getComponentType: " + reflections.getClass().getComponentType());  //获得该数据的对象 class reflection_test.Reflection
        Reflection reflection = (Reflection) clazz.newInstance();
        System.out.println("newInstance:" + reflection);
    }
}
