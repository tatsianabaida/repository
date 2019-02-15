package lesson8hw;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Task1 {

    public static void main(String[] args) {
        List<String> stringLinkedList = new LinkedList<>();
        stringLinkedList.add("this");
        stringLinkedList.add("is");
        stringLinkedList.add("lots");
        stringLinkedList.add("of");
        stringLinkedList.add("fun");
        stringLinkedList.add("for");
        stringLinkedList.add("every");
        stringLinkedList.add("Java");
        stringLinkedList.add("programmer");
        System.out.println("Initial list :: " + stringLinkedList);
        System.out.println("Modified list :: " + markLength4(stringLinkedList));
    }

    private static List<String> markLength4(List<String> list) {
        ListIterator<String> iterator = list.listIterator(list.size());
        while (iterator.hasPrevious()) {
            if (iterator.previous().length() == 4) {
                iterator.add("****");
                iterator.previous();
            }
        }
        return list;
    }
}