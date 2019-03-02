package com.itacademy.baida.lesson13hw;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;

public class Task1 {

    public static void main(String[] args) throws IOException {
        File sourceFile = Paths.get("resources", "lesson13hw", "task1", "verse.txt").toFile();
        File targetFile = new File(String.join(File.separator, "resources", "lesson13hw",
                "task1", "lettersFrequency.txt"));
        targetFile.createNewFile();
        printLettersFrequency(sourceFile, targetFile);
    }

    private static void printLettersFrequency(File sourceFile, File targetFile) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(targetFile))) {
            Map<Character, Integer> alphabetMap = createRussianAlphabetMap();
            reader.lines().forEach(line -> {
                for (Character lineCharacter : line.toLowerCase().toCharArray()) {
                    alphabetMap.computeIfPresent(lineCharacter, (key, value) -> value + 1);
                }
            });
            for (Map.Entry<Character, Integer> entry : alphabetMap.entrySet()) {
                writer.write(String.format("%s - %d" + System.lineSeparator(), entry.getKey(), entry.getValue()));
            }
        }
    }

    private static Map<Character, Integer> createRussianAlphabetMap() {
        Map<Character, Integer> alphabetMap = new LinkedHashMap<>();
        for (Character i = 'а'; i <= 'е'; i++) {
            alphabetMap.put(i, 0);
        }
        alphabetMap.put('ё', 0);
        for (Character i = 'ж'; i <= 'я'; i++) {
            alphabetMap.put(i, 0);
        }
        return alphabetMap;
    }
}