package reflection_test;

import java.lang.reflect.Field;

/**
 * 测试 Field
 */
public class ReflectionTest3 {
    public static void main(String[] args) throws Exception {

        Class<?> aClass = Class.forName("reflection_test.Reflection");
        Reflection reflection = new Reflection();

        //Field field0 = aClass.getField("string");   //Exception in thread "main" java.lang.NoSuchFieldException: string
        Field field0 = aClass.getField("aBoolean");
        Field field1 = aClass.getDeclaredField("aDouble");
        Field[] fields = aClass.getFields();
        Field[] declaredFields = aClass.getDeclaredFields();

        int i = 0;
        for (Field field : fields) {
            System.out.println("field" + i + " --> " + field.getModifiers() + " " + field.getType() + " " + field.getName());
            i++;
        }
        System.out.println("-----------------------------------------");

        i = 0;
        for (Field field : declaredFields) {
            System.out.println("field" + i + " --> " + field.getModifiers() + " " + field.getType() + " " + field.getName());
            i++;
        }
        System.out.println("-----------------------------------------");

        System.out.println("Class.getField(string name) --> " + field0);  //public boolean reflection_test.Reflection.aBoolean 根据name获取类中一个访问权限为public的字段
        System.out.println("Class.getDeclaredField(string name) --> " + field1); //private double reflection_test.Reflection.aDouble 根据name获取类中一个任意访问权限的字段
        System.out.println("Field.getName() --> " + field0.getName());  //aBoolean
        System.out.println("Field.getType() --> " + field0.getType());  //boolean
        System.out.println("Field.getBoolean() --> " + field0.getBoolean(reflection));  //false 获取某个实例对象该Field的值，什么类型的Field就是getXXX(Object obj)
        System.out.println("Field.getModifiers() --> " + field0.getModifiers()); // 1 以整数形式返回此Field对象的Java语言修饰符，如public、static、final等
        System.out.println("Field.isAccessible() --> " + field0.isAccessible()); // 返回Field的访问权限，对private的Field赋值，必须要将accessible设置为true，如下
        System.out.println("-----------------------------------------");

        System.out.println();
        field1.setAccessible(true);
        System.out.println("before set --> " + reflection);  // before set --> String = null, aDouble = 0.0, aBoolean = false
        field1.set(reflection, 15.6);
        System.out.println("after set --> " + reflection + ",,," + Reflection.anInt);  // after set --> String = null, aDouble = 15.6, aBoolean = false
    }
}
