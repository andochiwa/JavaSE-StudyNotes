package cn.me.CollectionsTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SuppressWarnings("all")
public class CollectionsTest {

    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(123);
        list.add(126);
        list.add(125);
        list.add(124);
        list.add(128);
        list.add(133);
        list.add(123);

        System.out.println(list);
        
        // 反转
        Collections.reverse(list);
        System.out.println(list);

        // 随机顺序
        Collections.shuffle(list);
        System.out.println(list);

        Collections.sort(list);
        System.out.println(list);

        Collections.swap(list, 2, 3);
        System.out.println(list);

        System.out.println(Collections.min(list));

        System.out.println(Collections.frequency(list, 123));
        
        // Exception
        // List dest = new ArrayList();
        // Collections.copy(dest, list);
        // System.out.println(dest);
        List dest = Arrays.asList(new Object[list.size()]);
        System.out.println(dest);
        Collections.copy(dest, list);
        System.out.println(dest);

        // 线程安全的list
        List list1 = Collections.synchronizedList(list);
        System.out.println(list1);
    }
}
