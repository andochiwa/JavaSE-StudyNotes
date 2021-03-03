package cn.me.Reflection;

import java.util.Random;

/**
 * 通过反射创建对应的运行时类对象
 */
@SuppressWarnings(value = { "rawtypes", "unchecked" })
public class NewInstanceTest {
    public static void main(String[] args) throws Exception {
        Class clazz = Person.class;

        /**
         * newInstance()调用空参构造器
         */
        // 弃用
        // Person person = (Person) clazz.newInstance();
        Person person = (Person) clazz.getDeclaredConstructor().newInstance();
        System.out.println(person);
        System.out.println();

        for(int i = 0; i < 10; i++) {
            String classpath = "";
            int num = new Random().nextInt(3);
            switch(num) {
                case 0:
                    classpath = "java.util.Date";
                    break;
                case 1:
                    classpath = "java.lang.Object";
                    break;
                case 2:
                    classpath = "cn.me.Reflection.Person";
                    break;
            }
            Object obj = getInstance(classpath);
            System.out.println(obj);
        }
        
    }

    public static Object getInstance(String classpath) throws Exception{
        Class clazz = Class.forName(classpath);
        return clazz.getDeclaredConstructor().newInstance();
    }
}
