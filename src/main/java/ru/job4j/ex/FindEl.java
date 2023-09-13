package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if (value[i].equals(key)) {
                rsl = i;
                break;
            }
        }
        if (rsl == -1) {
            throw new ElementNotFoundException("Element not found in the array");
        }
        return rsl;
    }

    public static void main(String[] args) {
        String[] array = {"One", "Two", "Three"};
        String key = "Four";
        try {
            int index = FindEl.indexOf(array, key);
            System.out.println("Element found at index: " + index);
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
