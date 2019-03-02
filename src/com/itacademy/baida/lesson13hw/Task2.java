package com.itacademy.baida.lesson13hw;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task2 {

    public static void main(String[] args) throws IOException {
        File targetFile = new File(String.join(File.separator, "resources", "lesson13hw", "task2", "targetFile.txt"));
        targetFile.getParentFile().mkdirs();
        targetFile.createNewFile();
        fillFileWithRandomIntegers(targetFile);
        sortFile(targetFile);
    }

    private static void fillFileWithRandomIntegers(File targetFile) throws IOException {
        Random random = new Random();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(targetFile))) {
            for (int randomValue : random.ints(100, -1000, 10000).toArray()) {
                writer.write(randomValue + System.lineSeparator());
            }
        }
    }

    private static void sortFile(File file) throws IOException {
        List<Integer> sortedIntegers;
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(file)))) {
            sortedIntegers = scanner.tokens()
                    .map(Integer::valueOf)
                    .sorted()
                    .collect(Collectors.toList());
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (Integer value : sortedIntegers) {
                writer.write(value + System.lineSeparator());
            }
        }
    }
}