package cn.me.DateTest;

import java.util.Calendar;
import java.util.Date;

public class CalendarTest {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();

        //get()
        int days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH));
        //set()
        calendar.set(Calendar.DAY_OF_MONTH, 22);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        //add()
        calendar.add(Calendar.DAY_OF_MONTH, -3);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        //getTime() 
        Date date = calendar.getTime();
        System.out.println(date);

        //setTime()
        Date date1 = new Date();
        calendar.setTime(date1);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
    }
}
