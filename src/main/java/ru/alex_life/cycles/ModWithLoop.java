package ru.alex_life.cycles;

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
public class ModWithLoop {
    public static int mod(int n, int d) {
        int remnant = 0;
        while (n >= d) {
            n -= d;
            remnant = n;
        }
        return remnant;
    }
}
