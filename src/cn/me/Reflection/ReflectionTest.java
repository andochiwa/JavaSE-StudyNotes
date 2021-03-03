package cn.me.Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@SuppressWarnings(value = { "rawtypes", "unchecked" })
public class ReflectionTest {
    public static void main(String[] args) throws Exception {
        noReflection();
        System.out.println();
        reflection();
    }

    public static void noReflection() {
        Person person = new Person("Tom", 12);

        person.age = 10;
        System.out.println(person.age);

        person.show();
    }

    public static void reflection() throws Exception {
        Class clazz = Person.class;        
        Constructor cons = clazz.getConstructor(String.class, int.class);

        Object obj = cons.newInstance("Tom", 12);
        Person p = (Person) obj;
        System.out.println(p);

        // call attribute
        Field age = clazz.getDeclaredField("age");
        age.set(p, 10);
        System.out.println(p);

        // call method
        Method method = clazz.getDeclaredMethod("show");
        method.invoke(p);

        // call private struct
        Constructor cons1 = clazz.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        Person p1 = (Person) cons1.newInstance("Jerry");
        System.out.println(p1);

        // call private attribute
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1, "Mary");
        System.out.println(p1);

        // call private mathod
        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        String nation = (String) showNation.invoke(p1, "China");
        System.out.println(nation);
    }
}
