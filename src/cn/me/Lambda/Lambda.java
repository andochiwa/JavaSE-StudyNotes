package cn.me.Lambda;

import java.util.Comparator;

public class Lambda {
    public static void main(String[] args) {
        Runnable r1 = new Runnable(){
            @Override
            public void run() {
                System.out.println("我爱北京天安门");
            }
        };
        r1.run();
        System.out.println("**************************************");
        
        Runnable r2 = () -> System.out.println("我爱北京故宫");
        r2.run();
        System.out.println();

        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            };
        };
        System.out.println(com1.compare(12, 23));
        System.out.println("**************************************");

        Comparator<Integer> com2 = (o1, o2) -> Integer.compare(o1, o2);
        System.out.println(com2.compare(23, 12));
        System.out.println("**************************************");

        // 方法引用
        Comparator<Integer> com3 = Integer :: compare;
        System.out.println(com3.compare(23, 12));


    }
}
