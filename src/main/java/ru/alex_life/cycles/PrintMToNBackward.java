package ru.alex_life.cycles;

/**
 * Упражнения курса job4j
 * 1.1.5. Циклы
 * 0.4. Вывести на консоль числа от M до N.
 *
 * Нужно вывести числа от M до N. N не включено. M > N.
 *
 * @author Alex_life
 * @version 1.0
 * @since 07.10.2021
 */
public class PrintMToNBackward {
    public static void out(int m, int n) {
        for (int i = m; i > n; i--) {
            System.out.println(i);
        }
    }
}
