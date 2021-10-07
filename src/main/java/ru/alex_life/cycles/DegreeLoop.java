package ru.alex_life.cycles;

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
public class DegreeLoop {
    public static int calculate(int a, int n) {
        int rsl = 1;
        for (int i = 1; i <= n; i++) {
            rsl *= a; //это тоже самое что rsl = rsl * a
        }
        return rsl;
    }
}
