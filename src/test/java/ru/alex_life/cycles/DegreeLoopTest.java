package ru.alex_life.cycles;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Упражнения курса job4j
 * 1.1.5. Циклы
 * 0.7. Найти степень числа
 *
 * Дано целое число a и целое число n (> 0). Найти a в степени n: a^n = a·a· . . . ·a (числа a перемножаются n раз).
 *
 * @author Alex_life
 * @version 1.0
 * @since 07.10.2021
 */
public class DegreeLoopTest {
    @Test
    public void test() {
        assertEquals(4, DegreeLoop.calculate(2, 2));
        assertEquals(9, DegreeLoop.calculate(3, 2));
        assertEquals(3, DegreeLoop.calculate(3, 1));
        assertEquals(128, DegreeLoop.calculate(2, 7));
    }
}
