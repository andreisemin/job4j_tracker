package ru.job4j.cast;

public class PolyVehicle {
    public static void main(String[] args) {
        Vehicle airplane = new Airplane();
        Vehicle train = new Train();
        Vehicle bus = new Bus();
        Vehicle[] vehicle = new Vehicle[]{airplane, train, bus};
        for (Vehicle a : vehicle) {
            a.move();
        }
    }
}
