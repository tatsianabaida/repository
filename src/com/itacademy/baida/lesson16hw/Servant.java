package com.itacademy.baida.lesson16hw;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import static com.itacademy.baida.lesson16hw.TimeUtil.DAYS_AMOUNT;
import static com.itacademy.baida.lesson16hw.TimeUtil.DAY_LENGTH;

@Getter
public class Servant extends Thread {

    private CrazyScientist scientist;
    private List<RobotDetail> collectedDetails;
    private RubbishDump rubbishDump = RubbishDump.getInstance();

    public Servant(@NotNull String name, CrazyScientist scientist) {
        super(name);
        this.scientist = scientist;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < DAYS_AMOUNT; i++) {
                synchronized (rubbishDump.getRobotDetails()) {
                    System.out.printf(System.lineSeparator() + "%s is here!", getName());
                    System.out.printf(System.lineSeparator() + getName() + "Initial RubbishDump size: %d" + System.lineSeparator(),
                            rubbishDump.getRobotDetails().size());

                    if (!rubbishDump.getRobotDetails().isEmpty()) {
                        int plannedToCollect = RandomUtil.next();
                        if (rubbishDump.getRobotDetails().size() > plannedToCollect) {
                            collectedDetails = rubbishDump.getRobotDetails().subList(0, plannedToCollect);
                            rubbishDump.setRobotDetails(new ArrayList<>(rubbishDump.getRobotDetails()
                                    .subList(plannedToCollect, rubbishDump.getRobotDetails().size())));

                            System.out.printf("%s Collects %s details: %s" + System.lineSeparator(), getName(),
                                    plannedToCollect, collectedDetails);
                        } else {
                            collectedDetails = new ArrayList<>(rubbishDump.getRobotDetails());
                            rubbishDump.getRobotDetails().clear();

                            System.out.printf("%sCollects all remaining details from RubbishDump: %s%s",
                                    getName(), collectedDetails, System.lineSeparator());
                        }
                        System.out.printf(getName() + "New RubbishDump size: %d" + System.lineSeparator(),
                                rubbishDump.getRobotDetails().size());
                        System.out.printf(getName() + "RubbishDump elements: %s" + System.lineSeparator(),
                                rubbishDump.getRobotDetails());
                        System.out.printf(getName() + "Own collection size: %d" + System.lineSeparator(),
                                collectedDetails.size());
                    } else {
                        System.out.println(getName() + "Cannot collect anything as RubbishDump is empty.");
                    }
                }
                synchronized (scientist.getRobotDetails()) {
                    if (!collectedDetails.isEmpty()) {
                        collectedDetails.forEach(detail ->
                                scientist.getRobotDetails().compute(detail, (key, value) -> value + 1));
                        collectedDetails.clear();

                        System.out.println(getName() + "Gives details to the scientist");
                        System.out.printf(getName() + "Own collection size: %d" + System.lineSeparator(),
                                collectedDetails.size());
                        System.out.println(getName() + "Scientist's details :: " + scientist.getRobotDetails());
                    }
                    scientist.getRobotDetails().notify();
                }
                Thread.sleep(DAY_LENGTH);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}