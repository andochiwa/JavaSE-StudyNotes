package cn.me.Reflection2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

@SuppressWarnings(value = {"rawtypes"})
public class MethodTest {
    public static void main(String[] args) {
        Class clazz = Person.class;

        // 获取当前类极其父类中所有public权限的方法
        Method[] method = clazz.getMethods();
        for(var m : method) {
            System.out.println(m);
        }
        System.out.println();

        // 获取当前类的所有方法
        method = clazz.getDeclaredMethods();
        for(var m : method) {
            // 获取方法的注解
            Annotation[] annos = m.getAnnotations();
            for(var a : annos) {
                System.out.println(a);
            }

            // 权限修饰符
            System.out.print(Modifier.toString(m.getModifiers()) + "\t");

            // 方法的返回值类型
            System.out.print(m.getReturnType().getName() + "\t");

            System.out.print(m.getName() + "(");

            Class[] types = m.getParameterTypes();
            for(int i = 0; i < types.length; i++) {
                if(i == types.length - 1) {
                    System.out.print(types[i].getName() + i);
                } else {
                    System.out.print(types[i].getName() + ",");
                }
            }
            System.out.println(")");

        } 

    }
}
