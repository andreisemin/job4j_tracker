package ru.job4j.ex;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FactTest {
    @Test
    public void whenException() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    new Fact().calc(-1);
                });
        assertThat(exception.getMessage()).isEqualTo("N could not be less than 0");
    }

    @Test
    public void when3Then6() {
        int expected = 6;
        assertThat(new Fact().calc(3)).isEqualTo(expected);
    }
}