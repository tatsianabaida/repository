package com.itacademy.baida.lesson16hw;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.util.stream.IntStream;

import static com.itacademy.baida.lesson16hw.TimeUtil.DAYS_AMOUNT;
import static com.itacademy.baida.lesson16hw.TimeUtil.DAY_LENGTH;

@Getter
public class Factory extends Thread {

    private RubbishDump rubbishDump = RubbishDump.getInstance();

    public Factory(@NotNull String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < DAYS_AMOUNT; i++) {
                int detailsAmount = RandomUtil.next();
                throwDetails(detailsAmount);
                Thread.sleep(DAY_LENGTH);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void throwDetails(int amount) {
        System.out.printf("%sFactory %s attempts to throw details\n", System.lineSeparator(), getName());
        synchronized (rubbishDump.getRobotDetails()) {
            System.out.printf("%sInitial amount of details : %d%s", getName(), rubbishDump.getRobotDetails().size(),
                    System.lineSeparator());
            IntStream.range(0, amount).forEach(i -> {
                rubbishDump.getRobotDetails().add(getRandomDetail());
                System.out.printf("\t\tFactory threw %s" + System.lineSeparator(),
                        rubbishDump.getRobotDetails().get(rubbishDump.getRobotDetails().size() - 1).getDescription());
            });
            System.out.printf("%s%d details are thrown.%s", getName(), amount, System.lineSeparator());
            System.out.println("Size: " + rubbishDump.getRobotDetails().size());
        }
    }

    public static RobotDetail getRandomDetail() {
        RobotDetail[] values = RobotDetail.values();
        return values[RandomUtil.next(RobotDetail.values().length)];
    }
}
