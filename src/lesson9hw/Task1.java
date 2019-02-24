package lesson9hw;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Task1 {

    public static void main(String[] args) {
        String text = "I live in a big city. There is a wonderful zoo in my city. I like to go there with my parents. " +
                "There are a lot of funny animals in it. They are elephants, lions, monkeys, tigers, and others. " +
                "There are a lot of different birds, too. I like to go to the zoo very much!";
        text = text.replaceAll("[,.?!:;\"'()]", "");
        String[] wordsArray = text.split(" ");
        System.out.println(":: Unique words = its' frequency in the initial text ::\n" + getWordFrequency(wordsArray));
    }

    private static Map<String, Integer> getWordFrequency(String[] stringArray) {
        Map<String, Integer> wordFrequency = new HashMap<>();
        Arrays.stream(stringArray).forEach(word ->
                wordFrequency.compute(word, (key, value) -> (value == null) ? 1 : value + 1));
        return wordFrequency;
    }
}