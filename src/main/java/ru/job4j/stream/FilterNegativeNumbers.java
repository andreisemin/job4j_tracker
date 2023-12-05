package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;

public class FilterNegativeNumbers {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 5, -2, 8, -1, -9, 4);
        List<Integer> positive = numbers.stream().filter(number -> number > 0).toList();
        positive.forEach(System.out::println);
    }
}
