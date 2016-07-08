package com.rafakob.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class StringUtils {

    public static String bytesToString(long bytes) {
        int unit = 1024;
        if (bytes < unit) return bytes + " B";
        int exp = (int) (Math.log(bytes) / Math.log(unit));
        String pre = ("KMGTPE").charAt(exp - 1) + "";
        return String.format(Locale.US, "%.1f %sB", bytes / Math.pow(unit, exp), pre);
    }

    public static String capitalize(String input) {
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }

    public static String millisToString(long millis) {
        if (millis < 1000) {
            return String.format("0 %s", "secs");
        }
        String[] units = {
                "day", "hour", "min", "sec"
        };
        long[] times = new long[4];
        times[0] = TimeUnit.DAYS.convert(millis, TimeUnit.MILLISECONDS);
        millis -= TimeUnit.MILLISECONDS.convert(times[0], TimeUnit.DAYS);
        times[1] = TimeUnit.HOURS.convert(millis, TimeUnit.MILLISECONDS);
        millis -= TimeUnit.MILLISECONDS.convert(times[1], TimeUnit.HOURS);
        times[2] = TimeUnit.MINUTES.convert(millis, TimeUnit.MILLISECONDS);
        millis -= TimeUnit.MILLISECONDS.convert(times[2], TimeUnit.MINUTES);
        times[3] = TimeUnit.SECONDS.convert(millis, TimeUnit.MILLISECONDS);
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            if (times[i] > 0) {
                s.append(String.format("%d %s%s, ", times[i], units[i], times[i] == 1 ? "" : "s"));
            }
        }
        return s.toString().substring(0, s.length() - 2);
    }

    public static String leftTimeToString(long millis) {
        if (millis < 1000) {
            return String.format("0 %s", "secs");
        }
        String[] units = {
                "day", "hour", "min", "sec"
        };
        long[] times = new long[4];
        times[0] = TimeUnit.DAYS.convert(millis, TimeUnit.MILLISECONDS);
        millis -= TimeUnit.MILLISECONDS.convert(times[0], TimeUnit.DAYS);
        times[1] = TimeUnit.HOURS.convert(millis, TimeUnit.MILLISECONDS);
        millis -= TimeUnit.MILLISECONDS.convert(times[1], TimeUnit.HOURS);
        times[2] = TimeUnit.MINUTES.convert(millis, TimeUnit.MILLISECONDS);
        millis -= TimeUnit.MILLISECONDS.convert(times[2], TimeUnit.MINUTES);
        times[3] = TimeUnit.SECONDS.convert(millis, TimeUnit.MILLISECONDS);
        StringBuilder s = new StringBuilder();

        if (times[0] > 0) {
            times[2] = 0;
            times[3] = 0;
        } else if (times[1] > 0) {
            times[3] = 0;
        }


        for (int i = 0; i < 4; i++) {
            if (times[i] > 0) {
                s.append(String.format("%d %s%s, ", times[i], units[i], times[i] == 1 ? "" : "s"));
            }
        }
        return s.toString().substring(0, s.length() - 2);
    }

    public static String getLocaleDate(long milliSeconds) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milliSeconds);
        DateFormat formatter = SimpleDateFormat.getDateTimeInstance();
        return formatter.format(calendar.getTime());
    }

    public static String getDate(long milliSeconds, String dateFormat) {
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat, Locale.getDefault());
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milliSeconds);
        return formatter.format(calendar.getTime());
    }

    public static String concatWithComma(String... s) {
        String text = "";
        for (int i = 0; i < s.length; i++) {
            text += s[i] + ",";
        }
        return text.substring(0, text.length() - 1);
    }

}
