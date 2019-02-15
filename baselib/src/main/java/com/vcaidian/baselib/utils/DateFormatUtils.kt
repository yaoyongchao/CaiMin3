package com.vcaidian.wclib.utils

import java.text.ParseException
import java.text.ParsePosition
import java.text.SimpleDateFormat
import java.util.*



object DateFormatUtils {
    /** yyyy-MM-dd hh:mm:ss  */
    val DATE_FORMAT2 = "yyyy-MM-dd HH:mm:ss"
    /** yyyy-MM-dd  */
    val DATE_FORMAT1 = "yyyy-MM-dd"
    private val weeksWed = arrayOf("周日", "周一", "周二", "周三", "周四", "周五", "周六")
    /**
     * 秒转化为　日期时间
     */
    fun formatSecondToDate(second: Long, patten: String): String {
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = second * 1000//转换为毫秒
        val date = calendar.time
        val format = SimpleDateFormat(patten)
        return format.format(date)
    }

    fun formatSecondToM(second: Long): String {
        //		return formatSecondToDate(second,"yyyy-MM-dd hh:mm:ss");
        return formatSecondToDate(second, "yyyy-MM-dd HH:mm")
    }

    fun formatSecondToS(second: Long): String {
        //		return formatSecondToDate(second,"yyyy-MM-dd hh:mm:ss");
        return formatSecondToDate(second, "yyyy-MM-dd HH:mm:ss")
    }

    fun getWeek(sdate: String): String {
        return getCurrentWeekWed(strToDate(sdate))
    }

    fun strToDate(strDate: String): Date {
        val formatter = SimpleDateFormat("yyyyMMdd")
        val pos = ParsePosition(0)
        val strtodate = formatter.parse(strDate, pos)
        return strtodate
    }


    fun getCurrentWeekWed(value: Date): String {
        val calendar = getCalendar(value, DateFormatUtils.DATE_FORMAT1)
        val weekIndex = if (calendar.get(Calendar.DAY_OF_WEEK) - 1 < 0) 0 else calendar.get(Calendar.DAY_OF_WEEK) - 1

        return weeksWed[weekIndex]
    }

    fun getCalendar(date: Date?, format: String): Calendar {
        var date = date
        if (date == null) {
            date = getCurrentDate(format)
        }
        val calender = Calendar.getInstance()
        calender.time = date
        return calender
    }

    fun getCurrentDate(format: String): Date? {
        val sdf = DateFormatUtils.getFormat(format)
        val dateS = getCurrentTime(format)
        var date: Date? = null
        try {
            date = sdf.parse(dateS)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        return date
    }

    fun getCurrentTime(format: String): String {
        val sdf = DateFormatUtils.getFormat(format)
        val date = Date()
        return sdf.format(date)
    }

    fun getFormat(format: String?): SimpleDateFormat {
        var format = format
        if (format == null || "" == format) {
            format = DATE_FORMAT2
        }
        return SimpleDateFormat(format!!)
    }

    /**
     * 时间戳转化为小时分钟
     */
    fun getFormatHM(format: String?): SimpleDateFormat {
        var format = format
        if (format == null || "" == format) {
            format = "HH:mm:ss"
        }
        return SimpleDateFormat(format!!)
    }

    /*
     * 将时间转换为时间戳
     */
    @Throws(ParseException::class)
    fun dateToStamp(s: String): String {
        val res: String
        val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        val date = simpleDateFormat.parse(s)
        val ts = date.time
        res = ts.toString()
        return res
    }

    /**
     * 获取前几个月月份： YYYY年MM月
     * @param month
     * @return YYYY年MM月
     */
    fun getBeforeMonths(month: Int): List<String> {
        val list = ArrayList<String>()
        val format1 = SimpleDateFormat("yyyy年MM月")
        val calendarCurrent = Calendar.getInstance()
        val calendarBefore = Calendar.getInstance()

        calendarBefore.add(Calendar.MONTH, -month)
        while (calendarCurrent.after(calendarBefore)) {
            list.add(format1.format(calendarCurrent.time))
            calendarCurrent.add(Calendar.MONTH, -1)
        }

        return list
    }

}