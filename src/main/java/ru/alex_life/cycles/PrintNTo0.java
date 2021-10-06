package ru.alex_life.cycles;

/**
 * Упражнения курса job4j
 * 1.1.5. Циклы
 * 0.3. Вывести на консоль числа от N до 0
 *
 * Выведите на консоль числа от N до 0. N не входит. В этом упражнении используйте цикл for c index
 *
 * @author Alex_life
 * @version 1.0
 * @since 05.10.2021
 */
public class PrintNTo0 {
    public static void out(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(n - 1 - i);
        }
    }
}
