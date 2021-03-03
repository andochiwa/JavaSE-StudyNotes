package cn.me.Reflection2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

@SuppressWarnings(value = { "rawtypes" })
public class Othertest {
    public static void main(String[] args) {
        getConstructor();
        getFatherConstructor();
        getInterface();
        getPackage();
        getAnnotation();
    }

    // 获取运行时类
    public static void getConstructor() {
        Class clazz = Person.class;
        System.out.println("获取运行时类");
        // 获取当前类声明为public的构造器
        Constructor[] cs = clazz.getConstructors();
        for(var c : cs) {
            System.out.println(c);
        }
        System.out.println();

        // 获取当前类所有构造器
        cs = clazz.getDeclaredConstructors();
        for(var c : cs) {
            System.out.println(c);
        }
        System.out.println();
    }

    public static void getFatherConstructor() {
        Class clazz = Person.class;
        System.out.println("获取运行时类的父类");

        // 获取运行时类的父类
        Class superclass = clazz.getSuperclass();
        System.out.println(superclass);

        // 获取运行时类带泛型的父类
        Type genericSuperclass = clazz.getGenericSuperclass();
        System.out.println(genericSuperclass);

        // 获取运行时类带泛型的父类的泛型
        ParameterizedType paramType = (ParameterizedType) genericSuperclass;
        Type[] actualTypeArguments = paramType.getActualTypeArguments();
        for(var a : actualTypeArguments) {
            // System.out.println(a.getTypeName());
            System.out.println(((Class)a).getName());
        }
        System.out.println();
    }

    public static void getInterface() {
        Class clazz = Person.class;
        System.out.println("获取运行时类和父类的接口");

        Class[] interfaces = clazz.getInterfaces();
        for(var i : interfaces) {
            System.out.println(i);
        }

        Class superclass = clazz.getSuperclass();
        interfaces = superclass.getInterfaces();
        for(var i : interfaces) {
            System.out.println(i);
        }
        System.out.println();
    }

    public static void getPackage() {
        Class clazz = Person.class;
        System.out.println("获取包");

        Package packages = clazz.getPackage();
        System.out.println(packages);
        System.out.println();
    }

    public static void getAnnotation() {
        Class clazz = Person.class;
        Annotation[] annotation = clazz.getAnnotations();
        System.out.println("获取注解");
        for(var a : annotation) {
            System.out.println(a);
        }
        System.out.println();
    }
}
