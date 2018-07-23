package reflection_test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 测试 Method
 */
public class ReflectionTest5 {
    public static void main(String[] args) throws Exception {
        Class aClass = Class.forName("reflection_test.Reflection");
        Method method0 = aClass.getMethod("publicMethod", String.class, double.class, List.class);
        Method method1 = aClass.getDeclaredMethod("privateMethod");

        Method[] methods0 = aClass.getMethods();
        Method[] methods1 = aClass.getDeclaredMethods();

        System.out.println("Class.getMethod() --> " + method0);  // 根据方法名和参数列表获取指定的public方法
        System.out.println("Class.getDeclaredMethod() --> " + method1); // // 根据方法名和参数列表获取指定的任意访问权限的方法,但不包括继承的方法
        System.out.println("---------------------------------------------");

        System.out.println("Method.getMethods()："); // 获取此类包括其父类中所有的public方法
        for (Method m : methods0)
            System.out.println(m + "\t");
        System.out.println("---------------------------------------------");

        System.out.println("Method.getDeclaredMethods()："); // 返回此类中所有的方法(无访问权限限制),但不包括继承的方法
        for (Method m : methods1)
            System.out.println(m + "\t");
        System.out.println("---------------------------------------------");

        System.out.println("Method.getName()：" + method0.getName()); // 获取方法的名字
        System.out.println("Method.isAccessible()：" + method0.isAccessible()); // 获取方法的访问属性 false
        System.out.println("Method.getModifiers(): " + method0.getModifiers()); // 1 修饰符对应的枚举值
        System.out.println("Method.isVarArgs()：" + method0.isVarArgs()); // 获取方法是否带有可变数量的参数
        System.out.println("Method.getReturnType()：" + method0.getReturnType()); // 获取方法的返回类型
        System.out.println("Method.getParameterTypes()：" + method0.getParameterTypes()[0] + ", "
                + method0.getParameterTypes()[1] + ", " + method0.getParameterTypes()[2]); // 获取方法的参数类型，数组形式，注意一下和下面的方法的区别
        System.out.println("Method.getGenericParameterTypes()：" + method0.getGenericParameterTypes()[0] + ", "
                + method0.getGenericParameterTypes()[1] + ", " + method0.getGenericParameterTypes()[2]); // 获取方法的参数化（带泛型）类型，数组形式
        System.out.println("---------------------------------------------");

        Reflection reflection = new Reflection();
        System.out.println(method0.invoke(reflection, "Hello Louis", 2.2, new ArrayList<String>())); // 反射调用方法，重要
        // Object invoke(Object obj, Object... args) Objec 对应原方法的返回值
        // 若原方法声明为private,则需要在调用此invoke()方法前，显式调用方法对象的setAccessible(true)方法，将可访问private的方法。
    }
}
