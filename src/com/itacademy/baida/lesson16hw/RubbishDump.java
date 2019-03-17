package com.itacademy.baida.lesson16hw;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RubbishDump {

    private static volatile RubbishDump ourInstance;

    private List<RobotDetail> robotDetails = new ArrayList<>();

    public static RubbishDump getInstance() {
        if (ourInstance == null) {
            synchronized (RubbishDump.class) {
                if (ourInstance == null) {
                    ourInstance = new RubbishDump();
                }
            }
        }
        return ourInstance;
    }
}
