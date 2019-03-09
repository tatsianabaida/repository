package com.itacademy.baida.lesson18hw;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
@Setter
public class Course implements LecturesList {

    private List<Day> courseSchedule = new ArrayList<>();

    public Course(Path scheduleFilePath) throws IOException {
        String courseSchedule = ScheduleFileHandler.addEndActivityTime(scheduleFilePath);
        Arrays.stream(ScheduleFileHandler.splitToDays(courseSchedule))
                .map(ScheduleFileHandler::mapToActivities)
                .forEach(activitiesList -> this.courseSchedule.add(Day.builder().schedule(activitiesList).build()));
    }

    public List<Activity> getLecturesList() {
        List<Activity> lecturesList = new ArrayList<>();
        courseSchedule.stream()
                .map(Day::getLecturesList)
                .iterator()
                .forEachRemaining(lecturesList::addAll);
        return lecturesList;
    }

    public String lecturesListToString() {
        return courseSchedule.stream()
                .map(Day::lecturesListToString)
                .collect(Collectors.joining("\n"));
    }

    @Override
    public String toString() {
        return courseSchedule.stream()
                .map(Day::toString)
                .collect(Collectors.joining("\n\n"));
    }
}