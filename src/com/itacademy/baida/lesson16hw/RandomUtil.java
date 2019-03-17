package com.itacademy.baida.lesson16hw;

import lombok.experimental.UtilityClass;

import java.util.Random;

@UtilityClass
public class RandomUtil {

    private static final Random RANDOM = new Random();

    public static int next() {
        return RANDOM.nextInt(4) + 1;
    }

    public static int next(int value) {
        return RANDOM.nextInt(value);
    }
}
