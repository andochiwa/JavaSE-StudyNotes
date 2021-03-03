package cn.me.DateTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        String birth = "1999-06-13";
        Date date = sdf1.parse(birth);
        java.sql.Date date2 = new java.sql.Date(date.getTime());
        System.out.println(date2);

        Date date1 = new Date();
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf2.format(date1));
    }
}
