package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.*;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> nameContainsKey = i -> i.getName().contains(key);
        Predicate<Person> surnameContainsKey = i -> i.getSurname().contains(key);
        Predicate<Person>  phoneContainsKey = i -> i.getPhone().contains(key);
        Predicate<Person> addressContainsKey = i -> i.getAddress().contains(key);
        Predicate<Person> combine = nameContainsKey.or(surnameContainsKey).or(phoneContainsKey).or(addressContainsKey);
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
