package ru.job4j.poly.ru.job4j.poly;

import ru.job4j.poly.Transport;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("The bus is driving.");
    }

    @Override
    public void passengers(int count) {
        System.out.println("Number of passengers: " + count);
    }

    @Override
    public int refuel(int fuelAmount) {
        int price = fuelAmount * 55;
        System.out.println("Refueled " + fuelAmount + " liters of fuel.");
        return price;
    }
}
