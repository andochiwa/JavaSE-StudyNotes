package cn.me.Reflection;

@SuppressWarnings(value = { "rawtypes" })
public class ReflectionTest2 {
    public static void main(String[] args) throws ClassNotFoundException {
        // 1
        Class clazz1 = Person.class;
        System.out.println(clazz1);

        // 2
        Person p1 = new Person();
        Class clazz2 = p1.getClass();
        System.out.println(clazz2); 

        // 3
        Class clazz3 = Class.forName("cn.me.Reflection.Person");
        // clazz3 = Class.forName("java.lang.String");
        System.out.println(clazz3);

        // 4
        ClassLoader classloader = ReflectionTest2.class.getClassLoader();
        Class clazz4 = classloader.loadClass("cn.me.Reflection.Person");
        System.out.println(clazz4);

    }
}
