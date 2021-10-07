package ru.alex_life.cycles;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Упражнения курса job4j
 * 1.1.5. Циклы
 * 0.6. Произведение чисел в диапазоне
 *
 * Даны два целых числа a и b (a < b). Найти произведение всех целых чисел от a до b включительно.
 *
 * @author Alex_life
 * @version 1.0
 * @since 07.10.2021
 */
public class MultiplicationLoopTest {

    @Test
    public void test() {
        assertEquals(0, MultiplicationLoop.mult(0, 2));
        assertEquals(2, MultiplicationLoop.mult(1, 2));
        assertEquals(6, MultiplicationLoop.mult(1, 3));
    }
}
