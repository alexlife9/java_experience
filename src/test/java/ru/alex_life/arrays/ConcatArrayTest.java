package ru.alex_life.arrays;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Упражнения курса job4j
 * 1.1.6. Массивы
 * 0.4. Размер массива
 *
 * Даны 2 массива чисел. Необходимо определить общий размер массива при их объединении.
 *
 * @author Alex_life
 * @version 1.0
 * @since 19.10.2021
 */
public class ConcatArrayTest {
    @Test
    public void whenMethodReturnResultEight() {
        int[] a = {1, 2, 3};
        int[] b = {4, 5, 6, 7, 8};
        int expected = 8;
        int rsl = ConcatArray.combineSize(a, b);
        assertThat(expected, is(rsl));
    }

    @Test
    public void whenMethodReturnResultTwelve() {
        int[] a = {1, 2, 3, 4};
        int[] b = {4, 5, 6, 7, 8, 9, 10, 11};
        int expected = 12;
        int rsl = ConcatArray.combineSize(a, b);
        assertThat(expected, is(rsl));
    }
}
