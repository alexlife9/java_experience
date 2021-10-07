package ru.alex_life.cycles;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Упражнения курса job4j
 * 1.1.5. Циклы
 * 1.1. Найти сумму каждого второго числа в диапазоне
 *
 * Даны два целых положительных числа a и b (b > a).
 * Надо сложить каждое второе число в диапазоне [a, b] начиная с первого.
 * Например:
 * [1, 2] => 1
 * [1, 3] => 1 + 3 = 4
 * [1, 5] => 1 + 3 + 5 = 9
 * [0, 5] => 0 + 2 + 4 = 6
 *
 * @author Alex_life
 * @version 1.0
 * @since 07.10.2021
 */
public class SecondSumTest {

    @Test
    public void test() {
        assertEquals(1, SecondSum.sum(1, 2));
        assertEquals(4, SecondSum.sum(1, 3));
        assertEquals(4, SecondSum.sum(1, 4));
        assertEquals(9, SecondSum.sum(1, 5));
        assertEquals(12, SecondSum.sum(0, 6));
    }
}
