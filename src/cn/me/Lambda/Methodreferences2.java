package cn.me.Lambda;

import java.util.Comparator;
import java.util.function.BiPredicate;

/**
 * 类 :: 实例方法
 */
public class Methodreferences2 {
    public static void main(String[] args) {
        test1();
        test2();
    }

    /**
     * Comparator int compare(T t1, T t2)
     * String int t1.compareTo(String t2)
     */
    public static void test1() {
        Comparator<String> com1 = (s1, s2) -> s1.compareTo(s2);
        System.out.println(com1.compare("abc", "acb"));

        Comparator<String> com2 = String :: compareTo;
        System.out.println(com2.compare("abc", "acb"));
        System.out.println("************************************");
    }

    /**
     * BiPredicate boolean test(T t1, T t2)
     * String boolean t1.equals(String t2)
     */
    public static void test2() {
        BiPredicate<String, String> p1 = (s1, s2) -> s1.equals(s2);
        System.out.println(p1.test("abc", "abc"));

        p1 = String :: equals;
        System.out.println(p1.test("abc", "acb"));
    }
}
