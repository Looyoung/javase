package reflection_test;

/**
 * 测试 package
 */
public class ReflectionTest2 {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("reflection_test.Reflection");
        Package aPackage = clazz.getPackage();
        System.out.println("Package.toString()：" + aPackage.toString()); //toString()  package reflection_test
        System.out.println("Package.getName()：" + aPackage.getName());     // 获取包名 reflection_test
        System.out.println("Package.getImplementationTitle()：" + aPackage.getImplementationTitle()); // 获取包标题 null
        System.out.println("Package.getImplementationVendor()：" + aPackage.getImplementationVendor()); // 获取提供该实现的组织、供应商或公司的名称 null
        System.out.println("Package.getImplementationVersion()：" + aPackage.getImplementationVersion()); // 获取该实现的版本 null
        System.out.println("Package.isSealed()：" + aPackage.isSealed()); // 获取包是否密封的 false
    }
}
