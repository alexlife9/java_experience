package ru.alex_life.arrays;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Упражнения курса job4j
 * 1.1.6. Массивы
 * 0.1. Проверить сортировку массива
 *
 * Задан числовой массив. Необходимо написать программу, которая проверит, что массив отсортирован по возрастанию.
 * Сортировать массив не нужно!
 *
 * @author Alex_life
 * @version 1.0
 * @since 19.10.2021
 */
public class SortedTest {

    @Test
    public void whenSorted() {
        assertThat(
                Sorted.isSorted(
                        new int[] {1, 2, 3}
                ),
                is(true)
        );
    }

    @Test
    public void whenNotSorted() {
        assertThat(
                Sorted.isSorted(
                        new int[] {1, 3, 2}
                ),
                is(false)
        );
    }
}
