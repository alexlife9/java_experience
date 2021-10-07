package ru.alex_life.cycles;

/**
 * Упражнения курса job4j
 * 1.1.5. Циклы
 * 0.6. Произведение чисел в диапазоне
 *
 * Даны два целых числа a и b (a < b). Найти произведение всех целых чисел от a до b включительно.
 *
 * @author Alex_life
 * @version 1.0
 * @since 07.10.2021
 */
public class MultiplicationLoop {
    public static int mult(int a, int b) {
        int rsl = 1;
        for (int i = a; i <= b; i++) {
            rsl *= i;
        }
        return rsl;
    }
}

