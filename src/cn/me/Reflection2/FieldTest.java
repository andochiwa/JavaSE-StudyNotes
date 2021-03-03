package cn.me.Reflection2;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

@SuppressWarnings(value = {"rawtypes"})
public class FieldTest {
    public static void main(String[] args) {
        Class clazz = Person.class;

        // 获取属性结构
        // getfields() 获取当前类极其父类的public属性
        Field[] fields = clazz.getFields();
        for(var f : fields) {
            System.out.println(f);
        }
        System.out.println();

        // getDeclaredFields() 获取当前类声明过的属性
        fields = clazz.getDeclaredFields();
        for(var f : fields) {
            System.out.println(f);
        }
        System.out.println();

        for(var f : fields) {
            // 获取修饰符
            int modifier = f.getModifiers();
            System.out.print(Modifier.toString(modifier) + " ");

            // 获取数据类型
            Class type = f.getType();
            System.out.print(type + " ");

            // 变量名
            String name = f.getName();
            System.out.println(name);
            
        }
    }
}
