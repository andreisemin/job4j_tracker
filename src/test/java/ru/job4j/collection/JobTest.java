package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.ItemAscByName;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;

class JobTest {

    @Test
    public void whenListAscByName() {
        List<Job> jobs = Arrays.asList(
                new Job("Fix bugs", 5),
                new Job("Uhj hjk", 3),
                new Job("Rghj fdf", 1),
                new Job("Ahux gfdd", 6));
        jobs.sort(new JobAscByName());
        List<Job> expected = Arrays.asList(
                new Job("Ahux gfdd", 6),
                new Job("Fix bugs", 5),
                new Job("Rghj fdf", 1),
                new Job("Uhj hjk", 3));
        assertThat(jobs.equals(expected)).isTrue();
    }

    @Test
    public void whenListDescByName() {
        List<Job> jobs = Arrays.asList(
                new Job("Fix bugs", 5),
                new Job("Uhj hjk", 3),
                new Job("Rghj fdf", 1),
                new Job("Ahux gfdd", 6));
        jobs.sort(new JobDescByName());
        List<Job> expected = Arrays.asList(
                new Job("Uhj hjk", 3),
                new Job("Rghj fdf", 1),
                new Job("Fix bugs", 5),
                new Job("Ahux gfdd", 6));
        assertThat(jobs.equals(expected)).isTrue();
    }

    @Test
    public void whenListAscByPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("Fix bugs", 5),
                new Job("Uhj hjk", 3),
                new Job("Rghj fdf", 1),
                new Job("Ahux gfdd", 6));
        jobs.sort(new JobAscByPriority());
        List<Job> expected = Arrays.asList(
                new Job("Rghj fdf", 1),
                new Job("Uhj hjk", 3),
                new Job("Fix bugs", 5),
                new Job("Ahux gfdd", 6));
        assertThat(jobs.equals(expected)).isTrue();
    }

    @Test
    public void whenListDescByPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("Fix bugs", 5),
                new Job("Uhj hjk", 3),
                new Job("Rghj fdf", 1),
                new Job("Ahux gfdd", 6));
        jobs.sort(new JobDescByPriority());
        List<Job> expected = Arrays.asList(
                new Job("Ahux gfdd", 6),
                new Job("Fix bugs", 5),
                new Job("Uhj hjk", 3),
                new Job("Rghj fdf", 1));
        assertThat(jobs.equals(expected)).isTrue();
    }

    @Test
    public void whenCompatorDescByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Fix bugs", 5),
                new Job("Fix bugs", 3));
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenCompatorAscByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Fix bugs", 3),
                new Job("Fix bugs", 5));
        assertThat(rsl).isLessThan(0);
    }
}