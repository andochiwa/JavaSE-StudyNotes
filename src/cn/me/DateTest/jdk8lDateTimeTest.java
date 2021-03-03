package cn.me.DateTest;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

public class jdk8lDateTimeTest {
    public static void main(String[] args) {
        LocalDateTimeTest();
        instantTest();
        DateTimeFormatter();
    }

    public static void LocalDateTimeTest() {
        //now()
        LocalDate localdate = LocalDate.now();
        LocalTime localtime = LocalTime.now();
        LocalDateTime localdatetime = LocalDateTime.now();
        System.out.println(localdate);
        System.out.println(localtime);
        System.out.println(localdatetime);
        System.out.println();

        //of() 设定指定的时间
        LocalDateTime localdatetime1 = LocalDateTime.of(2020, 10, 6, 13, 23, 43);
        System.out.println(localdatetime1);
        System.out.println();

        //getXxx()
        System.out.println(localdatetime.getDayOfMonth());
        System.out.println(localdatetime.getDayOfWeek());
        System.out.println(localdatetime.getYear());
        System.out.println(localdatetime.getMinute());
        System.out.println(localdatetime.getMonthValue());
        System.out.println();

        //不可变性
        LocalDateTime localdatetime2 = localdatetime.withDayOfMonth(22);
        System.out.println(localdatetime);
        System.out.println(localdatetime2);
        System.out.println();

        LocalDateTime localdatetime3 = localdatetime.plusMonths(3);
        System.out.println(localdatetime3);
        System.out.println();
    }

    public static void instantTest() {
        //now() 获取本初子午线对应的标准时间
        Instant instant = Instant.now();
        System.out.println(instant);

        //添加时间偏移量
        OffsetDateTime offset = instant.atOffset(ZoneOffset.ofHours(9));
        System.out.println(offset);

        //计算毫秒数
        long milli = instant.toEpochMilli();
        System.out.println(milli);

        //解析
        Instant instant1 = Instant.ofEpochMilli(1610127536867L);
        System.out.println(instant1);
        System.out.println();
    }

    // 格式化或解析日期
    public static void DateTimeFormatter() {
        // 格式化
        java.time.format.DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        String str1 = formatter.format(LocalDateTime.now());
        System.out.println(str1);

        //解析
        TemporalAccessor accessor = formatter.parse("2021-01-09 02:49:29");
        System.out.println(accessor);
    }
    
}
