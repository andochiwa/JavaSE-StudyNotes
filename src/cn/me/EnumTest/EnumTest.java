package cn.me.EnumTest;

import java.lang.Thread.State;

public class EnumTest {
    public static void main(String[] args) {
        Season spring = Season.SPRING;
        System.out.println(spring);
        System.out.println();

        //values()
        Season1 summer = Season1.SUMMER;
        System.out.println(summer);
        System.out.println(Season1.class.getSuperclass());
        System.out.println();
        Season1[] values = Season1.values();
        for(int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
        }
        
        System.out.println();
        State[] values2 = Thread.State.values();
        for(int i = 0; i < values2.length; i++) {
            System.out.println(values2[i]);
        }
        System.out.println();

        //valueOf(String objName)
        Season1 winter = Season1.valueOf("WINTER");
        System.out.println(winter);
    }
}

/**
 *  枚举类
 * @since 1.0
 */
class Season {

    private final String seasonName;
    private final String seasonDesc;

    private Season(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    public static final Season SPRING = new Season("spring", "spring good");
    public static final Season SUMMER = new Season("summer", "summer good");
    public static final Season AUTUMN = new Season("autumn", "autumn good");
    public static final Season WINTER = new Season("winter", "winter good");

    @Override
    public String toString() {
        return "Season [seasonDesc=" + seasonDesc + ", seasonName=" + seasonName + "]";
    }
}

/**
 * 使用enum
 * @since 1.5
 */
enum Season1 {

    SPRING("spring", "spring good"),
    SUMMER("summer", "summer good"),
    AUTUMN("autumn", "autumn good"),
    WINTER("winter", "winter good");

    private final String seasonName;
    private final String seasonDesc;

    @Override
    public String toString() {
        return "Season1 [seasonDesc=" + seasonDesc + ", seasonName=" + seasonName + "]";
    }

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    private Season1(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }
}