package cn.me.StreamAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import cn.me.Reflection2.Person;

@SuppressWarnings("unused")
public class StreamAPI {
    public static void main(String[] args) {
        test3();
    }

    /**
     * 通过集合 default Stream<E> stream(): 返回一个顺序流 default Stream<E> parallelStream():
     * 返回一个并行流
     */

    public static void test1() {
        List<Integer> list = new ArrayList<>();

        // 返回一个顺序流
        Stream<Integer> stream = list.stream();

        // 返回一个并行流
        Stream<Integer> parallelStream = list.parallelStream();
    }

    /**
     * 通过数组
     */
    public static void test2() {
        int[] arr = { 1, 2, 3 };
        IntStream stream = Arrays.stream(arr);

        Person p1 = new Person();
        Person p2 = new Person();
        Person[] arr1 = { p1, p2 };
        Stream<Person> stream2 = Arrays.stream(arr1);
    }

    /**
     * 3.通过Stream.of() 4.创建无限流
     */
    public static void test3() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6);
        // 遍历前十个偶数
        // public static<T> Stream<T> iterate(final T seed, final UnaryOperator<T> f)
        Stream.iterate(0, t -> t + 2).limit(10).forEach(t -> System.out.print(t + " "));
        System.out.println();

        // 生成
        // public static<T> Stream<T> generate(Supplier<T> s)
        Stream.generate(Math::random).limit(10).forEach(t -> System.out.print(t + " "));

    }
}
