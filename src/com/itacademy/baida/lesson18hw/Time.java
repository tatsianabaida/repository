package com.itacademy.baida.lesson18hw;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Getter
@Setter
@Builder
public class Time {

    private static final String TIME_REGEX = "^0?(?<time>..?)$";
    private static final Integer MINUTES_IN_HOUR = 60;

    private String hours;
    private String minutes;

    public Integer getDuration(Time time) {
        return java.lang.Math.abs((toIntegerTime(time.getHours()) * MINUTES_IN_HOUR + toIntegerTime(time.getMinutes()))
                - (toIntegerTime(hours) * MINUTES_IN_HOUR + toIntegerTime(minutes)));
    }

    private static Integer toIntegerTime(String time) {
        Matcher matcher = Pattern.compile(TIME_REGEX).matcher(time);
        matcher.matches();
        return Integer.valueOf(matcher.group("time"));
    }

    @Override
    public String toString() {
        return String.format("%s:%s", hours, minutes);
    }
}