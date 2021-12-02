package ru.alex_life.arrays;


import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Упражнения курса job4j
 * 1.1.6. Массивы
 * 1.8. Транспонировать матрицу
 *
 * Дана матрица n на m. Транспонирование матрицы, это когда строки исходной матрицы, становятся столбцами в результирующей матрице
 * Например:
 * {1, 2, 3}
 * {4, 5, 6}
 * на выходе должно стать:
 * {1, 4}
 * {2, 5}
 * {3, 6}
 *
 * @author Alex_life
 * @version 1.0
 * @since 02.12.2021
 */
public class TranspositionTest {

    @Test
    public void whenSquare() {
        int[][] input = {
                {1, 2},
                {3, 4}
        };
        int[][] expect = {
                {1, 3},
                {2, 4}
        };
        assertArrayEquals(expect, Transposition.convert(input));
    }

    @Test
    public void whenNotSquare() {
        int[][] input = {
                {1, 2, 3},
                {4, 5, 6}
        };
        int[][] expect = {
                {1, 4},
                {2, 5},
                {3, 6}
        };
        assertArrayEquals(expect, Transposition.convert(input));
    }

    @Test
    public void whenNotSquare2() {
        int[][] input = {
                {1, 4},
                {2, 5},
                {3, 6}
        };
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6}
        };
        assertArrayEquals(expect, Transposition.convert(input));
    }

}
