package reflection_test;

import java.lang.reflect.Constructor;

/**
 * 测试 Constructor
 */
public class ReflectionTest4 {
    public static void main(String[] args) throws Exception {
        Class<?> aClass = Class.forName("reflection_test.Reflection");
        Constructor<?> constructor = aClass.getConstructor(String.class);
        Constructor<?>[] constructors = aClass.getConstructors();
        Constructor<?>[] constructors1 = aClass.getDeclaredConstructors();

        System.out.println("Class.getConstructor(Class<?>...parameterTypes) --> " + constructor);
        System.out.println("Class.getConstructors() --> ");
        for (Constructor<?> con : constructors) {
            System.out.println(con + "\t");
        }
        System.out.println("---------------------------");
        System.out.println("Class.getDeclaredConstructors() --> ");
        for (Constructor<?> con : constructors1) {
            System.out.println(con + "\t");
        }
        System.out.println("---------------------------");

        System.out.println("Constructor.getName()：" + constructor.getName()); // 获取构造函数名,没什么意义,肯定是和类同名
        System.out.println("Constructor.getModifiers()：" + constructor.getModifiers()); // 获取以整数形式返回的此Constructor对象的Java语言修饰符，如public、static、final等
        System.out.println("Constructor.isAccessible()：" + constructor.isAccessible()); // 获取该Constructor的访问权限
        System.out.println("Constructor.getParameterTypes()：" + constructor.getParameterTypes()[0]); // 获取Constructor的参数类型，是个数组
        System.out.println("Constructor.isVarArgs()：" + constructor.isVarArgs()); // 获取此Constructor中是否带了可变数量的参数，即例如"String... str"类型的参数

        System.out.println("---------------------------");
        constructor = aClass.getConstructor(String.class, double.class, boolean.class);
        Reflection reflection = (Reflection) constructor.newInstance("哈哈哈", 16.5, true); // 根据指定的构造方法实例化出一个类的实例来,重要
        System.out.println("Constructor.newInstance()：" + reflection); //Constructor.newInstance()：String = 哈哈哈, aDouble = 16.5, aBoolean = true
    }
}
