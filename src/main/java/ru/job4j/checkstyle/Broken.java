package ru.job4j.checkstyle;

public class Broken {

    private int sizeOfEmpty() {
        return 10;
    }

    public String surname() {
        String name = "Andrei";
        return name;
    }

    public static final String NEW_VALUE = "новое значение";

    public void echo() {
    }

    public void media(Object obj) {
        if (obj != null) {
            System.out.println(obj);
        }
    }

    public void method(int a, int b, int c, int d, int e, int f, int g) {
    }

    public Broken() {
    }
}

