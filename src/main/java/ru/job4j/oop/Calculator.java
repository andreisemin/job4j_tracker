package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public static int sum(int y) {
        return y + x;
    }

    public static int minus(int y) {
        return y - x;
    }

    public int divide(int y) {
        return y / x;
    }

    public int multiply(int y) {
        return y * x;
    }

    public int sumAllOperation(int y) {
        return sum(y) + multiply(y) + minus(y) + divide(y);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int y = 10;
        System.out.println("Сумма: " + sum(y));
        System.out.println("Умножение: " + calculator.multiply(y));
        System.out.println("Вычитание: " + minus(y));
        System.out.println("Деление: " + calculator.divide(y));
        System.out.println("Сумма всех операций: " + calculator.sumAllOperation(y));

    }
}
