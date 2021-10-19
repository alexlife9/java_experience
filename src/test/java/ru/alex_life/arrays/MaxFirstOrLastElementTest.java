package ru.alex_life.arrays;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Упражнения курса job4j
 * 1.1.6. Массивы
 * 0.7. Максимум из первого и последнего элемента массива
 *
 * В этом задании продолжим закреплять индексацию в массиве, а также то,
 * что первый элемент имеет индекс 0, а последний имя_массива.length - 1.
 *
 * Необходимо реализовать метод, который принимает массив целочисленных значений,
 * сравнивает между собой первый и последний элемент и возвращает максимальное из двух значений.
 *
 * @author Alex_life
 * @version 1.0
 * @since 19.10.2021
 */
public class MaxFirstOrLastElementTest {

    @Test
    public void getMaxValueFirstElement() {
        int[] in = {5, 4, 3, 2, 1};
        int expected = 5;
        int rsl = MaxFirstOrLastElement.getMaxValue(in);
        assertThat(rsl, is(expected));
    }

    @Test
    public void getMaxValueLastElement() {
        int[] in = {1, 2, 3, 4, 5};
        int expected = 5;
        int rsl = MaxFirstOrLastElement.getMaxValue(in);
        assertThat(rsl, is(expected));
    }
}
