package ru.alex_life.cycles;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Упражнения курса job4j
 * 1.1.5. Циклы
 * 1.4. Сумма цифр
 *
 * Дано число, нужно получить сумму его цифр
 * Например,
 * 12 => 1 + 2 => 3
 *
 * @author Alex_life
 * @version 1.0
 * @since 08.10.2021
 */
public class DigitSumTest {
    @Test
    public void test() {
        assertEquals(1, DigitSum.sum(1));
        assertEquals(3, DigitSum.sum(12));
        assertEquals(6, DigitSum.sum(123));
        assertEquals(10, DigitSum.sum(1234));
        assertEquals(15, DigitSum.sum(12345));
    }
}
