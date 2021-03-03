package cn.me.Reflection2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/** 调用运行时类中指定的结构 */
@SuppressWarnings(value = { "rawtypes", "unchecked" })
public class ReflectionTest {
    public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException,
            IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
        field();
        method();
        constructor();
    }

    public static void field() throws InstantiationException, IllegalAccessException, IllegalArgumentException,
            InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException {
        Class clazz = Person.class;
        System.out.println("操作指定的属性");
        Person person = (Person) clazz.getDeclaredConstructor().newInstance();

        // 要求声明为public
        Field id = clazz.getField("id");
        id.set(person, 1001);
        System.out.println(id.get(person));

        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(person, "Tom");
        System.out.println(name.get(person));
        System.out.println();
    }

    public static void method() throws NoSuchMethodException, SecurityException, InstantiationException,
            IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        System.out.println("操作指定的方法");
        Class clazz = Person.class;
        Person person = (Person) clazz.getDeclaredConstructor().newInstance();

        // 参数是取的方法， 形参列表
        Method show = clazz.getDeclaredMethod("show", String.class);
        // 参数是方法的调用者， 形参赋值的实参
        show.setAccessible(true);
        Object returnValue = show.invoke(person, "CHINA");
        System.out.println(returnValue);

        System.out.println("******************调用静态方法********************************");
        Method showDest = clazz.getDeclaredMethod("showDest");
        showDest.setAccessible(true);
        // returnValue = showDest.invoke(Person.class);
        returnValue = showDest.invoke(null);
        System.out.println(returnValue);
        System.out.println();
    }

    public static void constructor() throws NoSuchMethodException, SecurityException, InstantiationException,
            IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        System.out.println("调用指定的构造器");
        Class clazz = Person.class;
        Constructor constructor = clazz.getDeclaredConstructor(String.class);
        constructor.setAccessible(true);
        Person person = (Person) constructor.newInstance("Tom");
        // Person person = (Person) clazz.getDeclaredConstructor(String.class).newInstance("Tom");
        System.out.println(person);

    }
}
