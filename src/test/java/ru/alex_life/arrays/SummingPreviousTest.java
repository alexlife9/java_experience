package ru.alex_life.arrays;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

/**
 * Упражнения курса job4j
 * 1.1.6. Массивы
 * 1.9. Суммирования предыдущих значений
 *
 * Даны целые числа n (> 2), a и b. Сформировать и вывести (без первых двух элементов) целочисленный массив размера n,
 * первый элемент которого равен a, второй равен b, а каждый последующий элемент равен сумме всех предыдущих.
 *
 * @author Alex_life
 * @version 1.0
 * @since 02.12.2021
 */
public class SummingPreviousTest {

    @Test
    public void test() {
       assertArrayEquals(new int[] {1, 2, 3}, SummingPrevious.calculate(1, 2, 3));
       assertArrayEquals(new int[] {2, 2, 4, 8}, SummingPrevious.calculate(2, 2, 4));
       assertArrayEquals(new int[] {1, 2, 3, 6, 12}, SummingPrevious.calculate(1, 2, 5));
    }

}
