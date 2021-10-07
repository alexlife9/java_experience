package ru.alex_life.cycles;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Упражнения курса job4j
 * 1.1.5. Циклы
 * 0.9. Найти количество нечетных в диапазоне
 *
 * Даны два целых положительных числа a и b (b > a). Найти количество нечетных чисел в диапазоне [a, b].
 * Нечетным считается число, у которого остаток от деления на 2 равен 1.
 *
 * @author Alex_life
 * @version 1.0
 * @since 07.10.2021
 */
public class OddCountTest {

    @Test
    public void test() {
        assertEquals(1, OddCount.count(1, 2));
        assertEquals(2, OddCount.count(1, 3));
        assertEquals(2, OddCount.count(1, 4));
        assertEquals(3, OddCount.count(1, 5));
    }
}
