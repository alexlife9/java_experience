package ru.alex_life.cycles;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Упражнения курса job4j
 * 1.1.5. Циклы
 * 1.3. mod через while
 *
 * Есть операция остаток от деления %. Даны два целых положительных числа числа n и d (d > 0).
 * n это делимое, d это делитель. Нужно не используя операцию %, найти остаток от деления.
 *
 * @author Alex_life
 * @version 1.0
 * @since 08.10.2021
 */
public class ModWithLoopTest {

    @Test
    public void test() {
        assertEquals(0, ModWithLoop.mod(4, 2));
        assertEquals(1, ModWithLoop.mod(3, 2));
        assertEquals(2, ModWithLoop.mod(8, 3));
        assertEquals(0, ModWithLoop.mod(0, 3));
        assertEquals(0, ModWithLoop.mod(5, 5));
    }
}
