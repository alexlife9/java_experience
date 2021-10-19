package ru.alex_life.arrays;

/**
 * Упражнения курса job4j
 * 1.1.6. Массивы
 * 0.2. Одинаковые элементы для массивов
 *
 * Заданы два числовых массива.
 * Нужно вывести на консоль числа, которые есть одновременно в первом и втором массиве.
 *
 * @author Alex_life
 * @version 1.1 - Переделал на форич
 * @since 19.10.2021
 */
public class CrossArray {
    public static void printCrossEl(int[] left, int[] right) {
        int rsl = 0;
        for (int k : left) {
            for (int i : right) {
                if (k == i) {
                    rsl += k;
                    System.out.println(rsl);
                }
            }
        }
    }
}
