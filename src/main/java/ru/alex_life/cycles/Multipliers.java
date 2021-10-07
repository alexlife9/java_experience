package ru.alex_life.cycles;

/**
 * Упражнения курса job4j
 * 1.1.5. Циклы
 * 0.8. Вывести делители числа
 *
 * Дано целое число n (> 0). Нужно вывести делители числа. Делитель это число на которое делится заданное число.
 * Например:
 * Для 1, это 1
 * Для 2, это 1 и 2
 * Для 6, это 1, 2, 3, 6
 * Для 7, это 1, 7
 *
 * @author Alex_life
 * @version 1.0
 * @since 07.10.2021
 */
public class Multipliers {
    public static void out(int n) {
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                System.out.println(i);
            }
        }
    }
}
