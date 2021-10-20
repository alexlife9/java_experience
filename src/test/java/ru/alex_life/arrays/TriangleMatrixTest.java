package ru.alex_life.arrays;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Упражнения курса job4j
 * 1.1.6. Массивы
 * 1.7. Заполнить треугольную матрицу
 *
 * Треугольная матрица, это матрица вида:
 * 1
 * 2 3
 * 4 5 6
 *
 * Дано количество строк в результирующей матрице. Нужно заполнить ее.
 * Например, для одной строки:
 * {{1}}
 *
 * Для двух строк:
 * {1}
 * {2, 3}
 *
 * @author Alex_life
 * @version 1.0
 * @since 20.10.2021
 */
public class TriangleMatrixTest {

    @Test
    public void whenRows1() {
        int[][] result = {
                {1}
        };
        assertArrayEquals(result, TriangleMatrix.rows(1));
    }

    @Test
    public void whenRows2() {
        int[][] result = {
                {1}, {2, 3}
        };
        assertArrayEquals(result, TriangleMatrix.rows(2));
    }

    @Test
    public void whenRows3() {
        int[][] result = {
                {1}, {2, 3}, {4, 5, 6}
        };
        assertArrayEquals(result, TriangleMatrix.rows(3));
    }
}
