package hdd.demo.java8.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoField;

/**
 * 新的时间api
 *
 * @author huangqiaowei
 * @create 2018-12-20 13:46
 **/
public class TimeAPI {

    public static void main(String args[]) {
        TimeAPI timeAPI = new TimeAPI();
        timeAPI.testLocalDateTime();
    }

    /**
     * localDate
     */
    public void localDate() {

    }

    /**
     * localTime
     */
    public void localTime() {

    }

    /**
     * localDateTime
     */
    public void localDateTime() {

    }

    /**
     * 测试java8新的时间api
     */
    public void testLocalDateTime() {

        // 获取当前的日期时间
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println("当前时间: " + currentTime);

        LocalDate date1 = currentTime.toLocalDate();
        System.out.println("date1: " + date1);

        Month month = currentTime.getMonth();
        int i = month.get(ChronoField.MONTH_OF_YEAR);
        int day = currentTime.getDayOfMonth();
        int seconds = currentTime.getSecond();

        System.out.println("月: " + month + "，月份数: " + i + ", 日: " + day + ", 秒: " + seconds);

        LocalDateTime date2 = currentTime.withDayOfMonth(10).withYear(2012);
        System.out.println("date2: " + date2);

        // 12 december 2014
        LocalDate date3 = LocalDate.of(2014, Month.DECEMBER, 12);
        System.out.println("date3: " + date3);

        // 22 小时 15 分钟
        LocalTime date4 = LocalTime.of(22, 15);
        System.out.println("date4: " + date4);

        // 解析字符串
        LocalTime date5 = LocalTime.parse("20:15:30");
        System.out.println("date5: " + date5);
    }

}
