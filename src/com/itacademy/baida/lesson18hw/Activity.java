package com.itacademy.baida.lesson18hw;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class Activity {

    private Time startTime;
    private Time endTime;
    private String name;
    private Type type;

    public Integer getDuration() {
        return startTime.getDuration(endTime);
    }

    public static Integer getDuration(List<Activity> list) {
        return list.stream()
                .map(Activity::getDuration)
                .reduce(0, (acc, next) -> acc + next);
    }

    @Override
    public String toString() {
        return String.format("%s-%s %s", startTime, endTime, name);
    }

    @Getter
    @AllArgsConstructor
    enum Type {

        LECTURE("Лекции"),
        EXERCISE("Упражнения"),
        PRACTISE("Решения"),
        LUNCH("Обеденный перерыв"),
        BREAK("Перерыв");

        private final String type;
    }
}