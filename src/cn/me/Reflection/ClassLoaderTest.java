package cn.me.Reflection;

public class ClassLoaderTest {
    public static void main(String[] args) {
        // 对于自定义类，使用系统加载器加载
        ClassLoader classloader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classloader);
        // 调用系统加载器的getParent()方法，获取扩展类加载器
        System.out.println(classloader.getParent());
        // 调用扩展类加载器的getParent方法，无法获得引导类加载器
        // 引导类加载器主要负责加载java的核心类库，无法加载自定义类
        System.out.println(classloader.getParent().getParent());
        System.out.println();

        ClassLoader str = String.class.getClassLoader();
        // 引导类加载器加载的String
        System.out.println(str);

    }
}
