package com.itacademy.baida.lesson18hw;

public final class Math {

    private Math() {
    }

    public static long getPercent(double target, double total) {
        return java.lang.Math.round(target / total * 100);
    }
}
