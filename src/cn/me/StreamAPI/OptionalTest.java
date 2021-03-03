package cn.me.StreamAPI;

import java.util.Optional;

public class OptionalTest {
    
    public static void main(String[] args) {
        test1();
    }

    /**
     * Optional.of(T t) 创建一个Optional实例， t必须为非空
     * Optional.empty() 创建一个空的Optional实例
     * Optional.ofNullable(T t) t可以是null
     * Optional.orElse 如果当前Optional对象不是null则返回内部的t， 如果是null则返回参数的t
     */
    public static void test1() {
        Girl girl = new Girl();
        Optional<Girl> optionalGirl = Optional.of(girl);
        System.out.println(optionalGirl);

        optionalGirl = Optional.ofNullable(null);
        System.out.println(optionalGirl);

        System.out.println(getGirlName(null));
    }

    // NullPointerException
    // public static String getGirlName(Boy boy) {
    //     return boy.getGirl().getName();
    // }

    // 优化 使用Optional.orElse
    public static String getGirlName(Boy boy) {
        Optional<Boy> boyOptional = Optional.ofNullable(boy);
        Boy boy1 = boyOptional.orElse(new Boy(new Girl("Mary")));

        Girl girl = boy1.getGirl();
        Optional<Girl> girlOptional = Optional.ofNullable(girl);
        Girl girl1 = girlOptional.orElse(new Girl("Mavy"));

        return girl1.getName();
    }
}
