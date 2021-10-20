package ru.alex_life.arrays;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Упражнения курса job4j
 * 1.1.6. Массивы
 * 0.9. Размер двумерного массива
 *
 * Двумерный массив - это массив одномерных массивов. Создается следующим образом:
 * new тип_переменной[количество_рядов][количество_элементов_в ряду]
 * Размер всего массива, как и в случае с одномерным массивом, определяется следующим образом:
 * имя_массива.length;
 * А что если надо узнать количество элементов в любом из интересующих нас ряду? Тогда надо обратиться
 * к этому ряду по индексу и вызвать у него поле length:
 * имя_массива[номер_ряда].length;
 *
 * В задании необходимо реализовать 2 метода - первый возвращает размер массива,
 * второй - количество элементов в ряду, номер которого мы передаем в метод.
 *
 * @author Alex_life
 * @version 1.0
 * @since 20.10.2021
 */
public class BoardTest {
    @Test
    public void getCountRow() {
        int[][] in = {{1}, {2, 3}, {4, 5, 6}};
        int expected = 3;
        int result = Board.getCountRow(in);
        assertThat(result, is(expected));
    }

    @Test
    public void getCountCellInRow() {
        int[][] in = {{1}, {2, 3}, {4, 5, 6}};
        int expected = 3;
        int result = Board.getCountCellInRow(in, 2);
        assertThat(result, is(expected));
    }
}
