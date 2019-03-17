package com.itacademy.baida.lesson16hw;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RobotDetail {

    HEAD("Head"),
    BODY("Body"),
    LEFT_HAND("Left hand"),
    RIGHT_HAND("Right hand"),
    LEFT_LEG("Left leg"),
    RIGHT_LEG("Right leg"),
    CPU("CPU"),
    RAM("RAM"),
    HDD("HDD");

    private String description;
}