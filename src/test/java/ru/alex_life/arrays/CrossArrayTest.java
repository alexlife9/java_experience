package ru.alex_life.arrays;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Упражнения курса job4j
 * 1.1.6. Массивы
 * 0.2. Одинаковые элементы для массивов
 *
 * Заданы два числовых массива.
 * Нужно вывести на консоль числа, которые есть одновременно в первом и втором массиве.
 *
 * @author Alex_life
 * @version 1.0
 * @since 19.10.2021
 */
public class CrossArrayTest {

    @Test
    public void whenHasCross() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        CrossArray.printCrossEl(
                new int[] {1, 3},
                new int[] {2, 1}
        );
        assertThat(out.toString(), is("1" + System.lineSeparator()));
    }

    @Test
    public void whenNotCross() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        CrossArray.printCrossEl(
                new int[] {1, 2},
                new int[] {3, 4}
        );
        assertThat(out.toString(), is(""));
    }
}

