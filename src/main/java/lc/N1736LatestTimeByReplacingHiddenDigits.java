package lc;

/**
 * description: 给你一个字符串 time ，格式为 hh:mm（小时：分钟），其中某几位数字被隐藏（用 ? 表示）。
 * 有效的时间为 00:00 到 23:59 之间的所有时间，包括 00:00 和 23:59 。
 * 替换time 中隐藏的数字，返回你可以得到的最晚有效时间。
 *
 * @author hawdies
 * @date 2021/7/24
 **/
public class N1736LatestTimeByReplacingHiddenDigits {
    public String maximumTime(String time) {
        String[] split = time.split(":");
        String hour = split[0];
        String minute = split[1];
        hour = parseHour(hour);
        minute = parseMinute(minute);
        return hour + ":" + minute;
    }

    private String parseMinute(String minute) {
        if (minute.charAt(0) == '?' && minute.charAt(1) == '?') {
            return "59";
        } else if (minute.charAt(0) == '?') {
            return "" + 5 + minute.charAt(1);
        } else if (minute.charAt(1) == '?') {
            return "" + minute.charAt(0) + 9;
        } else {
            return minute;
        }
    }

    private String parseHour(String hour) {
        if (hour.charAt(0) == '?' && hour.charAt(1) == '?') {
            return "23";
        } else if (hour.charAt(0) == '?') {
            int lastDigit = Integer.parseInt("" + hour.charAt(1));
            if (lastDigit > 3) {
                return "" + 1 + hour.charAt(1);
            } else {
                return "" + 2 + hour.charAt(1);
            }
        } else if (hour.charAt(1) == '?') {
            int firstDigit = Integer.parseInt("" + hour.charAt(0));
            if (firstDigit == 2) {
                return "23";
            } else {
                return "" + hour.charAt(0) + 9;
            }
        } else {
            return hour;
        }
    }
}
