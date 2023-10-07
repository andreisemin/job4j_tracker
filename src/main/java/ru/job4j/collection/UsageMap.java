package ru.job4j.collection;
import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("andr-syomin@yandex.ru", "Andrei Semin");
        map.put("andr-syomin@yandex.ru", "Andrei Semin Vladimirovich");
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " = " + value);
        }
    }
}
