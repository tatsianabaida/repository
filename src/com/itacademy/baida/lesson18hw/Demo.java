package com.itacademy.baida.lesson18hw;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Demo {

    public static void main(String[] args) throws IOException {
        Path scheduleFilePath = Paths.get("resources", "lesson18hw", "log-file.txt");
        Path report1 = Paths.get("resources", "lesson18hw", "reports", "TimePeriodsReport.txt");
        Path report2 = Paths.get("resources", "lesson18hw", "reports", "DetailedTimeReport.txt");
        Report.generateTimePeriodsReport(scheduleFilePath, report1);
        Report.generateDetailedTimeReport(scheduleFilePath, report2);
    }
}
