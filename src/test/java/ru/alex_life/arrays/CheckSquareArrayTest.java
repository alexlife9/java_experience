package ru.alex_life.arrays;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Упражнения курса job4j
 * 1.1.6. Массивы
 * 1.3. Проверить является ли двумерный массив квадратным
 *
 * имя_массива.length - размер массива;
 * имя_массива[номер_ряда].length - количество элементов в его ряду.
 * Необходимо проверить является ли входящий двумерный массив квадратным (т.е. количество элементов в каждом ряду,
 * должно совпадать с количеством рядов).
 *
 * @author Alex_life
 * @version 1.0
 * @since 20.10.2021
 */
public class CheckSquareArrayTest {

    @Test
    public void checkArrayTrue() {
        int[][] in = new int[][]{{4, 5, 6}, {2, 3, 0}, {1, 7, 8}};
        boolean result = CheckSquareArray.checkArray(in);
        assertThat(result, is(true));
    }

    @Test
    public void checkArrayFalse() {
        int[][] in = new int[][]{{4, 5, 6}, {2, 3}, {1}};
        boolean result = CheckSquareArray.checkArray(in);
        assertThat(result, is(false));
    }
}
