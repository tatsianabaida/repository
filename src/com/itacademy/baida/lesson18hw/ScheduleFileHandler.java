package com.itacademy.baida.lesson18hw;

import com.itacademy.baida.lesson18hw.Activity.Type;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ScheduleFileHandler {

    private final static String DAY_DELIMITER_REGEX = "(\\r\\n){2}";
    private final static String ACTIVITY_REGEX = "(?<startHours>\\d{2}):(?<startMinutes>\\d{2}) " +
            "(?<endHours>\\d{2}):(?<endMinutes>\\d{2}) (?<name>.+?)\\r\\n";
    private final static String END_TIME_REGEX = " .+?\\r\\n(?<endTime>\\d{2}:\\d{2})";

    private ScheduleFileHandler() {
    }

    public static String addEndActivityTime(Path path) throws IOException {
        StringBuffer courseSchedule = new StringBuffer();
        Matcher matcher = Pattern.compile(END_TIME_REGEX).matcher(Files.readString(path));
        while (matcher.find()) {
            matcher.appendReplacement(courseSchedule,
                    String.format(" %s%s", matcher.group("endTime"), matcher.group(0)));
        }
        return courseSchedule.toString();
    }

    public static String[] splitToDays(String courseSchedule) {
        return courseSchedule.split(DAY_DELIMITER_REGEX);
    }

    public static List<Activity> mapToActivities(String daySchedule) {
        Matcher matcher = Pattern.compile(ACTIVITY_REGEX).matcher(daySchedule);
        List<Activity> activitiesList = new ArrayList<>();
        while (matcher.find()) {
            Activity activity = Activity.builder()
                    .startTime(Time.builder()
                            .hours(matcher.group("startHours"))
                            .minutes(matcher.group("startMinutes"))
                            .build())
                    .endTime(Time.builder()
                            .hours(matcher.group("endHours"))
                            .minutes(matcher.group("endMinutes"))
                            .build())
                    .name(matcher.group("name"))
                    .build();
            switch (matcher.group("name")) {
                case "Упражнения":
                    activity.setType(Type.EXERCISE);
                    break;
                case "Решения":
                    activity.setType(Type.PRACTISE);
                    break;
                case "Обеденный перерыв":
                    activity.setType(Type.LUNCH);
                    break;
                case "Перерыв":
                    activity.setType(Type.BREAK);
                    break;
                default:
                    activity.setType(Type.LECTURE);
            }
            activitiesList.add(activity);
        }
        return activitiesList;
    }
}