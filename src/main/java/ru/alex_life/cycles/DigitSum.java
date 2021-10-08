package ru.alex_life.cycles;

/**
 * Упражнения курса job4j
 * 1.1.5. Циклы
 * 1.4. Сумма цифр
 *
 * Дано число, нужно получить сумму его цифр
 * Например,
 * 12 => 1 + 2 => 3
 *
 * @author Alex_life
 * @version 1.0
 * @since 08.10.2021
 */
public class DigitSum {
    public static int sum(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
