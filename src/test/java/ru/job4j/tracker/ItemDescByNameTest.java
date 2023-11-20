package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ItemDescByNameTest {

    @Test
    public void whenListDesc() {
        List<Item> items = Arrays.asList(
                new Item(4, "Fix bugs"),
                new Item(4, "Uhj hjk"),
                new Item(1, "Rghj fdf"),
                new Item(6, "Ahux gfdd"));
        items.sort(new ItemDescByName());
        List<Item> expected = Arrays.asList(
                new Item(4, "Uhj hjk"),
                new Item(1, "Rghj fdf"),
                new Item(4, "Fix bugs"),
                new Item(6, "Ahux gfdd"));
        assertThat(items.equals(expected)).isTrue();
    }

    @Test
    public void whenListNotDesc() {
        List<Item> items = Arrays.asList(
                new Item(4, "Fix bugs"),
                new Item(4, "Uhj hjk"),
                new Item(1, "Rghj fdf"),
                new Item(6, "Ahux gfdd"));
        items.sort(new ItemDescByName());
        List<Item> expected = Arrays.asList(
                new Item(1, "Rghj fdf"),
                new Item(4, "Fix bugs"),
                new Item(6, "Ahux gfdd"),
                new Item(4, "Uhj hjk"));
        assertThat(items.equals(expected)).isFalse();
    }
}