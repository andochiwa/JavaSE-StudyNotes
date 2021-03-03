package cn.me.Lambda;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class ConstructorReferences {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    // Supplier T get()
    // Person的空参构造器 Person()
    @SuppressWarnings("unused")
    public static void test1() {
        Supplier<Person> sup = new Supplier<Person>() {
            @Override
            public Person get() {
                return new Person();
            };
        };
        System.out.println("*************************");

        Supplier<Person> sup1 = () -> new Person();
        System.out.println("*************************");

        Supplier<Person> sup2 = Person :: new;
    }

    // BiFunction R apply(T t, U u)
    public static void test2() {
        BiFunction<Integer, String, Person> func1 = (i, s) -> new Person(i, s);
        System.out.println(func1.apply(1001, "Tom"));
        System.out.println("**************************");

        BiFunction<Integer, String, Person> func2 = Person :: new;
        System.out.println(func2.apply(1002, "Mary"));
        System.out.println("**************************");

    }

    // 数组引用
    // Function apply(T t)
    public static void test3() {
        Function<Integer, String[]> func1 = length -> new String[length];
        String[] apply = func1.apply(5);
        System.out.println(Arrays.toString(apply));

        Function<Integer, String[]> func2 = String[] :: new;
        apply = func2.apply(5);
        System.out.println(Arrays.toString(apply));
    }

}
