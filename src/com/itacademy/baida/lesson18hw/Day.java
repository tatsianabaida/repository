package com.itacademy.baida.lesson18hw;

import com.itacademy.baida.lesson18hw.Activity.Type;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Builder
@Getter
@Setter

public class Day implements LecturesList {

    private List<Activity> schedule;

    public Map<Type, Integer> getActivityTypeDurationMap() {
        Map<Type, Integer> activityTypeMap = new LinkedHashMap<>();
        Arrays.stream(Type.values())
                .forEach(type -> activityTypeMap.put(type, Activity.getDuration(filterActivitiesByType(type))));
        return activityTypeMap;
    }

    public List<Activity> filterActivitiesByType(Type type) {
        return schedule.stream()
                .filter(activity -> activity.getType().equals(type))
                .collect(Collectors.toList());
    }

    public List<Activity> getLecturesList() {
        return filterActivitiesByType(Type.LECTURE);
    }

    public String lecturesListToString() {
        return getLecturesList().stream()
                .map(Activity::getName)
                .collect(Collectors.joining("\n"));
    }

    @Override
    public String toString() {
        return schedule.stream()
                .map(Activity::toString)
                .collect(Collectors.joining("\n"));
    }
}