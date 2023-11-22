package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] sortLeft = left.split("\\.");
        String[] sortRight = right.split("\\.");
        return Integer.compare(Integer.parseInt(sortLeft[0]), Integer.parseInt(sortRight[0]));
    }
}
