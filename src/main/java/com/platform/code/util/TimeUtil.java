package com.platform.code.util;

import java.util.Calendar;
import java.util.Date;

public class TimeUtil {

    /**
     * expiration秒后的时间
     *
     * @param expiration
     * @return
     */
    public static Date getLaterOneHoursDate(Long expiration) {
        long currentTime = System.currentTimeMillis();
        currentTime += expiration.longValue();
        Date date = new Date(currentTime);
        return date;
    }

    /**
     * 一周后的时间
     *
     * @return
     */
    public static Date getLaterOneWeekDate() {
        Date today7 = new Date();
        Calendar c7 = Calendar.getInstance();
        c7.setTime(today7);
        c7.add(Calendar.DAY_OF_MONTH, +6);
        today7 = c7.getTime();
        return today7;
    }

    /**
     * 判断当前时间距离第二天凌晨的秒数
     *
     * @return 返回值单位为[s:秒]
     */
    public static Long getSecondsNextEarlyMorning() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return (cal.getTimeInMillis() - System.currentTimeMillis()) / 1000;
    }

    /**
     * 获取明天的凌晨12点时间戳
     *
     * @return
     */
    public static Date getTomorrowBegin() {
        long currentTime = System.currentTimeMillis();
        currentTime += getSecondsNextEarlyMorning().longValue();
        Date date = new Date(currentTime);
        return date;
    }
}
