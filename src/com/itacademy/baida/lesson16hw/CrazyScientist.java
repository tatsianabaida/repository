package com.itacademy.baida.lesson16hw;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.itacademy.baida.lesson16hw.TimeUtil.DAYS_AMOUNT;
import static java.util.function.Function.identity;

@Getter
public class CrazyScientist extends Thread {

    public static final Set<RobotDetail> PARTS_NEEDED_FOR_ROBOT = new HashSet<>(Arrays.asList(RobotDetail.values()));

    private List<Robot> robots = new ArrayList<>();
    private Map<RobotDetail, Integer> robotDetails = PARTS_NEEDED_FOR_ROBOT.stream()
            .collect(Collectors.toMap(identity(), it -> 0));

    public CrazyScientist(@NotNull String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < DAYS_AMOUNT; i++) {
                synchronized (getRobotDetails()) {
                    robotDetails.wait();
                    System.out.printf("%s%sWoke up!%s", System.lineSeparator(),
                            getName(), System.lineSeparator());
                    while (getRobotDetails().values().stream().min(Comparator.naturalOrder()).get() > 0) {
                        robotDetails.keySet()
                                .forEach(key -> getRobotDetails().compute(key, (k, value) -> value - 1));
                        robots.add(new Robot(PARTS_NEEDED_FOR_ROBOT));
                        System.out.println(getName() + "\tNew robot is created!");
                        System.out.println(getName() + "Amount of robots: " + robots.size());
                        System.out.println(getName() + "Remaining robot details: " + getRobotDetails());
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
