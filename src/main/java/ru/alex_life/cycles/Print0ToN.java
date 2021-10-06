package ru.alex_life.cycles;

/**
 * Упражнения курса job4j
 * 1.1.5. Циклы
 * 0.1. Вывести на консоль числа от 0 до N
 *
 * Выведите на консоль числа от 0 до N. N не входит. В этом упражнении используйте цикл for c index.
 *
 * @author Alex_life
 * @version 1.0
 * @since 05.10.2021
 */
public class Print0ToN {
    public static int out(int n) {
        int out = 0;
        for (int i = 0; i < n; i++) {
            System.out.println(i);
        }
        return n;
    }
}
