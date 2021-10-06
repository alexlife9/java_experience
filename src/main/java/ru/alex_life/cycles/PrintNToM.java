package ru.alex_life.cycles;

/**
 * Упражнения курса job4j
 * 1.1.5. Циклы
 * 0.2. Вывести на консоль числа от N до M
 *
 * Выведите на консоль числа от N до M. M не входит. В этом упражнении используйте цикл for c index.
 *
 * @author Alex_life
 * @version 1.0
 * @since 05.10.2021
 */
public class PrintNToM {
    public static void out(int n, int m) {
        for (int i = n; i < m; i++) {
            System.out.println(i);
        }
    }
}
