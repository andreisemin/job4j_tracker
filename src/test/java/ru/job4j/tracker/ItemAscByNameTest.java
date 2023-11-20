package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

class ItemAscByNameTest {

    @Test
    public void whenListAsc() {
        List<Item> items = Arrays.asList(
                new Item(4, "Fix bugs"),
                new Item(4, "Uhj hjk"),
                new Item(1, "Rghj fdf"),
                new Item(6, "Ahux gfdd"));
        items.sort(new ItemAscByName());
        List<Item> expected = Arrays.asList(
                new Item(6, "Ahux gfdd"),
                new Item(4, "Fix bugs"),
                new Item(1, "Rghj fdf"),
                new Item(4, "Uhj hjk"));
        assertThat(items.equals(expected)).isTrue();
    }

    @Test
    public void whenListNotAsc() {
        List<Item> items = Arrays.asList(
                new Item(4, "Fix bugs"),
                new Item(4, "Uhj hjk"),
                new Item(1, "Rghj fdf"),
                new Item(6, "Ahux gfdd"));
        items.sort(new ItemAscByName());
        List<Item> expected = Arrays.asList(
                new Item(1, "Rghj fdf"),
                new Item(4, "Fix bugs"),
                new Item(6, "Ahux gfdd"),
                new Item(4, "Uhj hjk"));
        assertThat(items.equals(expected)).isFalse();
    }
}