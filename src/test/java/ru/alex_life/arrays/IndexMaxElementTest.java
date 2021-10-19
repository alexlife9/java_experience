package ru.alex_life.arrays;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Упражнения курса job4j
 * 1.1.6. Массивы
 * 0.8. Индекс максимального значения массива
 *
 * Метод должен вернуть ИНДЕКС элемента, который является максимальным из двух: первый элемент или последний элемент.
 *
 * @author Alex_life
 * @version 1.0
 * @since 19.10.2021
 */
public class IndexMaxElementTest {

    @Test
    public void getIndexMaxIs4() {
        int[] in = {1, 2, 3, 4, 5};
        int expected = 4;
        int rsl = IndexMaxElement.getIndexMax(in);
        assertThat(rsl, is(expected));
    }

    @Test
    public void getIndexMaxIs0() {
        int[] in = {5, 4, 3, 2, 1};
        int expected = 0;
        int rsl = IndexMaxElement.getIndexMax(in);
        assertThat(rsl, is(expected));
    }
}
