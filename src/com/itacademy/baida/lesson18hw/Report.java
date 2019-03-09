package com.itacademy.baida.lesson18hw;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.StandardOpenOption.CREATE;

public final class Report {

    private Report() {
    }

    public static void generateTimePeriodsReport(Path scheduleFilePath, Path targetFilePath) throws IOException {
        targetFilePath.toFile().getParentFile().mkdirs();
        targetFilePath.toFile().createNewFile();
        Course course = new Course(scheduleFilePath);
        Files.write(targetFilePath, course.toString().getBytes(StandardCharsets.UTF_8), CREATE);
    }

    public static void generateDetailedTimeReport(Path scheduleFilePath, Path targetFilePath) throws IOException {
        targetFilePath.toFile().getParentFile().mkdirs();
        targetFilePath.toFile().createNewFile();
        Course course = new Course(scheduleFilePath);
        StringBuffer stringBuffer = new StringBuffer();
        course.getCourseSchedule()
                .forEach(day -> {
                    Integer totalTime = Activity.getDuration(day.getSchedule());
                    Integer totalLecturesTime = Activity.getDuration(day.getLecturesList());
                    stringBuffer
                            .append("\n\tДень ").append((course.getCourseSchedule().indexOf(day)) + 1).append("\n");
                    day.getActivityTypeDurationMap()
                            .forEach((activityType, duration) -> stringBuffer
                                    .append(lineFormat(activityType.getType(), duration, totalTime)));
                    stringBuffer.append("\tЛекции:\n");
                    day.getLecturesList()
                            .forEach(activity -> stringBuffer
                                    .append(lineFormat(activity.getName(), activity.getDuration(), totalLecturesTime)));
                });
        Files.write(targetFilePath, stringBuffer.toString().getBytes(StandardCharsets.UTF_8));
    }

    private static String lineFormat(String activityName, Integer activityTime, Integer totalTime) {
        String minutes = (activityTime % 100 > 10 && activityTime % 100 < 20)
                || String.valueOf(activityTime % 10).matches("[05-9]")
                ? String.format("%d минут", activityTime)
                : activityTime % 10 == 1
                ? String.format("%d минута", activityTime)
                : String.format("%d минуты", activityTime);
        return String.format("%s: %s %d%%\n", activityName, minutes, Math.getPercent(activityTime, totalTime));
    }
}