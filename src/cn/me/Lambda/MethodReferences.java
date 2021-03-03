package cn.me.Lambda;

import java.util.function.Consumer;
import java.util.function.Supplier;

import org.junit.jupiter.api.Test;

public class MethodReferences {
    public static void main(String[] args) {
        test2();
    }

    // 对象 :: 实例方法
    // Consumer void accept(T t)
    // PrintStream void println(T t)
    @Test
    public void test1() {
        Consumer<String> con1 = str -> System.out.println(str);
        con1.accept("北京");
        
        // PrintStream ps = System.out;
        con1 = System.out :: println;
        con1.accept("beijing");
        System.out.println("********************************************");
    }

    // Supplier T get()
    // Person String get()
    public static void test2() {
        Person person = new Person(18, "Tom");
        Supplier<String> sup1 = () -> person.getName();
        System.out.println(sup1.get());
        
        sup1 = person :: getName;
        System.out.println(sup1.get());
    }
}
