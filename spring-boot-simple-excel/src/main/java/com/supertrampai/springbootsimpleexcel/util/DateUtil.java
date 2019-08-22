package com.supertrampai.springbootsimpleexcel.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @Description
 * @author lxh800109@gmail.com
 * @create 2019-08-21 20:39
 */
public class DateUtil {
    private static final String DATE = "yyyy-MM-dd";
    private static final String DATETIME = "yyyy-MM-dd HH:mm:ss";
    private static final String STIME = "HH:mm";
    private static final String DATETIME2 = "yyyyMMddHHmmss";

    public static String DateToStr(Date date, String pattern) {
        if(pattern == null){
            pattern = DATETIME;
        }
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
    }

    public static String NowStr(String pattern) {
        if(pattern == null){
            pattern = DATETIME;
        }
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(Calendar.getInstance().getTime());
    }

    public static void main(String[] args){
        System.out.println(DateUtil.DateToStr(new Date(),"yyyy"));

    }

    //转换字符串为日期时间(yyyy-MM-dd HH:mm:ss)
    public static Date getDateTimeByString(String dtstring){
        return getDate(dtstring,DATETIME);
    }

    //转换字符串为日期(yyyy-MM-dd)
    public static Date getDateByString(String dtstring){
        return getDate(dtstring,DATE);
    }

    //转换字符串为指定格式日期时间
    public static Date getDate(String dtstring,String pattern){
        DateFormat df = new SimpleDateFormat(pattern);
        Date d = null;
        try {
            d = df.parse(dtstring);
        } catch (Exception e) {
        }
        return d;
    }

    public static boolean isTuesday(){
//        return Calendar.getInstance().get(Calendar.DAY_OF_WEEK)==Calendar.WEDNESDAY;
        return Calendar.getInstance().get(Calendar.DAY_OF_WEEK)==Calendar.TUESDAY;
    }

    //转换日期为字符串(yyyy-MM-dd HH:mm:ss)
    public static String getStringByDateTime(Date date){
        return DateToStr(date,DATETIME);
    }

    //转换日期为字符串(yyyy-MM-dd)
    public static String getStringByDate(Date date){
        return DateToStr(date,DATE);
    }

    //转换日期为字符串(HH:mm)
    public static String getStringByStime(Date date){
        return DateToStr(date,STIME);
    }
    //转换日期为字符串(yyyyMMddHHmmss)
    public static String getStringByDateTime2(Date date){
        return DateToStr(date,DATETIME2);
    }

//    //转换日期时间为指定格式字符串
//    public static String formatDateTime(Date myDate, String pattern) {
//        DateFormat fd = new SimpleDateFormat(pattern);
//        return fd.format(myDate);
//    }

    //计算日期（向前或向后计算days天，允许跨月跨年）
    public static Date addDay(Date date,int days){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_YEAR,days);
        return cal.getTime();
    }

    //计算日期（向前或向后计算days天，允许跨月跨年）
    public static Date addHour(Date date,int hours){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR_OF_DAY,hours);
        return cal.getTime();
    }
	public static Date addMinute(Date date, Integer minutes) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MINUTE,minutes);
        return cal.getTime();
	}

    //计算日期（向前或向后计算days天，允许跨月跨年）(yyyy-MM-dd)
    public static String addDay(String dtstring,int days){
        return getStringByDate(addDay(getDateByString(dtstring),days));
    }

    /**
     * 计算日期（向前或向后计算月份）
     * @param date
     * @param months
     * @return
     */
    public static Date addMonth(Date date, int months){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, months);
        return cal.getTime();
    }

    /**
     * 根据时间获取月份的第一天.
     * @param date
     * @return
     */
    public static Date getFristDayByDate(Date date){
        GregorianCalendar gcLast = (GregorianCalendar) Calendar.getInstance();
        gcLast.setTime(date);
        gcLast.set(Calendar.DAY_OF_MONTH, 1);
        return getDateByString(getStringByDate(gcLast.getTime()));
    }

    /**
     * 计算两个时间相差的分钟数.
     * @param sDate
     * @param eDate
     * @return
     */
    public static double calculateMintues(Date sDate, Date eDate) {
        return Math.abs((sDate.getTime() - eDate.getTime()) / (1000 * 60 * 1.0));
    }

    /**
     * 计算两个日期相差的小时数.
     * @param sDate
     * @param eDate
     * @return
     */
    public static long calculateHours(Date sDate, Date eDate) {
        return (sDate.getTime() - eDate.getTime()) / (1000 * 60 * 60);
    }

    /**
     * 计算两个日期相差的天数.
     * @param sDate
     * @param eDate
     * @return
     */
    public static long calculateDays(Date sDate, Date eDate) {
        return (sDate.getTime() - eDate.getTime()) / (1000 * 60 * 60 * 24);
    }

    /**
     * 计算两个日期相差的天数
     * @param sDate
     * @param eDate
     * @return
     */
    public static double calculateDaysAndHours(Date sDate, Date eDate) {
        return (double)(sDate.getTime() - eDate.getTime()) / (1000 * 60 * 60 * 24);
    }

    //转换字符串为日期(yyyy-MM-dd)
    public static Date transDate(Date date){
        String dateStr=getStringByDate(date);
        return getDateByString(dateStr);
    }

    /***
     * 两个日期相差多少秒
     *
     * @param sDate
     * @param eDate
     * @return
     */
    public static int getTimeDelta(Date sDate,Date eDate){
        long timeDelta=(sDate.getTime()- eDate.getTime())/1000;//单位是秒
        int secondsDelta=timeDelta>0?(int)timeDelta:(int)Math.abs(timeDelta);
        return secondsDelta;
    }


    /***
     * 两个日期相差多少秒
     * @param dateStr1  :yyyy-MM-dd HH:mm:ss
     * @param dateStr2 :yyyy-MM-dd HH:mm:ss
     */
    public static int getTimeDelta(String dateStr1,String dateStr2){
        Date date1=getDateTimeByString(dateStr1);
        Date date2=getDateTimeByString(dateStr2);
        return getTimeDelta(date1, date2);
    }

}
